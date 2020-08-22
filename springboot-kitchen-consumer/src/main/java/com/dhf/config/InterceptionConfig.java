package com.dhf.config;

import com.dhf.handler.LoginIntercept;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptionConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] path={
                "/kitchen/foodlist"
        };
        String[] excPath={
                "/kitchen/decidelogin","/kitchen/index"
        };
        registry.addInterceptor(new LoginIntercept()).addPathPatterns(path).excludePathPatterns(excPath);
    }
}
