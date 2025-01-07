package top.xym.springboot.filter_interceptor.filter;
// 在响应返回客户端之前修改内容（例如设置响应头）

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class ResponseModificationFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) {
        log.info("ResponseModificationFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // 执行请求链
        chain.doFilter(request, response);
        // 在响应返回之前添加头信息或进行其他修改
        httpResponse.setHeader("X-Content-Processed", "true");
    }

    @Override
    public void destroy() {
        log.info("ResponseModificationFilter 销毁");
    }
}
