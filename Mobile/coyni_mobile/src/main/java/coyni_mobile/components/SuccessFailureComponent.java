package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	
	private By lblSucessfullHeading = MobileBy.xpath("//*[contains(@resource-id,'tvDone')]|//*[contains(@text,' Email Successful')]|//*[contains(@text,'Password Successful')]");
	private By lblSucessfullDescription = MobileBy.xpath("//*[contains(@text,'Your passwo')]|//*[contains(@text,'For security purposes')]|//*[contains(@text,'For security purposes, please log out')]");
	private By btnLogin = MobileBy.xpath("//*[contains(@text,'Log in')]");
	private By btnLogOut=MobileBy.xpath("//*[contains(@resource-id,'EmailLogoutCV')]|//*[contains(@resource-id,'btnCV')]|//*[contains(@resource-id,'Logout')]");
	private By btnClickMore = MobileBy.xpath("//*[contains(@resource-id,'learnMoreTV')]");
	private By lblSucessFailure = MobileBy.xpath("//*[contains(@resource-id,'tvHeading')]");
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'giftCardType')]");
	private By lblTitleDescription = MobileBy.xpath("//*[contains(@resource-id,'giftCardDesc')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'Processing')]");
	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'giftCardAmount')]");
	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]");//
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'doneCV')]|//*[contains(@resource-id,'cvDone')]");//
	private By lblReferenceID = MobileBy.xpath("//*[contains(@resource-id,'refID')]");
	private By lblTrasactionStatus = MobileBy.xpath("//*[contains(@text,'Trasactions')]");
	private By lblEmailSucessFul = MobileBy.xpath("//*[contains(@text,'Change Email Successful')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'Close')]");
	
	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblHeading));
	}

	public void getDescription() {
		ExtentTestManager.setInfoMessageInReport("Description: " + getText(lblTitleDescription));
	}

	public void getProcessingDescription() {
		ExtentTestManager.setInfoMessageInReport("Processing Description: " + getText(lblDescription));
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblAmount));
	}

	public void verifyTrasactionsStatus() {
		String str = getText(lblTrasactionStatus);

		ExtentTestManager.setPassMessageInReport("Trasactions status is " + str);

	}

	public void viewEmailSuccessHeading() {
		new CommonFunctions().elementView(lblEmailSucessFul, "Email Successful");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyRecipentEmail(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReceipentEmail, "Email", expHeading);
	}

	public void verifySuccessFailureHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessFailure, "heading", expHeading);

	}

	public void clickLearnMore() {
		if(getElementList(btnClickMore, "Click More").size()>0) {
			click(btnClickMore, "Click More");	
			click(btnClose, "Close");
		}
	}

	public void getReferenceID() {
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		ExtentTestManager.setInfoMessageInReport("Reference ID : " + "lblReferenceID");
	}

	public void getTransactionDetails(){
		getStatus();
		getAmount();
		getDescription();
		getReferenceID();
		getProcessingDescription();
		clickLearnMore();
		clickDone();
	}
//	public NavigationComponent navigationComponent() {
//		return new NavigationComponent();
//	}

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessfullHeading,
				"Sucessfully Upadated Page Heading : ", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblSucessfullDescription,
				"Sucessfully Upadated Page Description : ", expDescription);
	}

	public void clickLogin() {
		new CommonFunctions().elementView(btnLogin, "Login");
		click(btnLogin, "Login");
	}
	
	public void clickLogout() {
		scrollDownToElement(btnLogOut, "Log Out");
		new CommonFunctions().elementView(btnLogOut, "Logout");
		click(btnLogOut, "Logout");
	}
	
//	private By btnClickMore = MobileBy.xpath("//*[contains(@resource-id,'learnMoreTV')]");
//	private By lblSucessFailure = MobileBy.xpath("//*[contains(@resource-id,'tvHeading')]");
//	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'giftCardType')]");
//	private By lblTitleDescription = MobileBy.xpath("//*[contains(@resource-id,'giftCardDesc')]");
//	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'Processing')]");
//	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'giftCardAmount')]");
//	private By btnLogout = MobileBy.xpath("//*[contains(@resource-id,'Logout')]");
//	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]");//
//	private By btnDone = MobileBy.xpath("//*[@text='Done']|//*[contains(@resource-id,'doneCV')]|//*[contains(@resource-id,'cvBDone')]");//
//	private By lblReferenceID = MobileBy.xpath("//*[contains(@resource-id,'refID')]");
//	private By lnkReferenceID = MobileBy.xpath("//*[contains(@resource-id,'tvReferenceID')]/following-sibling::*[1]");
//	private By lblTrasactionStatus = MobileBy.xpath("//*[contains(@text,'Trasactions')]");
//	private By lblEmailSucessFul = MobileBy.xpath("//*[contains(@text,'Change Email Successful')]");
//	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'Close')]");
//
//	public void getStatus() {
//		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblHeading));
//	}
//
//	public void getDescription() {
//		ExtentTestManager.setInfoMessageInReport("Description: " + getText(lblTitleDescription));
//	}
//
//	public void getProcessingDescription() {
//		ExtentTestManager.setInfoMessageInReport("Processing Description: " + getText(lblDescription));
//	}
//
//	public void getAmount() {
//		ExtentTestManager.setInfoMessageInReport("Amount: " + getText(lblAmount));
//	}
//
//	public void verifyTrasactionsStatus() {
//		String str = getText(lblTrasactionStatus);
//
//		ExtentTestManager.setPassMessageInReport("Trasactions status is " + str);
//
//	}
//
//	public void viewEmailSuccessHeading() {
//		new CommonFunctions().elementView(lblEmailSucessFul, "Email Successful");
//	}
//
//	public void clickDone() {
//		click(btnDone, "Done");
//	}
//
//	public void clickClose() {
//		click(btnClose, "Close");
//	}
//
//	public void verifyRecipentEmail(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblReceipentEmail, "Email", expHeading);
//	}
//
//	public void verifySuccessFailureHeading(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblSucessFailure, "heading", expHeading);
//
//	}
//
//	public void clickLearnMore() {
//		click(btnClickMore, "Click More");
//	}
//
//	public void getReferenceID() {
//		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
//		ExtentTestManager.setInfoMessageInReport("Reference ID : " + "lblReferenceID");
//	}
//
//	public void clickLogOut() {
//		click(btnLogout, "LogOut");
//	}
//
//	public void getTransactionDetails() {
//		getStatus();
//		getAmount();
//		getDescription();
//		getReferenceID();
//		getProcessingDescription();
//		clickLearnMore();
//		clickClose();
//		clickDone();
//	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
