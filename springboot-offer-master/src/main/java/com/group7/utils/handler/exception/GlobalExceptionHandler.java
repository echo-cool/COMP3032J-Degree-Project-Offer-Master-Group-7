package com.group7.utils.handler.exception;

import com.group7.utils.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xujinfengxu
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常
     * @param e
     * @return
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public R accessDeniedException(Exception e){
        return R.error().message("AccessDenied").data("error", e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    public R badCredentialsException(Exception e){
        return R.error().message("badCredentials").data("error", e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("执行了全局异常处理..").data("error", e.getMessage());
    }

    /**
     * ArithmeticException 特定异常(算术异常)
     * @param e
     * @return
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public R error(ArithmeticException e){
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理..").data("error", e.getMessage());
    }

    /**
     * GuliException 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(Group7Exception.class)
    @ResponseBody
    public R error(Group7Exception e){
        log.error(e.getMsg());
        e.printStackTrace();
        return R.error().code(e.getCode()).message(e.getMsg());
    }
}
