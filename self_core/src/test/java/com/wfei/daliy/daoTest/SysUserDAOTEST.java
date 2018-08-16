package com.wfei.daliy.daoTest;

import com.wfei.daliy.BaseTest;
import com.wfei.daliy.dao.UserDao;
import com.wfei.daliy.pojo.SysUser;
import com.wfei.daliy.spring.SpringBeanUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;


/**
 * Created by feiwen on 2018/4/9.
 * @author wangfei
 */
public class SysUserDAOTEST extends BaseTest{

    @Autowired
    private UserDao userDao;

    @Test
    public void getUser(){
        SysUser sysUser=userDao.getUser("lisi");
        SpringBeanUtil.getBeanByName("lisi");

    }


}
