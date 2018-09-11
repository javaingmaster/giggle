package giggles.giggle.infra.util.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import giggles.giggle.infra.util.interfaces.CheckIfOne;
import giggles.giggle.infra.util.jwt.ValidatorUtil;

public class CheckIfOneValidator implements ConstraintValidator<CheckIfOne, String> {

    private String define;

    @Override
    public void initialize(CheckIfOne constraintAnnotation) {
        define=constraintAnnotation.value();
        System.out.println("注解的值是: "+define);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidatorUtil.isThisValue(value,define,context);
    }
}
