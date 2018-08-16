package com.wfei.daliy.common.enumtype;

/**
 * 错误类型的枚举类
 * Created by feiwen on 2018/4/12.
 */
public enum  ErrorCodeEnumType {
    SYSTEM_DEFAULT_ERROR(1,"系统默认异常"),
    ILLEGAL_ARGUMENT_ERROR(1000,"参数相关");

    private int errorCode;
    private String errorMsg;

    ErrorCodeEnumType(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
