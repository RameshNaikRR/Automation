package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BuyCoyniTokensPaymentMethodPopup extends BrowserFunctions {
	
	private By lblBank = By.xpath("//p[contains(text(),'Bank')]");
	private By headingBuyCoyniToken = By.xpath("//h1[contains(text(),'Buy Coyni Tokens')]");
	private By radBtnDebit = By.cssSelector("");
	private By radBtnCredit = By.cssSelector("");
	private By lnkAddNewPayment = By.cssSelector("");
	private By btnDeleteBank = By.cssSelector("");
	private By btnDeleteCredit = By.cssSelector("");
	private By btnEditCredit = By.cssSelector("");
	private By btnDeleteDebit = By.cssSelector("");
	private By btnEditDebit = By.cssSelector("");
	private By btnNext = By.xpath("//button[contains(text(),'Next')]");
	private By lblBankErrorMessage = By.cssSelector("");
	private By lblCreditErrorMessage = By.cssSelector("");
	private By lbldebitErrorMessage = By.cssSelector("");
	private By buyCoyniTokensDescp = By.xpath("//h2[contains(text(),'Choose Your Payment Method:')]");
	private By btnDelete = By.xpath("//button[@class=' ml-2 icon-trash BuyTokenPaymentMethod_action_icon__2nonE']");
	
	public void clickBank() {
		click(lblBank,"Click Bank" );
	}
	public void clickDebit() {
		click(radBtnDebit,"Click Debit" );
	}
	public void clickCredit() {
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
	public void clickDelete() {
		click(btnDelete,"Click Delete");
	}
	public void clickNext() {
		click(btnNext,"Click Next" );
	}
   public void clickLinkAddNewPayment() {
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
   public BuyCoyniTokensPopup buyCoyniTokensPopup() {
	   return new BuyCoyniTokensPopup();
   }
   public void verifyBuyCoyniTokenDescription() {
	   	new CommonFunctions().elementView(buyCoyniTokensDescp, "Choose Your Paayment Method  ");
	   }
   
   public void verifyBuyCoyniTokenHeading(String expBuyCoyniTokenHeading) {
	   	new CommonFunctions().verifyLabelText(headingBuyCoyniToken, "Buy Coyni Token Heading is", expBuyCoyniTokenHeading);
	   }
   
   public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
	   return new SuccessFailurePopupCardComponent();
   }
   
   
   
}
