import api.User;
import api.UserApi;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;
import static pageobject.Data.*;

public class ConstructorTest {
    /* Раздел «Конструктор»
     Проверь, что работают переходы к разделам:
             «Булки»,
             «Соусы»,
             «Начинки».*/
    private WebDriver driver;
    private String accessToken;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.education-services.ru/";
        User user = new User(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        userApi.sendPostRequestReg(user);
        RegisterPage registerPage = new RegisterPage(driver);
        accessToken = registerPage.getAccessToken(EMAIL, PASSWORD);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(ofSeconds(20));
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.open();
        mainPage.clickEntryButton();
        loginPage.insertEmail();
        loginPage.insertPassword();
        loginPage.clickEntryButton();
    }

    @Test
    @DisplayName("Работают переходы к разделу «Булки»")
    @Description("Работают переходы к разделу «Булки»")
    public void toBunsCapterTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        assertTrue(mainPage.isClassBunsContains("current"));
    }

    @Test
    @DisplayName("Работают переходы к разделу «Соусы»")
    @Description("Работают переходы к разделу «Соусы»")
    public void toSauseCapterTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauseButton();
        assertTrue(mainPage.isClassSausContains("current"));
    }

    @Test
    @DisplayName("Работают переходы к разделу «Начинки»")
    @Description("Работают переходы к разделу «Начинки»")
    public void toFillingCapterTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingButton();
        assertTrue(mainPage.isClassFillingContains("current"));
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
        UserApi userApi = new UserApi();
        userApi.deleteUser(accessToken);
    }
}
