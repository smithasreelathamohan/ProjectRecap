package com.example.projectrecap;

public class Calculator {

    public double add(double a, double b)
    {
        return a + b;
    }
    public double subtract(double a, double b)
    {
        return a - b;
    }
    public int multiply(int a, int b)
    {
        return a * b;
    }
    public int divide(int a, int b)
    {
        if (b == 0)
            throw new ArithmeticException("Cannot Divide by zero");
        else
            return a / b;
    }

}
