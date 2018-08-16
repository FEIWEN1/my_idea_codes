package com.wfei.daliy.pojo.vo;

/**
 * 接口返回的通用对象
 * Created by feiwen on 2018/4/12.
 */
public class ResponseResult<T> {

    //状态吗
    private int code;
    //错误信息
    private String msg;
    private T data;

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    //0代表正常
    private static final int SUCCESS_CODE = 0;
    //1代表失败
    private static final int ERROR_CODE = 1;
    /**
     * 构造成功返回
     */
    public static final ResponseResult SUCCESS = new ResponseResult(SUCCESS_CODE, "SUCCESS");
    /**
     * 构造错误返回
     */
    public static final ResponseResult ERROR = new ResponseResult(1, "ERROR");

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }


}
