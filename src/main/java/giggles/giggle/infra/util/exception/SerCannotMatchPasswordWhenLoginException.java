package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>登陆时密码错误</p>
 */
public class SerCannotMatchPasswordWhenLoginException extends RuntimeException {
    public SerCannotMatchPasswordWhenLoginException() {
    }

    public SerCannotMatchPasswordWhenLoginException(String message) {
        super(message);
    }

    public SerCannotMatchPasswordWhenLoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerCannotMatchPasswordWhenLoginException(Throwable cause) {
        super(cause);
    }

    public SerCannotMatchPasswordWhenLoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
