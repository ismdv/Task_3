package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageobject.Data.EMAIL;
import static pageobject.Data.PASSWORD;

public class LoginPage {
    WebDriver driver;

    // Кнопка регистрации

    private By regButton = By.xpath(".//a[@class='Auth_link__1fOlj'" +
            " and text()='Зарегистрироваться']");

    private By entryButton = By.xpath(".//button[text()='Войти']");

    private By emailInput = By.xpath(".//input");

    private By passwordInput = By.xpath(".//input[@class='text input__textfield text_type_main-default'" +
            " and @type='password']");

    private By entryText = By.xpath(".//h2[text()='Вход']");

    private By forgotPassButton = By.xpath(".//a[@href='/forgot-password']");

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

    @Step("entryText")
    public String entryText(){
       return  driver.findElement(entryText).getText();
    }
    @Step("insertEmail")
    public void insertEmail() {
        driver.findElement(emailInput).sendKeys(EMAIL);

    }
    @Step("insertPassword")
    public void insertPassword() {
        driver.findElement(passwordInput).sendKeys(PASSWORD);

    }
    @Step("clickForgotPassButton")
    public void clickForgotPassButton() {
        driver.findElement(forgotPassButton).click();

    }




}
