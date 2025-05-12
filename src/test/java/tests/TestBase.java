package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import drivers.BrowserstackDriver;
import drivers.LocalDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.EnvHelper.isBrowserStack;

public class TestBase {
    @BeforeAll
    static void testSetup() {
        if(isBrowserStack) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else {
            Configuration.browser = LocalDriver.class.getName();
        }
        Configuration.browserSize = null;
        Configuration.timeout = 30000;
    }

    @BeforeEach
    void beforeEach() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void afterEach() {
        Attach.pageSource();
        Attach.screenshotAs("Last Screenshot");

        if(isBrowserStack) {
            String sessionId = Selenide.sessionId().toString();
            closeWebDriver();
            Attach.addVideo(sessionId);
        } else {
            closeWebDriver();
        }
    }
}
