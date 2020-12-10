package com.hukuta94.simplecalculator.domain.arabicroman.model;

import java.util.Objects;

public final class InputData
{
    private int firstOperand;
    private int secondOperand;
    private String operator;
    private NumberType type;

    public InputData( int firstOperand, int secondOperand, String operator, NumberType type ) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
        this.type = type;
    }

    public int getFirstOperand() {
        return firstOperand;
    }

    public int getSecondOperand() {
        return secondOperand;
    }

    public String getOperator() {
        return operator;
    }

    public NumberType getType() {
        return type;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o )
            return true;

        if ( !( o instanceof InputData ))
            return false;

        InputData inputData = (InputData) o;

        return firstOperand == inputData.firstOperand &&
                secondOperand == inputData.secondOperand &&
                Objects.equals( operator, inputData.operator ) &&
                type == inputData.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash( firstOperand, secondOperand, operator, type );
    }
}