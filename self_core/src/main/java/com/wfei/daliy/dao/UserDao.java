package com.wfei.daliy.dao;

import com.wfei.daliy.pojo.SysUser;
import org.jfaster.mango.annotation.DB;
import org.jfaster.mango.annotation.SQL;
import org.springframework.stereotype.Service;

/**
 * 链接数据库示范类
 * Created by feiwen on 2018/4/9.
 */

@DB(name ="self",table ="sys_user")
public interface UserDao {
    /**
     * 按照usercode查询sysUser
     * @param userCode
     * @return
     */
    @SQL("select id,usercode,username,password,salt from #table where usercode=:1")
    SysUser getUser(String userCode);
}
