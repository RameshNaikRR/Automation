package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.PaymentMethodComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.components.TopBarComponent;
import coyni.apibusiness.components.UserDetailsComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector("#token-account-wallets-page>h1");
	private By lblTotalWalletBalance = By.xpath("//h3[text()='Total Wallet Balance']");
	private By walletBalance = By.cssSelector("div[class*=TokenAccountWallets_wallet_bal]>span:nth-of-type(1)");
	private By lblcurrency = By.cssSelector("div[class*=TokenAccountWallets_wallet_bal]>span:nth-of-type(2)");
	private By walletsList = By.cssSelector("div[class*='TokenAccountWallets_Wallets_Table']>div");
	
	private By getWalletListElements(String walletElements, String rowNum) {
		return By.cssSelector(String.format(
				"div[class*='TokenAccountWallets_Wallets_Table']>div:nth-of-type(%s)>div:nth-of-type(1)>div:nth-of-type(%s)>span",
				rowNum, walletElements));
	}

	private By getCopyWalletAdressIcon(String WalletElements) {
		return By.cssSelector(String.format(
				"div[class*='TokenAccountWallets_Wallets_Table']>div:nth-of-type(%s)>div:nth-of-type(1)>div:nth-of-type(4)>div",
				WalletElements));
	}
	public void getIndividualWalletsName(String rowNum) {
		ExtentTestManager
				.setInfoMessageInReport(rowNum + " WalletName: " + getText(getWalletListElements("2", rowNum), ""));
	}

	public void getIndividualWalletAmount(String rowNum) {
		ExtentTestManager.setInfoMessageInReport(
				rowNum + " WalletAmount: " + getText(getWalletListElements("3", rowNum), "") + " CYN");
	}
	
	public void clickIndividualWalletsName( ) {
		click(getWalletListElements("2", "1"),"");
	}

	public void getIndividualWalletAddress(String rowNum) {

		click(getCopyWalletAdressIcon(rowNum), "copy");

		ExtentTestManager.setInfoMessageInReport(rowNum + " WalletAddress: " + getCopiedData());

	}

	public void getWalletInfo() {
		int walletCount = getElementsList(walletsList, "").size();
		for (int i = 1; i <= walletCount; i++) {
			String num = Integer.toString(i);
			getIndividualWalletsName(num);
			getIndividualWalletAmount(num);
			getIndividualWalletAddress(num);

		}

	}
	
	
	
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

	public void verifyTotalWalletBalanceView() {
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

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public UserDetailsComponent userDetailsComponent() {
		return new UserDetailsComponent();
	}
	
	public PaymentMethodComponent paymentMethodComponent() {
		return new PaymentMethodComponent();
	}
}
