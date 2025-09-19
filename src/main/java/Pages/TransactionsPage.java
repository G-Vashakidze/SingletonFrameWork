package Pages;


import elementWrappers.ButtonElement;

import elementWrappers.InputElement;
import org.openqa.selenium.By;

public class TransactionsPage {


    private final static InputElement amountInput = new InputElement(By.id("toBank_money_input"), "Amount");
    private final static InputElement idInput = new InputElement(By.id("toBank_input_input"), "ID Number");


    private final static ButtonElement transferButton = new ButtonElement(By.id("toBank_submit_button"), "Transfer Button");




    public static void fillAmountInput(String fromAccount) {
        amountInput.fill(fromAccount);
    }

    public static void filledInput(String toAccount) {
        idInput.fill(toAccount);
    }

    public static void clickTransfer() {
        transferButton.click();
    }

    public static String getIdValue() {
        return idInput.getValue();
    }

    public static String getAmountValue() {
        return amountInput.getValue();
    }

    public static boolean isTransferButtonEnabled() {
        return transferButton.isEnabled();
    }

}
