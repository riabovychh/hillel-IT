package lesson30_HW_ApiTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiTest {

    @Test
    public void getTest() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://qauto.forstudy.space/api/auth/logout"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();
        String responseBody = response.body();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(statusCode, 200);
        softAssert.assertTrue(responseBody.contains("{\"status\":\"ok\"}"));
    }
}
