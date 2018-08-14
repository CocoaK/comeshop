package com.eshop.serviceapp.common.exception;

import com.eshop.serviceapp.common.model.ResultEntity;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 登陆异常
     * @param req
     * @param e
     * @return
     */
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public ResultEntity handleAuthException(HttpServletRequest req, UnauthorizedException e) throws UnauthorizedException {
        ResultEntity<String> r = new ResultEntity();
        r.setCode(HttpStatus.UNAUTHORIZED.value());
        r.setMsg(e.getMessage());
        r.setData("");
        logger.info("UnauthorizedException",e.getMessage());
        //拦截未授权页面
        return r;
    }

    /**
     * 验证异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultEntity handleMethodArgumentNotValidException(HttpServletRequest req, MethodArgumentNotValidException e) throws MethodArgumentNotValidException {
        ResultEntity r = new ResultEntity();
        BindingResult bindingResult = e.getBindingResult();
        String msg = "Parameter Error!";
        String errorData = "";

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorData += fieldError.getField()+":"+fieldError.getDefaultMessage() + ",";
        }
        errorData = errorData.substring(0,errorData.lastIndexOf(","));
        r.setCode(HttpStatus.BAD_REQUEST.value());
        r.setMsg(msg);
        r.setData(errorData);
        logger.info("MethodArgumentNotValidException",e);
        return r;
    }

    /**
     * 全局异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultEntity handleException(HttpServletRequest req, Exception e) throws Exception {
        ResultEntity r = new ResultEntity();
        r.setCode(HttpStatus.BAD_REQUEST.value());
        r.setMsg(e.getMessage());
        r.setData(e.getCause());
        logger.error(e.getMessage(),e);
        return r;
    }
}