package com.zouwei.firstweb.exception;

import com.zouwei.firstweb.utils.JsonData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 异常处理类
 */
@ControllerAdvice
public class CustomExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handle(Exception e) {
        logger.error("[ 系统异常 ]{}", e.getMessage());
        if (e instanceof XDException) {
            XDException xdException = (XDException) e;
            return JsonData.buildError(xdException.getCode(), xdException.getMsg());

        } else if (e instanceof HttpRequestMethodNotSupportedException) {
            //post方法使用了get请求，get请求用了post请求
//        org.springframework.web.HttpRequestMethodNotSupportedException: Request method 'GET' not supported
            return JsonData.buildError("请求方式错误");
        } else {
            return JsonData.buildError("全局异常,未知错误");
        }
    }

}
