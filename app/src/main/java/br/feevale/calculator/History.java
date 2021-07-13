package br.feevale.calculator;

import java.io.Serializable;

public class History implements Serializable {
    private float number1 = 0;
    private float number2 = 0;
    private char operator = ' ';
    private float result = 0;

    public float getNumber1() {
        return number1;
    }

    public void setNumber1(float number1) {
        this.number1 = number1;
    }

    public float getNumber2() {
        return number2;
    }

    public void setNumber2(float number2) {
        this.number2 = number2;
        setResult();
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public float getResult() {
        return result;
    }

    private void setResult() {
        switch (getOperator()) {
            case '+':
                this.result = number1 + number2;
                break;
            case '-':
                this.result = number1 - number2;
                break;
            case 'x':
                this.result = number1 * number2;
                break;
            case '÷':
                // Dividing by zero is an impossible count
                if (number2 != 0) {
                    this.result = number1 / number2;
                }
                break;
        }
    }
}
