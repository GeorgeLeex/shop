package xyz.northsky.shop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/")
public class UserFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("login filter is init...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        logger.info("requestUri is " + request.getRequestURI());
        if (request.getRequestURI().contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (session.getAttribute("user") == null) {
            request.getRequestDispatcher("/login").forward(request, ((HttpServletResponse) servletResponse));
        } else if (session.getAttribute("admin") == null) {
            request.getRequestDispatcher("/adminlogin").forward(request, ((HttpServletResponse) servletResponse));
        }
    }

    @Override
    public void destroy() {

    }
}
