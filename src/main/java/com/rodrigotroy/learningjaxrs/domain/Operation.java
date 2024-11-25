package com.rodrigotroy.learningjaxrs.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlTransient;
import java.util.function.BinaryOperator;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 23-11-24
 * Time: 21:32
 */
@XmlEnum
public enum Operation {
    ADD(Double::sum),
    DIVIDE((a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return a / b;
    }),
    MULTIPLY((a, b) -> a * b),
    SUBTRACT((a, b) -> a - b);

    @XmlTransient
    private final BinaryOperator<Double> function;

    Operation(BinaryOperator<Double> function) {
        this.function = function;
    }

    @XmlTransient
    public Double apply(Double a, Double b) {
        return function.apply(a, b);
    }
}
