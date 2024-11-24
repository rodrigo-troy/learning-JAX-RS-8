package com.rodrigotroy.learningjaxrs.domain;

/**
 * Created with IntelliJ IDEA.
 * $ Project: learning-JAX-RS
 * User: rodrigotroy
 * Date: 23-11-24
 * Time: 21:34
 */
@javax.xml.bind.annotation.XmlRootElement
public class OperationRequest {
    private Double firstNumber;
    private Double secondNumber;
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
