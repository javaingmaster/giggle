package giggles.giggle.app.service.impl;

import java.util.List;

import giggles.giggle.app.service.UserService;
import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;
import giggles.giggle.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zty
 *
 * <p>用户业务实现类</p>
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * <p>实现添加</p>
     *
     * @param user 用户
     * @return
     */
    @Override
    public User save(User user) {
        return userRepository.create(user);
    }

    /**
     * <p>实现查询</p>
     *
     * @param username 用户名
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public User findWithName(String username) {
        return userRepository.findUserByName(username);
    }

    /**
     * <p>实现更新</p>
     *
     * @param username 用户名
     * @param user     用户
     * @return
     */
    @Override
    public User update(String username, User user) {
        return userRepository.update(username, user);
    }

    /**
     * <p>实现删除</p>
     *
     * @param username 用户名
     * @return
     */
    @Override
    public int delete(String username) {
        return userRepository.delete(username);
    }

    /**
     * <p>实现分页查询</p>
     *
     * @param page
     * @return
     */
    @Override
    public List<User> list(Page page) {
        return userRepository.listAll(page);
    }
}
