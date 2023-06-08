package coyni_mobile.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	private By lblAllDone = MobileBy.AccessibilityId("All Done");
	private By lblAccountCreated = MobileBy.AccessibilityId("Account Created");
	private By lblAccountReadyDesc = MobileBy.AccessibilityId("Account is Ready");
	private By lblCardSucessDesc = MobileBy.AccessibilityId("");
	private By imgTickMark = MobileBy.AccessibilityId("Success image");
	private By lblEmailSucess = MobileBy.AccessibilityId("Change Email Successful");
	private By lblChangeEmailDesc = MobileBy.AccessibilityId("");

	private By lblPasswordSucess = MobileBy.AccessibilityId("Change Password Successful");
	private By lblPasswordUpdatedDesc = MobileBy.AccessibilityId("");
	private By btnLogin = MobileBy.AccessibilityId("");
	private By lblPwdChanged = MobileBy.AccessibilityId("");
	private By lblpwdChangedDesc = MobileBy.AccessibilityId("");
	private By btnDone = MobileBy.AccessibilityId("");

//	Add Bank Successful page
	private By addBankSuccHeading = MobileBy.AccessibilityId("");
//	private By lblDescription = MobileBy.xpath("//*[@text='Your bank account(s) has been successfully authorized and added to your payment methods.']");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 80);

	public void verifyBankSucessHeading(String expHeading) {
		wait.until(ExpectedConditions.presenceOfElementLocated(addBankSuccHeading));
		new CommonFunctions().verifyLabelText(addBankSuccHeading, "Bank Success Heading", expHeading);
	}

	public void verifyAddedBankDescription(String description) {
		By lblDescription = MobileBy.xpath("//*[@text=" + "'" + description + "'" + "]");
		if (getElement(lblDescription, "Bank Description").isDisplayed()) {
			ExtentTestManager.setPassMessageInReport(getText(lblDescription) + " is displayed");
		} else {
			ExtentTestManager.setFailMessageInReport(getText(lblDescription) + " is not displayed");
		}
	}

	public void verifyPasswordChanged(String hdg) {
		new CommonFunctions().elementView(imgTickMark, "Tick mark");
		new CommonFunctions().verifyLabelText(lblPwdChanged, "password changed", hdg);
	}

	public void verifyPasswordChangedDesc(String hdg) {
		new CommonFunctions().verifyLabelText(lblpwdChangedDesc, "password changed", hdg);
	}

	public void verifyAllDone(String allDone) {
		new CommonFunctions().elementView(imgTickMark, "Tick Mark");
		new CommonFunctions().verifyLabelText(lblAllDone, "All Done", allDone);
	}

	public void verifyCardSucessDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblCardSucessDesc, "description", desc);
	}

	public void clickDone() {
		if (getElement(btnDone, "Done").isEnabled()) {
			click(btnDone, "Done");
		} else {
			ExtentTestManager.setInfoMessageInReport("Done Button is disabled");
		}
	}

//	
//	private By lblHeading = MobileBy.xpath("(//*[contains(@name,'All Done')])[1]|//*[contains(@name,'Transaction')]");
//
//	private By ImgSuccessFailure = MobileBy.xpath(
//			"//*[contains(@name,'All Done')]/preceding-sibling::*[1] | //XCUIElementTypeStaticText[contains(@name,'Transaction')]/preceding-sibling::*[1]");
//
//	private By btnLogout = MobileBy.xpath("//*[contains(@name,'security')]/../following-sibling::*[1]");
//
//	private By btnDone = MobileBy.xpath("(//*[@name='Done'])[1]");
//
//	private By lblRequestStatus = MobileBy
//			.xpath("//XCUIElementTypeImage[contains(@name,'icon')]/following-sibling::*[1]");
//
////    private By lblDes =MobileBy.xpath("//*[@name='All Done']/following-sibling::*[1]");
//
//	private By lblDes = MobileBy
//			.AccessibilityId("Your card has been successfully authorized and added to your payment methods.");
//

//
//	private By lblReferId = MobileBy
//			.xpath("//XCUIElementTypeStaticText[@name=\"Reference ID\"]/following-sibling::*[1]");
//
//	private By lblSuccessfullDescription = MobileBy.xpath(
//			"//*[contains(@name,'Email Successful')]/following-sibling::*[1] | //*[contains(@name,'Password Successful')]/following-sibling::*[1]");
//
//	private By lblTransactionInProg = MobileBy.xpath(
//			"//XCUIElementTypeStaticText[@name='Transaction in Progress'] | //XCUIElementTypeStaticText[contains(@name,'Transaction In')] | //XCUIElementTypeStaticText[contains(@name,'Transaction Pending')]");
//
////    private By lblTransactionInProg = MobileBy.AccessibilityId("Transaction in Progress | Transaction In progress");
//
//	private By lblamount = MobileBy
//			.xpath("//XCUIElementTypeStaticText[contains(@name,'Transaction')]/following-sibling::*[1]");
//
//	private By lblThisTotal = MobileBy
//			.xpath("//XCUIElementTypeStaticText[contains(@name,'Transaction')]/following-sibling::*[3]");
//
//	private By lblProcessingDesc = MobileBy.xpath(
//			"//*[contains(@name,'We are processing your request,')]|//XCUIElementTypeImage[@name='copy']/following-sibling::*[1]");
//
//	
//	//////////// failure screen/////////////
//
//	private By lblPreauthFailed = MobileBy.xpath("//*[contains(@name,'Pre-Authorization Failed')]");
//
//	private By imgFailed = MobileBy.xpath("//*[contains(@name,'Pre-Authorization Failed')]/preceding-sibling::*[1]");
//
//	private By lblfailureDesc = MobileBy.xpath("//*[contains(@name,'Your account has been locked due')]");
//
//	private By btnOK = MobileBy.xpath("//XCUIElementTypeButton[@name='OK']");
//	private By lblCardSuccess = MobileBy.AccessibilityId("");
//	private By lblCardDesc = MobileBy.AccessibilityId("");
//	private By btnBuyToken = MobileBy.AccessibilityId("");
//	private By btnSkip = MobileBy.AccessibilityId("");
//
//	public void clicBuyTokens() {
//		click(btnBuyToken, "Buy Token");
//	}
//
//	public void clickSkip() {
//		click(btnSkip, "Skip");
//	}
//
//	public void verifyCardSuccess(String cardDesc) {
//		new CommonFunctions().elementView(lblCardSuccess, "Heading");
//		new CommonFunctions().verifyLabelText(lblCardDesc, "Description", cardDesc);
//	}
//
//	public void verifyPreAuthyHeading(String expHeading) {
//
//		new CommonFunctions().verifyLabelText(lblPreauthFailed, "Preauthy failed", expHeading);
//
//		new CommonFunctions().elementView(imgFailed, "Image failed");
//
//	}
//
//	public void VerifyFeailureDesc(String expDesc) {
//
//		new CommonFunctions().verifyLabelText(lblfailureDesc, expDesc, expDesc);
//
//		click(btnOK, "Ok");
//
//	}
//
//	public void verifyProcessingDEsc() {
//
//		new CommonFunctions().elementView(lblProcessingDesc, "Proc desc");
//
//		ExtentTestManager.setInfoMessageInReport("proc desc is :" + getText(lblProcessingDesc));
//
//	}
//
//	public void veriyfTransactionStatus() {
//
//		ExtentTestManager.setInfoMessageInReport("the status is : " + getText(lblHeading));
//
//	}
//
//	public void VerifyTransactionScreen() throws InterruptedException {
//
////        Thread.sleep(3000);
//
////        if(getElementList(lblTransactionInProg, "Transaction In Progress").size()>0) {
//
//		new CommonFunctions().elementView(lblTransactionInProg, "Transaction in Prog");
//
//		new CommonFunctions().elementView(ImgSuccessFailure, "Image");
//
//		ExtentTestManager.setInfoMessageInReport("the text is :" + getText(lblThisTotal));
//
//		// getStatus();
//
//		getAmountAndRefID();
//
//		verifyProcessingDEsc();
//
////        }else {
//
////            ExtentTestManager.setInfoMessageInReport("transaction is not in progress state");
//
////        }
//
//	}
//
//	public String verifyReferenceCopy() {
//
//		// click(lblReferId, "Copy the Referrence ID");
//
//		String str = getText(lblReferId);
//
//		return str;
//
//	}
//
//	public void verifySucessDescription(String sucessDescription) {
//
//		new CommonFunctions().verifyLabelText(lblSuccessfullDescription, "sucessDescription", sucessDescription);
//
//	}
//
//	public void getStatus() {
//
//		// new CommonFunctions().elementView(ImgSuccessFailure, "Success Image");
//
//		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblAllDone));
//
//	}
//
//	public void clickDone() {
//
//		click(btnDone, "Done");
//
//	}
//
//	public void verifySucessHeading(String expHeading) {
//
//		new CommonFunctions().verifyLabelText(lblAllDone, "heading", expHeading);
//
//	}

	public void verifyEmailSucess(String expHeading) {
		new CommonFunctions().elementView(imgTickMark, "sucess image");
		new CommonFunctions().verifyLabelText(lblEmailSucess, "heading", expHeading);

	}

	public void verifyPasswordSucess(String expHeading) {

		new CommonFunctions().verifyLabelText(lblPasswordSucess, "heading", expHeading);

	}

//	public void verifySuccessFailureHeading(String expHeading) {
//
//		new CommonFunctions().verifyLabelText(lblPreauthFailed, "heading", expHeading);
//
//	}
//
//	public void clickLogOut() {
//
//		click(btnLogout, "LogOut");
//
//	}

//	public void getRequestStatus() {
//
//		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblRequestStatus));
//
//	}

//	public void getDescription() {
//
//		ExtentTestManager.setInfoMessageInReport("Description:" + getText(lblDes));
//
//		// new CommonFunctions().verifyLabelText(lblDes, "description", expDesc);
//
//	}

	public void verifyPasswordUpdatedDesc(String desc) {
		new CommonFunctions().elementView(lblAllDone, "AllDOne");
		new CommonFunctions().elementView(imgTickMark, "Tick mark");
		new CommonFunctions().verifyLabelText(lblPasswordUpdatedDesc, "Password Update desc", desc);
	}

//	public void getSucessDescription(String expDesc) {
//
//		// ExtentTestManager.setInfoMessageInReport("Description:"+getText(lblDes));
//
//		new CommonFunctions().verifyLabelText(lblDes, "description", expDesc);
//
//	}

	public void clickLogin() {
		if (getElement(btnLogin, "Login").isEnabled()) {
			click(btnLogin, "Login");
		} else {
			ExtentTestManager.setInfoMessageInReport("login button is disabled");
		}

	}

	public void verifyChangeEmailDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblChangeEmailDesc, "desc", desc);
	}

//	public void getAmountAndRefID() {
//
//		ExtentTestManager.setInfoMessageInReport("amount is :" + getText(lblamount));
//
//		ExtentTestManager.setInfoMessageInReport("ref Id is :" + getText(lblReferId));
//
//		ExtentTestManager.setInfoMessageInReport("this total desc is :" + getText(lblThisTotal));
//
//	}
	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
	}

}
