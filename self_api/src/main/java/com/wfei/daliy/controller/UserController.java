package com.wfei.daliy.controller;

import com.wfei.daliy.core.event.CallBackEventListener;
import com.wfei.daliy.core.event.EventListenerManger;
import com.wfei.daliy.core.event.MyEventEnum;
import com.wfei.daliy.pojo.SysUser;
import com.wfei.daliy.pojo.dto.GetUserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 请求User相关的业务示例
 * Created by feiwen on 2018/4/10.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    EventListenerManger eventListenerManger;

    @RequestMapping("/getUser")
    public SysUser getUser(@Valid GetUserDTO getUserDTO) {
        logger.info("进入getUser方法");
        return null;
    }
    @RequestMapping("/testListener")
    public void testListener(){
        logger.info("进入监听器的测试方法");
        eventListenerManger.registerListener(MyEventEnum.CALLBACK_EVENT,new CallBackEventListener());
        eventListenerManger.fireEvent(MyEventEnum.CALLBACK_EVENT);
    }

}
