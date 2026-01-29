package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    WebDriver driver;

    // Кнопка зарегистрироваться

    private By regButtonFinal =By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa'" +
            " and text()='Зарегистрироваться']");
    private By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");

    private By emailInput = By.xpath(".//label[@text()='Email']/following-sibling::input");

    private By passwordInput = By.xpath(".//input[@class='text input__textfield text_type_main-default' " +
            "and @type='password']");

    private By warning = By.xpath(".//p[text()='Некорректный пароль']");


    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void insertName(String name){
        driver.findElement(nameInput).sendKeys(name);
    }
    public void insertEmail(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void insertPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickRegButton(){
        driver.findElement(regButtonFinal).click();

    }

    public String getTextError(){
        return driver.findElement(warning).getText();
    }

}
