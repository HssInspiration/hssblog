package com.hssblog.controller;

import com.hssblog.common.resp.RespBean;
import com.hssblog.entity.User;
import com.hssblog.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hssblog
 * @since 2020-05-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 进入首页
     *
     * @return RespBean
     */
    @RequiresAuthentication
    @GetMapping("/index")
    public RespBean index() {
        User user = userService.getById(1L);
        return RespBean.success(user);
    }

    /**
     * 保存用户信息
     *
     * @param user User
     * @return RespBean
     */
    @PostMapping("/save")
    public RespBean save(@Validated @RequestBody User user) {
        userService.save(user);
        return RespBean.success();
    }

}
