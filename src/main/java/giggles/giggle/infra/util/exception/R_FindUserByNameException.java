package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>根据用户查询不到用户</p>
 */
public class R_FindUserByNameException extends RuntimeException {
    public R_FindUserByNameException() {
    }

    public R_FindUserByNameException(String message) {
        super(message);
    }

    public R_FindUserByNameException(String message, Throwable cause) {
        super(message, cause);
    }

    public R_FindUserByNameException(Throwable cause) {
        super(cause);
    }

    public R_FindUserByNameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
