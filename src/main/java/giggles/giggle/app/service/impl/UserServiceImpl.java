package giggles.giggle.app.service.impl;

import javax.servlet.http.HttpSession;
import java.util.List;

import giggles.giggle.app.service.UserService;
import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;
import giggles.giggle.domain.repository.UserRepository;
import giggles.giggle.infra.util.exception.SerCannotMatchPasswordWhenLoginException;
import giggles.giggle.infra.util.exception.SerCannotMatchUserNameWhenLoginException;
import giggles.giggle.infra.util.exception.SerUserAlreadyExistException;
import giggles.giggle.infra.util.result.Results;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zty
 *
 * <p>user service impl</p>
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        if (userRepository.findUserByName(user.getUserName()) != null) {
            throw new SerUserAlreadyExistException(" user already exists ");
        }
        return userRepository.create(user);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, readOnly = true)
    public User findWithName(String username) {
        return userRepository.findUserByName(username);
    }

    @Override
    public User update(String username, User user) {
        return userRepository.update(username, user);
    }

    @Override
    public int delete(String username) {
        return userRepository.delete(username);
    }

    @Override
    public List<User> list(Page page) {
        return userRepository.listAll(page);
    }

    @Override
    public Object login(User user) {
        String username = user.getUserName();
        User userInDatabase = userRepository.findUserByName(username);
        if (null != userInDatabase) {
            if (DigestUtils.md5Hex(user.getUserPassword()).equals(userInDatabase.getUserPassword())) {
                //创建token
                return Results.success(userInDatabase);
            }
            throw new SerCannotMatchPasswordWhenLoginException(" cannot match password when login ");
        }
        throw new SerCannotMatchUserNameWhenLoginException(" cannot match user name when login ");
    }

}
