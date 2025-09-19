package webDriverManager;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (tlDriver.get() == null) {
            tlDriver.set(WebDriverFactory.createDriver());
        }
        return tlDriver.get();
    }

    public static void quitBrowser() {
        if(tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }

}
