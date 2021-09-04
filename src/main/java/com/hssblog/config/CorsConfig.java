package com.hssblog.config;

import com.hssblog.common.constant.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 解决跨域问题
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    /**
     * 设置Cors
     *
     * @param registry CorsRegistry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // TODO 当前放开的是所以的请求，需支持
        registry.addMapping(Constants.TWO_ASTERISK_WITH_SLASH)
                .allowedOrigins(Constants.ASTERISK)
                .allowedMethods(HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.DELETE.name())
                .allowCredentials(true)
                .maxAge(Constants.reqParams.MAX_AGE)
                .allowedHeaders(Constants.ASTERISK);
    }
}