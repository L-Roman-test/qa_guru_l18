package tests.api;

import api.model.CityData;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import settings.TestBase;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class WeatherTests extends TestBase {

    @Tag("API")
    @Test
    public void verifyWeatherInCity() {

        CityData cityData = weather.getWeatherInCity("Prague");

        System.out.println(cityData.getCountry() + "\n" + cityData.getName() + "\n" + cityData.getLatitude() + "\n" + cityData.getLongitude() + "\n" + cityData.getCityId());
        assertThat(cityData.getCountry(), is("CZ"));
        assertThat(cityData.getName(), is("Prague"));
        assertThat(cityData.getLatitude(), is(50.088));
        assertThat(cityData.getLongitude(), is(14.4208));
    }
}
