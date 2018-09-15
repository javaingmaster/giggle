package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>请求参数校验异常</p>
 */
public class ConBindingResultException extends RuntimeException {
    public ConBindingResultException() {
    }

    public ConBindingResultException(String message) {
        super(message);
    }

    public ConBindingResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConBindingResultException(Throwable cause) {
        super(cause);
    }

    public ConBindingResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
