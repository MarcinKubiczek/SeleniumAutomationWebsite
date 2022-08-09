package UIBase.framework.wrappers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;

public class Button implements WrapsElement {
    private final WebElement button;

    public Button(WebElement buttonElement){
        this.button = buttonElement;
    }
    @Override
    public WebElement getWrappedElement() {
        return button;
    }
    public String getText(){
        return button.getText();
    }
    public void click(){
        button.click();
    }
}
