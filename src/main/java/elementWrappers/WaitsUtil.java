package elementWrappers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static Util.PropertyLoader.getProperty;
import static webDriverManager.WebDriverManager.getDriver;

public class WaitsUtil {

    private static final int DEFAULT_TIMEOUT = Integer.parseInt(getProperty("WAIT_TIMEOUT"));
    private static final Logger logger = LoggerFactory.getLogger(WaitsUtil.class);

    private static WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public static WebElement waitForVisibility(By locator) {
        logger.info("Waiting for visibility of element: {}", locator);
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickable(By locator) {
        logger.info("Waiting for element to be clickable: {}", locator);
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForInvisibility(By locator) {
        logger.info("Waiting for element to become invisible: {}", locator);
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public static void waitForTextToBe(By locator, String text) {
        logger.info("Waiting for element {} text to be '{}'", locator, text);
        getWait().until(ExpectedConditions.textToBe(locator, text));
    }

    public static Boolean waitForTextToBeNonZero(By locator) {
        logger.info("Waiting for element {} text to be non-zero", locator);
        return getWait().until(driver -> {
            WebElement el = driver.findElement(locator);
            String text = el.getText();
            return !text.isEmpty() && !text.equals("0");
        });
    }
}
