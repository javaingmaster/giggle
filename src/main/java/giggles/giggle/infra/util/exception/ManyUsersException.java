package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>查询多用户异常，用于单个用户查询时查询出多用户情况</p>
 */
public class ManyUsersException extends RuntimeException {
    public ManyUsersException() {
    }

    public ManyUsersException(String message) {
        super(message);
    }

    public ManyUsersException(String message, Throwable cause) {
        super(message, cause);
    }

    public ManyUsersException(Throwable cause) {
        super(cause);
    }

    public ManyUsersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
