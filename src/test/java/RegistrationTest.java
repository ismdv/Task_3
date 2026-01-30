import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;


import static pageobject.Data.*;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(ofSeconds(10));
    }


    @Test
    @DisplayName("Проверить регистрацию") // имя теста
    @Description("Проверить регистрацию") // описание теста
    public void registrationTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.open();
        mainPage.clickEntryButton();
        loginPage.clickRegButton();
        registerPage.insertName(NAME);
        registerPage.insertEmail(EMAIL_REG);
        registerPage.insertPassword(PASSWORD);
        registerPage.clickRegButton();
        assertEquals("Вход", loginPage.entryText());

    }

    @Test
    @DisplayName("Проверить регистрацию при пароле 5 символов") // имя теста
    @Description("Проверить регистрацию при пароле 5 символов") // описание теста
    public void regErrorPasswordTest() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);
        mainPage.open();
        mainPage.clickEntryButton();
        loginPage.clickRegButton();
        registerPage.insertName(NAME);
        registerPage.insertEmail(EMAIL);
        registerPage.insertPassword(FAKE_PASSWORD);
        registerPage.clickRegButton();
        assertEquals("Некорректный пароль", registerPage.getTextError());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
