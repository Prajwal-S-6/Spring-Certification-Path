package com.spring.data.example17.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.spring.data.example17.util.CountDownLatchUtil.await;
import static com.spring.data.example17.util.CountDownLatchUtil.countDown;


@Component
public class TransactionIsolationExampleInvoker {
    @Autowired
    private TransactionIsolationExample transactionIsolationExample;

    private ExecutorService executorService = Executors.newFixedThreadPool(3);

    public void execute() throws InterruptedException {
        System.out.println("Starting Repeatable Read Example");

        executorService.execute(() -> {
            try {
                transactionIsolationExample.readOperations();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            transactionIsolationExample.nextReadOperation();

            countDown(transactionIsolationExample.getReadWriteLatch());
        });

        executorService.execute(() -> {
            try {
                transactionIsolationExample.writeOperations();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            countDown(transactionIsolationExample.getWriteDoneAndCommittedLatch());

            countDown(transactionIsolationExample.getReadWriteLatch());
        });

        await(transactionIsolationExample.getReadWriteLatch());

        executorService.shutdown();

        System.out.println("Finishing Repeatable Read Example");
    }
}
