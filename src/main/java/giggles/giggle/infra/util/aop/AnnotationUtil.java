package giggles.giggle.infra.util.aop;

import java.lang.annotation.Annotation;

import org.springframework.web.method.HandlerMethod;

/**
 * @author zty
 *
 * <p>获取注解的工具类</p>
 */
public class AnnotationUtil {
    /**
     * @param handlerMethod <p>包含方法、参数等反射对象的信息类</p>
     * @param classType     <p>依据该参数获取对应的注解类型</p>
     * @return <p>返回该注解</p>
     */
    public static Annotation getAnnotation(HandlerMethod handlerMethod, Class<? extends Annotation> classType) {
        return handlerMethod.getMethod().getAnnotation(classType);
    }
}
