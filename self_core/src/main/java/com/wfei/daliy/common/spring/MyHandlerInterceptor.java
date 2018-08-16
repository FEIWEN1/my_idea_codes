package com.wfei.daliy.common.spring;

/**
 * Created by feiwen on 2018/4/12.
 */
public interface MyHandlerInterceptor {
    /**
     * 进行拦截
     *
     * @param dispatcherRequest
     * @return false会中断本次请求, 业务逻辑不会继续往下走; true业务逻辑会继续往下走
     */
    boolean preHandle(String req);
}
