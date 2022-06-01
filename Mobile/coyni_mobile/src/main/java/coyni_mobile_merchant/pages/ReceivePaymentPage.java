package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.ErrorMessagePopupComponent;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ReceivePaymentPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@text,'Receive Payment')]");
	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'tvName')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'messageQr')]");
	private By lblUserLogo = MobileBy.xpath("//*[contains(@resource-id,'tvUserInfo')]");
	private By lnkSetAmount = MobileBy.xpath("//*[contains(@resource-id,'scanMesetAmountTV')]");
	private By lnkSaveAlbum = MobileBy.xpath("//*[contains(@resource-id,'saveToAlbumTV')]");
	private By lblReceiptentAddress = MobileBy.xpath("//*[contains(@resource-id,'b_tvWalletAddress')]");
	private By lnkCopy = MobileBy.xpath("//*[contains(@resource-id,'lyCopy')]");
	// *[contains(@resource-id,'chooser_copy_button')]
	private By lnkShare = MobileBy.xpath("//*[contains(@resource-id,'lyShare')]");
	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'setAmountET')]");
	private By lblAmountHeading = MobileBy.xpath("//*[contains(@text,'Set Amount')]");
	private By lblRequestedAmount = MobileBy.xpath("//*[contains(@resource-id,'scanMeRequestAmount')]");
	private By btnOk = MobileBy.xpath("(//*[contains(@resource-id,'Action')])[1]");
	private By lnkClearAmount = MobileBy.xpath("//*[contains(@resource-id,'scanMesetAmountTV')]");
	private By lblShareHeading = MobileBy.xpath("//*[contains(@resource-id,'title')]");
	private By lblShareDescription = MobileBy.xpath("//*[contains(@resource-id,'chooser_row_text_option')]");
	private By lblShareReceiptentAddress = MobileBy.xpath("(//*[contains(@resource-id,'preview')])[3]");
	private By lnkShareCopy = MobileBy.xpath("//*[contains(@resource-id,'chooser_copy_button')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'receivePaymentLL')]");
	private By btnAllow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	private By lblErrMsgHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblErrMsg = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Receive Payment Page Heading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Receive Payment Page Description", expDescription);
	}

	public void verifyAmountPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAmountHeading, "Amount Heading", expHeading);
	}

	public void verifySharePageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblShareHeading, "Share Page Heading", expHeading);
	}

	public void getUserLogoText() {
		ExtentTestManager.setInfoMessageInReport("User Logo Text is :" + getText(lblUserLogo));
	}

	public void getUserNameText() {
		ExtentTestManager.setInfoMessageInReport("User Name is :" + getText(lblUserName));
	}

	public void getReceiptentAddress() {
		ExtentTestManager.setInfoMessageInReport("Receiptent's Address is :" + getText(lblReceiptentAddress));
	}

	public void getShareDescription() {
		ExtentTestManager.setInfoMessageInReport("Share Description is :" + getText(lblShareDescription));
	}

	public void getShareReceiptentAddress() {
		ExtentTestManager.setInfoMessageInReport("Receiptent Address :" + getText(lblShareReceiptentAddress));
	}

	public void getRequestedAmount() {
		ExtentTestManager.setInfoMessageInReport("Reuested Amount is :" + getText(lblRequestedAmount));
	}

	public void fillAmount(String expAmount) {
		new CommonFunctions().elementView(txtAmount, "Amount");
		enterText(txtAmount, expAmount, "Amount");
	}

	public void clickSetAmount() {
		new CommonFunctions().elementView(lnkSetAmount, "Set Amount");
		click(lnkSetAmount, "Set Amount");
	}

	public void clickSaveAlbum() {
		new CommonFunctions().elementView(lnkSaveAlbum, "Save Album");
		click(lnkSaveAlbum, "Save Album");
	}

	public void clickCopy() {
		new CommonFunctions().elementView(lnkCopy, "Copy");
		click(lnkCopy, "Copy");
	}

	public void clickShare() {
		new CommonFunctions().elementView(lnkShare, "Share");
		click(lnkShare, "Share");
	}

	public void clickOk() {
		new CommonFunctions().elementView(btnOk, "Ok");
		click(btnOk, "Ok");
	}

	public void clickClearAmount() {
		new CommonFunctions().elementView(lnkClearAmount, "Clear Amount");
		click(lnkClearAmount, "Clear Amount");
	}

	public void clickShareCopy() {
		new CommonFunctions().elementView(lnkShareCopy, "Share Copy");
		click(lnkShareCopy, "Share Copy");
	}

	public void clickClose() {
		new CommonFunctions().elementView(btnClose, "btnClose");
		click(btnClose, "btnClose");
	}

	public void clickAllow() {
		new CommonFunctions().elementView(btnAllow, "Allow");
		click(btnAllow, "Allow");
	}
	
	public ErrorMessagePopupComponent errorMessagePopupComponent() {
		return new ErrorMessagePopupComponent();
	}

}
