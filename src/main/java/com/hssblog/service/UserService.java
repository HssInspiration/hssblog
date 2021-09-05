package com.hssblog.service;

import com.hssblog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 关注公众号：hssblog
 * @since 2020-05-25
 */
public interface UserService extends IService<User> {

    /**
     * 新增User
     *
     * @param user User
     * @return userId
     */
    Long saveUser(User user);

}
