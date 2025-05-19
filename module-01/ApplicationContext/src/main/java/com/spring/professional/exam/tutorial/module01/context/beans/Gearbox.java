package com.spring.professional.exam.tutorial.module01.context.beans;

import org.springframework.stereotype.Component;

@Component
class Gearbox {
    void putIntoDrivePosition() {
        System.out.println("Putting Gearbox into Drive Position");
    }
}
