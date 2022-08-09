package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Trade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.AdvancedSearchPage;
import pages.MainPage;
import pages.SearchSettingsModal;
import pages.SuppliersPage;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class Test1Steps {
    private static final Logger log = LogManager.getLogger();
    private final MainPage basicPage;
    private final SuppliersPage suppliersPage;
    private final AdvancedSearchPage advancedSearchPage;
    private final SearchSettingsModal searchSettingsModal;

    public Test1Steps() {
        basicPage = new MainPage();
        suppliersPage = new SuppliersPage();
        advancedSearchPage = new AdvancedSearchPage();
        searchSettingsModal = new SearchSettingsModal();
    }

    @Given("Page opened {string}")
    public void openUrl(String url) {
        try {
            open(url);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info(MessageFormat.format("Открыта страница {0}", url));
    }

    @When("Click {string} in {string} column in footer")
    public void clickLinkInTheColumnInFooter(String linkName, String columnName) {
        try {
            basicPage.clickLink(linkName, columnName);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info(MessageFormat.format("Переходим на \"{0}\"", linkName));
    }

    @And("Click {string} on suppliers page")
    public void clickLinkOnSuppliersPage(String linkName) {
        try {
            suppliersPage.checkIfLoaded();

            suppliersPage.clickLink(linkName);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info(MessageFormat.format("Переходим на \"{0}\"", linkName));
    }

    @And("Click {string} on advanced search page")
    public void clickLinkOnAdvancedSearchPage(String linkName) {
        try {
            advancedSearchPage.checkIfLoaded();

            advancedSearchPage.clickLink(linkName);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info(MessageFormat.format("Переходим на \"{0}\"", linkName));
    }

    @And("Select {string} checkbox on search settings modal window")
    public void selectCheckboxOnSearchSettingModalWindow(String checkboxName) {
        try {
            searchSettingsModal.checkIfLoaded();

            searchSettingsModal.selectCheckbox(checkboxName);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info(MessageFormat.format("Отмечаем чекбокс \"{0}\"", checkboxName));
    }

    @And("Open {string} category on search settings modal window")
    public void openCategoryOnSearchSettingsModalWindow(String filterName) {
        try {
            searchSettingsModal.openFilter(filterName);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info(MessageFormat.format("Открываем фильтр \"{0}\"", filterName));
    }

    @And("Enter today's date in {string} from\\/to fields")
    public void enterTodaySDateInFromToFields(String fieldName) {
        try {
            var dateFrom = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            var dateTo = dateFrom;
            //LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            searchSettingsModal.enterFromDate(fieldName, dateFrom);
            searchSettingsModal.enterToDate(fieldName, dateTo);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info(MessageFormat.format("Вводим даты от/до в поле \"{0}\"", fieldName));
    }

    @And("Enter {string} in delivery region input field")
    public void enterInDeliveryRegionInputField(String regionName) {
        try {
            searchSettingsModal.enterDeliveryRegion(regionName);
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info(MessageFormat.format("Вводим регион \"{0}\"", regionName));
    }

    @And("Click find button")
    public void clickFindButton() {
        try {
            searchSettingsModal.clickFind();
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info("Нажимаем кнопку поиска");
    }

    @And("Load more trades until all of them are loaded")
    public void loadMoreTradesUntilAllOfThemAreLoaded() {
        try {
            advancedSearchPage.checkIfLoaded();

            advancedSearchPage.loadMore();
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        log.info("Загружаем все полученные закупки");
    }

    @Then("Collect and log data on prices and quantity")
    public void collectAndLogDataOnPricesAndQuantity() {
        List<Trade> tradeList = null;
        try {
            advancedSearchPage.checkIfLoaded();

            tradeList = advancedSearchPage.getTrades();
        }
        catch (Exception e) {
            log.error(e.getMessage());
        }

        double totalSum = 0;

        for (var trade : tradeList) {
            log.info(trade);
            totalSum += trade.getPrice();
        }

        log.info(MessageFormat.format("Общая сумма цен всех отфильтрованных закупок: {0}", totalSum));
    }
}
