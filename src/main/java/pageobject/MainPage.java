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


    private By bunsButton = By.xpath(".//section[1]/div[1]/div[1][.//span[text()='Булки']]");
    private By sauseButton = By.xpath(".//section[1]/div[1]/div[2][.//span[text()='Соусы']]");
    private By fillingButton = By.xpath(".//section[1]/div[1]/div[3][.//span[text()='Начинки']]");

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

    @Step("clickUserButton")
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


    @Step("isClassBunsContains")
    public boolean isClassBunsContains(String str) {
        return driver.findElement(bunsButton).getDomAttribute("class").contains(str);

    }

    @Step("isClassSauseContains")
    public boolean isClassSausContains(String str) {
        return driver.findElement(sauseButton).getDomAttribute("class").contains(str);
    }

    @Step("isClassFillingContains")
    public boolean isClassFillingContains(String str) {
        return driver.findElement(fillingButton).getDomAttribute("class").contains(str);
    }


}
