package giggles.giggle.infra.constant;

/**
 * @author zty
 *
 * <p>正则匹配</p>
 */
public class CheckPattern {
    /**
     * 匹配手机号
     */
    public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$";
    /**
     * 匹配邮箱
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    /**
     * 数字和英文
     */
    public static final String REGEX_USERNAME = "^[A-Za-z0-9]+$";
}
