package giggles.giggle.infra.util.jwt;

import javax.validation.ConstraintValidatorContext;

import java.awt.*;

import org.springframework.validation.BindingResult;

/**
 * @author zty
 *
 * <p>校验工具类</p>
 */
public class ValidatorUtil {
    public static boolean isThisValue(Object o, Object value, ConstraintValidatorContext context) {
        System.out.println(o.equals(value));
        return o.equals(value);
    }

    /**
     * <p>创建验证码</p>
     *
     * @return
     */
    public static Byte[] createIdentifyImage() {
        // TODO: 2018/9/13
        return null;
    }
}
