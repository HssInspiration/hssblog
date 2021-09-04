package com.hssblog.common.constant;

import org.springframework.http.HttpMethod;

/**
 * 常量类
 *
 * @author hss
 * @create 2021-09-04 16:59
 * @Desc Constants
 */
public class Constants {
    public static final String ASTERISK = "*";

    public static final String ONE_ASTERISK_WITH_SLASH = "/*";

    public static final String TWO_ASTERISK_WITH_SLASH = "/**";

    public interface reqParams {
        int MAX_AGE = 60 * 60;
        String ALLOW_ORIGIN = "Access-control-Allow-Origin";
        String ALLOW_METHODS = "Access-Control-Allow-Methods";
        String ALLOW_HEADERS = "Access-Control-Allow-Headers";
        String REQUEST_HEADERS = "Access-Control-Request-Headers";
        String HEADER_ORIGIN = "Origin";
        String HEADER_AUTHORIZATION = "Authorization";
    }

    public interface jwtConstants {
        String TYPE = "typ";

        String JWT_KEY_UP = "JWT";

        String JWT_KEY_DOWN = "jwt";
    }
}
