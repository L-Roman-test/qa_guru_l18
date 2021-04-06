package settings;

import api.steps.WeatherSteps;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class APITestBase {
    public static WeatherSteps weather;

    @BeforeAll
    public static void init() {
        weather = new WeatherSteps();
        RestAssured.baseURI = "https://api.openweathermap.org";
    }
}
