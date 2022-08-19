package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.ex.ElementIsNotClickableException;
import models.Trade;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AdvancedSearchPage extends BasePage {
    private final By linkToSearchSettings = By.xpath("//span[@class='main-search__settings-btn']");
    private final By buttonLoadMore = By.id("load-more");
    private final By trades = By.className("card-item");
    private final By loader = By.className("loader");
    private final By modalConsultation = By.xpath("//div[@class='modal-wrap consultation_modal']");
    private final By buttonCloseConsultation = By.xpath("//button[@class='modal-close consultation_modal']");

    @Override
    public void clickLinkByName(String linkName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        if (linkName.equals("Настройка поиска")) {
            $(linkToSearchSettings).click();
        }
    }

    public void loadMore() throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        while ($(buttonLoadMore).isDisplayed()) {
            //anti-captcha wait
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {

            }
            if ($(modalConsultation).isDisplayed()) {
                $(buttonCloseConsultation).click();
            }
            $(buttonLoadMore).click();
            $(loader).shouldNotBe(visible);
        }
    }

    @Override
    public void checkIfLoaded() throws NoSuchElementException {
        $(linkToSearchSettings).shouldBe(visible).exists();
        $(loader).shouldNotBe(visible);
    }

    public List<Trade> getTrades() throws NumberFormatException{
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
