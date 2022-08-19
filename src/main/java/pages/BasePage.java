package pages;

import com.codeborne.selenide.ex.ElementIsNotClickableException;
import org.openqa.selenium.ElementClickInterceptedException;

import java.util.NoSuchElementException;

public abstract class BasePage {
    public abstract void clickLinkByName(String linkName) throws NoSuchElementException, ElementClickInterceptedException, ElementIsNotClickableException;
    public abstract void checkIfLoaded() throws NoSuchElementException;
}
