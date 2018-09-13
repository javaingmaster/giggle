package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>请求参数校验异常</p>
 */
public class C_BindingResultException extends RuntimeException {
    public C_BindingResultException() {
    }

    public C_BindingResultException(String message) {
        super(message);
    }

    public C_BindingResultException(String message, Throwable cause) {
        super(message, cause);
    }

    public C_BindingResultException(Throwable cause) {
        super(cause);
    }

    public C_BindingResultException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
