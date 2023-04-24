package coyni.merchant.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.merchant.popups.GeneratePrintableQRCodePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class MyQRCodeComponent extends BrowserFunctions {

	private By imgActualQRCode = By.cssSelector("");

	private By lblWalletAddress = By.cssSelector("");

	private By btnCopy = By.cssSelector(".copy-image");

	// private By btnShare =By.cssSelector(".icon-button");

	private By btnDone = By.xpath("//button[text()='Done']");

	private By txtTextMessage = By.xpath("//textarea[@id='text-area']");

	private By btnPasteTestMessage = By.cssSelector("");

	private By btnGeneratePrintableQRCode = By.xpath("//button[text()='Generate Printable QR Code']");

	private By txtEmail = By.id("email_id");

	private By txtPhoneNumber = By.id("Phone_Number");

	private By btnShare = By.cssSelector(".icon-button");//

	private By bShare = By.xpath("//button[text()='Share']");

	private By copyMsg = By.cssSelector(".icon-copy");

//	private By txtMsgToRecipient = By.id("text-area");

	private By txtCopyToClipBoard = By.xpath("//div[@id='image']");

	private By btnPaste = By.xpath("(//button[text()='Paste'])[1]");

	private By btnPasteEmail = By.xpath("(//button[text()='Paste'])[2]");

	public void verifytxtCopyToClipBoard(String data) {
		new CommonFunctions().verifyLabelText(txtCopyToClipBoard, "Copied to clipboard", data);
	}

	public void verifyQRCodeDisplayed() {
		verifyElementDisplayed(imgActualQRCode, "QR Code Image");
	}

	public void fillPhoneNumber(String phoneNumber) {
		if (getElement(txtPhoneNumber, "Phone Number").isEnabled()) {
			enterText(txtPhoneNumber, phoneNumber, "Phone Number");
		} else {
			ExtentTestManager.setPassMessageInReport("Phone Number is disable");
		}
	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));

	}

	public void verifyhandSymbolHighlightedQRCode(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("QR Code"), "QR Code");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "QR Code", cssProp, expValue, expColor);
	}

	public void clickGeneratePrintableQRCode() {
		click(btnGeneratePrintableQRCode, "Generate Printable QR Code");
	}

	public String getWalletAddress() {
		return getText(lblWalletAddress, "wallet address");
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

	public void clickOnPaste() {
		if (getElement(btnPaste, "Paste").isEnabled()) {
			click(btnPaste, "Paste");
		} else {
			ExtentTestManager.setInfoMessageInReport("Share Via Email is in disabled Mode");

		}
	}

	public void pasteOption(String phoneNumber) throws InterruptedException {
		copyDataToClipboard(phoneNumber);
		clickOnPaste();
		// click(btnPaste, "Paste");
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

	public GeneratePrintableQRCodePopup generatePrintableQRCodePopup() {
		return new GeneratePrintableQRCodePopup();
	}

}
