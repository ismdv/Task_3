package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private String url = "https://stellarburgers.education-services.ru/";

    private WebDriver driver;

//кнопка войти в аккаунт
private By entryButton =By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg'" +
        " and text()='Войти в аккаунт']");

    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void open() {
        driver.get(url);
    }


    public void clickEntryButton(){
        driver.findElement(entryButton).click();

    }
}
