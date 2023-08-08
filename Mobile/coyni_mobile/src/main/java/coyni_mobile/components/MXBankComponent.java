package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class MXBankComponent extends MobileFunctions {
	private By btnStart = MobileBy.xpath("//*[contains(@resource-id,'cvStart')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'coyni uses a trusted')]");
	private By lblMXChBXDesc = MobileBy.xpath("//*[contains(@text,'coyni uses trusted')]");
	private By lblSelectInstitution = MobileBy
			.xpath("//*[contains(@text,'Select your institution')]|//*[contains(@text,'Search more institutions')]");
	private By btnMxBank = MobileBy.xpath("//*[@text='Add account with MX Bank']");
	private By btnMXOuath = MobileBy.xpath("//*[contains(@text,'MX Bank (Oauth)')]");
	private By btnSearchMoreInstitutions = MobileBy
			.xpath("//*[@text='Search more institutions']|//*[@text='Search for your institution']");
	private By btnContinue = MobileBy.xpath("//*[@text='Yes, continue']");
	private By btnCancel = MobileBy.xpath("//*[@text='Cancel']");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'closeBtn')]");
	// Enter your Credentials screen
	private By heading = MobileBy.xpath("//*[@text='Add Bank Account']|//*[@text='Add Bank Checking Account']");
	private By btncheckBox = MobileBy.xpath("//*[contains(@resource-id,'checkbox')]");
	private By txtUsername = MobileBy.xpath("//*[@resource-id='LOGIN']");
	private By txtPassword = MobileBy.xpath("//*[@resource-id='PASSWORD']");
	private By btnCredentialsContinue = MobileBy.xpath("//*[@text='Continue']");
	private By btnCredentialsBack = MobileBy.xpath("//*[@text='Back']");
	// Verify Identity screen
	private By lblIdentityHeading = MobileBy.xpath("//*[@text='Verify identity']");
	private By btnChecking = MobileBy.xpath("//*[@text='Checking']");
	private By btnSavings = MobileBy.xpath("//*[@text='Savings']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Bank Heading", expHeading);
	}

	public void clickheckBox() {
		click(btncheckBox, "Check Box");
	}

	public void verifyBankDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDescription, "MX Description", description);
//		By a = MobileBy.xpath("//*[@text=" + "'" + description + "'" + "]");
//		if (getElement(a, "Bank Description").isDisplayed()) {
//			ExtentTestManager.setPassMessageInReport(getText(a) + " is displayed");
//		} else {
//			ExtentTestManager.setFailMessageInReport(getText(a) + " is not displayed");
//		}
	}

	public void verifyChkBxDescription(String description) {
		new CommonFunctions().verifyLabelText(lblMXChBXDesc, "MX Description", description);
//		By a = MobileBy.xpath("//*[@text=" + "'" + description + "'" + "]");
//		if (getElement(a, "Bank Description").isDisplayed()) {
//			ExtentTestManager.setPassMessageInReport(getText(a) + " is displayed");
//		} else {
//			ExtentTestManager.setFailMessageInReport(getText(a) + " is not displayed");
//		}
	}

	public void verifyStart() {
		if (!getElement(btnStart, "Start").isEnabled()) {
			ExtentTestManager.setPassMessageInReport("Before click on check box, Start Button is disabled mode");
		} else {
			ExtentTestManager.setFailMessageInReport("Before click on check box, Start Button is enabled mode");
		}
	}

	public void clickStart() {
		new CommonFunctions().clickEnabledElement(btnStart, "Start");
	}

	public void clickMoreInstitutions() {
		click(btnSearchMoreInstitutions, "Search more Institutions");
	}

	public void clickMXBank() {
		click(btnMxBank, "MX Bank");
	}

	public void clickMXBankOauth() {
		click(btnMXOuath, "MX Bank Oauth");
	}

	public void clickMXCancel() {
		click(btnCancel, "Cancel");
	}

	public void clickMXContinue() {
		click(btnContinue, "Yes,continue");
	}

	public int MXConfirmationScreen(String heading) throws InterruptedException {
		/*
		 * here confirmation screen not coming every time so, to handle this we are
		 * using get element list but here explicitly wait is not working. so, to get
		 * accurate results we are using static wait
		 */
		Thread.sleep(1500);
		By mxHeading = MobileBy.xpath("//*[@text=" + "'" + heading + "'" + "]");
		return getElementList(mxHeading, "Confirmstion Screen").size();
	}

	public void verifyMXConfirmationScreen(String haeding, String description) {
		By mxHeading = MobileBy.xpath("//*[@text=" + "'" + haeding + "'" + "]");
		By mxDescription = MobileBy.xpath("//*[@text=" + "'" + description + "'" + "]");
		if (getElement(mxHeading, "MX Already Connected Heading").isDisplayed()
				&& getElement(mxDescription, "MX Already Connected Description").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(getText(mxHeading) + " is displayed");
			ExtentTestManager.setPassMessageInReport(getText(mxDescription) + " is displayed");
		} else {
			ExtentTestManager.setFailMessageInReport(getText(mxHeading) + " is not displayed");
			ExtentTestManager.setFailMessageInReport(getText(mxDescription) + " is not displayed");
		}
	}

	public void clickAdd() {
		click(btnClose, "Close");
	}

	public void verifySelectYourInstitution(String heading) {
		By institutionHeading = MobileBy.xpath("//*[@text='Select your institution']");
		new CommonFunctions().elementView(institutionHeading, "institutionHeading");
	}

	public void addBank(String expHeading, String bankDescription, String chkbxDescription) {
		verifyHeading(expHeading);
		verifyStart();
		verifyBankDescription(bankDescription);
		clickheckBox();
		clickStart();
	}

	public void selectMXBank() {

		clickMoreInstitutions();
		clickMXBank();
	}

// Enter your Credentials screen
	public void fillUserName(String username) {
		new CommonFunctions().verifyAutoFocusElement(txtUsername, "User Name");
		click(txtUsername, "User Name");
		enterText(txtUsername, username, "User Name");
	}

	public void fillPassword(String password) {
		click(txtPassword, "Password");
		enterText(txtPassword, password, "Password");
	}

	public void clickContinue() {
		DriverFactory.getDriver().hideKeyboard();
		click(btnCredentialsContinue, "Credentials Continue");
	}

	public void clickBack() {
		click(btnCredentialsBack, "Credentials Back");
	}

	public void verifyCredentialsHeading(String heading) {
		By entercredenHeading = MobileBy.xpath("//*[@text='Enter your credentials']");
		new CommonFunctions().elementView(entercredenHeading, "Enter Credentilas Heading");
	}

//	Verify Identity screen
	public void clickChecking() {
		click(btnChecking, "Checking");
	}

	public void clickSavings() {
		click(btnSavings, "savings");
	}

	public void VerifySelectAccountHeading() {
		By identityHeading = MobileBy.xpath("//*[@text='Select an account']");
		new CommonFunctions().elementView(identityHeading, "Select an account");
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

}
