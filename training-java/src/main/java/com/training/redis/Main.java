package com.training.redis;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Date date = new Date();
        System.out.println(date);

        TimeUnit.SECONDS.sleep(3);

        System.out.println(date);
    }
}
