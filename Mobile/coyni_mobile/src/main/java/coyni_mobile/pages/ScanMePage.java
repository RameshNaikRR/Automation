package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.SetAmountComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanMePage extends MobileFunctions {

	private By lblUserName = MobileBy.xpath("//*[contains(@resource-id,'tvName')]");
	private By lblProfileWithNoImage = MobileBy.xpath("//*[contains(@resource-id,'tvUserInfo')]");
	private By qrCode = MobileBy.xpath("//*[contains(@resource-id,'idIVQrcode')]");
	private By lnkSetAmount = MobileBy.xpath("//*[contains(@resource-id,'scanMesetAmountTV')]");
	private By lnkClearAmount = MobileBy.xpath("//*[contains(@resource-id,'scanMesetAmountTV')]");
	private By lnkSaveToAlbum = MobileBy.xpath("//*[contains(@resource-id,'saveToAlbumTV')]");
	private By lnkCopy = MobileBy.xpath("//*[contains(@resource-id,'lyCopy')]");
	private By lnkShare = MobileBy.xpath("//*[contains(@resource-id,'imgShare')]");
	private By lblRecipientAddress = MobileBy.xpath("//*[@text='Recipient’s Address']");
	private By btnAllow = MobileBy.xpath("//*[contains(@text,'ALLOW')]");

	public void verifylblUserName(String userName) {
		new CommonFunctions().verifyLabelText(lblUserName, "userName", userName);
	}

	public void verifylblProfileWithNoImage(String profile) {
		new CommonFunctions().verifyLabelText(lblProfileWithNoImage, "profile", profile);

	}

	public void verifyQrCode() {
		new CommonFunctions().elementView(qrCode, "QR Code");
	}

	public void clickSetAmount() {
		new CommonFunctions().elementView(lnkSetAmount, "Set Amount");
		click(lnkSetAmount, "SetAmount");
	}

	public void clickClearAmount() {
		new CommonFunctions().elementView(lnkClearAmount, "Clear Amount");
		click(lnkClearAmount, "ClearAmount");
	}

	public void clickSaveToAlbum() {
		new CommonFunctions().elementView(lnkSaveToAlbum, "Save To Album");
		click(lnkSaveToAlbum, "Save To Album");
	}

	public void clickCopy() {
		click(lnkCopy, "Copy");
	}

	public void clickShare() {
		new CommonFunctions().elementView(lnkShare, "Share");
		click(lnkShare, "Share");
	}

	public void verifyReceipientAddress() {
		new CommonFunctions().elementView(lblRecipientAddress, "Recipient's Address");
	}

	public SetAmountComponent setAmountComponent() {
		return new SetAmountComponent();
	}

	public void clickAllow() {
		click(btnAllow, "Allow");
	}
}
