package framework.config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:conf.properties")
public interface Configuration extends Config{
    String applicationAddress();
    String browserName();
    String driverType();
}
