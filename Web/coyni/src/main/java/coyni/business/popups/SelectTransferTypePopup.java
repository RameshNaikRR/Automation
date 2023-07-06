package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SelectTransferTypePopup extends BrowserFunctions {

	private By lblSelectTransferHeading = By.xpath("");
	private By btnWalletTransfer = By.xpath("");
	private By btnB2BTransfer = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifySelectTransferTypeHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSelectTransferHeading, "Heading is: ", expHeading);
	}

	public void clickWalletTransfer(String backGround, String borderColor) {
		new CommonFunctions().verifyMouseHoverAction(btnWalletTransfer, "Wallet Transfer", backGround, borderColor);
		click(btnWalletTransfer, "Wallet Transfer");
	}

	public void clickB2BTransfer(String backGround, String borderColor) {
		new CommonFunctions().verifyMouseHoverAction(btnB2BTransfer, "B2B Transfer", backGround, borderColor);
		click(btnB2BTransfer, "B2B Transfer");
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public B2BTransferPopup b2bTransferPopup() {
		return new B2BTransferPopup();
	}

	public WalletTransferPopup walletTransferPopup() {
		return new WalletTransferPopup();
	}

}
