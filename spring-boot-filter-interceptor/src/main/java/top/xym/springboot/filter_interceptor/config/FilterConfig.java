//package top.xym.springboot.filter_interceptor.config;
//
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import top.xym.springboot.filter_interceptor.filter.CustomFilter;
//
//@Configuration
//public class FilterConfig {
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
//}
