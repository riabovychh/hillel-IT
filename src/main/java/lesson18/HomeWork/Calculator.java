package lesson18.HomeWork;

public class Calculator {
    private double firstNumber;
    private double secondNumber;

    public Calculator(double firstNumber, double secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public double addOperation() {
        return firstNumber + secondNumber;
    }

    public double subtractOperation(){
        return firstNumber - secondNumber;
    }

    public double multiplyOperation(){
        return firstNumber * secondNumber;
    }

    public double divideOperation() throws ArithmeticException {
        if (secondNumber!= 0) {
            return firstNumber / secondNumber;
        } else {
            throw new ArithmeticException();
        }
    }

//    public double getFirstNumber() {
//        return firstNumber;
//    }
//
//    public double getSecondNumber() {
//        return secondNumber;
//    }
//
//    public void setFirstNumber(double firstNumber) {
//        this.firstNumber = firstNumber;
//    }
//
//    public void setSecondNumber(double secondNumber) {
//        this.secondNumber = secondNumber;
//    }
}
