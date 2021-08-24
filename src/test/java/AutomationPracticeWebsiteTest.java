import framework.Application;
import framework.helper.ElementExtension;
import framework.helper.LocatorsExtension;
import framework.helper.PageExtension;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pageHelper.ActionHelper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutomationPracticeWebsiteTest {
    private WebDriver driver;
    protected Application application;
    private ElementExtension element;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kubiczem\\IdeaProjects\\SeleniumAutomationWebsite\\src\\main\\resources\\chromedriver.exe");
    }


    @BeforeEach
    public void setUpBeforeEach() {
        this.driver = new ChromeDriver();
        application = new Application(driver);
    }

    @AfterEach
    public void cleanUpAfterEach() {
        Allure.getLifecycle().addAttachment(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png", makeScreenShot());
        application.close();
    }

    private byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void clickOnElementTest() {
        application.open();
        ElementExtension element = null;
        element.findElement(By.xpath("//*[@id='contact-link']"));
        element.click();


    }

}

