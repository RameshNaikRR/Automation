package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	private By btnClickMore = MobileBy.xpath("//*[contains(@resource-id,'learnMoreTV')]");
	private By lblSucessFailure = MobileBy.xpath("//*[contains(@resource-id,'tvHeading')]|//*[contains(@resource-id,'Heading')]");
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'giftCardType')]");
	private By lblTitleDescription = MobileBy.xpath("//*[contains(@resource-id,'giftCardDesc')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'Processing')]");
	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'giftCardAmount')]|//*[contains(@resource-id,'Amount')]");
	private By btnLogout = MobileBy.xpath("//*[contains(@resource-id,'Logout')]");
	private By lblReceipentEmail = MobileBy.xpath("//*[contains(@resource-id,'recipientMailTV')]");//
	private By btnDone = MobileBy.xpath("//*[@text='Done']|//*[contains(@resource-id,'doneCV')]|//*[contains(@resource-id,'cvBDone')]");//
	private By lblReferenceID = MobileBy.xpath("//*[contains(@resource-id,'refIDTV')]|//*[contains(@resource-id,'ReferenceID')]");
	private By lnkReferenceID = MobileBy.xpath("//*[contains(@resource-id,'tvReferenceID')]/following-sibling::*[1]");
	private By lblTrasactionStatus = MobileBy.xpath("//*[contains(@text,'Trasactions')]");
	private By lblEmailSucessFul = MobileBy.xpath("//*[contains(@text,'Change Email Successful')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'Close')]");

	public void getStatus() {
		ExtentTestManager.setPassMessageInReport("Status: " + getText(lblHeading));
	}

	public void getDescription() {
		ExtentTestManager.setPassMessageInReport("Description: " + getText(lblTitleDescription));
	}

	public void getProcessingDescription() {
		ExtentTestManager.setPassMessageInReport("Processing Description: " + getText(lblDescription));
	}

	public void getAmount() {
		ExtentTestManager.setPassMessageInReport("Amount: " + getText(lblAmount));
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

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void verifyRecipentEmail(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReceipentEmail, "Email", expHeading);
	}

	public void verifySuccessFailureHeading() {
		ExtentTestManager.setPassMessageInReport(getText(lblSucessFailure));
//		new CommonFunctions().verifyLabelText(lblSucessFailure, "heading", expHeading);

	}

	public void clickLearnMore() {
		click(btnClickMore, "Click More");
	}

	public void getReferenceID() {
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
		ExtentTestManager.setPassMessageInReport("Reference ID : " + getText(lblReferenceID));
	}

	public void clickLogOut() {
		click(btnLogout, "LogOut");
	}

	public void getTokenTransactionStatusDetails() {
		verifySuccessFailureHeading();
		getAmount();
		getReferenceID();
		clickDone();
	}
	
	public void getGiftCardTransactionDetails() {
		getStatus();
		getAmount();
		getDescription();
		getReferenceID();
		getProcessingDescription();
		clickDone();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
