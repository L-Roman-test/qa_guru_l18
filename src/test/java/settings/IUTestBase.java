package settings;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static config.ConfigHelper.isVideoOn;
import static settings.AttachmentsHelper.*;
import static settings.AttachmentsHelper.attachVideo;

public class IUTestBase {

    @BeforeAll
    public static void init() {
        addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.baseUrl = "https://openweathermap.org";
        DriverConfig.config();
    }

    @AfterEach
    public void attachments() {
        String sessionId = getSessionId();
        attachScreenshot("Last screenshot");
        attachPageSource();
        attachText("Browser console logs", getConsoleLogs());
        if (isVideoOn()) {
            attachVideo(sessionId);
        }
        closeWebDriver();
    }
}
