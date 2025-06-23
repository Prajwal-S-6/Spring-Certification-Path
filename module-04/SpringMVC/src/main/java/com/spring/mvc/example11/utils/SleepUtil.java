package com.spring.mvc.example11.utils;


import java.util.concurrent.TimeUnit;

public class SleepUtil {
    public static final int SLEEP_TIME_SECONDS = 5;

    public static void sleep() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(SLEEP_TIME_SECONDS));
    }
}
