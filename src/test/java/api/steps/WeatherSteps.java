package api.steps;

import api.model.CityData;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class WeatherSteps {

    public CityData getWeatherInCity(String city) {
        return
        given()
                .baseUri("https://api.openweathermap.org")
                .log().uri()
                .contentType(ContentType.URLENC)
                .formParam("q", city)
                .formParam("appid", "502d31da29891f4a00eac2f46ff2e93b")
                .when()
                .get("/data/2.5/weather")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .as(CityData.class);
    }
}