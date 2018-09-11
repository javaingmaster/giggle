package giggles.giggle.infra.util.interfaces;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import giggles.giggle.infra.util.validator.CheckIfOneValidator;

/**
 * @author zty
 *
 * <p></p>
 */

@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CheckIfOneValidator.class)
@Documented
public @interface CheckIfOne {
    String message() default "{giggles.giggle.infra.util.interfaces.CheckIfOneValidator}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String value();
}
