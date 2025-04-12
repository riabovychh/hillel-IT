package lesson15;

public class Triangle {

    private int firstSide;
    private int secondSide;
    private int thirdSide;

    public Triangle(int firstSide, int secondSide, int thirdSide) {
        TriangleValidator.checkTriangleSides(firstSide, secondSide, thirdSide);
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }
}