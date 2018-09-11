package giggles.giggle.infra.mapper;

import giggles.giggle.domain.entity.User;
import giggles.giggle.infra.tkMapper.TkMapper;

/**
 * @author zty
 *
 * <p>用户mapper</p>
 */
public interface UserMapper extends TkMapper<User> {
    /**
     * <p>依据用户名更新数据</p>
     *
     * @param username 用户名
     * @return 用户信息
     */
    public User findUserByName(String username);

    /**
     * <p>更新带有版本属性的安全数据</p>
     *
     * @param user 更新的数据
     * @return 返回更新后的数据
     */
    public int updateWithSafeControl(User user);

    /**
     * <p>删除某用户</p>
     *
     * @param username 用户名
     * @return 空或者not found
     */
    public int deleteUserByName(String username);
}
