package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.components.TopBarComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector("#token-account-wallets-page>h1");
	private By lblTotalWalletBalance = By.xpath("//h3[text()='Total Wallet Balance']");
	private By walletBalance = By.cssSelector("div[class*=TokenAccountWallets_wallet_bal]>span:nth-of-type(1)");
	private By lblcurrency = By.cssSelector("div[class*=TokenAccountWallets_wallet_bal]>span:nth-of-type(2)");

	private By getlnk(String walletNum, String type) {
		return By.cssSelector(String.format(
				"div[class*='TokenAccountWallets_Wallets_Table']>div:nth-of-type('%s')>div:nth-of-type(2)>button:nth-of-type('%s')",
				walletNum, type));
	}

	private By getTranferLnk(String walletNum) {
		return getlnk(walletNum, "1");
	}

	private By getBuylnk(String walletNum) {
		return getlnk(walletNum, "2");
	}

	private By getWithdrawlnk(String walletNum) {
		return getlnk(walletNum, "3");
	}

	public void clickTransfer() {
		click(getTranferLnk("1"), "Transfer in 1st wallet");
	}

	public void clickBuy() {
		click(getBuylnk("1"), "Buy in 1st wallet");
	}

	public void clickWithdraw() {
		click(getWithdrawlnk("1"), "Withdraw in 1st wallet");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyTotalWalletBalance() {
		new CommonFunctions().elementView(lblTotalWalletBalance, "Total Wallet Balance");
	}

	public void getWalletBalance() {
		ExtentTestManager.setInfoMessageInReport(
				"Total Wallet Balance " + getText(walletBalance, "") + " " + getText(lblcurrency, ""));
	}

	public TopBarComponent topBarComponent() {
		return new TopBarComponent();
	}

	public SideBarMenuComponent sideBarMenuComponent() {
return new SideBarMenuComponent();
	}
}
