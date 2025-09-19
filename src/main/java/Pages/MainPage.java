package Pages;

import elementWrappers.ButtonElement;
import elementWrappers.InputElement;
import org.openqa.selenium.By;

public class MainPage {
    private static final ButtonElement transactionsButton = new ButtonElement(By.xpath("//a[contains(text(),'გადარიცხვები')]"), "Transactions Button");

    public static void clickTransfersButton() {
        transactionsButton.click();
    }


}
