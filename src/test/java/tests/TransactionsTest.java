package tests;

import Pages.BankTransactionsPage;
import Pages.TransactionsPage;
import Util.PropertyLoader;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TransactionsTest extends BaseTest {

    @Test(dataProvider = "transactionTestData", dataProviderClass = TransactionsDataProvider.class)
    public void testTransactionInputValidations(
            String amount, String id, String expectedAmount,
            boolean expectedButtonEnabled, boolean continueFlow) throws InterruptedException {


        // Fill amount
        TransactionsPage.fillAmountInput(amount);

        // Assert amount field value
        Assert.assertEquals(TransactionsPage.getAmountValue(), expectedAmount, "Amount mismatch!");

        // Only try ID if amount was valid enough to render it
        if (id != null && Integer.parseInt(TransactionsPage.getAmountValue()) >= 1) {
            TransactionsPage.filledInput(id);
        }

        // Check button state
        Assert.assertEquals(TransactionsPage.isTransferButtonEnabled(), expectedButtonEnabled);

        // If valid, continue full flow
        if (continueFlow && expectedButtonEnabled) {
            TransactionsPage.clickTransfer();
            BankTransactionsPage.clickBankSelect();
            BankTransactionsPage.clickBankChoice();
            BankTransactionsPage.fillServiceInput(PropertyLoader.getProperty("DEFAULT_ID"));
            BankTransactionsPage.clickCheckButton();
            BankTransactionsPage.clickSelectService();
            BankTransactionsPage.clickChooseBankAccount();
            Assert.assertEquals(Double.parseDouble(PropertyLoader.getProperty("CORRECT_AMOUNT")) * 1.2 / 100,
                    Double.parseDouble(BankTransactionsPage.getCommissionAmount()), 0.001
            );


        }
    }

}
