package com.wfei.daliy.common.spring;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Spring容器初始化类，完成对拦截器链条的加载
 * Created by feiwen on 2018/4/12.
 */
public class HandlerInterceptorChainFactory implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent == null) {
            return;
        }

        ApplicationContext applicationContext = contextRefreshedEvent.getApplicationContext();
        if (null == applicationContext || null != applicationContext.getParent()) {
            return;
        }
        Map<String, MyHandlerInterceptor> map = BeanFactoryUtils.beansOfTypeIncludingAncestors(applicationContext, MyHandlerInterceptor.class, false, false);
        if (MapUtils.isEmpty(map)) {
            return;
        }

        List<MyHandlerInterceptor> interceptors = new ArrayList<>(map.values());
        MyInterceptorChain interceptorChain = applicationContext.getBean(MyInterceptorChain.class);

        interceptorChain.setInterceptors(interceptors);
    }
}
