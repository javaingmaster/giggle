package giggles.giggle.infra.mapper;

import giggles.giggle.domain.entity.User;
import giggles.giggle.infra.tkmapper.TkMapper;

/**
 * @author zty
 *
 * <p>user mapper</p>
 */
public interface UserMapper extends TkMapper<User> {
    /**
     * <p>query user by name, you must make sure that no same user in database</p>
     *
     * @param username
     * @return
     */
    public User findUserByName(String username);

    /**
     * <p>update user safely</p>
     *
     * @param user
     * @return
     */
    public int updateWithSafeControl(User user);

    /**
     * <p>delete user by name</p>
     *
     * @param username
     * @return null or not found
     */
    public int deleteUserByName(String username);
}
