package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletPage extends BrowserFunctions {

	private By lblHeading = By
			.xpath("//h3[@class='text-cgy4 tracking-wide Heading_heading3__3l6XX font-bold text-cm3']");
	private By walletamount = By.xpath("//span[@class='font-bold cursor-default text-cgy4 text-5xl']");
	private By lblcurrency = By.xpath("//span[@class='ml-1 text-2xl font-semibold text-cgy2']");
	private By lnkTransferTokens = By.xpath("//span[text()='Transfer Tokens']/parent::button");
	private By lnkBuyTokens = By.xpath("//span[text()='Buy Tokens']/parent::button");
	private By lnkWithdrawToUsd = By.xpath("//span[text()='Withdraw to USD']/parent::button");

	public void getWalletBalance() {
		ExtentTestManager
				.setInfoMessageInReport("Total Wallet Balance is " + getText(walletamount, "Available Balance"));

	}
////span[contains(@class,'TokenAccountWallets_Wallets_Table__3GFO9') or contains(@class,'font-bold text-sm ml-2 Wallet_walletName__2Rapf') and text()='QA DB']

	public By getLabelItem(String walletName) {
		return By.xpath(String.format("//div[contains(@class, 'Wallets_Table')]/div//span[text()='%s']", walletName));
	}

	public void clickItem(String walletName) {
		click(getLabelItem(walletName), "Click Items");
	}

	public void clickTransferTokens() {
		click(lnkTransferTokens, "Transfer Tokens");
	}

	public void clickBuyTokens() {
		click(lnkBuyTokens, "Buy Tokens");
	}

	public void clickWithdrawToUsd() {
		click(lnkWithdrawToUsd, "Withdraw To USD");
	}

	public void verifyCurrencyView() {
		new CommonFunctions().elementView(lblcurrency, "CYN");
	}

	public void verifyMouseActionTransferTokens() {
		// new CommonFunctions().verifyMouseHoverAction(lnkTransferTokens, "Transfer
		// Tokens", "", "");
		new CommonFunctions().verifyCursorAction(lnkTransferTokens, "Transfer Tokens");
	}

	public void verifyMouseActionBuyTokens() {
//		new CommonFunctions().verifyMouseHoverAction(lnkBuyTokens, "Buy Tokens", "", "");
		new CommonFunctions().verifyCursorAction(lnkBuyTokens, "Buy Tokens");
	}

	public void verifyMouseActionWithdrawToUsd() {
//		new CommonFunctions().verifyMouseHoverAction(lnkWithdrawToUsd, "Withdraw To USD", "", "");
		new CommonFunctions().verifyCursorAction(lnkWithdrawToUsd, "Withdraw to USD");
	}

	public void verifyTokenWalletBalanceView(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Total Wallet Balance", expHeading);
	}
}
