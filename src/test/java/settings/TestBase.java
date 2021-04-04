package settings;

import api.steps.WeatherSteps;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    public static WeatherSteps weather;

    @BeforeAll
    public static void init() {
        weather = new WeatherSteps();
    }
}
