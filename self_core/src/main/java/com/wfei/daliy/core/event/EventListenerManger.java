package com.wfei.daliy.core.event;

/**
 * 实现观察者模式
 * 观察器控制接口（被观察者）
 * 负责实现注册观察者、删除观察者、通知观察者
 * Created by feiwen on 2018/4/20.
 */
public interface EventListenerManger {
    /**
     * 注册观察者
     * @param e
     */
    void registerListener(MyEventEnum myEventEnum,MyEventListener e);

    /**
     * 删除观察者
     * @param e
     */
    void removeListener(MyEventEnum myEventEnum,MyEventListener e);

    /**
     * 通知所有的观察者
     */
    void fireEvent(MyEventEnum myEventEnum);

}
