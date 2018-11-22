package com.wfei.daliy.logback;

import com.wfei.daliy.BaseTest;
import org.junit.Test;
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
        logger.info("--------info--------");
        logger.debug("--------debug--------");
        logger.warn("--------warn--------");
        logger.error("--------error--------");
    }

}
