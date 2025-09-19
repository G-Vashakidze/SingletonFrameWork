package tests;

import Util.PropertyLoader;
import org.testng.annotations.DataProvider;

public class TransactionsDataProvider {
    public static String correctAmount = PropertyLoader.getProperty("CORRECT_AMOUNT");
    public static String minAmount = PropertyLoader.getProperty("MIN_AMOUNT");
    public static String maxAmount = PropertyLoader.getProperty("MAX_AMOUNT");
    public static String overMaxAmount = PropertyLoader.getProperty("OVER_MAX_AMOUNT");
    public static String belowMinAmount = PropertyLoader.getProperty("BELOW_MIN_AMOUNT");
    public static String defaultId = PropertyLoader.getProperty("DEFAULT_ID");


    @DataProvider(name = "transactionTestData")
    public Object[][] provideTransactionData() {
        return new Object[][]{
//                 amount,    id,             expectedAmount, expectedButtonEnabled, continueFlow
//                {"abc",      null,           "",    false, false},       // letters in amount → ignored
//                {"",      null,           "",    false, false},
//                {belowMinAmount,     defaultId,  minAmount,   true, false},       // less than 1 → capped to 1
//                {overMaxAmount,     defaultId,  maxAmount, true,  false},      // capped to 1500
//                {correctAmount,      "abcdefghijk",  correctAmount, false, false},       // letters ignored → empty ID
//                {correctAmount,      "12345",        correctAmount, false, false},       // too short
//                {correctAmount,      defaultId, correctAmount, true,  false},        // capped at 11 → valid
//                {correctAmount,      "",  correctAmount, false,  false},
                {correctAmount,      defaultId,  correctAmount, true,  true},        // perfect case
        };
    }

    }

