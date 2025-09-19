package tests;

import Pages.MainPage;
import Util.PropertyLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import webDriverManager.WebDriverManager;

import java.time.Duration;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        WebDriver driver = WebDriverManager.getDriver(); // this uses your factory
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(PropertyLoader.getProperty("BASE_URL"));
        MainPage.clickTransfersButton();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverManager.quitBrowser();
    }
}
