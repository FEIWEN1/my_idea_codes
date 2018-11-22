package com.wfei.daliy.daoTest;

import com.wfei.daliy.BaseTest;
import com.wfei.daliy.dao.DemoDAO;
import com.wfei.daliy.pojo.Demo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by feiwen on 2018/4/10.
 */
public class DemoDAOTest extends BaseTest {
    @Autowired
    private DemoDAO demoDAO;
    @Test
    public void getDemo() throws Exception {
        List<Demo> list=demoDAO.getDemo();
//        logger.info("查询demo列表：{}",list.get(1));
    }

}