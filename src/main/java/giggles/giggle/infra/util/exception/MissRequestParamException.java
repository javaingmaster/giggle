package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>缺少请求参数</p>
 */
public class MissRequestParamException extends RuntimeException {

    public MissRequestParamException() {
    }

    public MissRequestParamException(String message) {
        super(message);
    }

    public MissRequestParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public MissRequestParamException(Throwable cause) {
        super(cause);
    }

    public MissRequestParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
