package api.steps;

import api.model.CityData;
import config.APIConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class WeatherSteps {
    static final APIConfig config = ConfigFactory.create(APIConfig.class, System.getProperties());

    public CityData getWeatherInCity(String city) {
        return
                given()
                        .baseUri("https://api.openweathermap.org")
                        .filter(new AllureRestAssured().setRequestTemplate("request.ftl").setResponseTemplate("response.ftl"))
                        .log().uri()
                        .contentType(ContentType.URLENC)
                        .formParam("q", city)
                        .formParam("appid", config.accessToken())
                        .when()
                        .get("/data/2.5/weather")
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(CityData.class);
    }
}