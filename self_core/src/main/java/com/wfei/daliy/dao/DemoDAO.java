package com.wfei.daliy.dao;

import com.wfei.daliy.pojo.Demo;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;

import java.util.List;

/**
 * Created by feiwen on 2018/4/10.
 */
@DB(name = "self",table = "demo")
public interface DemoDAO {
    @SQL("SELECT id,enterpriseName,address,salary,joinTime,leaveTime from demo")
    public List<Demo> getDemo();
}
