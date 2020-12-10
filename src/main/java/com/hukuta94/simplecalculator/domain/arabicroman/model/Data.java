package com.hukuta94.simplecalculator.domain.arabicroman.model;

import java.util.Objects;

public final class Data {

    private int firstNumber;    // первый операнд
    private int secondNumber;   // второй операнд
    private String operator;    // тип операции
    private NumberType type;    // тип чисел (рим./араб.)

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Data)) return false;
        Data data = (Data) o;
        return firstNumber == data.firstNumber &&
                secondNumber == data.secondNumber &&
                Objects.equals(operator, data.operator) &&
                type == data.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber, operator, type);
    }
}