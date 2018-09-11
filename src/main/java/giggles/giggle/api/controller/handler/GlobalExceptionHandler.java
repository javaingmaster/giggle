package giggles.giggle.api.controller.handler;

import giggles.giggle.infra.util.exception.BindingResultException;
import giggles.giggle.infra.util.exception.MissRequestParamException;
import giggles.giggle.infra.util.result.Results;
import org.apache.log4j.Logger;
import org.springframework.web.bind.MissingServletRequestParameterException;
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
    @ExceptionHandler(value = MissRequestParamException.class)
    @ResponseBody
    public Object missActionParam(HttpServletRequest req, MissRequestParamException e) throws Exception {
        return Results.invalid(req.getRequestURI() + " throw a MissRequestParamException: " + e.getMessage());
    }

    /**
     * <p>请求参数未通过校验</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = BindingResultException.class)
    @ResponseBody
    public Object missActionParam(HttpServletRequest req, BindingResultException e) throws Exception {
        return Results.invalid(req.getRequestURI() + " throw a BindingResultException: " + e.getMessage());
    }

//    /**
//     * 加密解密错误
//     */
//    @ExceptionHandler(value = CryptException.class)
//    @ResponseBody
//    public JSONObject cryptError(HttpServletRequest req, CryptException e) throws Exception {
//        return makeErrorObj("加密解密有误", req, e);
//    }
//
//    /**
//     * 数字格式错误
//     */
//    @ExceptionHandler(value = NumberFormatException.class)
//    @ResponseBody
//    public JSONObject numberFormatError(HttpServletRequest req, NumberFormatException e) throws Exception {
//        return makeErrorObj("数字格式错误", req, e);
//    }
//
//    /**
//     * JSON格式解析错误
//     */
//    @ExceptionHandler(value = JSONException.class)
//    @ResponseBody
//    public JSONObject jsonError(HttpServletRequest req, JSONException e) throws Exception {
//        return makeErrorObj("JSON格式解析错误", req, e);
//    }
//
//    /**
//     * 服务器内部错误
//     */
//    @ExceptionHandler(value = NullPointerException.class)
//    @ResponseBody
//    public JSONObject nullError(HttpServletRequest req, NullPointerException e) throws Exception {
//        return makeErrorObj("服务器内部错误", req, e);
//    }
//
//    /**
//     * HTTP请求外部服务失败
//     */
//    @ExceptionHandler(value = HTTPConnException.class)
//    @ResponseBody
//    public JSONObject requestError(HttpServletRequest req, HTTPConnException e) throws Exception {
//        return makeErrorObj("HTTP请求外部服务失败", req, e);
//    }
//
//    /**
//     * 绑卡错误
//     */
//    @ExceptionHandler(value = CardException.class)
//    @ResponseBody
//    public JSONObject payError(HttpServletRequest req, CardException e) throws Exception {
//        return makeErrorObj("绑卡错误", req, e);
//    }
//
//    /**
//     * 支付失败
//     */
//    @ExceptionHandler(value = PayException.class)
//    @ResponseBody
//    public JSONObject payError(HttpServletRequest req, PayException e) throws Exception {
//        return makeErrorObj("支付失败", req, e);
//    }
//
//    /**
//     * 第三方支付API返回错误
//     */
//    @ExceptionHandler(value = ThirdPartyPaymentException.class)
//    @ResponseBody
//    public JSONObject thirdPayError(HttpServletRequest req, ThirdPartyPaymentException e) throws Exception {
//        return makeErrorObj("第三方支付API返回错误", req, e);
//    }
//
//    /**
//     * 查询还款计划错误
//     */
//    @ExceptionHandler(value = RepaymentScheduleException.class)
//    @ResponseBody
//    public JSONObject scheduleError(HttpServletRequest req, RepaymentScheduleException e) throws Exception {
//        return makeErrorObj("查询还款计划错误", req, e);
//    }
//
//    /**
//     * 未知错误
//     */
//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public JSONObject scheduleError(HttpServletRequest req, Exception e) throws Exception {
//        return makeErrorObj("未知错误", req, e);
//    }
//
//    /**
//     * 构造错误信息
//     *
//     * @param msg 错误描述
//     * @param e   异常信息
//     * @return
//     */
}

