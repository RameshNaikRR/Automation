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
	private By imgTickMark = MobileBy.xpath("//*[contains(@resource-id,'Logo')]|//*[contains(@resource-id,'image')]");
	private By lblEmailSucess = MobileBy.AccessibilityId("Change Email Successful");
	private By lblEmailSucessDesc = MobileBy.id("com.coyni.mapp:id/tvDescription");
	private By btnBuyTokens = MobileBy.xpath("//*[@text='Buy Tokens']");
	private By lblAddCardHeading = MobileBy.xpath("//*[contains(@text,'Added')]");
	private By lblAddCardDesc = MobileBy.id("com.coyni.mapp:id/subHeaderTV");

	// Change Password Sucessful details
	private By lblPasswordSucess = MobileBy.id("com.coyni.mapp:id/tvHeading");
	private By lblPasswordUpdatedDesc = MobileBy.id("com.coyni.mapp:id/tvDescription");
	private By btnLogin = MobileBy.id("com.coyni.mapp:id/tvTryAgain");
	private By lblPwdChanged = MobileBy.xpath("");
	private By lblpwdChangedDesc = MobileBy.xpath("");
	private By btnDone = MobileBy.xpath("//*[@text='Done']");
	private By imgPassTickMark = MobileBy.id("com.coyni.mapp:id/ivLogo");

//	End All Sessions
	private By lblEndAllSessi = MobileBy.id("com.coyni.mapp:id/tvHeading");
	private By lblEndAllSessiDesc = MobileBy.id("com.coyni.mapp:id/tvDescription");

	// Transaction Complete Screen
	// BuyTokens and withdraw
	private By lblTransFailed = MobileBy.xpath("//*[@text='Transaction Failed']");
	private By lblTransactionProcessing = MobileBy.xpath("//*[@text='Transaction Processing']");
	private By lblPurchaseComplete = MobileBy.id("com.coyni.mapp:id/tvHeading");
	private By lblAmount = MobileBy.id("com.coyni.mapp:id/tvAmount");
	private By lblPaymentMethod = MobileBy.id("com.coyni.mapp:id/selectedAccountTypeTV");
	private By lblPurchaseDesc = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By lblBankSuccRequest = MobileBy.id("com.coyni.mapp:id/selectedAccountTypeTV");
	private By lblBankSuccPurchase = MobileBy.id("com.coyni.mapp:id/tvMessage");
	private By lnkViewTransaction = MobileBy.id("com.coyni.mapp:id/tvViewTransaction");
	private By lblWithdrawlComplete = MobileBy.xpath("");
	private By lblGiftCardSent = MobileBy.xpath("");
	private By btnTryagain = MobileBy.id("com.coyni.mapp:id/cvTryAgain");
	private By lblBuyToken = MobileBy.xpath("//*[@text='Buy Tokens']");
	private By lblBuyTokenDesc = MobileBy.xpath("//*[contains(@text,'Please select a')]");

//	Purchase Details

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 90);

	public void verifyGiftCardSent(String hdg) {
		new CommonFunctions().elementView(imgTickMark, "Tick Mark");
		new CommonFunctions().verifyLabelText(lblGiftCardSent, "gift Card Sent", hdg);
	}

	public void verifyWithdrawlComplete(String hdg) {
		new CommonFunctions().elementView(imgTickMark, "Tick Mark");
		new CommonFunctions().verifyLabelText(lblWithdrawlComplete, "withdrawl Complete", hdg);
	}

	public void verifyBankSuccRequest() {
		new CommonFunctions().elementView(lblBankSuccRequest, "Request has been submitted");
		ExtentTestManager.setPassMessageInReport(getText(lblBankSuccRequest));
		new CommonFunctions().elementView(lblBankSuccPurchase, "Purchase Completed");
		ExtentTestManager.setPassMessageInReport(getText(lblBankSuccPurchase));
	}

	public void verifyPurchaseComplete(String hdg) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfElementLocated(lblPurchaseDesc));
		Thread.sleep(800);
		if (getElementList(lblTransFailed, "Transaction Failed").size() == 0) {
			new CommonFunctions().verifyLabelText(lblPurchaseComplete, "Purchase Complete", hdg);
		} else {
			click(btnTryagain, "Try Again");
			new CommonFunctions().elementView(lblBuyToken, "Buy Token");
			ExtentTestManager.setFailMessageInReport("Transaction Failed");
		}
	}

	public void verifyPurchaseCompleteDesc(String hdg) {
		new CommonFunctions().elementView(imgTickMark, "Tick Mark");
		new CommonFunctions().verifyLabelText(lblPurchaseDesc, "Purchase Complete Description", hdg);
	}

	public void verifyGiftCardDesc(String firstName, String lastName, String email) {
		new CommonFunctions().elementView(imgTickMark, "Tick Mark");
		if (getText(lblPurchaseDesc).equals("Gift card sent to " + firstName + " " + lastName + " at " + email+".")) {
			ExtentTestManager.setPassMessageInReport(
					"The Gift Card description message is as per expected : " + getText(lblPurchaseDesc));
		} else {
			ExtentTestManager.setFailMessageInReport(
					"The Gift Card description message is not as per expected : " + getText(lblPurchaseDesc));
		}
	}

	public void verifyAmount(String amount) {
		double purchasingAmt = Double.parseDouble(amount);
		double pursedAmt = Double.parseDouble(getText(lblAmount));
		if (purchasingAmt == pursedAmt) {
			ExtentTestManager.setPassMessageInReport("Expected amount purchase completed");
		} else {
			ExtentTestManager.setFailMessageInReport("Expected amount purchase not completed");
		}
	}

	public int verifyAmount() {
		String str = getText(lblAmount).trim().replace(" ", "").replace("USD", "").replace("$", "").replace("CYN", "");
		Integer amt = Integer.parseInt(str);
		return amt;

	}

	public void verifyCardName() {
		new CommonFunctions().elementView(lblPaymentMethod, "Payment Method");
	}

	public void verifyTransactionSucessDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblCardSucessDesc, "Transaction sucess desc", desc);
	}

	public void clickViewTransaction() {
		click(lnkViewTransaction, "View Transaction");
	}

//	Add Bank Successful page
	private By addBankSuccHeading = MobileBy.xpath("//*[contains(@text,'Account(s) Added')]");
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

	public void verifyBankSucessHeading(String expHeading) {
		wait.until(ExpectedConditions.presenceOfElementLocated(addBankSuccHeading));
		new CommonFunctions().verifyLabelText(addBankSuccHeading, "Bank Success Heading", expHeading);
	}

	public void verifyAddedBankDescription(String description) {
		new CommonFunctions().verifyLabelText(lblPurchaseDesc, "Bank Success Description", description);
	}

	public void verifyPasswordChanged(String hdg) {
		new CommonFunctions().elementView(imgTickMark, "Tick mark");
		new CommonFunctions().verifyLabelText(lblPasswordSucess, "Password changed", hdg);
	}

	public void verifyPasswordChangedDesc(String hdg) {
		new CommonFunctions().verifyLabelText(lblPasswordUpdatedDesc, "Password changed", hdg);
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

	public void verifyCardAddedHeading(String expHeading, String expDesc) {
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
		click(btnLogin, "Login");
	}

	public void verifyChangeEmailDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblEmailSucessDesc, "desc", desc);
	}

	public BuyTokenComponent buyTokenComponent() {
		return new BuyTokenComponent();
	}

}
