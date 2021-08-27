package framework.pages;

import framework.helper.PageExtension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class MainPage extends PageExtension {
    @FindBy(xpath = "//*[@id='contact-link']")
    WebElement signInButton;
    @FindBy(xpath = "//div[@class='ac_results']")
    WebElement searchResult;
    @FindBy(css="#search_query_top")
    WebElement searchField;
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("User click contact Button")
    public ContactPage contactPage() {
        log.info("Go to 'Sign in' page");
        signInButton.click();
        return pageFactory.create(ContactPage.class);
    }

    @Step("User search for a item in shop")
    public MainPage searchForItem(String request) {
        log.info("User search for an item in shop");
        searchField.sendKeys(request);
        return this;
    }

    @Step("User click on search Result")
    public MainPage clickSearchResult(String result) {
        log.info("Click on search result " + result);
        searchResult.findElement(By.xpath("//li[contains(text(),'" + result + "')]")).click();
        return this;
    }

}
