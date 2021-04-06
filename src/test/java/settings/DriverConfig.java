package settings;

import com.codeborne.selenide.Configuration;
import config.ConfigHelper;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverConfig {

    public static void config() {
        Configuration.browserSize = "1920x1080";
        if (ConfigHelper.isRemoteWebDriver()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;
            Configuration.remote = ConfigHelper.getWebRemoteDriver();
        }
    }
}
