package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>根据用户查询不到用户</p>
 */
public class FindUserByNameException extends RuntimeException {
    public FindUserByNameException() {
    }

    public FindUserByNameException(String message) {
        super(message);
    }

    public FindUserByNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public FindUserByNameException(Throwable cause) {
        super(cause);
    }

    public FindUserByNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
