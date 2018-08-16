package com.wfei.daliy.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取springBean工具类
 *
 * @author zhanjie.zhang
 * @date 17/7/8
 */
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.applicationContext = applicationContext;
    }

    public static Object getBeanByName(String beanName) {
        if (null == applicationContext) {
            return null;
        }

        return applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<T> type) {

        return applicationContext.getBean(type);
    }
}
