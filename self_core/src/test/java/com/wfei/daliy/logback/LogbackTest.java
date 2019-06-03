package com.wfei.daliy.logback;

import com.wfei.daliy.BaseTest;
import org.junit.Test;
import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author feiwen
 * @date 2018/11/22
 */
public class LogbackTest extends BaseTest{

    Logger logger= LoggerFactory.getLogger(LogbackTest.class);
    @Test
    public void log(){
//        logger.info("--------info--------");
//        logger.debug("--------debug--------");
//        logger.warn("--------warn--------");
//        logger.error("--------error--------");
        StopWatch stopWatch=new Slf4JStopWatch("shell");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stopWatch.stop("ll"));
    }

}
