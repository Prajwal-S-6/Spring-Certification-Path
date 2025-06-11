package com.spring.data.example17.util;



import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchUtil {
    public static void countDown(CountDownLatch countDownLatch) {
        countDownLatch.countDown();
    }

    public static void await(CountDownLatch countDownLatch) throws InterruptedException {
        countDownLatch.await(10, TimeUnit.SECONDS);
    }
}
