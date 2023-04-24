package coyni.customer.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class MyQRCodeComponent extends BrowserFunctions {

	private By imgActualQRCode = By.xpath("//div[contains(@class,'p-3.5 ShareQrCodeModal_corners__31Ytu')]");

	private By lblWalletAddress = By.xpath("//span[contains(@class,'text-sm font-semibold text-center text-cgy4')]");

	private By btnCopy = By.cssSelector(".copy-image");

	// private By btnShare =By.cssSelector(".icon-button");

	private By btnDone = By.xpath("//button[text()='Done']");

	private By txtTextMessage = By.xpath("//textarea[@id='text-area']");

	private By btnPasteTestMessage = By.cssSelector("");

	private By txtEmail = By.id("email_id");

	private By txtPhoneNumber = By.id("Phone_Number");

	private By btnShare = By.cssSelector(".icon-button");//

	private By bShare = By.xpath("//button[text()='Share']");

	private By copyMsg = By.cssSelector(".icon-copy");

//	private By txtMsgToRecipient = By.id("text-area");

	private By txtCopyToClipBoard = By.xpath("//div[@id='image']");

	private By btnPaste = By.xpath("(//button[text()='Paste'])[1]");

	private By btnPasteEmail = By.xpath("(//button[text()='Paste'])[2]");

	private By walletAddress = By.xpath("//span[contains(@class,'text-sm font-semibold text-center text-cgy4')]");

	public void verifytxtCopyToClipBoard(String data) {
		new CommonFunctions().verifyLabelText(txtCopyToClipBoard, "Copied to clipboard", data);
	}

	public void verifyQRCodeDisplayed() {
		if (verifyElementDisplayed(imgActualQRCode, "QR Code Image")) {
			ExtentTestManager.setInfoMessageInReport(" QR code is displayed");
		} else {
			ExtentTestManager.setInfoMessageInReport(" QR code is not displayed");

		}

	}

	public void fillPhoneNumber(String phoneNumber) {
		if (getElement(txtPhoneNumber, "Phone Number").isEnabled()) {
			enterText(txtPhoneNumber, phoneNumber, "Phone Number");
		} else {
			ExtentTestManager.setPassMessageInReport("Phone Number is disable");
		}
	}

	public WebElement getWalletAddress() {
		WebElement text = getElement(lblWalletAddress, "wallet address");
		return text;
	}

	// DOUBT
	public void verifyCopyBtnWorking() {
		boolean enabled = getElement(btnCopy, "Button copy").isEnabled();
		if (enabled) {
			ExtentTestManager.setPassMessageInReport("Button copy is working");
		} else {
			ExtentTestManager.setFailMessageInReport("Button copy is not working");
		}
	}

	public void verifyCopy() { // String expMsg
//		moveToElement(btnCopy, "Copy");
//		new CommonFunctions().verifyLabelText(copyMsg, "Copy", expMsg);
		click(btnCopy, "Copy");
	}

	public void getWalletID() {

	}

	public void clickShareButton() {
		if (getElement(bShare, "Share").isEnabled()) {
			click(bShare, "click share");
		} else {
			ExtentTestManager.setPassMessageInReport("Share button is Disable");
		}
	}

	public void clickShare() {
		click(btnShare, "Share");
	}

	public void clickDone() {
		click(btnDone, "click done");
	}

	public void fillTextMessage(String textMessage) {
		enterText(txtTextMessage, textMessage, "Text Message");
	}

	// DOUBT
	public void verifyPasteTextMessageWorking() {
		boolean enabled = getElement(btnPasteTestMessage, "Paste Text Message").isEnabled();
		if (enabled) {
			ExtentTestManager.setPassMessageInReport("Paste Text Message is working");
		} else {
			ExtentTestManager.setFailMessageInReport("Paste Text Message is not working");
		}
	}

	public void fillTextEmail(String textEmail) {
		if (getElement(txtEmail, "Text Email").isEnabled()) {
			enterText(txtEmail, textEmail, "Text Email");
		} else {
			ExtentTestManager.setPassMessageInReport("Email is disable mode");
		}
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
	}

	public void pasteOption(String phoneNumber) throws InterruptedException {
		copyDataToClipboard(phoneNumber);
		click(btnPaste, "Paste");
		clearText(btnPaste, "Phone Number");
		Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
	}

	public void pasteOptionEmail(String email) throws InterruptedException {
		copyDataToClipboard(email);
		click(btnPasteEmail, "Paste Email");
		clearText(btnPasteEmail, "Email Number");
		Uninterruptibles.sleepUninterruptibly(10000, TimeUnit.MILLISECONDS);
	}

//	public void fillMsgToRecipient(String msgToRecipient) {
//		enterText(txtMsgToRecipient, msgToRecipient, "Message To Recipient");
//	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
