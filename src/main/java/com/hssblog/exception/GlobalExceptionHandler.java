package com.hssblog.exception;

import com.hssblog.common.constant.RespEnum;
import com.hssblog.common.resp.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hss
 * @create 2021-06-13 23:47
 * @Desc
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 鉴权抛出异常
     *
     * @param e ShiroException
     * @return RespBean
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public RespBean handler(ShiroException e) {
        log.error("ShiroException：----------------", e);
        return RespBean.error(RespEnum.SIGNATURE_NOT_MATCH);
    }

    /**
     * 处理自定义的业务异常
     *
     * @param req 请求
     * @param e   异常
     * @return RespBean
     */
    @ExceptionHandler(value = GlobalException.class)
    @ResponseBody
    public RespBean globalExceptionHandler(HttpServletRequest req, GlobalException e) {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return RespBean.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 处理空指针的异常
     *
     * @param req 请求
     * @param e   异常信息
     * @return RespBean
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public RespBean exceptionHandler(HttpServletRequest req, NullPointerException e) {
        log.error("发生空指针异常！原因是:", e);
        return RespBean.error(RespEnum.BODY_NOT_MATCH);
    }


    /**
     * 处理其他异常
     *
     * @param req 请求
     * @param e   异常信息
     * @return RespBean
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RespBean exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("未知异常！原因是:", e);
        return RespBean.error(RespEnum.INTERNAL_SERVER_ERROR);
    }
}
