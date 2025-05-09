package tests.emulator;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import pages.WikipediaOnbordingPage;

import static io.qameta.allure.SeverityLevel.NORMAL;

@EnabledIfSystemProperty(named = "env", matches = "emulator")
public class WikipediaTests extends TestBase {

    WikipediaOnbordingPage wikipediaOnbordingPage = new WikipediaOnbordingPage();

    @Test
    @Tag("mobile")
    @Severity(NORMAL)
    @DisplayName("Проверяем наличие контента в онбординге при первом запуске")
    void searchOnMainScreenTest() {
        wikipediaOnbordingPage.assertThatMainTitleExist()
                .goOnNextScreen()
                .assertThatImageExists()
                .goOnNextScreen()
                .assertThatSubtitleExists()
                .goOnNextScreen()
                .assertThatButtonFinishOnbordingExists();
    }
}


