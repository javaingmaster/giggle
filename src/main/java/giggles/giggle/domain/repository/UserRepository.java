package giggles.giggle.domain.repository;

import java.util.List;

import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;

/**
 * @author zty
 *
 * <p>user repository</p>
 */
public interface UserRepository {
    /**
     * <p>add</p>
     *
     * @param user
     * @return
     */
    public User create(User user);

    /**
     * <p>query a user with some params and it is banned because of violating restful</p>
     *
     * @param user
     * @return
     */
    public User query(User user);

    /**
     * <p>query user by name</p>
     *
     * @param username
     * @return
     */
    public User findUserByName(String username);

    /**
     * <p>update user by name</p>
     *
     * @param user
     * @param username
     * @return
     */
    public User update(String username, User user);

    /**
     * <p>delete user by name</p>
     *
     * @param username
     * @return null or not found
     */
    public int delete(String username);

    /**
     * <p>list all users by page</p>
     *
     * @param page
     * @return
     */
    public List<User> listAll(Page page);
}
