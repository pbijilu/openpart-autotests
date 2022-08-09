package pages;

import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuppliersPage {
    private final By linkToAdvancedSearch = By.xpath("//a[contains(@href, '/poisk/poisk-223-fz/')]");

    public void checkIfLoaded() {
        $(linkToAdvancedSearch).shouldBe(visible);
    }

    public void clickLink(String linkName) {
        if (linkName.equals("Расширенный поиск")) {
            $(linkToAdvancedSearch).click();
        }
    }
}
