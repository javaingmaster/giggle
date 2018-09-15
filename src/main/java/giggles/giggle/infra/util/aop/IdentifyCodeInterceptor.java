package giggles.giggle.infra.util.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author zty
 *
 * <p>校验验证码</p>
 */
public class IdentifyCodeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        PrintWriter writer = response.getWriter();
        String code = request.getParameter("identifyCode");

        System.out.println("input: " + code);
        System.out.println("code in session: " + (String) session.getAttribute("identifyCode"));

        if (code == null || code.trim().isEmpty()) {
            writer.println("you need input an identify code");
            response.sendError(400);
            return false;
        }
        if (!code.equals((String) session.getAttribute("identifyCode"))) {
            writer.println("you need check the identify code");
            response.sendError(400);
            return false;
        }
        return true;
    }
}
