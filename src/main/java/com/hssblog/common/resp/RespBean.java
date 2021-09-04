package com.hssblog.common.resp;

import com.hssblog.common.constant.RespEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应对象
 *
 * @author hss
 * @create 2021-05-04 14:35
 * @Desc 响应对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    // 响应码
    private String code;

    // 响应信息
    private String msg;

    // 响应数据
    private Object data;

    /**
     * 响应成功
     *
     * @return 响应成功
     */
    public static RespBean success() {
        return new RespBean(RespEnum.SUCCESS.getCode(), RespEnum.SUCCESS.getMsg(), null);
    }

    /**
     * 响应成功
     *
     * @param data 响应数据
     * @return 响应数据
     */
    public static RespBean success(Object data) {
        return new RespBean(RespEnum.SUCCESS.getCode(), RespEnum.SUCCESS.getMsg(), data);
    }

    /**
     * 响应失败
     *
     * @param respEnum 枚举
     * @return 响应失败
     */
    public static RespBean error(RespEnum respEnum) {
        return new RespBean(respEnum.getCode(), respEnum.getMsg(), null);
    }

    /**
     * 响应失败
     *
     * @param respEnum 枚举
     * @param obj      外部传入的对象参数
     * @return 响应失败
     */
    public static RespBean error(RespEnum respEnum, Object obj) {
        return new RespBean(respEnum.getCode(), respEnum.getMsg(), obj);
    }

    /**
     * 错误异常处理
     *
     * @param code 响应码
     * @param msg  响应信息
     * @param obj  响应对象
     * @return RespBean
     */
    public static RespBean error(String code, String msg, Object obj) {
        return new RespBean(code, msg, obj);
    }

    /**
     * 错误异常处理
     *
     * @param code 响应码
     * @param msg  响应信息
     * @return RespBean
     */
    public static RespBean error(String code, String msg) {
        return new RespBean(code, msg, null);
    }

}
