package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SuccessFailurePopupCardComponent extends BrowserFunctions {

	private By imgSuccessFailure = By.cssSelector(".h-36.w-36");
	private By imgSuccessFailureRequest = By.cssSelector(".h-48.w-48");
	private By headingPreAuthorizationSucess = By.xpath("//h1[contains(text(),'Pre-Authorization Success')]");
	private By headingPreAuthorizationFailed = By.xpath("//h1[contains(text(),'Pre-Authorization Failed')]");
	private By lblTransactionFailed = By.cssSelector("");
	private By tryAgain = By.xpath("");
	private By lblFailedMessage = By.xpath("");
	private By lblSignetDeleted = By.xpath("//h1[text()='Signet Account']");
	private By btnBuyCoyni = By.xpath("//button[contains(text(),'Buy Coyni')]");
	private By lblTransactionSuccessful = By.xpath("//div[text()='Transaction Successful']");
	private By lblRequestSuccessful = By.xpath("//div[text()='Tokens Requested Successfully']");
	private By lblSignetDeleted1 = By.xpath("//h1[text()='Removed Successfully']");
	private By lblRemovedSuccessfully = By.xpath("//h1[contains(text(),'Payment Method Removed Successfully')]");
	private By lblMessage = By.xpath("//h2[text()='You successfully sent']");
	private By btnDone = By.xpath("//button[text()='Done']");
	private By lblReferenceID = By.xpath("//span[text()='Reference ID']");
	private By lblAccountBalance = By.xpath("//span[text()='Account Balance']");
	private By lblBankAddedSuceesful = By.xpath("//h1[contains(text(),'Bank Account Added')]");
	private By heading = By.className("SendReceiveModal_successful_message__3TKQt");
	private By btnClose = By.xpath("//button[text()='Close']");
	private By lblEmailAddress = By.xpath("//div[@class='mt-4']");
	private By btnWithdrawCoyni = By.xpath("//button[text()='Withdraw coyni']");
	
	public void verifyAccountBalance() {
		new CommonFunctions().elementView(lblAccountBalance, "Account Balance");
	}

	public void verifyRequestHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblRequestSuccessful, expHeading, "Tokens Requested Successfully");
	}

	// DOUBT
	public void verifyImage() {
		new CommonFunctions().elementView(imgSuccessFailure, "Tick Mark");

	}

	public void verifyLabelFailedMessage() {
		new CommonFunctions().elementView(lblFailedMessage, "Transaction Failed Description");
	}

	public void verifyTransactionFailedHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionFailed, "Transaction Failed", expHeading);
	}

	public void verifyReferenceID() {
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
	}

	public void verifyMessge(String expMessage) {
		new CommonFunctions().verifyLabelText(lblMessage, "Message", expMessage);
	}

	public void verifyImageRequest() {
		new CommonFunctions().elementView(imgSuccessFailureRequest, "Tick Mark");

	}

	public void verifyFailedHeadingView() {
		new CommonFunctions().elementView(headingPreAuthorizationFailed, "Pre Authorization Failed");
	}

	public void clickDone() {
		if (getElement(btnDone, "").isDisplayed()) {
			click(btnDone, "Click Done");
		} else {
			click(btnWithdrawCoyni, "Withdraw Coyni");
		}
	}

	public void clickTryAgain() {
		click(tryAgain, "Try Again");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionSuccessful, "Success Heading", expHeading);
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void verifySignetDeleteHeading(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetDeleted, "Signet Account Added Successfully", expSignetHeading);
	}

	public void verifySignetDeleteHeading2(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetDeleted1, "Signet Account Added Successfully", expSignetHeading);
	}

//
//	public void verifyAddBankAccountview() {
//		new CommonFunctions().elementView(btnAddBankAccount, "AddBankAccount");
//
//	}
	public void verifyheadingview() {
		new CommonFunctions().elementView(heading, "heading");

	}

	public void verifyEmailAddressChanged(String emailAddress) {
		new CommonFunctions().verifyLabelText(lblEmailAddress, "Email Address Changed Successfully Popup",
				emailAddress);
	}

	public void verifyPreAuthorizationSucessHeading(String expPreAuthorizationSucessHeading) {
		new CommonFunctions().verifyLabelText(headingPreAuthorizationSucess, "Pre-Authorization",
				expPreAuthorizationSucessHeading);
	}

	public void clickBuyCoyni() {
		click(btnBuyCoyni, "Click Buy Coyni");
	}

	public void verifyBankAddSuccesfulHeaading() {
		new CommonFunctions().elementView(lblBankAddedSuceesful, "Bank Added Succesful");
	}

	public void verifyPaymnetRemovedSuccessfulHeading() {
		new CommonFunctions().elementView(lblRemovedSuccessfully, "Payment Method Removed Successfully");
	}

	public void viewClose() {
		new CommonFunctions().elementView(btnClose, "Close");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
