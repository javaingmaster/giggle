package giggles.giggle.api.controller.handler;

import giggles.giggle.infra.util.exception.*;
import giggles.giggle.infra.util.result.Results;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zty
 *
 * <p>全局异常处理</p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    /**
     * <p>请求有参数没传</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = C_MissRequestParamException.class)
    @ResponseBody
    public Object missActionParam(HttpServletRequest req, C_MissRequestParamException e) throws Exception {
        return Results.invalid(req.getRequestURI() + " you may not send a required param " + e.getMessage());
    }

    /**
     * <p>请求参数未通过校验</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = C_BindingResultException.class)
    @ResponseBody
    public Object missActionParam(HttpServletRequest req, C_BindingResultException e) throws Exception {
        return Results.invalid(req.getRequestURI() + " some params are illegal " + e.getMessage());
    }


    /**
     * <p>unknown error</p>
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object scheduleError(HttpServletRequest req, Exception e) throws Exception {
        return Results.invalid(req.getRequestURI() + " unknown error " + e.getMessage());
    }

    /**
     * <p>登陆密码异常</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = S_CannotMatchPasswordWhenLogin.class)
    @ResponseBody
    public Object cannnotMatchPassword(HttpServletRequest req, S_CannotMatchPasswordWhenLogin e) throws Exception {
        return Results.invalid(req.getRequestURI() + " bad request caused: " + e.getMessage());
    }

    /**
     * <p>登陆用户名异常</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = S_CannotMatchUserNameWhenLogin.class)
    @ResponseBody
    public Object cannnotMatchPassword(HttpServletRequest req, S_CannotMatchUserNameWhenLogin e) throws Exception {
        return Results.invalid(req.getRequestURI() + " bad request caused: " + e.getMessage());
    }

    /**
     * <p>用户名重复，无法注册</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = S_UserAlreadyExist.class)
    @ResponseBody
    public Object cannnotMatchPassword(HttpServletRequest req, S_UserAlreadyExist e) throws Exception {
        return Results.invalid(req.getRequestURI() + " bad request caused: " + e.getMessage());
    }

}

