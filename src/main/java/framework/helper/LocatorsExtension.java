package framework.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;

public class LocatorsExtension {
    private final By by;

    private LocatorsExtension(By by) {
        this.by = by;
    }

    public static LocatorsExtension id(String id) {
        return new LocatorsExtension(By.id(id));
    }

    public static LocatorsExtension css(String css) {
        return new LocatorsExtension(By.cssSelector(css));
    }

    public static LocatorsExtension xpath(String xpath) {
        return new LocatorsExtension(By.xpath(xpath));
    }

    public static LocatorsExtension tag(String tag) {
        return new LocatorsExtension(By.tagName(tag));
    }

    public static LocatorsExtension className(String className) {
        return new LocatorsExtension(By.className(className));
    }

    public By by() {
        return this.by;
    }

    public String toString() {
        return "Locator: {" + by.toString() + "}";
    }

    public static LocatorsExtension linkText(String linkText) {
        return new LocatorsExtension(By.linkText(linkText));
    }

    public static LocatorsExtension name(String name) {
        return new LocatorsExtension(By.name(name));
    }

    public static LocatorsExtension partialLinkText(String linkText) {
        return new LocatorsExtension(By.partialLinkText(linkText));
    }

    public static LocatorsExtension idOrName(String idOrName) {
        return new LocatorsExtension(new ByIdOrName(idOrName));
    }
}
