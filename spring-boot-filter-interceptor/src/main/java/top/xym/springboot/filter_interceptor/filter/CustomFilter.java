package top.xym.springboot.filter_interceptor.filter;
// 创建过滤器类
import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化方法，可以用于配置一些初始化参数
        log.info("CustomerFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
        throws IOException, ServletException {
        // 在请求处理之前执行的逻辑
        log.info("CustomerFilter - 请求处理中");
        // 将请求传递给下一个过滤器或目标资源
        chain.doFilter(request, response);
        // 在响应处理之后执行的逻辑
        log.info("CustomerFilter - 响应处理中");
    }

    @Override
    public void destroy() {
        // 销毁方法，在过滤器被移除时调用
        log.info("CustomerFilter 销毁");
    }
}
