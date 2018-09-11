package giggles.giggle.api.controller.v1;

import javax.validation.Valid;

import giggles.giggle.app.service.UserService;
import giggles.giggle.domain.entity.Page;
import giggles.giggle.domain.entity.User;
import giggles.giggle.infra.util.exception.BindingResultException;
import giggles.giggle.infra.util.exception.MissRequestParamException;
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
@Api("操作用户api,包括查询用户列表、查询单个用户、添加用户、更新用户、删除用户")
@RequestMapping("/users")
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
    @ApiOperation("用户注册接口")
    @PostMapping
    public Object create(@Valid @RequestBody User user, BindingResult bindingResult) {
        logger.info("post请求: /users");
        if (bindingResult.hasErrors()) {
            throw new BindingResultException("create request data error: " + bindingResult.getFieldError().getDefaultMessage());
        }
        return Results.created(userService.save(user));
    }

    /**
     * <p>依据用户名查询用户</p>
     *
     * @param username
     * @return
     */
    @ApiOperation("依据用户名查询用户")
    @Permission(level = 2)
    @GetMapping(value = "/{username}")
    public Object query(@PathVariable(value = "username") String username) {
        logger.info("get请求: /users/" + username);
        if ("".equals(username)) {
            throw new MissRequestParamException("get /users without username");
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
    @ApiOperation("更新用户")
    @Permission(level = 3)
    @PutMapping(value = "/{username}")
    public Object update(@RequestBody User user, @PathVariable(value = "username") String username) {
        logger.info("put请求: /users/" + username);
        if ("".equals(username)) {
            throw new MissRequestParamException("put request user without username");
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
    @ApiOperation("删除用户")
    @Permission(level = 3)
    @DeleteMapping("/{username}")
    public Object delete(@PathVariable(value = "username") String username) {
        logger.info("delete请求: /users " + username);
        if ("".equals(username)) {
            throw new MissRequestParamException("delete request user without username");
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
    @ApiOperation("分页查询用户")
    @Permission(level = 2)
    @GetMapping
    public Object list(@Valid @ModelAttribute Page page, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BindingResultException("delete request data error: " + bindingResult.getFieldError().getDefaultMessage());
        }
        return Results.success(userService.list(page));
    }

}
