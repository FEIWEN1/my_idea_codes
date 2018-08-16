package com.wfei.daliy.common.spring;

/**
 * 自建的队列拦截器
 * Created by feiwen on 2018/4/12.
 */
public class QueueHandlerInterceptor implements MyHandlerInterceptor{

    @Override
    public boolean preHandle(String req) {
        return false;
    }
}
