package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>根据用户查询不到用户</p>
 */
public class RepFindUserByNameException extends RuntimeException {
    public RepFindUserByNameException() {
    }

    public RepFindUserByNameException(String message) {
        super(message);
    }

    public RepFindUserByNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepFindUserByNameException(Throwable cause) {
        super(cause);
    }

    public RepFindUserByNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
