
package utils;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public float divide(int a, int b) throws DivByZeroException {
        if(b == 0) {
            throw new ArithmeticException("Cannot divide a number by zero ");
        }    return a / b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Integer num1 = Integer.valueOf(args[0]);
        Integer num2 = Integer.valueOf(args[2]);
        switch (args[1]) {
            case "+":
                System.out.println(calc.add(num1, num2));
                break;
            case "-":
                System.out.println(calc.subtract(num1, num2));
                break;
            case "*":
                System.out.println(calc.multiply(num1, num2));
                break;
            case "/":
                try {
                    System.out.println(calc.divide(num1, num2));
                } catch (DivByZeroException e) {
                    System.out.println("Divide by zero error");
                }
                break;
        }
    }

    private class DivByZeroException extends Exception {
    }
}