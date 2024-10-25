package com.ureca.idle.originapi.presentation.web.config;

import com.ureca.idle.originapi.presentation.web.auth.LoginUserIdArgumentResolver;
import com.ureca.idle.originapi.presentation.web.filter.AdminRoleValidationFilter;
import com.ureca.idle.originapi.presentation.web.filter.UserLoginValidationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {


    private final LoginUserIdArgumentResolver loginUserIdArgumentResolver;
    private final UserLoginValidationFilter userLoginValidationFilter;
    private final AdminRoleValidationFilter adminRoleValidationFilter;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserIdArgumentResolver);
    }

    @Bean
    public FilterRegistrationBean<UserLoginValidationFilter> userLoginValidationFilter() {
        FilterRegistrationBean<UserLoginValidationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(userLoginValidationFilter);
        registrationBean.addUrlPatterns("/api/v1/not-yet"); // TODO /api/v1/**
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AdminRoleValidationFilter> adminRoleValidationFilter() {
        FilterRegistrationBean<AdminRoleValidationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(adminRoleValidationFilter);
        registrationBean.addUrlPatterns("/api/v1/not-yet"); // TODO /api/v1/**
        registrationBean.setOrder(2);
        return registrationBean;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://example.com")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}