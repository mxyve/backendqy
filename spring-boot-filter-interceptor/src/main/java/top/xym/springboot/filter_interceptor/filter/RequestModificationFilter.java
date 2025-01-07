package top.xym.springboot.filter_interceptor.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class RequestModificationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        log.info("RequestModificationFilter 初始化");
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        // 在这里可以对请求参数进行解密或进行其他修改
        String param = httpRequest.getParameter("data");
        if (param != null) {
            // 简单示例：添加前缀
            String modifiedParam = "Modified-" + param;
            // 将修改后的参数放入请求属性
            httpRequest.setAttribute("data", modifiedParam);
        }
        chain.doFilter(httpRequest, response);
    }

    @Override
    public void destroy() {
        log.info("RequestModificationFilter 销毁");
    }
}
