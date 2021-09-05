package com.hssblog.common.req;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Setter
@Getter
public class LoginReq implements Serializable {

    private static final long serialVersionUID = -1719007021295326643L;

    @NotBlank(message = "昵称不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;
}
