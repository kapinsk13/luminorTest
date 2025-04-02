package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Step;

public class WebDriverManager {

    @Step("Configure WebDriver")
    public static void setupWebDriver() {
        Dotenv dotenv = Dotenv.load();
        Configuration.browser = dotenv.get("BROWSER");
        Configuration.browserSize = dotenv.get("BROWSERSIZE");
        Configuration.timeout = Long.parseLong(dotenv.get("TIMEOUT"));
        Configuration.pageLoadTimeout = Long.parseLong(dotenv.get("PAGE_LOAD_TIMEOUT"));
    }

    @Step("Close WebDriver")
    public static void tearDown() {
        Selenide.closeWebDriver();
    }
}
