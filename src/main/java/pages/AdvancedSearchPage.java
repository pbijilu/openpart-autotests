package pages;

import com.codeborne.selenide.ElementsCollection;
import models.Trade;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AdvancedSearchPage{
    private final By linkToSearchSettings = By.xpath("//span[@class='main-search__settings-btn']");
    private final By buttonLoadMore = By.id("load-more");
    private final By trades = By.className("card-item");
    private final By loader = By.className("loader");
    private final By modalConsultation = By.xpath("//div[@class='modal-wrap consultation_modal']");
    private final By buttonCloseConsultation = By.xpath("//button[@class='modal-close consultation_modal']");

    public void clickLink(String linkName) {
        if (linkName.equals("Настройка поиска")) {
            $(linkToSearchSettings).click();
        }
    }

    public void loadMore() throws InterruptedException {
        while ($(buttonLoadMore).isDisplayed()) {
            //anti-captcha wait
            Thread.sleep(2000);
            if ($(modalConsultation).isDisplayed()) {
                $(buttonCloseConsultation).click();
            }
            $(buttonLoadMore).click();
            $(loader).shouldNotBe(visible);
        }
    }

    public void checkIfLoaded() {
        $(linkToSearchSettings).shouldBe(visible);
        $(loader).shouldNotBe(visible);
    }

    public List<Trade> getTrades() {
        List<Trade> tradesList = new ArrayList<>();
        ElementsCollection trades = $$(this.trades);
        for (var trade : trades) {
            var tradePrice = Float.parseFloat(trade.$x("div[@class='card-item__properties']/div[1]/div[2]").getAttribute("content"));
            var tradeItems = trade.$$x("div[7]/div/table[@class='card-table']/tbody/tr");
            tradesList.add(new Trade(tradePrice, tradeItems.size() - 1));
        }
        return tradesList;
    }
}
