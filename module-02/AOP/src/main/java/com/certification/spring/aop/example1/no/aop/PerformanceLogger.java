package com.certification.spring.aop.example1.no.aop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class PerformanceLogger {

    private Logger LOG = LoggerFactory.getLogger(PerformanceLogger.class);

    public PerformanceLoggerInfo start(String name) {
        return new PerformanceLoggerInfo(name, System.currentTimeMillis());
    }

    public void stop(PerformanceLoggerInfo performanceLoggerInfo) {
        long startTime = performanceLoggerInfo.getStartTime();
        long endTime = System.currentTimeMillis();
        LOG.info(String.format("Duration of %s execution was %s", performanceLoggerInfo.getName(), Duration.ofMillis(endTime - startTime)));

    }

    public static class PerformanceLoggerInfo {

        private final String name;
        private final long startTime;

        PerformanceLoggerInfo(String name, long startTime) {

            this.name = name;
            this.startTime = startTime;
        }

        String getName() {
            return name;
        }

        long getStartTime() {
            return startTime;
        }
    }

}
