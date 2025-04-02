package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import io.github.cdimascio.dotenv.Dotenv;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class HomePage {
    private static final By imdbLogo = By.id("home_img_holder");
    private static final By searchBox = By.id("suggestion-search");
    private static final By searchButton = By.id("suggestion-search-button");
    private static final SelenideElement consentBanner = $("[data-testid='consent-banner']");
    private static final SelenideElement consentBannerRejectButton = $("[data-testid='reject-button']");

    @Step("Open IMDB homepage")
    public static void openPage() {
        Dotenv dotenv = Dotenv.load();
        Selenide.open(dotenv.get("BASE_URL"));
        $(imdbLogo).shouldBe(visible, Duration.ofMillis(10000));
        try {
            consentBanner.shouldBe(visible, Duration.ofMillis(5000));
            consentBannerRejectButton.click();
        } catch (ElementNotFound | TimeoutException e) {
            System.out.println("Consent banner not found");
        }
    }


    @Step("Search for '{searchText}'")
    public static void searchFor(String searchText) {
        $(searchBox).setValue(searchText);
        $(searchButton).click();
    }
}
