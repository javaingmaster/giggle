package giggles.giggle.infra.repository.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;
import giggles.giggle.domain.repository.UserRepository;
import giggles.giggle.infra.constant.PasswordSafety;
import giggles.giggle.infra.mapper.UserMapper;
import giggles.giggle.infra.util.exception.FindUserByNameException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zty
 *
 * <p>用户持久层实现</p>
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMapper userMapper;

    /**
     * <P>添加用户实现</P>
     *
     * @param user 用户信息
     * @return
     */
    @Override
    public User create(User user) {
        //密码加密
        String pwd = user.getUserPassword();
        user.setUserPassword(DigestUtils.md5Hex(pwd + PasswordSafety.SALT));
        user.setLastUpdate(new Date());
        userMapper.insert(user);
        return user;
    }

    /**
     * <P>实现根据用户已有全部信息查询一个用户,当查询到多个用户时抛出ManyUsersException异常</P>
     *
     * @param user 用户信息
     * @return 所查用户
     */
    @Override
    public User query(User user) {
        return userMapper.selectOne(user);
    }

    /**
     * <p>实现根据用户名字查询,返回用户或者null</p>
     *
     * @param username 用户名字
     * @return 用户
     */
    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    /**
     * <p>实现根据用户名更新用户,由于是写入数据库数据，
     * 如果查询不到相应的用户会抛出FindUserByName异常,
     * </p>
     *
     * <p>此方法有待测试,存在安全隐患</p>
     *
     * @param username 用户名
     * @return 更新后用户信息
     */
    @Override
    public User update(String username, User user) {
        User currentUser = userMapper.findUserByName(username);
        if (currentUser == null) {
            throw new FindUserByNameException("cannot find a user by username when executing update action");
        } else {
            user.setUserName(username);
            if (currentUser.getUserVersion().equals(user.getUserVersion())) {
                user.setLastUpdate(new Date());
                int value = userMapper.updateWithSafeControl(user);
                if (value == 1) {
                    return user;
                }
                return null;
            } else {
                return update(username, user);
            }
        }
    }

    /**
     * <p>删除指定用户</p>
     *
     * @param username 用户名
     * @return 空(0)或者not found(-1)
     */
    @Override
    public int delete(String username) {
        User user = userMapper.findUserByName(username);
        if (user == null) {
            return -1;
        }
        userMapper.deleteUserByName(username);
        return 0;
    }

    /**
     * <p>分页查询用户</p>
     *
     * @param page 分页对象
     * @return 用户列表
     */
    @Override
    public List<User> listAll(Page page) {
        if ("".equals(page.getSort())) {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        } else {
            PageHelper.startPage(page.getPageNum(), page.getPageSize(), page.getSort());
        }
        return userMapper.selectAll();
    }
}
