package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>false username</p>
 */
public class SerCannotMatchUserNameWhenLoginException extends RuntimeException {
    public SerCannotMatchUserNameWhenLoginException() {
    }

    public SerCannotMatchUserNameWhenLoginException(String message) {
        super(message);
    }

    public SerCannotMatchUserNameWhenLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerCannotMatchUserNameWhenLoginException(Throwable cause) {
        super(cause);
    }

    public SerCannotMatchUserNameWhenLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
