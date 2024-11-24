package com.rodrigotroy.learningjaxrs.domain;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlTransient;
import java.util.function.BiFunction;

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
    SUBTRACT((a, b) -> a - b),
    MULTIPLY((a, b) -> a * b),
    DIVIDE((a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    });

    @XmlTransient
    private final BiFunction<Double, Double, Double> operation;

    Operation(BiFunction<Double, Double, Double> operation) {
        this.operation = operation;
    }

    @XmlTransient
    public Double apply(Double a, Double b) {
        return operation.apply(a, b);
    }
}
