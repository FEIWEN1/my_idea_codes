package com.wfei.daliy.common;

import com.wfei.daliy.common.enumtype.ErrorCodeEnumType;
import com.wfei.daliy.pojo.vo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理类
 * Created by feiwen on 2018/4/10.
 *
 * @author wangfei
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = {MissingServletRequestParameterException.class, ConstraintViolationException.class,
            TypeMismatchException.class, BindException.class})
    @ResponseBody
    public ResponseResult<Object> handleParamException(Exception ex) {
        ResponseResult responseResult = ResponseResult.ERROR;
        //缺少请求参数
        if (ex instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException missEx = (MissingServletRequestParameterException) ex;
            String paramename = missEx.getParameterName();
            responseResult.setCode(ErrorCodeEnumType.ILLEGAL_ARGUMENT_ERROR.getErrorCode());
            responseResult.setMsg(ErrorCodeEnumType.ILLEGAL_ARGUMENT_ERROR.getErrorMsg() + "," + paramename + " is required");
        }
        else if(ex instanceof TypeNotPresentException){
            TypeNotPresentException typeEx=(TypeNotPresentException) ex;
            responseResult.setCode(ErrorCodeEnumType.ILLEGAL_ARGUMENT_ERROR.getErrorCode());
            responseResult.setMsg(ErrorCodeEnumType.ILLEGAL_ARGUMENT_ERROR.getErrorMsg());
        }else if (ex instanceof BindException) {
            // 对象参数绑定异常
            BindException e = (BindException) ex;
            responseResult.setCode(ErrorCodeEnumType.ILLEGAL_ARGUMENT_ERROR.getErrorCode());
            responseResult.setMsg(e.getAllErrors().get(0).getDefaultMessage());
        }
        return responseResult;
    }

}
