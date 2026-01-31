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
import pageobject.ForgotPasswordPage;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

import static org.junit.jupiter.api.Assertions.*;

import static java.time.Duration.ofSeconds;
import static pageobject.Data.*;

public class LoginTest {
   /* Вход
    Проверь:
    вход по кнопке «Войти в аккаунт» на главной,
    вход через кнопку «Личный кабинет»,
    вход через кнопку в форме регистрации,
    вход через кнопку в форме восстановления пароля.*/

    private WebDriver driver;
    private String accessToken;

    @BeforeEach
    public void setUp() {
        RestAssured.baseURI = "https://stellarburgers.education-services.ru/";
        User user = new User(EMAIL, PASSWORD, NAME);
        UserApi userApi = new UserApi();
        userApi.sendPostRequestReg(user);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
    }

    @Test
    @DisplayName("Проверить вход по кнопке «Войти в аккаунт» на главной") // имя теста
    @Description("Проверить вход по кнопке «Войти в аккаунт» на главной") // описание теста
    public void entryMainPageTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.open();
        mainPage.clickEntryButton();
        loginPage.insertEmail();
        loginPage.insertPassword();
        loginPage.clickEntryButton();
        accessToken = registerPage.getAccessToken(EMAIL, PASSWORD);
        assertEquals("Соберите бургер", mainPage.getCreateBurgerText());
    }

    @Test
    @DisplayName("Проверить вход через кнопку «Личный кабинет") // имя теста
    @Description("Проверить вход через кнопку «Личный кабинет") // описание теста
    public void entryUserCabinetTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.open();
        mainPage.clickUserButton();
        loginPage.insertEmail();
        loginPage.insertPassword();
        loginPage.clickEntryButton();
        accessToken = registerPage.getAccessToken(EMAIL, PASSWORD);
        assertEquals("Соберите бургер", mainPage.getCreateBurgerText());
    }

    @Test
    @DisplayName("Проверить вход через кнопку в форме регистрации") // имя теста
    @Description("Проверить вход через кнопку в форме регистрации") // описание теста
    public void entryOverRegistrationTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.open();
        mainPage.clickEntryButton();
        loginPage.clickRegButton();
        registerPage.clickEntryFooter();
        loginPage.insertEmail();
        loginPage.insertPassword();
        loginPage.clickEntryButton();
        accessToken = registerPage.getAccessToken(EMAIL, PASSWORD);
        assertEquals("Соберите бургер", mainPage.getCreateBurgerText());
    }

    @Test
    @DisplayName("Проверить вход через кнопку в форме восстановления пароля") // имя теста
    @Description("Проверить вход через кнопку в форме восстановления пароля") // описание теста
    public void entryOverSavePasswordTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        mainPage.open();
        mainPage.clickEntryButton();
        loginPage.clickForgotPassButton();
        forgotPasswordPage.clickEntryButton();
        loginPage.insertEmail();
        loginPage.insertPassword();
        loginPage.clickEntryButton();
        accessToken = registerPage.getAccessToken(EMAIL, PASSWORD);
        assertEquals("Соберите бургер", mainPage.getCreateBurgerText());
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
        UserApi userApi = new UserApi();
        userApi.deleteUser(accessToken);
    }
}
