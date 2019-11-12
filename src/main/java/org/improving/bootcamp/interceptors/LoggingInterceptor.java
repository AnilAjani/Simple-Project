package org.improving.bootcamp.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LoggingInterceptor extends HandlerInterceptorAdapter {
    public static final String FIRST_REQUEST_TIME = "firstRequestTime";
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       HttpSession session = request.getSession();
       if(session.getAttribute(FIRST_REQUEST_TIME) == null) {
           session.setAttribute(FIRST_REQUEST_TIME, LocalDateTime.now());
       }
           logger.info("Request received {} {}", request.getMethod(), request.getRequestURI());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HttpSession session = request.getSession();
        logger.info("Completed request for a session that started at {}", session.getAttribute(FIRST_REQUEST_TIME));
    }
}
