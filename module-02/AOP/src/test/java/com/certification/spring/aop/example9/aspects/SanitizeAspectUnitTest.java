package com.certification.spring.aop.example9.aspects;

import com.certification.spring.aop.example9.annotations.Sanitize;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MemberSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class, OutputCaptureExtension.class})
class SanitizeAspectUnitTest {

    SanitizeAspect sanitizeAspect;

    @BeforeEach
    public void setUp() {
        sanitizeAspect = new SanitizeAspect();
        
    }

    @Test
    public void shouldAddAroundAspect() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        MethodSignature signature = mock(MethodSignature.class);
        when(proceedingJoinPoint.getSignature()).thenReturn(signature);
        Object[] objects = {};
        when(proceedingJoinPoint.getArgs()).thenReturn(objects);
        when(proceedingJoinPoint.proceed(any())).thenReturn("Test");

        assertEquals("Test", sanitizeAspect.around(proceedingJoinPoint));
        verify(proceedingJoinPoint).proceed(objects);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenJoinPointThrows() throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        MethodSignature signature = mock(MethodSignature.class);
        when(proceedingJoinPoint.getSignature()).thenReturn(signature);
        Object[] objects = {};
        when(proceedingJoinPoint.getArgs()).thenReturn(objects);
        when(proceedingJoinPoint.proceed(any())).thenThrow(new Throwable());

        assertThrows(RuntimeException.class, () -> sanitizeAspect.around(proceedingJoinPoint));
        verify(proceedingJoinPoint).proceed(objects);
    }

    
}