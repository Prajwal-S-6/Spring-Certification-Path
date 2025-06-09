package com.spring.data.example4.callback.stream;

import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        new StreamExample().run();
    }

    private void run() {
        Stream.iterate(2L, this::getNext)
                .limit(5)
                .map(this::formatNumber)
                .forEach(System.out::println);
    }

    private long getNext(long i) {
        return (long) Math.pow(i, 2);
    }

    private String formatNumber(long n) {
        return String.format("Number = %d", n);
    }
}
