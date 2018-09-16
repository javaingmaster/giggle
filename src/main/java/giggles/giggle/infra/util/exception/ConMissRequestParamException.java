package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>loss request params exception</p>
 */
public class ConMissRequestParamException extends RuntimeException {

    public ConMissRequestParamException() {
    }

    public ConMissRequestParamException(String message) {
        super(message);
    }

    public ConMissRequestParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConMissRequestParamException(Throwable cause) {
        super(cause);
    }

    public ConMissRequestParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
