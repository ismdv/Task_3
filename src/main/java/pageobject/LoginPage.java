package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Кнопка регистрации

    private By regButton = By.xpath(".//a[@class='Auth_link__1fOlj'" +
            " and text()='Зарегистрироваться']");

    private By entryButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa'" +
            " and text()='Войти']");

    private By emailInput = By.xpath(".//input[@class='text input__textfield text_type_main-default'" +
            " and @type='text']");

    private By emailPassword = By.xpath(".//input[@class='text input__textfield text_type_main-default'" +
            " and @type='password']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    @Step("clickRegButton")
    public void clickRegButton() {
        driver.findElement(regButton).click();

    }

    @Step("clickEntryButton")
    public void clickEntryButton() {
        driver.findElement(entryButton).click();

    }

}
