package pages;

import com.codeborne.selenide.ex.ElementIsNotClickableException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuppliersPage extends BasePage{
    private final By linkToAdvancedSearch = By.xpath("//a[contains(@href, '/poisk/poisk-223-fz/')]");

    @Override
    public void checkIfLoaded() throws NoSuchElementException {
        $(linkToAdvancedSearch).shouldBe(visible);
    }

    @Override
    public void clickLinkByName(String linkName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        if (linkName.equals("Расширенный поиск")) {
            $(linkToAdvancedSearch).click();
        }
    }
}
