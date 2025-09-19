package elementWrappers;

import org.openqa.selenium.By;

public class TextElement extends BaseElement {

    public TextElement(By locator, String elementName) {
        super(locator, elementName);
    }

    public TextElement(By locator) {
        super(locator, "Text Element");
    }

    public String getText() {
        String text = super.getElement().getText();
        logger.info("Getting text from element {}: {}", elementName, text);
        return text;
    }

    public boolean containsText(String text) {
        String elementText = getText();
        boolean contains = elementText != null && elementText.contains(text);
        logger.info("Element {} contains text '{}': {}", elementName, text, contains);
        return contains;
    }
}
