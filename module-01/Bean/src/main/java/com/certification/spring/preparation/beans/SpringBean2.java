package com.certification.spring.preparation.beans;

public class SpringBean2 {
    private void destroy() {
        System.out.println(getClass().getSimpleName() + "::destroy()");
    }
}
