package coyni.merchant.popups;

import org.openqa.selenium.By;


import ilabs.WebFramework.BrowserFunctions;

public class WithdrawToBankAccountSelectBankPopup extends BrowserFunctions {
 
    private By radBtnSelectBank = By.cssSelector("");
    private By lnkAddpayment = By.cssSelector("");
    private By btnNext = By.cssSelector("");
    
    public void clickOnSelectBank() {
    	click(radBtnSelectBank, "Click SlectBank");
    }
    public void clickOnAddPayment() {
    	click(lnkAddpayment, "Click AddPayment");
    }
    public AddExternalBankAccountPopup addExternalBankAccountPopup() {
    	return new AddExternalBankAccountPopup();
    }
    public void clickNext() {
    	click(btnNext, "Next");
    }
    public WithdrawToBankAccountPopup withdrawToBankAccountPopup() {
    	return new WithdrawToBankAccountPopup();
    }
}
