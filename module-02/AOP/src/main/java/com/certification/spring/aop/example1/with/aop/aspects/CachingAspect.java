package com.certification.spring.aop.example1.with.aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@Aspect
public class CachingAspect {

    private static final Logger LOG = LoggerFactory.getLogger(CachingAspect.class);

    private Map<CacheKey, Object> cache = new HashMap<>();

    @Around("@annotation(com.certification.spring.aop.example1.with.aop.annotations.Cachable)")
    public Object checkCache(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        CacheKey cacheKey = new CacheKey(proceedingJoinPoint);

        if(cache.containsKey(cacheKey)) {
            LOG.info("Fetching from cache for: " + proceedingJoinPoint.getSignature().toShortString());
            return cache.get(cacheKey);
        } else {
            Object result = proceedingJoinPoint.proceed();
            cache.put(cacheKey, result);
            return result;
        }
    }


    private static class CacheKey {

        private final Object target;
        private final String signature;
        private final Object[] args;

        public CacheKey(ProceedingJoinPoint proceedingJoinPoint) {
            target = proceedingJoinPoint.getTarget();
            signature = proceedingJoinPoint.getSignature().toLongString();
            args = proceedingJoinPoint.getArgs();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CacheKey)) return false;
            CacheKey cacheKey = (CacheKey) o;
            return target == cacheKey.target &&
                    Objects.equals(signature, cacheKey.signature) &&
                    Arrays.equals(args, cacheKey.args);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(target, signature);
            result = 31 * result + Arrays.hashCode(args);
            return result;
        }
    }
}
