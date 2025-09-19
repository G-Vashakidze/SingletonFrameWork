package elementWrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static elementWrappers.WaitsUtil.waitForClickable;
import static webDriverManager.WebDriverManager.getDriver;

public class BaseElement {

    protected By locator;
    protected String elementName;
    protected Actions actions;
    protected static final Logger logger = LoggerFactory.getLogger(BaseElement.class);

    public BaseElement(By locator, String elementName) {
        this.locator = locator;
        this.elementName = elementName;
        this.actions = new Actions(getDriver());
    }

    public BaseElement(By locator) {
        this(locator, "Base Element");
    }

    protected WebElement getElement() {
        return getDriver().findElement(locator);
    }

    public By getLocator() {
        return this.locator;
    }

    public void click() {
        WebElement element = waitForClickable(locator);
        logger.info("Clicking on element: {}", elementName);
        element.click();
    }

    protected void scrollIntoView() {
        logger.info("Scrolling element into view: {}", elementName);
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getElement());
    }

    public void hover() {
        logger.info("Hovering over element: {}", elementName);
        actions.moveToElement(getElement()).perform();
    }

    public boolean isDisplayed() {
        try {
            boolean displayed = getElement().isDisplayed();
            logger.info("Element {} displayed: {}", elementName, displayed);
            return displayed;
        } catch (NoSuchElementException e) {
            logger.warn("Element {} not found for isDisplayed check", elementName);
            return false;
        }
    }

    public boolean isEnabled() {
        try {
            boolean enabled = getElement().isEnabled();
            logger.info("Element {} enabled: {}", elementName, enabled);
            return enabled;
        } catch (NoSuchElementException e) {
            logger.warn("Element {} not found for isEnabled check", elementName);
            return false;
        }
    }

    public boolean isDisabled() {
        boolean disabled = !isEnabled();
        logger.info("Element {} disabled: {}", elementName, disabled);
        return disabled;
    }

    public boolean hasAttribute(String attributeName) {
        try {
            boolean hasAttr = getElement().getAttribute(attributeName) != null;
            logger.info("Element {} has attribute '{}': {}", elementName, attributeName, hasAttr);
            return hasAttr;
        } catch (NoSuchElementException e) {
            logger.warn("Element {} not found for hasAttribute check", elementName);
            return false;
        }
    }

    public String getAttribute(String attributeName) {
        try {
            String value = getElement().getAttribute(attributeName);
            logger.info("Getting attribute '{}' from element {}: {}", attributeName, elementName, value);
            return value;
        } catch (NoSuchElementException e) {
            logger.warn("Element {} not found for getAttribute '{}'", elementName, attributeName);
            return null;
        }
    }

    public String getValue() {
        String value = getAttribute("value");
        logger.info("Getting value of element {}: {}", elementName, value);
        return value;
    }
}
