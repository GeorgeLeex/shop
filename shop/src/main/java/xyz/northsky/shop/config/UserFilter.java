package xyz.northsky.shop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.northsky.shop.utils.StringUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserFilter implements Filter {

    private List<String> anyoneAccessList;

    private Pattern pattern1 = Pattern.compile("manage|condition|/book/edit|/book/recom");

    private Pattern pattern2 = Pattern.compile("\\w+\\.\\w+");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        anyoneAccessList = Arrays.asList(
                "/index", "/admin", "/adminlogin", "/login", "/logout", "/menus", "/register",
                "/user/admin/login", "/user/admin/logout", "/user/namecheck", "/order/process", "/order/success"
        );
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        String requestURI = request.getRequestURI();

        if (session.getAttribute("admin") == null & checkUriIsAdminAccess(requestURI)) {
            response.sendRedirect("/adminlogin");
        } else if (session.getAttribute("user") == null & !checkUriIsAdminAccess(requestURI)
                & !anyoneAccessList.contains(requestURI) & !"/adminlogin".equals(requestURI)
                & !"/login".equals(requestURI) & !isStaticSource(requestURI)) {
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {

    }


    private boolean checkUriIsAdminAccess(String requestUri) {
        return pattern1.matcher(requestUri).find();
    }

    private boolean isStaticSource(String requestUri) {

        return pattern2.matcher(requestUri).find();
    }

}
