package framework;
import com.sun.tools.javac.Main;
import framework.config.Configuration;
import framework.helper.PageExtension;
import framework.pages.MainPage;
import lombok.extern.slf4j.Slf4j;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
@Slf4j
public class Application extends PageExtension {
    private static Configuration configuration = ConfigFactory.create(Configuration.class);

    public Application(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage open() {
        String applicationAddress = configuration.applicationAddress();
        log.info("Opening application at: {}", applicationAddress);

        driver.get(applicationAddress);
        return pageFactory.create(MainPage.class);
    }

    public void close() {
        log.info("Closing application");
        driver.quit();
    }
}
