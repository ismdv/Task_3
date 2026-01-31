package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserCabinet {

    WebDriver driver;

    private By textMessage = By.xpath(".//p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private By toConstrButton = By.xpath("//a[.//p[contains(text(),'Конструктор')]]");
    private By label = By.xpath(".//a[@href = '/']");
    private By exitButton = By.xpath(".//button[text()='Выход']");


    public UserCabinet(WebDriver driver) {
        this.driver = driver;
    }

    @Step("getTextMessage")
    public String getTextMessage() {
        return driver.findElement(textMessage).getText();
    }

    @Step("clickConstrButton")
    public void clickConstrButton() {
        driver.findElement(toConstrButton).click();
    }

    @Step("clickLabel")
    public void clickLabel() {
        driver.findElement(label).click();
    }

    @Step("clickExit")
    public void clickExit() {
        driver.findElement(exitButton).click();
    }


}
