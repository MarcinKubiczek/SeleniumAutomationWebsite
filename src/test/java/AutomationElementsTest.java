import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class AutomationElementsTest {

    private WebDriver driver;
    private WebDriverWait wait;
    final private String seleniumAutomationWebsite = "https://rahulshettyacademy.com/seleniumPractise/";
    final private String automationPracticeWebsite = "https://rahulshettyacademy.com/AutomationPractice/";

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kubiczem\\IdeaProjects\\SeleniumAutomationWebsite\\src\\main\\resources\\chromedriver.exe");

    }

    @BeforeEach
    public void setUpBeforeEach() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 20);

    }

    @AfterEach
    public void cleanUpAfterEach() {
        Allure.getLifecycle().addAttachment(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MMM-yy_hh:mm:ss")), "image/png", "png", makeScreenShot());
        driver.quit();
        ;
    }

    private byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void clickOnCalendarTest() {

    }

    @Test
    public void testCheckboxes() {
        driver.get(automationPracticeWebsite);
        WebElement checkbox1 = driver.findElement(By.xpath("//input[@id='checkBoxOption1']"));
        Assertions.assertFalse(checkbox1.isSelected());
        checkbox1.click();
        Assertions.assertTrue(checkbox1.isSelected());
    }

    @Test
    public void countTestCheckboxes() {
        driver.get(automationPracticeWebsite);
        List<WebElement> boxes = driver.findElements(By.xpath("//div[@id='checkbox-example']//input[contains(@id,'checkBoxOption')]"));
        System.out.println(boxes.size());
    }

    @Test
    public void addElementsWithSimilarLocators() throws InterruptedException {
        driver.get(seleniumAutomationWebsite);
        String[] itemToAdd = {"Cucumber", "Tomato"};
        By products= By.cssSelector("h4.product-name");
        By numberOfElementInBracket = By.xpath("//tr[1]/td[3]/strong");
        wait.until((ExpectedConditions.presenceOfElementLocated(products)));
        List<WebElement> allProducts = driver.findElements(products);
        int j=0;
        for (int i = 0; i < allProducts.size(); i++) {
            String[] productName = allProducts.get(i).getText().split("-");
            String formattedName = productName[0].trim();

            List<String> itemsNeededList = Arrays.asList(itemToAdd);
            if (itemsNeededList.contains(formattedName)) {
                j++;
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
            }
            if(j==itemToAdd.length){
                break;
            }
        }
        int itemsInBracket = Integer.parseInt(driver.findElement(numberOfElementInBracket).getText());
        int expectedItemsInBracket=2;
        Assertions.assertEquals(itemsInBracket,expectedItemsInBracket);
    }

}
