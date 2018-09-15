package giggles.giggle.api.controller.v1;

import javax.validation.Valid;

import giggles.giggle.app.service.UserService;
import giggles.giggle.domain.entity.*;
import giggles.giggle.infra.util.exception.C_BindingResultException;
import giggles.giggle.infra.util.exception.C_MissRequestParamException;
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
 * <p>用户控制层</p>
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
     * <p>注册接口</p>
     *
     * @param user          注册用户
     * @param bindingResult
     * @return 注册用户数据
     */
    @ApiOperation("registry")
    @PostMapping
    @Permission
    public Object registry(@Valid @RequestBody User user, BindingResult bindingResult) {
        logger.info("post请求: /users");
        if (bindingResult.hasErrors()) {
            throw new C_BindingResultException("registry request data is not illegal: " + bindingResult.getFieldError().getDefaultMessage());
        }
        return Results.created(userService.save(user));
    }

    /**
     * <p>依据用户名查询用户</p>
     *
     * @param username
     * @return
     */
    @ApiOperation("query user by name")
    @Permission(level = 2)
    @GetMapping(value = "/{username}")
    public Object query(@PathVariable(value = "username") String username) {
        logger.info("get请求: /users/" + username);
        if (username == null) {
            throw new C_MissRequestParamException("get /users without username");
        }
        User user = userService.findWithName(username);
        if (user == null) {
            return Results.success("no such user in database");
        }
        return Results.success(user);
    }

    /**
     * <p>更新用户</p>
     *
     * @param user     此对象必须包含userVersion参数
     * @param username
     * @return
     */
    @ApiOperation("update user")
    @Permission(level = 3)
    @PutMapping(value = "/{username}")
    public Object update(@RequestBody User user, @PathVariable(value = "username") String username) {
        logger.info("put请求: /users/" + username);
        if (username == null) {
            throw new C_MissRequestParamException("put request user without username");
        } else {
            return Results.success(userService.update(username, user));
        }
    }

    /**
     * <p>根据用户名删除用户</p>
     *
     * @param username
     * @return
     */
    @ApiOperation("delete user by name")
    @Permission(level = 3)
    @DeleteMapping("/{username}")
    public Object delete(@PathVariable(value = "username") String username) {
        logger.info("delete请求: /users " + username);
        if (username == null) {
            throw new C_MissRequestParamException("delete request user without username");
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
     * <p>分页查询用户</p>
     *
     * @param page
     * @param bindingResult
     * @return
     */
    @ApiOperation("list users with page")
    @Permission(level = 2)
    @GetMapping
    public Object list(@Valid @ModelAttribute Page page, BindingResult bindingResult) {
        logger.info("list");
        if (bindingResult.hasErrors()) {
            throw new C_BindingResultException("list request data is not illegal: " + bindingResult.getFieldError().getDefaultMessage());
        }
        return Results.success(userService.list(page));
    }

    /**
     * <p>登陆</p>
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
            throw new C_MissRequestParamException("login data is illegal");
        }
        return Results.success(userService.login(user));
    }
}
