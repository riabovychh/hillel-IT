package lesson18.HomeWork;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {
    @DataProvider
    public Object[][] provideSubtractionData() {
        return new Object[][]{{1, 2, -1}, {4, 4, 0}, {5.5, 2.1, 3.4}, {5, 0, 5}};
    }

    @DataProvider
    public Object[][] provideAddingData() {
        return new Object[][]{{1, 2, 3}, {4, 4, 8}, {4.9, 2.5, 7.4}, {5, 0, 5}};
    }

    @DataProvider
    public Object[][] provideMultiplicationData() {
        return new Object[][]{{1, 2, 2}, {4, 4, 16}, {4.9, 2.5, 12.25}, {5, 0, 0}};
    }

    @DataProvider
    public Object[][] provideDivisionData() {
        return new Object[][]{{1, 2, 0.5}, {4, 4, 1}, {5.5, 2.5, 2.2}, {5, 0, 0}};
    }

    @Test(description = "Addition",
            dataProvider = "provideAddingData",
            priority = 4)
    public void testAddition(double number1, double number2, double expected) {
        Calculator calculator = new Calculator(number1, number2);
        double actual = calculator.addOperation();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Subtraction",
            dataProvider = "provideSubtractionData",
            priority = 3)
    public void testSubtraction(double number1, double number2, double expected) {
        Calculator calculator = new Calculator(number1, number2);
        double actual = calculator.subtractOperation();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Multiplication",
            dataProvider = "provideMultiplicationData",
            priority = 2)
    public void testMultiplication(double number1, double number2, double expected) {
        Calculator calculator = new Calculator(number1, number2);
        double actual = calculator.multiplyOperation();
        Assert.assertEquals(actual, expected);
    }

    @Test(description = "Division",
            dataProvider = "provideDivisionData",
            priority = 1)
    public void testDivision(double number1, double number2, double expected) {
        if (number2 == 0) {
            try {
                Calculator calculator = new Calculator(number1, number2);
                calculator.divideOperation();
            } catch (ArithmeticException e) {
                System.out.println("was exception");
            }
        } else {
            Calculator calculator = new Calculator(number1, number2);
            double actual = calculator.divideOperation();
            Assert.assertEquals(actual, expected);
        }
    }
}
