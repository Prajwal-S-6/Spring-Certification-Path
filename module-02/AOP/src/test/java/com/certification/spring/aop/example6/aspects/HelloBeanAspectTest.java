package com.certification.spring.aop.example6.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class, OutputCaptureExtension.class})
class HelloBeanAspectTest {

    HelloBeanAspect helloBeanAspect;
    @BeforeEach
    void setUp() {
        helloBeanAspect = new HelloBeanAspect();
    }

    @Test
    public void shouldPrintMethodNames(CapturedOutput capturedOutput) throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.getSignature()).thenReturn(mock(Signature.class));
        when(proceedingJoinPoint.getSignature().getName()).thenReturn("com.test.SomeClass.method1()");

        helloBeanAspect.withinPackage(proceedingJoinPoint);

        assertThat(capturedOutput.getOut()).isEqualToIgnoringWhitespace("Before - Around com.test.SomeClass.method1() \nAfter - Around com.test.SomeClass.method1()");
    }

    @Test
    public void shouldThrowErrorWhenMethodThrows(CapturedOutput capturedOutput) throws Throwable {
        ProceedingJoinPoint proceedingJoinPoint = mock(ProceedingJoinPoint.class);
        when(proceedingJoinPoint.getSignature()).thenReturn(mock(Signature.class));
        when(proceedingJoinPoint.getSignature().getName()).thenReturn("com.test.SomeClass.method1()");
        when(proceedingJoinPoint.proceed()).thenThrow(new RuntimeException());

        assertThrows(RuntimeException.class, () -> helloBeanAspect.withinPackage(proceedingJoinPoint));
        assertThat(capturedOutput.getOut()).isEqualToIgnoringWhitespace("Before - Around com.test.SomeClass.method1()");
        assertThat(capturedOutput.getOut()).doesNotContain("After - Around");

    }

}