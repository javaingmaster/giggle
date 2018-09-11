package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>请求参数校验异常</p>
 */
public class BindingResultException extends RuntimeException {
    public BindingResultException() {
    }

    public BindingResultException(String message) {
        super(message);
    }

    public BindingResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public BindingResultException(Throwable cause) {
        super(cause);
    }

    public BindingResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
