package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>登陆时用户名错误</p>
 */
public class S_CannotMatchUserNameWhenLogin extends RuntimeException {
    public S_CannotMatchUserNameWhenLogin() {
    }

    public S_CannotMatchUserNameWhenLogin(String message) {
        super(message);
    }

    public S_CannotMatchUserNameWhenLogin(String message, Throwable cause) {
        super(message, cause);
    }

    public S_CannotMatchUserNameWhenLogin(Throwable cause) {
        super(cause);
    }

    public S_CannotMatchUserNameWhenLogin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
