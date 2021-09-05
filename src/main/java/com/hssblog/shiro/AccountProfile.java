package com.hssblog.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户基本信息
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String userName;

    private String avatar;

    private String email;

}
