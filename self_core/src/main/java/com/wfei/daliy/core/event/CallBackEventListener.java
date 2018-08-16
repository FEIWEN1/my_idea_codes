package com.wfei.daliy.core.event;

/**
 * 实现观察者模式
 * 观察者接口
 * 负责实现业务逻辑
 * Created by feiwen on 2018/4/20.
 */
public class CallBackEventListener implements MyEventListener{

    @Override
    public void fire() {
        System.out.println("触发callback的业务逻辑");
    }
}
