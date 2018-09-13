package br.com.everton.Tasklist.configure;

import br.com.everton.Tasklist.util.Key;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author everton
 * @since 29/08/2018
 */
public class InterceptorLogin extends HandlerInterceptorAdapter{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();

        if(session.getAttribute(Key.LOGIN_SESSION) == null && (!uri.contains("/login"))){
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        
        return true;
    }
}
