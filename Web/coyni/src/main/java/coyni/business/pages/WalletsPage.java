package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.business.popups.DepositFundsPopup;
import coyni.business.popups.SelectTransferTypePopup;
import coyni.business.popups.WithdrawTokensPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WalletsPage extends BrowserFunctions {

	private By lblWalletsHeading = By.xpath("");
	private By lblTotalWalletBalance = By.xpath("");
	private By btnNewWallet = By.xpath("");
	private By lnkDepositFunds = By.xpath("");
	private By lnkTransfer = By.xpath("");
	private By lnkWithdraw = By.xpath("");
	private By copyWallet = By.xpath("");
	private By availableFunds = By.xpath("");
	private By close = By.xpath("");

	public void verifyWalletsHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWalletsHeading, "Hedaing is: ", expHeading);
	}

	public String verifyTotalWalletBalance() {
		String totalWalletBalance = getText(lblTotalWalletBalance, "Total Wallet Balance");
		ExtentTestManager.setInfoMessageInReport("Total Wallet Balance is" + totalWalletBalance);
		return totalWalletBalance;
	}

	public void close() {
		click(close, "Close");
	}

	public String verifyAvailableFunds() {
		String getavailableFunds = getText(availableFunds, "Available Funds");
		ExtentTestManager.setInfoMessageInReport("Available Funds :" + availableFunds);
		return getavailableFunds;
	}

	public void clickNewWallet() {
		new CommonFunctions().verifyCursorAction(btnNewWallet, "New Wallet");
		if (getElement(btnNewWallet, "New Wallet").isEnabled()) {
			click(btnNewWallet, "New Wallet");
			ExtentTestManager.setPassMessageInReport("New Wallet Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("New Wallet Button is Disabled");
		}
	}

	public void clickDepositFunds() {
		new CommonFunctions().verifyCursorAction(lnkDepositFunds, "Deposit Funds");
		click(lnkDepositFunds, "Deposit Funds");
	}

	public void clickTransfer() {
		new CommonFunctions().verifyCursorAction(lnkTransfer, "Transfer");
		click(lnkTransfer, "Transfer");
	}

	public void clickWithdraw() {
		new CommonFunctions().verifyCursorAction(lnkWithdraw, "Withdraw");
		click(lnkWithdraw, "Withdraw");
	}

	public void copyWallet() {
		new CommonFunctions().verifyCursorAction(copyWallet, "Wallet ID");
		click(copyWallet, "Wallet ID");
	}

	public DepositFundsPopup depositFundsPopup() {
		return new DepositFundsPopup();
	}

	public SelectTransferTypePopup selectTransferTypePopup() {
		return new SelectTransferTypePopup();
	}

	public WithdrawTokensPopup withdrawTokensPopup() {
		return new WithdrawTokensPopup();
	}

}
