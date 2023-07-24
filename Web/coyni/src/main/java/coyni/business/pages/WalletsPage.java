package coyni.business.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.business.popups.CancelWalletPopup;
import coyni.business.popups.DepositFundsPopup;
import coyni.business.popups.NewWalletPopup;
import coyni.business.popups.SelectTransferTypePopup;
import coyni.business.popups.WithdrawTokensPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WalletsPage extends BrowserFunctions {

	private By lblWalletPageHeading = By.xpath("");
	private By lblWalletsHeading = By.xpath("//div[text()='Wallet Settings']");
	private By lblTotalWalletBalance = By.xpath("");
	private By btnNewWallet = By
			.xpath("//button[contains(@class,' Buttons_btn__JEz-N Buttons_btn__custom_button__7ZKtE  ')]");
	private By lnkDepositFunds = By.xpath("");
	private By lnkTransfer = By.xpath("");
	private By lnkWithdraw = By.xpath("");
	private By copyWallet = By.xpath("");
	private By availableFunds = By.xpath("");
	private By close = By.xpath("");
	private By clickCancel = By.xpath("//button[text()='Cancel Wallet']");
	private By search = By.xpath("//input[@placeholder='Search By Wallet Name or ID']");
	private By searchIcon = By.xpath("//button[contains(@class,'icon-search flex flex-col ')]");
	private By firstRow = By
			.xpath("//tr[@class='border-b border-solid hover:bg-cm1 hover:cursor-pointer border-cm2'][1]");
	private By walletDetails = By.xpath("//div[@class='flex justify-between ']");
	private By walletEdit = By.xpath("//span[text()='Edit']");
	private By inputwalletName = By.xpath("//input[@name='walletName']");
	private By clickSave = By.xpath("//button[text()='Save']");
	private By txtCancelled = By.xpath("(//div[text()='cancelled'])[1]");

	public void verifyWalletsHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWalletsHeading, "Hedaing is: ", expHeading);
	}

	public String verifyTotalWalletBalance() {
		String totalWalletBalance = getText(lblTotalWalletBalance, "Total Wallet Balance");
		ExtentTestManager.setInfoMessageInReport("Total Wallet Balance is" + totalWalletBalance);
		return totalWalletBalance;
	}

	public void clickWalletEdit() {
		click(walletEdit, "Edit");
	}

	public void walletname(String name) {
		enterText(inputwalletName, name, "Wallet Name");
	}

	public void save() {
		click(clickSave, "Save");
	}

	public void clickFirstRow() {
		click(firstRow, "Wallet Row");
	}

	public void clickSearchIcon() {
		click(searchIcon, "Search Icon");
	}

	public void clickCancelledRow() {
		click(txtCancelled, "Cancelled ");
	}

	public void Search(String searching) {
		enterText(search, "Searched item", searching);
	}

	public void viewWalletDetails() {
		List<WebElement> rows = getElementsList(walletDetails, "wallet Details");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
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

	public void clickCancel() {
		click(clickCancel, "Cancel");
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

	public NewWalletPopup newWalletPopup() {
		return new NewWalletPopup();
	}

	public CancelWalletPopup cancelWalletPopup() {
		return new CancelWalletPopup();
	}

}
