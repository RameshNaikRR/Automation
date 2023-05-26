package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.business.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ReconfigureTwoStepAuthenticationPoup extends BrowserFunctions {

	private By lblReconfigureTwoStepHeading = By.xpath("");
	private By lnkClickHere = By.xpath("");
	private By lnkUseManualEntry = By.xpath("");
	private By copiedtoClipboard = By.xpath("");
	private By lnkScanQRCodeInstead = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyReconfigureTwoStepHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblReconfigureTwoStepHeading, "Heading is: ", expHeading);
	}

	public void clickClickHere() {
		new CommonFunctions().verifyCursorAction(lnkClickHere, "Click Here");
		click(lnkClickHere, "Click Here");
	}

	public void clickUseManualEntry() {
		new CommonFunctions().verifyCursorAction(lnkUseManualEntry, "Use Manual Entry Instead");
		click(lnkUseManualEntry, "Use Manual Entry Instead");
	}

	public void copyToClipboard() {
		new CommonFunctions().verifyCursorAction(copiedtoClipboard, "Copied to Clipboard");
		click(copiedtoClipboard, "Copied to Clipboard");
	}

	public void clickScanQRCodeInstead() {
		new CommonFunctions().verifyCursorAction(lnkScanQRCodeInstead, "Scan QR Code Instea");
		click(lnkScanQRCodeInstead, "Scan QR Code Instead");
	}

	public void clickCrossClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public void fillPin(String code) {
		new AuthyComponent().fillInput(code);
	}

	public PhoneNumberChangedPopup phoneNumberChangedPopup() {
		return new PhoneNumberChangedPopup();
	}

}
