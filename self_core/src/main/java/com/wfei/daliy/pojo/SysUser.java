package com.wfei.daliy.pojo;

import lombok.Data;

/**
 *
 * Created by feiwen on 2018/4/9.
 * @author wangfei
 */
//@Data注解是lombok的注解，可省略set、get方法
@Data
public class SysUser {

    /**
     * 主键id
     */
    private int id;
    /**
     * 用户code
     */
    private String  code;
    /**
     * 用户姓名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户盐
     */
    private String salt;
}
