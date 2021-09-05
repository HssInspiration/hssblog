package com.hssblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hssblog.common.constant.RespEnum;
import com.hssblog.entity.User;
import com.hssblog.exception.GlobalException;
import com.hssblog.mapper.UserMapper;
import com.hssblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 关注公众号：hssblog
 * @since 2020-05-25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Long saveUser(User entity) {
        // 若已存在抛出异常
        User user = getOne(new QueryWrapper<User>().eq("username", entity.getUserName()));
        if (user != null) {
            throw new GlobalException(RespEnum.USER_ALREADY_EXIST);
        }
        Long id = UUID.randomUUID().getMostSignificantBits() & Integer.MAX_VALUE;
        entity.setId(id);
        entity.setStatus(1);
        entity.setCreated(new Date());
        super.save(entity);
        return id;
    }
}
