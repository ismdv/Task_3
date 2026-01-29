import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        driver.manage().timeouts().implicitlyWait(ofSeconds(5));
    }


    @Test
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
    public void tearDown () {
        driver.quit();
    }

}
