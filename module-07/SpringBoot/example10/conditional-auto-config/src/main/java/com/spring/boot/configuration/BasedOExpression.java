package com.spring.boot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.env.Environment;

@AutoConfiguration
//@ConditionalOnExpression("#{2+2 == 4}")
@ConditionalOnExpression("#{@testBean.returnBoolean()}")
public class BasedOExpression {

    public void print() {
        System.out.println("ConditionalOnExpression");
    }
}
