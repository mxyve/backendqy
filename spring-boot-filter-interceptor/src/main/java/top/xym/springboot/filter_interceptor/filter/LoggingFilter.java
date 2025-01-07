package top.xym.springboot.filter_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;

@Slf4j
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        log.info("LoggingFilter 初始化");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String path = httpRequest.getRequestURI();
        String clientIp = httpRequest.getRemoteAddr();
        LocalDateTime timestamp = LocalDateTime.now();
        log.info("请求已到达过滤器：Path={},IP={},Time={}", path, clientIp, timestamp);
        chain.doFilter(request, response);
        log.info("过滤器响应处理完毕：Path={},Time={}", path, LocalDateTime.now());
    }

    @Override
    public void destroy() {
    }

}
