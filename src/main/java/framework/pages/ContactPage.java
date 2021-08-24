package framework.pages;

import framework.helper.PageExtension;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Slf4j
public class ContactPage extends PageExtension {
    public ContactPage(WebDriver driver) {
        super(driver);
    }

}
