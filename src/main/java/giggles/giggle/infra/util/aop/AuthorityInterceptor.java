package giggles.giggle.infra.util.aop;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import giggles.giggle.infra.util.interfaces.Permission;
import giggles.giggle.infra.util.jwt.JwtUtil;
import giggles.giggle.infra.util.jwt.TokenMessage;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author zty
 *
 * <p>api权限控制器</p>
 */
public class AuthorityInterceptor implements HandlerInterceptor {

    /**
     * <p>拦截调用对应的api</p>
     *
     * @param request  http请求对象
     * @param response http返回对象
     * @param handler  信息类
     * @return 是否放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        //获取接口所需权限
       // Permission permission = (Permission) AnnotationUtil.getAnnotation(handlerMethod, Permission.class);
        //获取token
       // String token = request.getHeader("Authorization");
        //解析token
       // TokenMessage tokenMessage = JwtUtil.parseToken(token);

        //todo 查询用户并操作


        return true;
    }

}
