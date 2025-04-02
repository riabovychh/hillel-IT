package lesson15;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        int x = 10;
        int y = 0;
//        System.out.println(x/y);

        File path = new File("path");
//        path.createNewFile();
        System.out.println("123");

//        Triangle triangle = new Triangle(2, 3, 5);

//        try - catch - finally
//        try -catch - catch -...
//        try - catch
//        try - finally

        try {
            Triangle triangle = new Triangle(2, 3, 3);
            System.out.println("Start");
        } catch (ArithmeticException | NoSuchFieldError e) {
            System.out.println("Catch arithmetic exception");
        } catch (OwnException ownException) {
            System.out.println("Catch own exception");
//            ownException.
        }
        finally {
            try {
//                close file
                new File("dasd").createNewFile();
            } catch (IOException e) {
                System.out.println("Catch io exception");
                e.getMessage();
            }
            System.out.println("Always do");
        }

        try {
            TriangleValidator.checkSomethingElse();
        } catch (SecondOwnException e) {
            throw new RuntimeException(e);
        }
    }
}
