/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import controllers.ConnectedUsers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Marcos Vinícius
 */
public class Interceptor extends HandlerInterceptorAdapter
{

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String url = request.getRequestURI();
        if (url.contains("emp-find"))
            return true;
        if (url.contains("usr-login"))
            return true;
        if(url.contains("usr-disconnect"))
            return true;
        if(url.contains("usr-quicked"))
            return true;
        if(url.contains("img"))
            return true;
        if(url.contains("autconfig"))
            return true;
        if(url.contains("testconfig"))
            return true;
        if(url.contains("getdb_type"))
            return true;
        if(url.contains("saveconfig"))
            return true;
        if(url.contains("ps_execute"))
            return true;

        String token = request.getParameter("token");

        if (ConnectedUsers.getInstance().exists(token))
            return true;
        else
        {
            response.sendRedirect("usr-quicked?token=" + token);
        }
        return true;
    }
}
