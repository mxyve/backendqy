package top.xym.springboot.filter_interceptor.filter;
// 设置相关的响应头以支持跨域请求
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class CORSFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        log.info("CORSFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods",
                "GET, POST, PUT, DELETE, OPTIONS");
        httpResponse.setHeader("Access-Controller-Allow-Headers",
                "Authorization, Content-Type");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("CORSFilter 销毁");
    }
}


