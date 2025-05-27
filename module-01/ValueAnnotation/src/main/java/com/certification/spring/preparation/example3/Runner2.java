package com.certification.spring.preparation.example3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Runner2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        context.registerShutdownHook();

        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setBeanResolver(new BeanFactoryResolver(context));

        ExpressionParser parser = new SpelExpressionParser();

        System.out.println(
                parser.parseExpression("@springBean1.streetName").getValue(evaluationContext)
        );
        System.out.println(
                parser.parseExpression("@springBean1.accountBalance + 1000").getValue(evaluationContext)
        );
        System.out.println(
                parser.parseExpression("@springBean1.casesMap.get('caseA')").getValue(evaluationContext)
        );

    }
}
