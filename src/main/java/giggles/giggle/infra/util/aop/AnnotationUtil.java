package giggles.giggle.infra.util.aop;

import java.lang.annotation.Annotation;

import org.springframework.web.method.HandlerMethod;

/**
 * @author zty
 *
 * <p>annotation util</p>
 */
public class AnnotationUtil {
    /**
     * @param handlerMethod <p>an information class which includes methods, arguments and other params</p>
     * @param classType     <p>type class you need</p>
     * @return <p>an annotation</p>
     */
    public static Annotation getAnnotation(HandlerMethod handlerMethod, Class<? extends Annotation> classType) {
        return handlerMethod.getMethod().getAnnotation(classType);
    }
}
