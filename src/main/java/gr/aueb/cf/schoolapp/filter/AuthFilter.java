package gr.aueb.cf.schoolapp.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        boolean authenticated = false;

        HttpSession session = request.getSession(false);
//        authenticated = (session != null) && (session.getAttribute("username") != null);
        authenticated = (session != null) && (session.getAttribute("authenticated") == Boolean.TRUE);
//

//        if (session == null || session.getAttribute("authenticated") != Boolean.TRUE) {
//            authenticated = false;
//        }

        if (!authenticated) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
