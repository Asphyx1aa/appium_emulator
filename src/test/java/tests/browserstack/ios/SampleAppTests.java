package tests.browserstack.ios;

import io.qameta.allure.Severity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import pages.SampleAppPage;
import tests.browserstack.TestBase;

import static io.qameta.allure.SeverityLevel.MINOR;

@EnabledIfSystemProperty(named = "platform", matches = "ios")
public class SampleAppTests extends TestBase {
    final SampleAppPage sampleAppPage = new SampleAppPage();

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("ios")
    })
    @Severity(MINOR)
    @DisplayName("Проверяем, что поиск возвращает результаты")
    void test() {
        sampleAppPage.assertThatUIElementExists();
    }
}


