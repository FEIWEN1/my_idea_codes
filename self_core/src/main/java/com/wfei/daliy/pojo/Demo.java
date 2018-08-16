package com.wfei.daliy.pojo;

import lombok.Data;

/**
 * Created by feiwen on 2018/4/10.
 */
@Data
public class Demo {
    /**
     *  主键id
     */
    private int id;
    /**
     * 公司名称
     */
    private String enterpriseName;
    /**
     * 地址
     */
    private String address;
    /**
     * 薪资
     */
    private String salary;
    /**
     * 入职时间
     */
    private String joinTime;
    /**
     * 离职时间
     */
    private String leaveTime;

}
