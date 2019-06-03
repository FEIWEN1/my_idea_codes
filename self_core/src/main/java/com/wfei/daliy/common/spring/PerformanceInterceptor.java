package com.wfei.daliy.common.spring;

import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 性能拦截器 监控接口请求耗时
 *
 * @author feiwen
 * @date 2018/12/21
 */
public class PerformanceInterceptor extends HandlerInterceptorAdapter {

    private ThreadLocal<StopWatch> local = new ThreadLocal<>();
    private Logger logger = LoggerFactory.getLogger(PerformanceInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        StopWatch stopWatch = new Slf4JStopWatch("shell");
        stopWatch.start();
        local.set(stopWatch);
        return false;
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        StopWatch stopWatch = local.get();
        stopWatch.stop();
        Long elapsedTime = stopWatch.getElapsedTime();
        String url = request.getRequestURI();
        logger.info("API接口{},耗时{}", url, elapsedTime);
    }

}
