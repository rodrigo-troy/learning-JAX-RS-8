package com.rodrigotroy.learningjaxrs.domain;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 23-11-24
 * Time: 21:34
 */
@XmlRootElement
public class OperationRequest {
    @NotNull(message = "The first number is required")
    @Digits(integer = 10, fraction = 6, message = "The first number must be a valid numerical value")
    private Double firstNumber;

    @NotNull(message = "The second number is required")
    @Digits(integer = 10, fraction = 6, message = "The second number ust be a valid numerical value")
    private Double secondNumber;

    @NotNull(message = "A specific operation type is required. Ex: ADD, SUBTRACT, MULTIPLY, DIVIDE")
    private Operation operation;

    public Double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public Double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    @Override
    public String toString() {
        return "OperationRequest{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", operation=" + operation +
                '}';
    }
}
