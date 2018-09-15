package giggles.giggle.api.controller.handler;

import javax.servlet.http.HttpServletRequest;

import giggles.giggle.infra.util.exception.*;
import giggles.giggle.infra.util.result.Results;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zty
 *
 * <p>global exception processor</p>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String BAD_REQUEST_NOTE = " bad request caused: ";
    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    /**
     * <p>loss request params</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ConMissRequestParamException.class)
    @ResponseBody
    public Object missActionParam(HttpServletRequest req, ConMissRequestParamException e) throws ConMissRequestParamException {
        logger.info("throw ConMissRequestParamException exception");
        return Results.invalid(req.getRequestURI() + " you may not send a required param " + e.getMessage());
    }

    /**
     * <p>request params are not illegal</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = ConBindingResultException.class)
    @ResponseBody
    public Object illegalParams(HttpServletRequest req, ConBindingResultException e) throws ConBindingResultException {
        logger.info("throw ConBindingResultException exception");
        return Results.invalid(req.getRequestURI() + BAD_REQUEST_NOTE + e.getMessage());
    }

    /**
     * <p>false password when login</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = SerCannotMatchPasswordWhenLoginException.class)
    @ResponseBody
    public Object cannnotMatchPassword(HttpServletRequest req, SerCannotMatchPasswordWhenLoginException e) throws SerCannotMatchPasswordWhenLoginException {
        logger.info("throw SerCannotMatchPasswordWhenLoginException exception");
        return Results.invalid(req.getRequestURI() + BAD_REQUEST_NOTE + e.getMessage());
    }

    /**
     * <p>false username when login</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = SerCannotMatchUserNameWhenLoginException.class)
    @ResponseBody
    public Object cannnotMatchUsername(HttpServletRequest req, SerCannotMatchUserNameWhenLoginException e) throws SerCannotMatchUserNameWhenLoginException {
        logger.info("throw SerCannotMatchUserNameWhenLoginException exception");
        return Results.invalid(req.getRequestURI() + BAD_REQUEST_NOTE + e.getMessage());
    }

    /**
     * <p>registry the same user for twice</p>
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = SerUserAlreadyExistException.class)
    @ResponseBody
    public Object userAlreadyExist(HttpServletRequest req, SerUserAlreadyExistException e) throws SerUserAlreadyExistException {
        logger.info("throw  SerUserAlreadyExistException exception");
        return Results.invalid(req.getRequestURI() + BAD_REQUEST_NOTE + e.getMessage());
    }

    /**
     * <p>unknown error</p>
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object scheduleError(HttpServletRequest req, Exception e) {
        logger.info("throw Exception exception");
        return Results.invalid(req.getRequestURI() + " unknown error " + e.getMessage());
    }
}

