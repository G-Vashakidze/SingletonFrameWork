package webDriverManager;

import Util.PropertyLoader;
import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static final String browser = PropertyLoader.getProperty("BROWSER").toLowerCase();

    public static WebDriver createDriver() {
        return new LocalDriverFactory(browser).createDriver();
    }
}