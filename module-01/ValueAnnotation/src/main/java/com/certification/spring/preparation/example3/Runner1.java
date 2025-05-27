package com.certification.spring.preparation.example3;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.util.Arrays;

public class Runner1 {

    public static void main(String[] args) {
        ExpressionParser expressionParser = new SpelExpressionParser();

        System.out.println(expressionParser.parseExpression("2+2").getValue());
        System.out.println(expressionParser.parseExpression("'Hello'.concat('World')").getValue());
        System.out.println(expressionParser.parseExpression("new String('Wall Street').toUpperCase()").getValue());
        System.out.println(expressionParser.parseExpression("24 * 60").getValue());
        System.out.println(expressionParser.parseExpression("{1,2,3}").getValue());
        System.out.println(expressionParser.parseExpression("{'A':1, 'B':2}").getValue());
        System.out.println(Arrays.toString((int[]) expressionParser.parseExpression("new int[]{1, 2, 3}").getValue()));
        System.out.println(expressionParser.parseExpression("2 > 6").getValue());
    }
}
