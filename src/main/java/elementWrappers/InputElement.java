package elementWrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static elementWrappers.WaitsUtil.waitForVisibility;

public class InputElement extends BaseElement {

    public InputElement(By locator, String elementName) {
        super(locator, elementName);
    }

    public InputElement(By locator) {
        super(locator, "Input");
    }

    public void fill(String text) {
        WebElement element = waitForVisibility(locator);
        logger.info("Filling element {} with value: {}", elementName, text);
        element.clear();
        element.sendKeys(text);
    }
}
