package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;


public class WikipediaSearchPage {
    final SelenideElement searchField = $(accessibilityId("Search Wikipedia")),
            searchFieldInput = $(id("org.wikipedia.alpha:id/search_src_text")),
            articleInTheList = $(id("org.wikipedia.alpha:id/page_list_item_title")),
            articleTitle = $(accessibilityId("Android"));
    final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Кликаем по строке поиска")
    public WikipediaSearchPage clickOnSearch() {
        searchField.click();
        return this;
    }

    @Step("Вводим в поисковую строку: {query} ")
    public WikipediaSearchPage sendSearchQuery(String query) {
        searchFieldInput.sendKeys(query);
        return this;
    }

    @Step("Проверяем, что есть результаты по запросу")
    public WikipediaSearchPage checkResults() {
        searchResults.shouldHave(sizeGreaterThan(0));
        return this;
    }

    @Step("Открываем статью из списка результатов")
    public WikipediaSearchPage openArticle() {
        articleInTheList.click();
        return this;
    }

    @Step("Проверяем, что открылась нужная статья")
    public WikipediaSearchPage verifyNameOfArticle() {
        articleTitle.shouldHave(Condition.text("Android"));
        return this;
    }
}


