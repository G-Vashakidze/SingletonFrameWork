package Pages;

import Util.PropertyLoader;
import elementWrappers.*;
import org.openqa.selenium.By;

import static elementWrappers.WaitsUtil.waitForTextToBeNonZero;
import static elementWrappers.WaitsUtil.waitForVisibility;

public class BankTransactionsPage {
    private static final String bankName = PropertyLoader.getProperty("BANK_NAME");
    private static final BaseElement bankSelectElement = new BaseElement(By.cssSelector("label[title='აირჩიეთ ბანკი']"),"select bank");
    private static final BaseElement bankChoice = new BaseElement(By.cssSelector("a[title='" + bankName + "']"),"CHOSEN BANK");
    private static final InputElement serviceInput = new InputElement(By.id("service_input"),"service_input");
    private static final ButtonElement checkButton = new ButtonElement(By.id("service_input_submit_button"),"check button");
    private static final BaseElement selectService = new BaseElement(By.cssSelector("label[title='აირჩიეთ სერვისი']"),"select service");
    private static final BaseElement chooseBankAccount = new BaseElement(By.xpath("//a[contains(@title, 'TBC')][1]"), "bank account");
    private static final TextElement commission = new TextElement(By.xpath("//button/span[not(@class)]"), "Commission");


    public static void clickBankSelect() {
        bankSelectElement.click();
    }


    public static void clickBankChoice() {
        bankChoice.click();
    }

    public static void fillServiceInput(String value) {
        waitForVisibility(serviceInput.getLocator());
        serviceInput.fill(value);
    }


    public static void clickCheckButton() {
        checkButton.click();
    }

    public static void clickSelectService(){
        selectService.click();
    }
    public static void clickChooseBankAccount(){
        chooseBankAccount.click();
    }

    public static String getCommissionAmount(){
        waitForTextToBeNonZero(commission.getLocator());
        return commission.getText();
    }


}
