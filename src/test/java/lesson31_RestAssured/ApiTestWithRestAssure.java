package lesson31_RestAssured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApiTestWithRestAssure {
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://qauto.forstudy.space";
    }

    @Test
    public void getTest2() throws URISyntaxException, IOException, InterruptedException {
        Response response = RestAssured
                .given()
                .when()
                .get("/api/cars/brands")
                .then()
                .extract()
                .response();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200, "Cтатус код - не 200");

        boolean audiExists = response.jsonPath().getList("data")
                .stream()
                .anyMatch(brand ->
                        ((Integer) ((java.util.Map) brand).get("id") == 1 &&
                                "Audi".equals(((java.util.Map) brand).get("title")))
                );

        softAssert.assertTrue(audiExists, "Response body does not contain Audi with id=1");
    }
}
