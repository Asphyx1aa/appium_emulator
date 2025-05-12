package tests;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.WikipediaOnbordingPage;
import pages.WikipediaSearchPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;

public class WikipediaTests extends TestBase  {
    final WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();
    final WikipediaOnbordingPage wikipediaOnbordingPage = new WikipediaOnbordingPage();

    @Test
    @Tag("browserstack")
    @Severity(CRITICAL)
    @DisplayName("Проверка работы поиска на главном экране приложения")
    void searchOnMainScreenTest() {
        String searchQuery = "Appium";

        wikipediaSearchPage.clickOnSearch()
                .sendSearchQuery(searchQuery)
                .checkResults();
    }

    @Test
    @Tag("browserstack")
    @Severity(CRITICAL)
    @DisplayName("Проверка корректного открывания статьи из списка результатов")
    void openArticleFromTheResultList() {
        String searchQuery = "Android";

        wikipediaSearchPage.clickOnSearch()
                .sendSearchQuery(searchQuery)
                .openArticle()
                .verifyNameOfArticle();
    }

    @Test
    @Tag("local")
    @Tag("emulator")
    @Severity(NORMAL)
    @DisplayName("Проверяем наличие контента в онбординге при первом запуске")
    void verifyThatAllContentExists() {
        wikipediaOnbordingPage.assertThatMainTitleExist()
                .goOnNextScreen()
                .assertThatImageExists()
                .goOnNextScreen()
                .assertThatSubtitleExists()
                .goOnNextScreen()
                .assertThatButtonFinishOnbordingExists();
    }
}


