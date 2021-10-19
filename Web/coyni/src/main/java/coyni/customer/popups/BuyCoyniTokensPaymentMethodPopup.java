package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BuyCoyniTokensPaymentMethodPopup extends BrowserFunctions {
	
	private By radBtnBank = By.cssSelector("");
	private By radBtnDebit = By.cssSelector("");
	private By radBtnCredit = By.cssSelector("");
	private By lnkAddNewPayment = By.cssSelector("");
	private By btnDeleteBank = By.cssSelector("");
	private By btnDeleteCredit = By.cssSelector("");
	private By btnEditCredit = By.cssSelector("");
	private By btnDeleteDebit = By.cssSelector("");
	private By btnEditDebit = By.cssSelector("");
	private By btnNext = By.cssSelector("");
	private By lblBankErrorMessage = By.cssSelector("");
	private By lblCreditErrorMessage = By.cssSelector("");
	private By lbldebitErrorMessage = By.cssSelector("");
	
	public void clickOnBank() {
		click(radBtnBank,"Click Bank" );
	}
	public void clickOnDebit() {
		click(radBtnDebit,"Click Debit" );
	}
	public void clickOnCredit() {
		click(radBtnCredit,"Click Credit" );
	}
	public void deleteBank() {
		click(btnDeleteBank,"Click DeleteBank" );
	}
	public void deleteDebit() {
		click(btnDeleteDebit,"Click DeleteDebit" );
	}
	public void deleteCredit() {
		click(btnDeleteCredit,"Click DeleteCredit" );
	}
	public void editDebit() {
		click(btnEditDebit,"Click EditDebit" );
	}
	public void editCredit() {
		click(btnEditCredit,"Click EditCredit" );
	}
	public void clickOnNext() {
		click(btnNext,"Click Next" );
	}
   public void clickOnLinkAddNewPayment() {
	   click(lnkAddNewPayment, "Click AddNewPayment");
   }
   public void VerifyBankErrorMessage(String BankErrorMessage) {
   	new CommonFunctions().verifyLabelText(lblBankErrorMessage, BankErrorMessage, "BankErrorMessage");
   }
   public void VerifyCreditErrorMessage(String CreditErrorMessage) {
    new CommonFunctions().verifyLabelText(lblCreditErrorMessage, CreditErrorMessage, "CreditErrorMessage");
   }
   public void VerifydebitErrorMessage(String DebitErrorMessage) {
	    new CommonFunctions().verifyLabelText(lbldebitErrorMessage, DebitErrorMessage, "DebitErrorMessage");
   }
   
}
