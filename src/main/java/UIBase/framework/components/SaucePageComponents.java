package UIBase.framework.components;

import UIBase.pageHelper.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaucePageComponents extends ActionHelper {
    @FindBy(id = "user-name")
    public WebElement loginInput;
    @FindBy(id = "password")
    public  WebElement passwordInput;
    @FindBy(xpath = "//*[@class='login_password']/text()")
    public WebElement password;
    @FindBy(xpath="//*[@id='login_credentials']/text()[1]")
   public  WebElement userLogin;
    @FindBy(css = "#login-button")
    public  WebElement loginButton;

    public SaucePageComponents(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
}
