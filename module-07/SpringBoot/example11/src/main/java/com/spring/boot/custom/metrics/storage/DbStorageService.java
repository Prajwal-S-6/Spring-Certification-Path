package com.spring.boot.custom.metrics.storage;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static com.spring.boot.custom.metrics.StatisticsUtils.averageContentSize;
import static com.spring.boot.custom.metrics.StatisticsUtils.maxId;

@Service
public class DbStorageService implements StorageService {
    private Map<Integer, String> dbStorage = new HashMap<>();
    private Counter objectsCount;
    private AtomicLong averageObjectSize;

    public DbStorageService(MeterRegistry meterRegistry) {
        objectsCount = meterRegistry.counter("storage.object.count", "type", "db");
        averageObjectSize = meterRegistry.gauge("storage.db.object.avg.size", new AtomicLong());
    }

    @Override
    public synchronized int store(String content) {
        int newId = maxId(dbStorage) + 1;

        dbStorage.put(newId, content);
        objectsCount.increment();
        averageObjectSize.set(averageContentSize(dbStorage));

        return newId;
    }

    @Override
    public synchronized Optional<String> fetch(int id) {
        return Optional.ofNullable(dbStorage.get(id));
    }
}
