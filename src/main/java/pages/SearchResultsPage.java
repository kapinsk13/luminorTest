package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    private static final ElementsCollection searchResults = $$(".find-title-result");

    @Step("Click on first title in search results")
    public static void clickOnFirstTitle() {
        searchResults.first().click();
    }
}
