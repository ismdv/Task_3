package pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private String url = "https://stellarburgers.education-services.ru/";

    private WebDriver driver;

    //кнопка войти в аккаунт
    private By entryButton = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'" +
            " and text()='Войти в аккаунт']");

    private By userCabinet = By.xpath(".//a[@href='/account']");

    private By createBurgerText = By.xpath(".//h1[text()='Соберите бургер']");


    private By bunsButton = By.xpath("//div[.//span[contains(text(),'Булки')]]");
    private By sauseButton = By.xpath("//div[.//span[contains(text(),'Соусы')]]");
    private By fillingButton = By.xpath("//div[.//span[contains(text(),'Начинки')]]");

    private By textBuns = By.xpath(".//h2[text()='Булки']");
    private By textSause = By.xpath(".//h2[text()='Соусы']");
    private By textFilling = By.xpath(".//h2[text()='Начинки']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("openPage")
    public void open() {
        driver.get(url);
    }

    @Step("clickEntryButton")
    public void clickEntryButton() {
        driver.findElement(entryButton).click();

    }
    @Step("lickUserButton")
    public void clickUserButton() {
        driver.findElement(userCabinet).click();

    }

    @Step("getCreateBurgerText")
    public String getCreateBurgerText() {
        return driver.findElement(createBurgerText).getText();
    }

    @Step("clickBunButton")
    public void clickBunButton() {
        driver.findElement(bunsButton).click();
    }

    @Step("clickSauseButton")
    public void clickSauseButton() {
        driver.findElement(sauseButton).click();
    }

    @Step("clickFillingButton")
    public void clickFillingButton() {
        driver.findElement(fillingButton).click();
    }
    @Step("isTextBunsDisplayed")
    public boolean isTextBunsDisplayed() {
       return driver.findElement(textBuns).isDisplayed();
    }
    @Step("isTextSauseDisplayed")
    public boolean isTextSauseDisplayed() {
        return driver.findElement(textSause).isDisplayed();
    }
    @Step("isTextFillingDisplayed")
    public boolean isTextFillingDisplayed() {
        return driver.findElement(textFilling).isDisplayed();
    }




}
