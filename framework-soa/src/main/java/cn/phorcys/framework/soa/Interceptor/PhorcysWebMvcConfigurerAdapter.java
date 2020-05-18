package cn.phorcys.framework.soa.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/14 12:43 下午
 */
@Configuration
@SuppressWarnings("all")
public class PhorcysWebMvcConfigurerAdapter extends WebMvcConfigurationSupport {
    @Autowired
    AuthIntercepter authIntercepter;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authIntercepter);
    }
}
