package giggles.giggle.app.service;

import java.util.List;

import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;

/**
 * @author zty
 *
 * <p>用户业务接口</p>
 */
public interface UserService {
    /**
     * <p>添加用户业务</p>
     *
     * @param user 用户
     * @return 用户
     */
    public User save(User user);

    /**
     * <p>查询用户业务</p>
     *
     * @param username 用户名
     * @return 用户
     */
    public User findWithName(String username);

    /**
     * <p>更新用户业务</p>
     *
     * @param username 用户名
     * @param user     用户
     * @return 用户
     */
    public User update(String username, User user);

    /**
     * <p>删除用户业务</p>
     *
     * @param username 用户名
     * @return 用户
     */
    public int delete(String username);

    /**
     * <p>分页查询用户</p>
     *
     * @param page
     * @return
     */
    public List<User> list(Page page);

    /**
     * <P>登陆业务</P>
     *
     * @param user 登陆者
     * @return 登陆信息
     */
    public Object login(User user);
}
