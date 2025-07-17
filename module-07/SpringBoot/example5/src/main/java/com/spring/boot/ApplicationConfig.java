package com.spring.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class ApplicationConfig {

    private int property1;
    private int property2;
    private int property3;
    private int property4;
    private int property5;
    private int property6;
    private int property7;
    private int property8;
    private int property9;
    private int property10;
    private int property11;
    private int property12;
    private int property13;
    private int property14;
    private int property15;
    private int property16;

    public int getProperty1() {
        return property1;
    }

    public void setProperty1(int property1) {
        this.property1 = property1;
    }

    public int getProperty2() {
        return property2;
    }

    public void setProperty2(int property2) {
        this.property2 = property2;
    }

    public int getProperty3() {
        return property3;
    }

    public void setProperty3(int property3) {
        this.property3 = property3;
    }

    public int getProperty4() {
        return property4;
    }

    public void setProperty4(int property4) {
        this.property4 = property4;
    }

    public int getProperty5() {
        return property5;
    }

    public void setProperty5(int property5) {
        this.property5 = property5;
    }

    public int getProperty6() {
        return property6;
    }

    public void setProperty6(int property6) {
        this.property6 = property6;
    }

    public int getProperty7() {
        return property7;
    }

    public void setProperty7(int property7) {
        this.property7 = property7;
    }

    public int getProperty8() {
        return property8;
    }

    public void setProperty8(int property8) {
        this.property8 = property8;
    }

    public int getProperty9() {
        return property9;
    }

    public void setProperty9(int property9) {
        this.property9 = property9;
    }

    public int getProperty10() {
        return property10;
    }

    public void setProperty10(int property10) {
        this.property10 = property10;
    }

    public int getProperty11() {
        return property11;
    }

    public void setProperty11(int property11) {
        this.property11 = property11;
    }

    public int getProperty12() {
        return property12;
    }

    public void setProperty12(int property12) {
        this.property12 = property12;
    }

    public int getProperty13() {
        return property13;
    }

    public void setProperty13(int property13) {
        this.property13 = property13;
    }

    public int getProperty14() {
        return property14;
    }

    public void setProperty14(int property14) {
        this.property14 = property14;
    }

    public int getProperty15() {
        return property15;
    }

    public void setProperty15(int property15) {
        this.property15 = property15;
    }

    public int getProperty16() {
        return property16;
    }

    public void setProperty16(int property16) {
        this.property16 = property16;
    }

    @Override
    public String toString() {
        return "ApplicationConfig{" +
                "property1=" + property1 +
                ", property2=" + property2 +
                ", property3=" + property3 +
                ", property4=" + property4 +
                ", property5=" + property5 +
                ", property6=" + property6 +
                ", property7=" + property7 +
                ", property8=" + property8 +
                ", property9=" + property9 +
                ", property10=" + property10 +
                ", property11=" + property11 +
                ", property12=" + property12 +
                ", property13=" + property13 +
                ", property14=" + property14 +
                ", property15=" + property15 +
                ", property16=" + property16 +
                '}';
    }
}
