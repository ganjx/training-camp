package com.training.log4j2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMain {

    static Logger logger = LoggerFactory.getLogger(LogMain.class);

    public static void main(String[] args) {

        logger.info("test");
    }
}
