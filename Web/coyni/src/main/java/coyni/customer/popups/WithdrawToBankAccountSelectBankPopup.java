package coyni.customer.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class WithdrawToBankAccountSelectBankPopup extends BrowserFunctions {
 
    private By radBtnSelectBank = By.cssSelector("");
    private By lnkAddpayment = By.cssSelector("");
    
    public void clickOnSelectBank() {
    	click(radBtnSelectBank, "Click SlectBank");
    }
    public void clickOnAddPayment() {
    	click(lnkAddpayment, "Click AddPayment");
    }
}
