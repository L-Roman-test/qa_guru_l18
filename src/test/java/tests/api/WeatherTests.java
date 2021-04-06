package tests.api;

import api.model.CityData;

import api.model.Coord;
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

        assertThat(cityData.getSys().getCountry(), is("CZ"));
        assertThat(cityData.getName(), is("Prague"));
        assertThat(cityData.getCoord().getLat(), is(50.088));
        assertThat(cityData.getCoord().getLon(), is(14.4208));
    }
}
