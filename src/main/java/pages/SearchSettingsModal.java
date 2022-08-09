package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchSettingsModal {

    private final By checkbox615 = By.xpath("//label[text()='615-�� ��']");
    private final By checkboxExcludeJointTrades = By.xpath("//label[text()='��������� ���������� �������']");
    private final By dateFilter = By.xpath("//div[text()='������� �� �����']");
    private final By deliveryRegionFilter = By.xpath("//div[text()='������ ��������']");
    private final By deliveryRegionSuggestion = By.xpath("//a[@class='cstm-search__suggest']");
    private final By inputDateApplicationSubmissionFrom = By.xpath("//*[@id=\"ftfbn-portal\"]/div[2]/div/div/div/div[1]/div[5]/div[12]/div[2]/div/div/div[1]/div[2]/div[1]/div/div/input");
    private final By inputDateApplicationSubmissionTo = By.xpath("//*[@id=\"ftfbn-portal\"]/div[2]/div/div/div/div[1]/div[5]/div[12]/div[2]/div/div/div[1]/div[2]/div[3]/div/div/input");
    private final By inputDeliveryRegion = By.xpath("//input[@class='form-control-search__input']");
    private final By buttonSearch =  By.xpath("//button[@class='search__btn bottomFilterSearch']");

    public void selectCheckbox(String checkboxName) {
        if (checkboxName.equals("615-��")) {
            if (!$(checkbox615).isSelected()) {
                $(checkbox615).click();
            }
        }
        else if (checkboxName.equals("��������� ���������� �������")) {
            if (!$(checkboxExcludeJointTrades).isSelected()) {
                $(checkboxExcludeJointTrades).click();
            }
        }
    }

    public void checkIfLoaded() {
        $(checkbox615).shouldBe(visible);
    }

    public void openFilter(String filterName) {
        if (filterName.equals("������� �� �����")) {
            $(dateFilter).click();
        }
        else if (filterName.equals("������ ��������")) {
            $(deliveryRegionFilter).click();
        }
    }

    public void enterFromDate(String fieldName, String fromDate) {
        if (fieldName.equals("������ ������")) {
            $(inputDateApplicationSubmissionFrom).sendKeys(fromDate);
            $(inputDateApplicationSubmissionFrom).pressEnter();
        }
    }

    public void enterToDate(String fieldName, String toDate) {
        if (fieldName.equals("������ ������")) {
            $(inputDateApplicationSubmissionTo).sendKeys(toDate);
            $(inputDateApplicationSubmissionTo).pressEnter();
        }
    }

    public void enterDeliveryRegion(String regionName) {
        $(inputDeliveryRegion).sendKeys(regionName);
        $(deliveryRegionSuggestion).click();
    }

    public void clickFind() {
        $(buttonSearch).click();
    }

}
