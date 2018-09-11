package giggles.giggle.domain.repository;

import java.util.List;

import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;

/**
 * @author zty
 *
 * <p>用户持久层接口</p>
 */
public interface UserRepository {
    /**
     * <p>添加一个用户</p>
     *
     * @param user 用户信息
     * @return 添加的用户信息
     */
    public User create(User user);

    /**
     * <p>根据用户尽可能所有信息查询一个用户,该实现暂时不用,违背restful风格</p>
     *
     * @param user 用户信息
     * @return 所查询用户
     */
    public User query(User user);

    /**
     * <p>根据用户名字查询用户</p>
     *
     * @param username
     * @return 所查用户
     */
    public User findUserByName(String username);

    /**
     * <p>更新指定用户名的用户</p>
     *
     * @param user     更新的信息
     * @param username 用户名
     * @return 更新后的用户信息
     */
    public User update(String username, User user);

    /**
     * <p>依据用户名删除用户</p>
     *
     * @param username 用户名
     * @return 空或者not found
     */
    public int delete(String username);

    /**
     * <p>分页查询所有用户</p>
     *
     * @param page 分页对象
     * @return 用户列表
     */
    public List<User> listAll(Page page);
}
