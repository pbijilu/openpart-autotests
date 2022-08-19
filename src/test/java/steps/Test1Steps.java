package steps;

import com.codeborne.selenide.ex.ElementIsNotClickableException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Trade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import pages.AdvancedSearchPage;
import pages.MainPage;
import pages.SearchSettingsModal;
import pages.SuppliersPage;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.open;

public class Test1Steps {
    private static final Logger log = LogManager.getLogger();
    private final MainPage mainPage;
    private final SuppliersPage suppliersPage;
    private final AdvancedSearchPage advancedSearchPage;
    private final SearchSettingsModal searchSettingsModal;

    public Test1Steps() {
        mainPage = new MainPage();
        suppliersPage = new SuppliersPage();
        advancedSearchPage = new AdvancedSearchPage();
        searchSettingsModal = new SearchSettingsModal();
    }

    @When("Click {string} in {string} column in footer")
    public void clickLinkInTheColumnInFooter(String linkName, String columnName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        mainPage.clickLinkByLinkAndColumnNames(linkName, columnName);

        log.info(MessageFormat.format("Переходим на \"{0}\"", linkName));
    }

    @And("Click {string} on suppliers page")
    public void clickLinkOnSuppliersPage(String linkName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        suppliersPage.checkIfLoaded();

        suppliersPage.clickLinkByName(linkName);

        log.info(MessageFormat.format("Переходим на \"{0}\"", linkName));
    }

    @And("Click {string} on advanced search page")
    public void clickLinkOnAdvancedSearchPage(String linkName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        advancedSearchPage.checkIfLoaded();

        advancedSearchPage.clickLinkByName(linkName);

        log.info(MessageFormat.format("Переходим на \"{0}\"", linkName));
    }

    @And("Select {string} checkbox on search settings modal window")
    public void selectCheckboxOnSearchSettingModalWindow(String checkboxName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        searchSettingsModal.checkIfLoaded();

        searchSettingsModal.selectCheckboxByName(checkboxName);

        log.info(MessageFormat.format("Отмечаем чекбокс \"{0}\"", checkboxName));
    }

    @And("Open {string} category on search settings modal window")
    public void openCategoryOnSearchSettingsModalWindow(String filterName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        searchSettingsModal.openFilterByName(filterName);

        log.info(MessageFormat.format("Открываем фильтр \"{0}\"", filterName));
    }

    @And("Enter today's date in {string} from\\/to fields")
    public void enterTodaySDateInFromToFields(String fieldName) throws NoSuchElementException {
        var dateFrom = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        var dateTo = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        searchSettingsModal.enterFromDate(fieldName, dateFrom);
        searchSettingsModal.enterToDate(fieldName, dateTo);

        log.info(MessageFormat.format("Вводим даты от/до в поле \"{0}\"", fieldName));
    }

    @And("Enter {string} in delivery region input field")
    public void enterInDeliveryRegionInputField(String regionName) throws NoSuchElementException {
        searchSettingsModal.enterDeliveryRegion(regionName);

        log.info(MessageFormat.format("Вводим регион \"{0}\"", regionName));
    }

    @And("Click find button")
    public void clickFindButton() throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        searchSettingsModal.clickFind();

        log.info("Нажимаем кнопку поиска");
    }

    @And("Load more trades until all of them are loaded")
    public void loadMoreTradesUntilAllOfThemAreLoaded() throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        advancedSearchPage.checkIfLoaded();
        advancedSearchPage.loadMore();

        log.info("Загружаем все полученные закупки");
    }

    @Then("Collect and log data on prices and quantity")
    public void collectAndLogDataOnPricesAndQuantity() throws NoSuchElementException {
        List<Trade> tradeList = null;

        advancedSearchPage.checkIfLoaded();

        tradeList = advancedSearchPage.getTrades();

        double totalSum = 0;

        for (var trade : tradeList) {
            log.info(trade);
            totalSum += trade.getPrice();
        }

        log.info(MessageFormat.format("Общая сумма цен всех отфильтрованных закупок: {0}", totalSum));
    }
}
