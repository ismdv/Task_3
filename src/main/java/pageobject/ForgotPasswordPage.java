package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    WebDriver driver;

    private By entryButton = By.xpath(".//a[@href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("clickEntryButton")
    public void clickEntryButton() {
        driver.findElement(entryButton).click();
    }
}
