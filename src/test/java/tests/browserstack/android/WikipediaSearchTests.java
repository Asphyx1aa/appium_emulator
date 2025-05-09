package tests.browserstack.android;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.WikipediaSearchPage;
import tests.browserstack.TestBase;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class WikipediaSearchTests extends TestBase {
    final WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("android")
    })
    @Severity(CRITICAL)
    @DisplayName("Проверка работы поиска на главном экране приложения")
    void searchOnMainScreenTest() {
        String searchQuery = "Appium";

        wikipediaSearchPage.clickOnSearch()
                .sendSearchQuery(searchQuery)
                .checkResults();
    }

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("android")
    })
    @Severity(CRITICAL)
    @DisplayName("Проверка корректного открывания статьи из списка результатов")
    void openArticleFromTheResultList() {
        String searchQuery = "Android";

        wikipediaSearchPage.clickOnSearch()
                .sendSearchQuery(searchQuery)
                .openArticle()
                .verifyNameOfArticle();
    }
}


