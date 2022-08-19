package pages;

import com.codeborne.selenide.ex.ElementIsNotClickableException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$;

public class MainPage extends BasePage {
    private final By linkTo223Suppliers = By.xpath("//nav[@class='nav nav-223-fz']//a[text()='Поставщикам']");

    public void clickLinkByLinkAndColumnNames(String linkName, String columnName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {
        if (columnName.equals("223-ФЗ") && linkName.equals("Поставщикам")) {
                $(linkTo223Suppliers).click();
        }
    }

    @Override
    public void clickLinkByName(String linkName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException {

    }

    @Override
    public void checkIfLoaded() throws NoSuchElementException {

    }
}
