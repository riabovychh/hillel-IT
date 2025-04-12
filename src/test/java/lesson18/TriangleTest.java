package lesson18;

import lesson15.OwnException;
import lesson15.Triangle;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TriangleTest {

    @DataProvider
    public static Object[][] notValidTriangleParameters() {
        return new Object[][]{{1,3,5}};
    }

    @DataProvider
    public Object[] provideData() {
        return new Object[][]{{3,3,3,9}, {4,4,4,12}, {1,1,1,3}};
    }

    public void setUp() {
        System.out.println("Pre-conditions steps");
    }

    @Test (groups = {"smoke", "base"},
            dataProvider = "provideData")
    public void perimeterTest(int side1, int side2, int side3, double expected) {
        // given
//        double expected = 9;
//        int side1 = 3;
//        int side2 = 3;
//        int side3 = 3;

        // when
        Triangle triangle = new Triangle (side1, side2, side3);
        double actual = triangle.getPerimeter();

        // then
//        if (actual == expected) {
//            System.out.println("Passed");
//        } else {
//            System.out.println("Failed");
//        }

        Assert.assertEquals(actual, expected);
    }

    @Test (dataProvider = "notValidTriangleParameters", expectedExceptions = {OwnException.class}) // який тип помилки ти очiкуещ
    public void notValidTriangleTest(int side1, int side2, int side3){
        Triangle triangle = new Triangle(side1, side2, side3);
        // вместо expectedException
        //  Assert.assertThrows(OwnException.class, () -> new Triangle(side1, side2, side3)); // какую ошибку ожидаем, и на каком месте
        // Assert - выполняет шаги (код), которые были после возникновения ексепшена, exceptedExceptions - не выполняет
        System.out.println("end");
    }
}
