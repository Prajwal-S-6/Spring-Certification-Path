package com.spring.data.example4.callback.custom;

import com.spring.data.example4.callback.custom.evaluator.NumbersEvaluator;
import com.spring.data.example4.callback.custom.expression.AddExpressionEvaluator;
import com.spring.data.example4.callback.custom.expression.ExpressionEvaluator;
import com.spring.data.example4.callback.custom.printer.StandardValuePrinter;
import com.spring.data.example4.callback.custom.printer.ValuePrinter;

public class Example {

    public static void main(String[] args) {
        new Example().run();
    }

    private void run() {
        /// callback using class that implements interface
        // ExpressionEvaluator expressionEvaluator = new AddExpressionEvaluator();

        /// using anonymous class
//        ExpressionEvaluator expressionEvaluator = new ExpressionEvaluator() {
//            @Override
//            public int evaluate(int a, int b) {
//                return a+b;
//            }
//        };

        /// using lambda expression
        // ExpressionEvaluator expressionEvaluator = (int a, int b) -> a+b;
        ExpressionEvaluator expressionEvaluator = (int a, int b) -> {
            return b - a;
        };


        /// using method reference
        // ExpressionEvaluator expressionEvaluator = Integer::sum;
        // ExpressionEvaluator expressionEvaluator = this::powEvaluator;


        ValuePrinter valuePrinter = new StandardValuePrinter();
        NumbersEvaluator evaluator = new NumbersEvaluator();


        evaluator.evaluate(2, expressionEvaluator, valuePrinter);
    }

    private int powEvaluator(int a, int b) {
        return (int) Math.pow(a, b);
    }
}
