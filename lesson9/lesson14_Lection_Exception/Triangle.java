package lesson14_Lection_Exception;

public class Triangle {
    private int firstSide;
    private int secondSide;
    private int thirdSide;

    public Triangle(int firstSide, int secondSide, int thirdSide) {
        if ((firstSide + secondSide <= thirdSide) ||
                (secondSide + thirdSide <= firstSide) ||
                (firstSide + thirdSide <= secondSide)) {
//            throw new IllegalArgumentException("asdfas");
            throw new OwnException();
        }
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }
}
