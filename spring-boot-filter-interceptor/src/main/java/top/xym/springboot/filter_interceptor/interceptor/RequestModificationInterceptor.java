package top.xym.springboot.filter_interceptor.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RequestModificationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String param = request.getParameter("data");
        if (param != null) {
            // 简单示例：添加前缀
            String modifiedParam = "Modified_" + param;
            // 将修改后的参数放入请求属性
            request.setAttribute("data", modifiedParam);
        }
        return true;
    }
}
