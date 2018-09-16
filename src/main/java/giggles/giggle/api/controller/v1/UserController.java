package giggles.giggle.api.controller.v1;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import giggles.giggle.app.service.UserService;
import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;
import giggles.giggle.infra.util.exception.ConBindingResultException;
import giggles.giggle.infra.util.exception.ConMissRequestParamException;
import giggles.giggle.infra.util.interfaces.Permission;
import giggles.giggle.infra.util.result.Results;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * @author zty
 *
 * <p>user controller</p>
 */
@RestController
@CrossOrigin
@Api("controller for users api")
@RequestMapping("/v1/users")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * <p>registry</p>
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @ApiOperation("registry")
    @PostMapping
    @Permission
    public Object registry(@Valid @RequestBody User user, BindingResult bindingResult) {
        logger.info("post request: /users");
        if (bindingResult.hasErrors()) {
            throw new ConBindingResultException("registry request data is not illegal: " + bindingResult.getFieldError().getDefaultMessage());
        }
        return Results.created(userService.save(user));
    }

    /**
     * <p>query user by name</p>
     *
     * @param username
     * @return
     */
    @ApiOperation("query user by name")
    @Permission(level = 2)
    @GetMapping(value = "/{username}")
    public Object query(@PathVariable(value = "username") String username) {
        logger.info("get request: /users/" + username);
        if (username == null) {
            throw new ConMissRequestParamException("get /users without username");
        }
        User user = userService.findWithName(username);
        if (user == null) {
            return Results.success("no such user in database");
        }
        return Results.success(user);
    }

    /**
     * <p>update user</p>
     *
     * @param user     the param must include version!
     * @param username
     * @return
     */
    @ApiOperation("update user")
    @Permission(level = 3)
    @PutMapping(value = "/{username}")
    public Object update(@RequestBody User user, @PathVariable(value = "username") String username) {
        logger.info("put request: /users/" + username);
        if (username == null) {
            throw new ConMissRequestParamException("put request user without username");
        } else {
            return Results.success(userService.update(username, user));
        }
    }

    /**
     * <p>delete user by name</p>
     *
     * @param username
     * @return
     */
    @ApiOperation("delete user by name")
    @Permission(level = 3)
    @DeleteMapping("/{username}")
    public Object delete(@PathVariable(value = "username") String username) {
        logger.info("delete request: /users " + username);
        if (username == null) {
            throw new ConMissRequestParamException("delete request user without username");
        } else {
            int value = userService.delete(username);
            if (value == 0) {
                return Results.deleted("");
            } else {
                return Results.deleted("not found");
            }
        }
    }

    /**
     * <p>list users by page</p>
     *
     * @param page
     * @param bindingResult
     * @return
     */
    @ApiOperation("list users with page")
    @Permission(level = 2)
    @GetMapping
    public Object list(@Valid @ModelAttribute Page page, BindingResult bindingResult) {
        logger.info("list users by page");
        if (bindingResult.hasErrors()) {
            throw new ConBindingResultException("list request data is not illegal: " + bindingResult.getFieldError().getDefaultMessage());
        }
        return Results.success(userService.list(page));
    }

    /**
     * <p>login</p>
     *
     * @param user
     * @param bindingResult
     * @return
     */
    @ApiOperation("login")
    @Permission
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        logger.info("login");
        if (null == user || user.getUserName().trim().isEmpty() || user.getUserPassword().trim().isEmpty()) {
            throw new ConMissRequestParamException("login data is illegal");
        }
        return Results.success(userService.login(user));
    }
}
