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

	private By lblAllDone = MobileBy.xpath("//*[@text='All Done']");
	private By lblAccountCreated = MobileBy.AccessibilityId("Account Created");
	private By lblAccountReadyDesc = MobileBy.AccessibilityId("Account is Ready");
	private By lblCardSucessDesc = MobileBy.id("com.coyni.mapp:id/subHeaderTV");
	private By imgTickMark = MobileBy.id("com.coyni.mapp:id/ivLogo");
	private By lblEmailSucess = MobileBy.AccessibilityId("Change Email Successful");
	private By lblChangeEmailDesc = MobileBy.xpath("");
	private By btnBuyTokens = MobileBy.xpath("//*[@text='Buy Tokens']");
	private By lblAddCardHeading = MobileBy.xpath("//*[contains(@text,'Added')]");
	private By lblAddCardDesc = MobileBy.id("com.coyni.mapp:id/subHeaderTV");

	// Change Password Sucessful details
	private By lblPasswordSucess = MobileBy.AccessibilityId("Change Password Successful");
	private By lblPasswordUpdatedDesc = MobileBy.xpath("//*[contains(@text,'successfully updated.')]");
	private By btnLogin = MobileBy.AccessibilityId("Log In");
	private By lblPwdChanged = MobileBy.xpath("");
	private By lblpwdChangedDesc = MobileBy.xpath("");
	private By btnDone = MobileBy.xpath("//*[@text='Done']");
	private By imgPassTickMark = MobileBy.id("com.coyni.mapp:id/ivLogo");

//	End All Sessions
	private By lblEndAllSessi = MobileBy.xpath("");
	private By lblEndAllSessiDesc = MobileBy.xpath("");

	// Transaction Complete Screen
	// BuyTokens and withdraw
	private By lblPurchaseComplete = MobileBy.xpath("");
	private By lblAmount = MobileBy.xpath("");
	private By lblCard = MobileBy.xpath("");
	private By lblsucessDesc = MobileBy.xpath("");
	private By lnkViewTransaction = MobileBy.xpath("");
	private By lblWithdrawlComplete = MobileBy.xpath("");
	private By lblGiftCardSent = MobileBy.xpath("");

	public void verifyGiftCardSent(String hdg) {
		new CommonFunctions().elementView(imgTickMark, "Tick Mark");
		new CommonFunctions().verifyLabelText(lblGiftCardSent, "gift Card Sent", hdg);
	}

	public void verifyWithdrawlComplete(String hdg) {
		new CommonFunctions().elementView(imgTickMark, "Tick Mark");
		new CommonFunctions().verifyLabelText(lblWithdrawlComplete, "withdrawl Complete", hdg);
	}

	public void verifyPurchaseComplete(String hdg) {
		new CommonFunctions().elementView(imgTickMark, "Tick Mark");
		new CommonFunctions().verifyLabelText(lblPurchaseComplete, "Purchase Complete", hdg);
	}

	public void verifygetAmount() {
		ExtentTestManager.setFailMessageInReport(getText(lblAmount));
	}

	public int verifyAmount() {
		String str = getText(lblAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		Integer amt = Integer.parseInt(str);
		return amt;

	}

	public void verifyCardName() {
		new CommonFunctions().elementView(lblCard, "card");
	}

	public void verifyTransactionSucessDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblCardSucessDesc, "Transaction sucess desc", desc);
	}

	public void clickViewTransaction() {
		click(lnkViewTransaction, "View Transaction");
	}

//	Add Bank Successful page
	private By addBankSuccHeading = MobileBy.xpath("");
//	private By lblDescription = MobileBy.xpath("//*[@text='Your bank account(s) has been successfully authorized and added to your payment methods.']");

//	Send and Request Success and Failed details
	private By lblSucessHeadi = MobileBy.xpath("");

	private By lblReceiptentName = MobileBy.xpath("");

	public void verifyHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblSucessHeadi, "Heading", heading);
	}

	public String verifyReceiptentName() {
		return getText(lblReceiptentName).replace("to ", "");
	}

//	public int verifyAmount() {
//		int amt = Integer.parseInt(getText(lblAmount));
//		return amt;
//	}

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
		new CommonFunctions().verifyLabelText(lblAllDone, "All Done", allDone);
	}

	public void verifyCardSucessDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblCardSucessDesc, "description", desc);
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyCardAddedHeading(String expHeading,String expDesc) {
		new CommonFunctions().verifyLabelText(lblAddCardHeading, "Added Card Heading", expHeading);
		new CommonFunctions().verifyLabelText(lblAddCardDesc, "Added Card Description", expDesc);
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "Buy Tokens");
	}

//	End All Sessions
	public void verifyEndAllSessions(String heading) {
		new CommonFunctions().elementView(imgTickMark, "Tick Mark");
		new CommonFunctions().verifyLabelText(lblEndAllSessi, "End All Sessions", heading);
		new CommonFunctions().elementView(lblEndAllSessiDesc, "End All Sessions Description");
	}

	public void verifyEmailSucess(String expHeading) {
		new CommonFunctions().elementView(imgTickMark, "sucess image");
		new CommonFunctions().verifyLabelText(lblEmailSucess, "heading", expHeading);

	}

	public void verifyPasswordSucess(String expHeading) {

		new CommonFunctions().verifyLabelText(lblPasswordSucess, "heading", expHeading);

	}

	public void verifyPasswordUpdatedDesc(String desc) {
		new CommonFunctions().elementView(imgTickMark, "Tick mark");
		new CommonFunctions().elementView(lblAllDone, "AllDOne");
		ExtentTestManager.setPassMessageInReport(getText(lblAllDone));
		new CommonFunctions().verifyLabelText(lblPasswordUpdatedDesc, "Password Update desc", desc);
	}

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

	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
	}

}
