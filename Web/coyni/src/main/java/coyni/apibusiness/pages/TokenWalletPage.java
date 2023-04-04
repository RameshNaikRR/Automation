package coyni.apibusiness.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.api.business.popups.BuyCoyniTokensNoPaymentPopup;
import coyni.api.business.popups.BuyTokensPaymentPopup;
import coyni.api.business.popups.PleaseCompleteVerificationPopup;
import coyni.api.business.popups.TokenWalletTransferTokenPopup;
import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.FilterComponent;
import coyni.apibusiness.components.PaymentMethodComponent;
import coyni.apibusiness.components.SideBarMenuComponent;
import coyni.apibusiness.components.TopBarComponent;
import coyni.apibusiness.components.TransactionDetailsComponent;
import coyni.apibusiness.components.TransactionListComponent;
import coyni.apibusiness.components.UserDetailsComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Token Wallets']");
	private By btnTokenWallet = By.xpath("//span[text()='Token Wallets']");
	private By lblTotalWalletBalance = By.xpath("//h3[text()='Total Wallet Balance']");
	private By walletBalance = By.cssSelector("div[class*=TokenAccountWallets_wallet_bal]>span:nth-of-type(1)");
	private By lblcurrency = By.cssSelector("div[class*=TokenAccountWallets_wallet_bal]>span:nth-of-type(2)");
	private By walletsList = By.cssSelector("div[class*='TokenAccountWallets_Wallets_Table']>div");
	private By editWalletName = By.xpath("//div[contains(@class,'icon-edit')]");
	private By iconSuccess = By.xpath("//span[contains(@class,'icon-success text-cm3 ')]");
	private By copyAddress = By.xpath("//button[@data-tip='Copied to clipboard']");
	private By clickTransfer = By.xpath("//span[text()='Transfer Tokens']");
	private By clickBuyTokens = By.xpath("//span[text()='Buy Tokens']");
	private By clickWithdrawTokens = By.xpath("//span[text()='Withdraw to USD']");
	private By lblWallets = By
			.xpath("//div[@class='text-sm TokenAccountWallets_Wallet_Id_Cyn__7pYfp text-cgy4 font-semibold']");
	private By lblNoData = By.xpath("//span[text()='No Filter Data Found']");
	private By walletsData = By.xpath("//span[@class='grid 1xl:grid-cols-2 lg:grid-cols-1']");


	private By getWallet(String walletNum) {
		return By.xpath(String.format(
				"(//div[contains(@class,'TokenAccountWallets_Wallets_Table')]//div[contains(@class,'Wallet_walletName')])[%s]",
				walletNum));
	}

	private By clickTransaction = By.xpath("//tr[@class='  hovered'][1]");

	public void clickWallet(String walletNum) {
		click(getWallet("1"), "Wallet Number " + walletNum);
	}

	public void clickSecondWallet(String walletNum) {
		click(getWallet("2"), "Wallet Number " + walletNum);
	}

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

	public void clickIndividualWalletsName() {
		click(getWalletListElements("2", "1"), "IndividualWalletsName");
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

	public void clickFirstTransaction() {
		click(clickTransaction, "Transaction");
	}

	private By getlnk(String walletNum, String type) {
		return By.cssSelector(String.format(
				"div[class*='TokenAccountWallets_Wallets_Table']>div:nth-of-type(%s)>div:nth-of-type(2)>button:nth-of-type(%s)",
				walletNum, type));
	}

	public By getTranferLnk(String walletNum) {
		return getlnk(walletNum, "1");
	}

	public By getBuylnk(String walletNum) {
		return getlnk(walletNum, "2");
	}

	public By getWithdrawlnk(String walletNum) {
		return getlnk(walletNum, "3");
	}

	public void clickTransfer(String walletNum) {
		click(getTranferLnk(walletNum), "Transfer");
	}

	public void clickEditWallet() {
		click(editWalletName, "Edit Wallet Name");
	}

	public void clickTokenWallet() throws InterruptedException {
		click(btnTokenWallet, "Token Wallet");
		Thread.sleep(3000);
	}

	public void clickCopyAddress() {
		new CommonFunctions().elementView(copyAddress, "Copied to clipBoard");
		click(copyAddress, "Copy Address");
	}

	public void clickIconSuccess() {
		click(iconSuccess, "Icon Success");
	}

	public void clickTransferTokensFirstUser() {
		click(clickTransfer, "Transfer Tokens");
	}

	public void clickBuyTokensFirstUser() {
		click(clickBuyTokens, "Buy Tokens");
	}

	public void clickWithdrawFirstUser() {
		click(clickWithdrawTokens, "Withdraw to USD");
	}

	public void verifyTransfer() {
		new CommonFunctions().elementView(getTranferLnk("walletNum"), "Transfer");
	}

	public void clickBuy(String walletNum) {
		click(getBuylnk(walletNum), "Buy");
	}

	public void clickWithdraw() {
		click(getWithdrawlnk("1"), "Withdraw in 1st wallet");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyTotalWalletBalanceView() {
		new CommonFunctions().elementView(lblTotalWalletBalance, "Available Balance");
	}

	public void getWalletBalance() {
		ExtentTestManager.setInfoMessageInReport(
				"Total Wallet Balance " + getText(walletBalance, "") + " " + getText(lblcurrency, ""));
	}

	public void verifyTokenWalletView() {
		List<WebElement> rows = getElementsList(lblWallets, " ");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void viewWalletsData() {
		String str = getText(walletsData, "Different Wallets Data");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public int getTransactionsSize() {
		return getElementsList(lblNoData, "No Data").size();

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

	public TokenWalletTransferTokenPopup tokenWalletTransferPopup() {
		return new TokenWalletTransferTokenPopup();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public TransactionDetailsComponent transactionDetailsComponent() {
		return new TransactionDetailsComponent();
	}

	public ExportFilesPage exportFilesPage() {
		return new ExportFilesPage();
	}

	public BuyTokensPaymentPopup buyTokensPaymentPopup() {
		return new BuyTokensPaymentPopup();
	}

	public BuyCoyniTokensNoPaymentPopup buyCoyniTokensNoPaymentPopup() {
		return new BuyCoyniTokensNoPaymentPopup();
	}

	public TransactionListComponent transactionListComponent() {
		return new TransactionListComponent();
	}

	public PleaseCompleteVerificationPopup pleaseCompleteVerificationPopup() {
		return new PleaseCompleteVerificationPopup();

	}

}
