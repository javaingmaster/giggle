package giggles.giggle.infra.repository.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;
import giggles.giggle.domain.repository.UserRepository;
import giggles.giggle.infra.constant.PasswordSafety;
import giggles.giggle.infra.mapper.UserMapper;
import giggles.giggle.infra.util.exception.RepFindUserByNameException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author zty
 *
 * <p>user repository impl</p>
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User create(User user) {
        String pwd = user.getUserPassword();
        user.setUserPassword(DigestUtils.md5Hex(pwd + PasswordSafety.SALT));
        user.setLastUpdate(new Date());
        userMapper.insert(user);
        return user;
    }

    @Override
    public User query(User user) {
        return userMapper.selectOne(user);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findUserByName(username);
    }

    /**
     * <p>if cannot query a user, throw an exception and the function should be test for its safety in multithreading</p>
     *
     * @param username
     * @return
     */
    @Override
    public User update(String username, User user) {
        User currentUser = userMapper.findUserByName(username);
        if (currentUser == null) {
            throw new RepFindUserByNameException("cannot find a user by username when executing update action");
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


    @Override
    public int delete(String username) {
        User user = userMapper.findUserByName(username);
        if (user == null) {
            return -1;
        }
        userMapper.deleteUserByName(username);
        return 0;
    }


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
