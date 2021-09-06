import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AutomationElementsTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kubiczem\\IdeaProjects\\SeleniumAutomationWebsite\\src\\main\\resources\\chromedriver.exe");
    }

    @BeforeEach
    public void setUpBeforeEach() {
        this.driver = new ChromeDriver();

    }

    @AfterEach
    public void cleanUpAfterEach() {
        Allure.getLifecycle().addAttachment(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png", makeScreenShot());
        driver.close();
    }
    private byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Test
    public void clickOnCalendarTest(){

    }
    @Test
    public void testCheckboxes() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
        Assertions.assertFalse(checkbox1.isSelected());
        checkbox1.click();
        Assertions.assertTrue(checkbox1.isSelected());
        driver.quit();
    }

    @Test
    public void countTestCheckboxes() {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> boxes = driver.findElements(By.xpath("//div[@id='checkbox-example']//input[contains(@id,'checkBoxOption')]"));
        System.out.println(boxes.size());
    }

}
