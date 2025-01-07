package top.xym.springboot.filter_interceptor.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.xym.springboot.filter_interceptor.filter.*;

@Configuration
public class FilterConfig {
//    @Bean
//    public FilterRegistrationBean<CustomFilter> customFilterRegistration() {
//        FilterRegistrationBean<CustomFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CustomFilter());
//        // 设置拦截的 URL 路径
//        registrationBean.addUrlPatterns("/*");
//        // 设置过滤器的执行顺序
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
//        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new LoggingFilter());
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(1);
//        return registrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean<AuthFilter> authFilter() {
//        FilterRegistrationBean<AuthFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new AuthFilter());
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(2);
//        return registrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean<CORSFilter> corsFilter() {
//        FilterRegistrationBean<CORSFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CORSFilter());
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(3);
//        return registrationBean;
//    }

//    @Bean
//    public FilterRegistrationBean<RequestModificationFilter> requestModificationFilter() {
//        FilterRegistrationBean<RequestModificationFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new RequestModificationFilter());
//        registrationBean.addUrlPatterns("/*");
//        registrationBean.setOrder(4);
//        return registrationBean;
//    }

    @Bean
    public FilterRegistrationBean<ResponseModificationFilter> responseModificationFilter() {
        FilterRegistrationBean<ResponseModificationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new ResponseModificationFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(5);
        return registrationBean;
    }
}
