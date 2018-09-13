package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>用户已经存在，用户名重复</p>
 */
public class S_UserAlreadyExist extends RuntimeException {
    public S_UserAlreadyExist() {
    }

    public S_UserAlreadyExist(String message) {
        super(message);
    }

    public S_UserAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }

    public S_UserAlreadyExist(Throwable cause) {
        super(cause);
    }

    public S_UserAlreadyExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
