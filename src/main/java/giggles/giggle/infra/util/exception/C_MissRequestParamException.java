package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>缺少请求参数</p>
 */
public class C_MissRequestParamException extends RuntimeException {

    public C_MissRequestParamException() {
    }

    public C_MissRequestParamException(String message) {
        super(message);
    }

    public C_MissRequestParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public C_MissRequestParamException(Throwable cause) {
        super(cause);
    }

    public C_MissRequestParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
