package tests.ui;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import settings.IUTestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends IUTestBase {

    @Test
    @Tag("UI")
    @Story("Search city on the main page ")
    @DisplayName("found city should have weather information")
    public void searchCityTest() {
        String city = "Prague, CZ";

        step("open MainPage", (step) -> {
            open("");
        });
        step("find a city", (step) -> {
            $(".search input").setValue(city);
            $(".search button").click();
            $$(".search-dropdown-menu span").findBy(text(city)).click();
        });
        step("check the weather data", (step) -> {
            $(".current-container.mobile-padding h2").shouldHave(text(city));
            $(".nowrap.horizontal").shouldBe(visible);
            $(".weather-items.standard-padding").shouldBe(visible);
        });

    }
}
