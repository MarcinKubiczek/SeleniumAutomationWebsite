import UIBase.framework.pages.SaucePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTest {
    private WebDriver driver;
    String username;
    String password;
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void chromeDefault(){
        driver= new ChromeDriver();
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    public void test001_testLoginPage(){
        SaucePage page = new SaucePage(driver);
        page.getLoggingPage();
        username=page.getUserNameForLogging();
        password=page.getUserPasswordForLogging();
        page.inputUserName("test");
        page.inputPassword("test");
        page.clickOnLoginButton();
    }
}
