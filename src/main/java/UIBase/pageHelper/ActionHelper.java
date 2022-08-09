package UIBase.pageHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionHelper {
    private WebDriver driver;
    private int timeout=20;

    public ActionHelper(WebDriver driver) {
        this.driver = driver ;
    }


    public void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public void clickElement(By locator) {
        waitForClickablility(locator, timeout);
        driver.findElement(locator).click();
    }
    public void clickElement(WebElement element){
        waitForClickablility(element,timeout);
        element.click();
    }
    public String getText(WebElement element){
        waitForElementToBeVisable(element,timeout);
       return element.getText();
    }

    private WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    private WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    private WebElement waitForElementToBeVisable(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void doubleClick(By locator){
        Actions act = new Actions(driver);
        waitForClickablility(locator,timeout);
        act.doubleClick(driver.findElement(locator)).perform();
    }
}
