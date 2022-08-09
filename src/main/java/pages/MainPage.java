package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final By linkTo223Suppliers = By.xpath("//nav[@class='nav nav-223-fz']//a[text()='�����������']");

    public void clickLink(String linkName, String columnName) {
        if (columnName.equals("223-��")) {
            if (linkName.equals("�����������")) {
                $(linkTo223Suppliers).click();
            }
        }
    }
}
