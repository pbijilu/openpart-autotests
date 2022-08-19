package pages;

import com.codeborne.selenide.ex.ElementIsNotClickableException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchSettingsModal extends BasePage{

    private final By checkbox615 = By.xpath("//label[text()='615-�� ��']");
    private final By checkboxExcludeJointTrades = By.xpath("//label[text()='��������� ���������� �������']");
    private final By dateFilter = By.xpath("//div[text()='������� �� �����']");
    private final By deliveryRegionFilter = By.xpath("//div[text()='������ ��������']");
    private final By deliveryRegionSuggestion = By.xpath("//a[@class='cstm-search__suggest']");
    private final By inputDateApplicationSubmissionFrom = By.xpath("//div[text()='������ ������']/../div/div[1]/div/div/input");
    private final By inputDateApplicationSubmissionTo = By.xpath("//div[text()='������ ������']/../div/div[3]/div/div/input");
    private final By inputDeliveryRegion = By.xpath("//input[@class='form-control-search__input']");
    private final By buttonSearch =  By.xpath("//button[@class='search__btn bottomFilterSearch']");

    public void selectCheckboxByName(String checkboxName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        if (checkboxName.equals("615-��") && !$(checkbox615).isSelected()) {
                $(checkbox615).click();
        }
        else if (checkboxName.equals("��������� ���������� �������") && !$(checkboxExcludeJointTrades).isSelected()) {
                $(checkboxExcludeJointTrades).click();
        }
    }

    @Override
    public void clickLinkByName(String linkName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {

    }

    @Override
    public void checkIfLoaded() throws NoSuchElementException {
        $(checkbox615).shouldBe(visible);
    }

    public void openFilterByName(String filterName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException  {
        if (filterName.equals("������� �� �����")) {
            $(dateFilter).click();
        }
        else if (filterName.equals("������ ��������")) {
            $(deliveryRegionFilter).click();
        }
    }

    public void enterFromDate(String fieldName, String fromDate) throws NoSuchElementException{
        if (fieldName.equals("������ ������")) {
            $(inputDateApplicationSubmissionFrom).sendKeys(fromDate);
            $(inputDateApplicationSubmissionFrom).pressEnter();
        }
    }

    public void enterToDate(String fieldName, String toDate) throws NoSuchElementException {
        if (fieldName.equals("������ ������")) {
            $(inputDateApplicationSubmissionTo).sendKeys(toDate);
            $(inputDateApplicationSubmissionTo).pressEnter();
        }
    }

    public void enterDeliveryRegion(String regionName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        $(inputDeliveryRegion).sendKeys(regionName);
        $(deliveryRegionSuggestion).click();
    }

    public void clickFind() throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        $(buttonSearch).click();
    }

}
