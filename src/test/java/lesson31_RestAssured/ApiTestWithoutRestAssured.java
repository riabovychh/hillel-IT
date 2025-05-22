package lesson31_RestAssured;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiTestWithoutRestAssured {
    @Test
    public void checkAudiBrand() {
        SoftAssert softAssert = new SoftAssert();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://qauto.forstudy.space/api/cars/brands"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            int statusCode = response.statusCode();
            String responseBody = response.body();

            softAssert.assertEquals(statusCode, 200);

            JSONArray brandsArray;
            try {
                brandsArray = new JSONArray(responseBody);
            } catch (Exception e) {
                JSONObject json = new JSONObject(responseBody);
                brandsArray = json.getJSONArray("data");
            }

            boolean found = false;
            for (int i = 0; i < brandsArray.length(); i++) {
                JSONObject brand = brandsArray.getJSONObject(i);
                if (brand.getInt("id") == 1 && brand.getString("title").equals("Audi")) {
                    found = true;
                    break;
                }
            }

            softAssert.assertTrue(found, "Об'єкт з id=1 та title='Audi' не знайдено у відповіді");

        } catch (Exception e) {
            softAssert.fail("Помилка під час виконання запиту: " + e.getMessage());
        }

        softAssert.assertAll();
    }
}
