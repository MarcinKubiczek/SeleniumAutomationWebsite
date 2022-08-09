package UIBase.framework.factory;

import UIBase.framework.helper.PageExtension;
import org.openqa.selenium.WebDriver;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PageFactory {
    private WebDriver driver;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public <T extends PageExtension> T create(Class<T> classToProxy) {
        log.debug("Creating page object: {}", classToProxy.getSimpleName());
        return org.openqa.selenium.support.PageFactory.initElements(driver, classToProxy);
    }
}
