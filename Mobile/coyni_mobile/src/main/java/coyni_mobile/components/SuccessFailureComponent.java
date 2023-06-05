package coyni_mobile.components;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.By;

import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	private By lblAllDone = MobileBy.AccessibilityId("All Done");
    private By imgTickMark = MobileBy.AccessibilityId("");
	private By lblEmailSucess = MobileBy.AccessibilityId("Change Email Successful");

	private By lblPasswordSucess = MobileBy.AccessibilityId("Change Password Successful");
	private By lblPasswordUpdatedDesc = MobileBy
			.AccessibilityId("");
	
	
	
	private By lblHeading = MobileBy.xpath("(//*[contains(@name,'All Done')])[1]|//*[contains(@name,'Transaction')]");

	private By ImgSuccessFailure = MobileBy.xpath(
			"//*[contains(@name,'All Done')]/preceding-sibling::*[1] | //XCUIElementTypeStaticText[contains(@name,'Transaction')]/preceding-sibling::*[1]");

	private By btnLogout = MobileBy.xpath("//*[contains(@name,'security')]/../following-sibling::*[1]");

	private By btnDone = MobileBy.xpath("(//*[@name='Done'])[1]");

	private By lblRequestStatus = MobileBy
			.xpath("//XCUIElementTypeImage[contains(@name,'icon')]/following-sibling::*[1]");

//    private By lblDes =MobileBy.xpath("//*[@name='All Done']/following-sibling::*[1]");

	private By lblDes = MobileBy
			.AccessibilityId("Your card has been successfully authorized and added to your payment methods.");

	private By btnLogin = MobileBy.xpath("//*[@name='All Done']/following-sibling::XCUIElementTypeButton");

	private By lblReferId = MobileBy
			.xpath("//XCUIElementTypeStaticText[@name=\"Reference ID\"]/following-sibling::*[1]");

	private By lblSuccessfullDescription = MobileBy.xpath(
			"//*[contains(@name,'Email Successful')]/following-sibling::*[1] | //*[contains(@name,'Password Successful')]/following-sibling::*[1]");

	private By lblTransactionInProg = MobileBy.xpath(
			"//XCUIElementTypeStaticText[@name='Transaction in Progress'] | //XCUIElementTypeStaticText[contains(@name,'Transaction In')] | //XCUIElementTypeStaticText[contains(@name,'Transaction Pending')]");

//    private By lblTransactionInProg = MobileBy.AccessibilityId("Transaction in Progress | Transaction In progress");

	private By lblamount = MobileBy
			.xpath("//XCUIElementTypeStaticText[contains(@name,'Transaction')]/following-sibling::*[1]");

	private By lblThisTotal = MobileBy
			.xpath("//XCUIElementTypeStaticText[contains(@name,'Transaction')]/following-sibling::*[3]");

	private By lblProcessingDesc = MobileBy.xpath(
			"//*[contains(@name,'We are processing your request,')]|//XCUIElementTypeImage[@name='copy']/following-sibling::*[1]");

	
	//////////// failure screen/////////////

	private By lblPreauthFailed = MobileBy.xpath("//*[contains(@name,'Pre-Authorization Failed')]");

	private By imgFailed = MobileBy.xpath("//*[contains(@name,'Pre-Authorization Failed')]/preceding-sibling::*[1]");

	private By lblfailureDesc = MobileBy.xpath("//*[contains(@name,'Your account has been locked due')]");

	private By btnOK = MobileBy.xpath("//XCUIElementTypeButton[@name='OK']");
	private By lblCardSuccess = MobileBy.AccessibilityId("");
	private By lblCardDesc = MobileBy.AccessibilityId("");
	private By btnBuyToken = MobileBy.AccessibilityId("");
	private By btnSkip = MobileBy.AccessibilityId("");

	public void clicBuyTokens() {
		click(btnBuyToken, "Buy Token");
	}

	public void clickSkip() {
		click(btnSkip, "Skip");
	}

	public void verifyCardSuccess(String cardDesc) {
		new AndroidCommonFunctions().elementView(lblCardSuccess, "Heading");
		new AndroidCommonFunctions().verifyLabelText(lblCardDesc, "Description", cardDesc);
	}

	public void verifyPreAuthyHeading(String expHeading) {

		new AndroidCommonFunctions().verifyLabelText(lblPreauthFailed, "Preauthy failed", expHeading);

		new AndroidCommonFunctions().elementView(imgFailed, "Image failed");

	}

	public void VerifyFeailureDesc(String expDesc) {

		new AndroidCommonFunctions().verifyLabelText(lblfailureDesc, expDesc, expDesc);

		click(btnOK, "Ok");

	}

	public void verifyProcessingDEsc() {

		new AndroidCommonFunctions().elementView(lblProcessingDesc, "Proc desc");

		ExtentTestManager.setInfoMessageInReport("proc desc is :" + getText(lblProcessingDesc));

	}

	public void veriyfTransactionStatus() {

		ExtentTestManager.setInfoMessageInReport("the status is : " + getText(lblHeading));

	}

	public void VerifyTransactionScreen() throws InterruptedException {

//        Thread.sleep(3000);

//        if(getElementList(lblTransactionInProg, "Transaction In Progress").size()>0) {

		new AndroidCommonFunctions().elementView(lblTransactionInProg, "Transaction in Prog");

		new AndroidCommonFunctions().elementView(ImgSuccessFailure, "Image");

		ExtentTestManager.setInfoMessageInReport("the text is :" + getText(lblThisTotal));

		// getStatus();

		getAmountAndRefID();

		verifyProcessingDEsc();

//        }else {

//            ExtentTestManager.setInfoMessageInReport("transaction is not in progress state");

//        }

	}

	public String verifyReferenceCopy() {

		// click(lblReferId, "Copy the Referrence ID");

		String str = getText(lblReferId);

		return str;

	}

	public void verifySucessDescription(String sucessDescription) {

		new AndroidCommonFunctions().verifyLabelText(lblSuccessfullDescription, "sucessDescription", sucessDescription);

	}

	public void getStatus() {

		// new CommonFunctions().elementView(ImgSuccessFailure, "Success Image");

		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblAllDone));

	}

	public void clickDone() {

		click(btnDone, "Done");

	}

	public void verifySucessHeading(String expHeading) {

		new AndroidCommonFunctions().verifyLabelText(lblAllDone, "heading", expHeading);

	}

	public void verifyEmailSucess(String expHeading) {

		new AndroidCommonFunctions().verifyLabelText(lblEmailSucess, "heading", expHeading);

	}

	public void verifyPasswordSucess(String expHeading) {

		new AndroidCommonFunctions().verifyLabelText(lblPasswordSucess, "heading", expHeading);

	}

	public void verifySuccessFailureHeading(String expHeading) {

		new AndroidCommonFunctions().verifyLabelText(lblPreauthFailed, "heading", expHeading);

	}

	public void clickLogOut() {

		click(btnLogout, "LogOut");

	}

	public void getRequestStatus() {

		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblRequestStatus));

	}

	public void getDescription() {

		ExtentTestManager.setInfoMessageInReport("Description:" + getText(lblDes));

		// new CommonFunctions().verifyLabelText(lblDes, "description", expDesc);

	}

	public void verifyPasswordUpdatedDesc(String desc) {
		new AndroidCommonFunctions().elementView(lblAllDone, "AllDOne");
		new AndroidCommonFunctions().elementView(imgTickMark, "Tick mark");
		new AndroidCommonFunctions().verifyLabelText(lblPasswordUpdatedDesc, "Password Update desc", desc);
	}

	public void getSucessDescription(String expDesc) {

		// ExtentTestManager.setInfoMessageInReport("Description:"+getText(lblDes));

		new AndroidCommonFunctions().verifyLabelText(lblDes, "description", expDesc);

	}

	public void clickLogin() {
     if(getElement(btnLogin, "Login").isEnabled()) {
		click(btnLogin, "Login");
     }else {
    	 ExtentTestManager.setInfoMessageInReport("login button is disabled");
     }

	}

	public void getAmountAndRefID() {

		ExtentTestManager.setInfoMessageInReport("amount is :" + getText(lblamount));

		ExtentTestManager.setInfoMessageInReport("ref Id is :" + getText(lblReferId));

		ExtentTestManager.setInfoMessageInReport("this total desc is :" + getText(lblThisTotal));

	}
	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
	}

}
