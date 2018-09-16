package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>the file uploaded already exists</p>
 */
public class SerFileNameAlreadyExistsException extends RuntimeException {
    public SerFileNameAlreadyExistsException() {
    }

    public SerFileNameAlreadyExistsException(String message) {
        super(message);
    }

    public SerFileNameAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerFileNameAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public SerFileNameAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
