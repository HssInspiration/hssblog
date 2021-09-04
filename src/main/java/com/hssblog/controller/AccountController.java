package com.hssblog.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hssblog.common.constant.RespEnum;
import com.hssblog.common.req.LoginReq;
import com.hssblog.common.resp.RespBean;
import com.hssblog.entity.User;
import com.hssblog.exception.GlobalException;
import com.hssblog.service.UserService;
import com.hssblog.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public RespBean login(@Validated @RequestBody LoginReq loginReq, HttpServletResponse response) {

        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginReq.getUsername()));
        if (user == null || !user.getPassword().equals(SecureUtil.md5(loginReq.getPassword()))) {
            throw new GlobalException(RespEnum.USER_OR_PWD_CHECK_FAILED);
        }

        String jwt = jwtUtils.generateToken(user.getId());

        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        return RespBean.success(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public RespBean logout() {
        SecurityUtils.getSubject().logout();
        return RespBean.success();
    }

}
