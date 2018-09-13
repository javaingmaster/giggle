package giggles.giggle.infra.util.jwt;

import javax.validation.ConstraintValidatorContext;

import org.springframework.validation.BindingResult;

/**
 * @author zty
 *
 * <p>校验工具类</p>
 */
public class ValidatorUtil {
    public static boolean isThisValue(Object o,Object value,ConstraintValidatorContext context){
        System.out.println(o.equals(value));
        return o.equals(value) ;
    }
}
