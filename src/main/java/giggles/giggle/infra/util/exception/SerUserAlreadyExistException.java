package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>用户已经存在，用户名重复</p>
 */
public class SerUserAlreadyExistException extends RuntimeException {
    public SerUserAlreadyExistException() {
    }

    public SerUserAlreadyExistException(String message) {
        super(message);
    }

    public SerUserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerUserAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public SerUserAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
