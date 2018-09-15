package giggles.giggle.app.service;

import java.util.List;

import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;

/**
 * @author zty
 *
 * <p>user service</p>
 */
public interface UserService {
    /**
     * <p>add user</p>
     *
     * @param user
     * @return
     */
    public User save(User user);

    /**
     * <p>query user</p>
     *
     * @param username
     * @return
     */
    public User findWithName(String username);

    /**
     * <p>update user</p>
     *
     * @param username
     * @param user
     * @return
     */
    public User update(String username, User user);

    /**
     * <p>delete user</p>
     *
     * @param username
     * @return
     */
    public int delete(String username);

    /**
     * <p>list users</p>
     *
     * @param page
     * @return
     */
    public List<User> list(Page page);

    /**
     * <P>login</P>
     *
     * @param user
     * @return
     */
    public Object login(User user);

}
