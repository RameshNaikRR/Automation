package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ToastComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class MyQRCodePage extends MobileFunctions {
	private By lblHeading = MobileBy.id("com.coyni.mapp:id/scanMeTV");
	private By lblUserName = MobileBy.id("com.coyni.mapp:id/tvName");
	private By lblUserLogo = MobileBy.id("com.coyni.mapp:id/tvUserInfo");
	private By btnSetAmount = MobileBy.id("com.coyni.mapp:id/endAllTV");
	private By imgSaveAlbum = MobileBy.id("com.coyni.mapp:id/imgSave");
	private By lblReceiptentAddress = MobileBy.id("com.coyni.mapp:id/imgCopy");
	private By lblQr = MobileBy.id("com.coyni.mapp:id/idIVQrcode");
	private By imgShare = MobileBy.id("com.coyni.mapp:id/imgShare");
	private By txtAmount = MobileBy.id("com.coyni.mapp:id/setAmountET");
	private By lblAmountHeading = MobileBy.xpath("//*[@text='Set Amount']");
	private By lblRequestedAmount = MobileBy.id("com.coyni.mapp:id/scanMeRequestAmount");
	private By btnOk = MobileBy.id("com.coyni.mapp:id/keyActionLL");
	private By lnkClearAmount = MobileBy.id("com.coyni.mapp:id/clearAmountLL");
	private By lblShareHeading = MobileBy.xpath("//*[@text='Edit']");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'receivePaymentLL')]");
	private By btnAllow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	private By lblErrMsgHeading = MobileBy.xpath("//*[contains(@resource-id,'tvHead')]");
	private By lblErrMsg = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Receive Payment Page Heading", expHeading);
	}

	public void verifyPageHeading() {
		new CommonFunctions().elementView(lblHeading, "Receive Payment Page Heading");
		new CommonFunctions().elementView(lblUserName, "User Name");
	}

	public void verifyAmountPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAmountHeading, "Amount Heading", expHeading);
	}

	public void verifySharePageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblShareHeading, "Share Page Heading", expHeading);
	}

	public void verifyQrCode() {
		new CommonFunctions().elementView(lblQr, "OR code");
		ExtentTestManager.setInfoMessageInReport("QR code:" + getText(lblQr));
	}

	public void getUserLogoText() {
		ExtentTestManager.setInfoMessageInReport("User Logo Text is :" + getText(lblUserLogo));
	}

	public void getUserNameText() {
		new CommonFunctions().elementView(lblUserName, "User Name");
		ExtentTestManager.setInfoMessageInReport("User Name is :" + getText(lblUserName));
	}

	public void getReceiptentAddress() {
		ExtentTestManager.setInfoMessageInReport("Receiptent's Address is :" + getText(lblReceiptentAddress));
	}

	public void getRequestedAmount(String amount) {
		if (Double.parseDouble(amount) == Double.parseDouble(getText(lblRequestedAmount))) {
			ExtentTestManager.setPassMessageInReport("Requested amount is accurately showing in My QR Code page");
		} else {
			ExtentTestManager.setFailMessageInReport("Requested amount is accurately not showing in My QR Code page");
		}
	}

	public void fillAmount(String expAmount) {
		enterText(txtAmount, expAmount, "Amount");
	}

	public void clickSetAmount() {
		click(btnSetAmount, "Set Amount");
	}

	public void clickSaveAlbum() {
		new CommonFunctions().elementView(imgSaveAlbum, "Save Album");
		click(imgSaveAlbum, "Save Album");
	}

	public void viewEdit() {
		new CommonFunctions().elementView(lblShareHeading, "Edit");
	}

	public void clickShare() {
		new CommonFunctions().elementView(imgShare, "Share");
		click(imgShare, "Share");
	}

	public void clickOk() {
		click(btnOk, "Ok");
	}

	public void clickClearAmount() {
		new CommonFunctions().elementView(lnkClearAmount, "Clear Amount");
		click(lnkClearAmount, "Clear Amount");
	}

	public void clickClose() {
		new CommonFunctions().elementView(btnClose, "Close");
		click(btnClose, "Close");
	}

	public void clickAllow() throws InterruptedException {
		click(btnAllow, "Allow");
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
