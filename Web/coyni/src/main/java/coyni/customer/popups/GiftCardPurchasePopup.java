package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class GiftCardPurchasePopup extends BrowserFunctions{
	
	private By txtFirstName = By.cssSelector("");
	private By txtLastName = By.cssSelector("");
	private By txtEmail = By.cssSelector("");
	private By txtAmount = By.cssSelector("");
	private By btnPurchase = By.cssSelector("");
	private By lblErrorMsg = By.cssSelector("");
	private By lnkViewMore = By.cssSelector("");
	
	public void enterFirstName (String Firstname) {
		enterText(txtFirstName, Firstname, "Firstname");
	}
	public void enterLastName(String LastName) {
		enterText(txtLastName, LastName, "LastName");
	}
	public void enterEmail (String Email) {
		enterText(txtEmail, Email, "Email");
	}
	public void enterAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}
	public void clickOnPurchase() {
		click(btnPurchase, "Click Purchase");
	}
	public void VerifyErrorMessage(String ErrorMessage) {
	  new CommonFunctions().verifyLabelText(lblErrorMsg, ErrorMessage, "ErrorMessage");
    }
	public void clickOnViewMoreLink() {
		click(lnkViewMore, "Click ViewMore");
	}
}
