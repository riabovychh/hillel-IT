package lesson15;

public final class TriangleValidator {
    private TriangleValidator() {
    }

    public static void checkTriangleSides(int firstSide, int secondSide, int thirdSide) {
        if ((firstSide + secondSide <= thirdSide) ||
                (secondSide + thirdSide <= firstSide) ||
                (firstSide + thirdSide <= secondSide)) {
//            throw new IllegalArgumentException("asdfas");
            throw new OwnException();
        }
    }

    public static void checkSomethingElse() throws SecondOwnException {
        if (true) {
            throw new SecondOwnException("Some message");
        }
    }
}