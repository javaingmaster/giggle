package giggles.giggle.infra.util.jwt;

import javax.validation.ConstraintValidatorContext;

public class ValidatorUtil {
    public static boolean isThisValue(Object o,Object value,ConstraintValidatorContext context){
        System.out.println(o.equals(value));
        return o.equals(value) ;
    }
}
