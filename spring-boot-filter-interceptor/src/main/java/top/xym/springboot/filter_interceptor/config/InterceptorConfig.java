package top.xym.springboot.filter_interceptor.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.xym.springboot.filter_interceptor.interceptor.*;

@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
//    private final LoggingInterceptor loggingInterceptor;
//    private final AuthInterceptor authInterceptor;
//    private final CORSInterceptor corsInterceptor;
//    private final RequestModificationInterceptor requestModificationInterceptor;
    private final ResponseModificationInterceptor responseModificationInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
//        registry.addInterceptor((corsInterceptor)).addPathPatterns("/**");
//        registry.addInterceptor(requestModificationInterceptor).addPathPatterns("/**");
    registry.addInterceptor(responseModificationInterceptor).addPathPatterns("/**");
    }
}
