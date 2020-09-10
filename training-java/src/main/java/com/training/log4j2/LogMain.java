package com.training.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMain {

    static Logger logger = LoggerFactory.getLogger(LogMain.class);

    public static void main(String[] args) throws InterruptedException {
//        int count = 1000;
//        for (int i = 0; i < count; i++) {
//            logger.info("i->{}",i);
//            Thread.sleep(100);
//        }
        logger.info("test");
    }
}
