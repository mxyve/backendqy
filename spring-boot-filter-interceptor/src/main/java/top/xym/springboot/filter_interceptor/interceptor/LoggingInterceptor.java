package top.xym.springboot.filter_interceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.LocalDateTime;

@Component
@Slf4j
public class LoggingInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String path = request.getRequestURI();
        String clientIp = request.getRemoteAddr();
        LocalDateTime timestamp = LocalDateTime.now();
        log.info("请求已到达拦截器：Path={},IP={},Time={}", path, clientIp, timestamp);
        // 继续执行
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
        log.info("拦截器应处理完毕：Path={},Time={}", request.getRequestURI(), LocalDateTime.now());
    }
}
