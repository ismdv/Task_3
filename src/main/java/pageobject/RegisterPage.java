package pageobject;

import api.User;
import api.UserApi;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage {
    WebDriver driver;

    private By regButtonFinal = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa'" +
            " and text()='Зарегистрироваться']");
    private By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");

    private By emailInput = By.xpath(".//input");

    private By passwordInput = By.xpath(".//input[@class='text input__textfield text_type_main-default' " +
            "and @type='password']");

    private By warning = By.xpath(".//p[text()='Некорректный пароль']");

    private By entryFooter = By.xpath(".//a[@href='/login']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("insertName")
    public void insertName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("insertEmail")
    public void insertEmail(String email) {
        List<WebElement> elements = driver.findElements(emailInput);
        elements.get(1).sendKeys(email);
    }

    @Step("insertPassword")
    public void insertPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("clickRegButton")
    public void clickRegButton() {
        driver.findElement(regButtonFinal).click();
    }

    @Step("getTextError")
    public String getTextError() {
        return driver.findElement(warning).getText();
    }

    @Step("clickEntryFooter")
    public void clickEntryFooter() {
        driver.findElement(entryFooter).click();
    }

    @Step
    public String getAccessToken(String email, String password) {
        User user = new User(email, password, null);
        UserApi userApi = new UserApi();
        Response response = userApi.sendPostRequestAuth(user);
        return response.path("accessToken").toString();
    }

}
