import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.UserCabinet;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstructorTest {
   /* Раздел «Конструктор»
    Проверь, что работают переходы к разделам:
            «Булки»,
            «Соусы»,
            «Начинки».*/
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
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
        mainPage.clickBunButton();
        assertTrue(mainPage.isTextBunsDisplayed());
    }
    @Test
    @DisplayName("Работают переходы к разделу «Соусы»")
    @Description("Работают переходы к разделу «Соусы»")
    public void toSauseCapterTest(){
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSauseButton();
        assertTrue(mainPage.isTextSauseDisplayed());
    }
    @Test
    @DisplayName("Работают переходы к разделу «Начинки»")
    @Description("Работают переходы к разделу «Начинки»")
    public void toFillingCapterTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickFillingButton();
        assertTrue(mainPage.isTextFillingDisplayed());
    }



    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
