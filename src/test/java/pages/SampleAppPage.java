package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.be;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;

public class SampleAppPage {
    static final SelenideElement UiElement = $(accessibilityId("UI Elements"));

    @Step("Проверяем, что UI Element существует")
    public SampleAppPage assertThatUIElementExists() {
        UiElement.should(be(visible));
        return this;
    }
}
