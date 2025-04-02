package tests;

import pages.HomePage;
import pages.SearchResultsPage;
import pages.TitlePage;
import utils.WebDriverManager;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ImdbSearchTest {

    @BeforeMethod
    public void setUp() {
        WebDriverManager.setupWebDriver();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverManager.tearDown();
    }

    @Test
    @Description("Search for QA on IMDB and retrieving top cast members")
    public void testImdbSearchAndTitleDetails() {
        HomePage.openPage();
        HomePage.searchFor("QA");
        SearchResultsPage.clickOnFirstTitle();
        TitlePage.getTopCast(5);
    }
}
