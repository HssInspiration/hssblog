package com.hssblog.util;

import com.hssblog.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

public class ShiroUtil {

    /**
     * 转换用户信息
     *
     * @return AccountProfile
     */
    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

}
