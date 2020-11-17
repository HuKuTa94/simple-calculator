package com.hukuta94.simplecalculator.model;

public final class Data
{
    private int firstNumber;
    private int secondNumber;
    private String operator;
    private NumberType type;

    public Data( int firstNumber, int secondNumber, String operator, NumberType type ) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
        this.type = type;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public String getOperator() {
        return operator;
    }

    public NumberType getType() {
        return type;
    }
}
