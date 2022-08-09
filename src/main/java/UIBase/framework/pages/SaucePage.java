package UIBase.framework.pages;

import UIBase.framework.components.SaucePageComponents;
import UIBase.framework.helper.PageExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SaucePage extends PageExtension {
    SaucePageComponents components;

    public SaucePage(WebDriver driver) {
        super(driver);
        components = new SaucePageComponents(driver);
        PageFactory.initElements(getDriver(), this);
    }

    public void getLoggingPage(){
        driver.get("https://www.saucedemo.com/");
    }

    public String getUserNameForLogging(){

        return components.getText(components.userLogin);
    }
    public String getUserPasswordForLogging(){
        return components.getText(components.password);
    }
    public void inputUserName (String username){
        components.loginInput.sendKeys(username);
    }
    public void inputPassword(String password){
        components.passwordInput.sendKeys(password);
    }
    public void clickOnLoginButton(){
        components.clickElement(components.loginButton);
    }
}
