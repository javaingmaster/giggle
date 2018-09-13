package giggles.giggle.infra.util.exception;

/**
 * @author zty
 *
 * <p>登陆时密码错误</p>
 */
public class S_CannotMatchPasswordWhenLogin extends RuntimeException {
    public S_CannotMatchPasswordWhenLogin() {
    }

    public S_CannotMatchPasswordWhenLogin(String message) {
        super(message);
    }

    public S_CannotMatchPasswordWhenLogin(String message, Throwable cause) {
        super(message, cause);
    }

    public S_CannotMatchPasswordWhenLogin(Throwable cause) {
        super(cause);
    }

    public S_CannotMatchPasswordWhenLogin(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
