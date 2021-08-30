package lesson1.test;

import lesson1.model.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator c1 = new Calculator();
        c1.enter(1);
        c1.enter(2);
        c1.add();

        assert c1.getResult() == 3;

        c1.multiply();
        assert c1.getResult() == 1 * 2;
        c1.enter(2);
        c1.enter(3);
        c1.multiply();
        assert c1.getResult() == 2 * 3;

        c1.subtract();
        assert c1.getResult() == 3 - 2;

        c1.divide();
        assert c1.getResult() == 3.0 / 2;
    }
}
