package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class BuyTokenMenuComponent extends MobileFunctions {
    // buy token options
    private By btnCreditDebitCards = MobileBy.id("com.coyni.android:id/layoutCard");
    private By btnBankAccount = MobileBy.id("com.coyni.android:id/layoutBank");

    // buy token option actions
    public void clickCreditDebitCards() {
        click(btnCreditDebitCards, "Credit/Debit Cards");
    }

    public void clickBankAccount() {
        click(btnBankAccount, "Bank Account");
    }
}
