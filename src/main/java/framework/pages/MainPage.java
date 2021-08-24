package framework.pages;

import framework.helper.PageExtension;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
@Slf4j
public class MainPage extends PageExtension {
    @FindBy(xpath = "//*[@id='contact-link']")
    WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @Step("User click contact Button")
    public ContactPage contactPage() {
        log.info("Go to 'Sign in' page");
        signInButton.click();
        return pageFactory.create(ContactPage.class);
    }

}
