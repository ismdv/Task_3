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
import pageobject.*;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pageobject.Data.*;

public class UserCabinetTest {
    /* Переход в личный кабинет
     Проверь переход по клику на «Личный кабинет».
     Переход из личного кабинета в конструктор
     Проверь переход по клику на «Конструктор» и на логотип Stellar Burgers.
     Выход из аккаунта
     Проверь выход по кнопке «Выйти» в личном кабинете.*/
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
    @DisplayName("Проверить переход по клику на «Личный кабинет»") // имя теста
    @Description("Проверить переход по клику на «Личный кабинет»") // описание теста
    public void entryUserCabinetTest() {
        MainPage mainPage = new MainPage(driver);
        UserCabinet userCabinet = new UserCabinet(driver);
        mainPage.clickUserButton();
        assertEquals("В этом разделе вы можете изменить свои персональные данные", userCabinet.getTextMessage());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор") // имя теста
    @Description("Переход из личного кабинета в конструктор") // описание теста
    public void toConstructorRoadTest() {
        MainPage mainPage = new MainPage(driver);
        UserCabinet userCabinet = new UserCabinet(driver);
        mainPage.clickUserButton();
        userCabinet.clickConstrButton();
        assertEquals("Соберите бургер", mainPage.getCreateBurgerText());
    }

    @Test
    @DisplayName("Переход из личного кабинета по логотипу Stellar Burgers") // имя теста
    @Description("Переход из личного кабинета по логотипу Stellar Burgers") // описание теста
    public void toLabelClickTest() {
        MainPage mainPage = new MainPage(driver);
        UserCabinet userCabinet = new UserCabinet(driver);
        mainPage.clickUserButton();
        userCabinet.clickLabel();
        assertEquals("Соберите бургер", mainPage.getCreateBurgerText());
    }

    @Test
    @DisplayName("Выход из аккаунта") // имя теста
    @Description("Выход из аккаунта") // описание теста
    public void exitFromAccount() {
        MainPage mainPage = new MainPage(driver);
        UserCabinet userCabinet = new UserCabinet(driver);
        LoginPage loginPage = new LoginPage(driver);
        mainPage.clickUserButton();
        userCabinet.clickExit();
        assertEquals("Вход", loginPage.entryText());
    }


    @AfterEach
    public void tearDown() {
        driver.quit();
        UserApi userApi = new UserApi();
        userApi.deleteUser(accessToken);
    }

}
