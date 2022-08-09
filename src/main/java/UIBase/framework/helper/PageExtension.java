package UIBase.framework.helper;
import UIBase.framework.factory.PageFactory;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public abstract class PageExtension {
    @Getter
    protected WebDriver driver;
    @Getter
    protected WebDriverWait webDriverWait;
    protected PageFactory pageFactory;

    public PageExtension(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, 15);
        pageFactory = new PageFactory(driver);
    }

    public List<ElementExtension> findElements(final LocatorsExtension locator) {
        return driver.findElements(locator.by())
                .stream()
                .map(ElementExtension::new)
                .collect(Collectors.toList());
    }

    public ElementExtension findElement(final LocatorsExtension locator) {
        return new ElementExtension(driver.findElement(locator.by()));
    }


    public void refresh() {
        driver.navigate().refresh();
    }

    public boolean isDisplayed(final LocatorsExtension locator) {
        try {
            return driver.findElement(locator.by()).isDisplayed();
        } catch (NotFoundException | StaleElementReferenceException | ElementNotVisibleException e) {
            return false;
        }
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NotFoundException | StaleElementReferenceException | ElementNotVisibleException e) {
            return false;
        }
    }

    }
