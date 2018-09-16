package giggles.giggle.infra.util.aop;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.Writer;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import giggles.giggle.domain.entity.User;
import giggles.giggle.infra.util.interfaces.Permission;
import giggles.giggle.infra.util.jwt.JwtUtil;
import giggles.giggle.infra.util.jwt.TokenMessage;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author zty
 *
 * <p>authority controller</p>
 */
public class AuthorityInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Permission permission = (Permission) AnnotationUtil.getAnnotation(handlerMethod, Permission.class);
        int level = permission.level();
        if (level == 1) {
            return true;
        }

        //获取token
        // String token = request.getHeader("Authorization");
        //解析token
        // TokenMessage tokenMessage = JwtUtil.parseToken(token);
        //把有关数据绑定request上比如 用户名

        //todo 查询用户并操作

        response.setCharacterEncoding("UTF-8");
        response.setContentType("charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("sorry! you haven't the authority of api: " + request.getRequestURI());
        response.sendError(401);

        return false;
    }

}
