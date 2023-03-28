package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.api.business.popups.AddNewCogentAccountPopup;
import coyni.api.business.popups.BuyCoyniTokensNoPaymentPopup;
import coyni.api.business.popups.BuyCoyniTokensPopup;
import coyni.api.business.popups.BuyTokensPaymentPopup;
import coyni.api.business.popups.RemovePaymentMethodPopup;
import coyni.api.business.popups.TokenWalletTransferTokenPopup;
import coyni.api.business.popups.TransactionInProgessPopup;
import coyni.api.business.popups.TransactionSuccessfulPopup;
import coyni.api.business.popups.VerifyYourIdentityPopup;
import coyni.api.business.popups.WalletTransferPrieviewPopup;
import coyni.api.business.popups.WithdrawCogentAccountPopup;
import coyni.api.business.popups.WithdrawCoyniToUSDPopup;
import coyni.api.business.popups.WithdrawToBankAccountPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletActivityComponent extends BrowserFunctions {
	private By lnkTokenWallets = By.xpath("//a[contains(@class,'breadcrumb')]");
	private By lblTokenWallet = By.xpath("//p[contains(.,'Token Wallet')]");
	private By walletName = By.cssSelector("div[data-tip='Edit Wallet Name']>h1:nth-of-type(1)");
	private By editIcon = By.cssSelector("div[data-tip='Edit Wallet Name']>span:nth-of-type(1)");
	private By walletIcon = By
			.xpath("//div[contains(@class,'BusinessWalletDashboard_account_Dashboard')]/span[1]/span[1]");
	private By lblAvailableBalance = By.xpath(
			"//div[contains(@class,'BusinessWalletDashboard_account_Dashboard')]/span[1]/span[2]/h2[.='Available Balance']");
	private By lblAmount = By
			.xpath("//div[contains(@class,'BusinessWalletDashboard_account_Dashboard')]/span[1]/span[2]/span[1]");
	private By lblWalletAddress = By
			.xpath("//div[contains(@class,'BusinessWalletDashboard_account_Dashboard')]/span[1]/span[2]/span[2]");
	private By lnkCopyAddress = By.cssSelector("div[class*='copy-clipboard__content']");
	private By lnkTransferTokens = By.xpath("//span[.='Transfer Tokens']");
	private By lnkBuyTokens = By.xpath("//span[.='Buy Tokens']");
	private By lnkWithdrawToUSD = By.xpath("//span[.='Withdraw to USD']");
	private By lblTokenWalletActitvity = By.xpath("//h2[.='Token Wallet Activity']");
	private By drpdwnTokenWalletActivity = By.xpath("//div[contains(@class,'flex justify-end')]");
	private By today = By.xpath("//data[@value='Today']");
	private By yesterday = By.xpath("//data[@value='Yesterday']");
	private By last7Days = By.xpath("//data[text()='Last 7 Days']");
	private By MonthToDate = By.xpath("//data[text()='Month to Date (MTD)']");
	private By lastMonth = By.xpath("//data[text()='Last Month']");
	private By customRange = By.xpath("//data[text()='Custom Date Range']");
	private By transfereddetails = By
			.xpath("//span[text()='Tokens Transferred']/parent::div/following-sibling::button");
	private By purchasedDetails = By.xpath("//span[text()='Tokens Purchased']/parent::div/following-sibling::button");
	private By withdrawnDetails = By.xpath("//span[text()='Tokens Withdrawn ']/parent::div/following-sibling::button");
	private By export = By.xpath("//button[text()='Export']");

//	private By lblTokenTransferred = By.xpath("//span[.='Tokens Transferred']");
	private By getTokens(String Tokens) {
		return By.xpath(String.format("//span[.='%s']", Tokens));
	}

	private By getAmount(String Amount) {
		return By.xpath(String.format("(//span[contains(@class,'AccountActivity_Wallet_balance__FcRUz')])[1]", Amount));
	}

	private By getDetails(String Details) {
		return By.xpath(String.format("(//button[.='Details'])[1]", Details));
	}

	private By lblYourTransactions = By.xpath("h2[class='subtitle']");
	private By btnFilter = By.xpath("//div[contains(@class,'middle-panel')]//button[1]");
	private By btnExport = By.xpath("//div[contains(@class,'middle-panel')]//button[1]");

	private By getTransactiontabs(String tabNumbers) {
		return By.xpath(String.format("table[class*='custom-table-wrapper'] th:nth-of-type(1)", tabNumbers));
	}

	private By lblNoTransactions = By.xpath("//span[.='You do not have any transactions.']");

	public void clickWithdrawToUSD() {
		new CommonFunctions().verifyCursorAction(lnkWithdrawToUSD, "Withdraw to USD");
		click(lnkWithdrawToUSD, "Withdraw to USD");
	}

	public void verifyWithdrawtoUsdCursorAction() {
		new CommonFunctions().verifyCursorAction(lnkWithdrawToUSD, "Withdrw to USD");
	}

	public void clickExport() {
		new CommonFunctions().verifyCursorAction(export, "Export");
		String str=getElement(export, "").getCssValue("color");
		ExtentTestManager.setPassMessageInReport(str);
		click(export, "Export");
	}

	public void verifyTokenWalletsLnk() {
		new CommonFunctions().elementView(lnkTokenWallets, "Token Wallets Link");
	}

	public void verifyTransferTokenCursorAction() {
		new CommonFunctions().verifyCursorAction(lnkTransferTokens, "Transfer Tokens");
	}

	public void clickTransferTokens() {
		click(lnkTransferTokens, "Transfer tokens");
	}

	public void clickBuyTokens() {
		click(lnkBuyTokens, "Buy Tokens");
	}

	public void clickTransferedDetails() {
		click(transfereddetails, "Token Transfered Details");
	}

	public void clickPurchasedDetails() {
		click(purchasedDetails, "Token Purchased Details");
	}

	public void clickWithdrawnDetails() {
		click(withdrawnDetails, "Token Withdrawn Details");
	}

	public void verifyTokenWalletHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblTokenWallet, Heading, "Heading");
	}

	public void verifyWalletName(String WalletName) {
		new CommonFunctions().verifyLabelText(walletName, WalletName, "WalletName");
	}

	public void verifyEditIcon() {
		new CommonFunctions().elementView(editIcon, "Edit Icon");
	}

	public void clickEditIcon() {
		click(editIcon, "Edit Icon");
	}

	public void verifyWalletIcon() {
		new CommonFunctions().elementView(walletIcon, "Wallet icon");
	}

	public void verifyAvailableBalancelbl(String AvailableBalance) {
		new CommonFunctions().verifyLabelText(lblAvailableBalance, AvailableBalance, "AvailableBalance");
	}

	public void verifyAmount(String Amount) {
		new CommonFunctions().verifyLabelText(lblAmount, Amount, "Amount");
	}

	public void verifyWalletAddress(String WalletAddress) {
		new CommonFunctions().verifyLabelText(lblWalletAddress, WalletAddress, "WalletAddress");
	}

	public void clickCopyAddress() {
		click(lnkCopyAddress, "Copy Address");
	}

	public void verifyCopyAddressLnk() {
		new CommonFunctions().elementView(lnkCopyAddress, "Copy Address Link");
	}

	public void verifyTransferTokenLnk() {
		new CommonFunctions().elementView(lnkTransferTokens, "Transfer Tokens link");
		click(lnkTransferTokens, "Transfer Tokens link");
	}

	public void verifyBuyTokensLnk() {
		new CommonFunctions().elementView(lnkBuyTokens, "Buy Tokens link");
		click(lnkBuyTokens, "Buy Tokens link");
	}

	public void verifyWithdrawToUSD() {
		new CommonFunctions().elementView(lnkWithdrawToUSD, "Withdraw to USD link");
		click(lnkWithdrawToUSD, "Withdraw to USD link");
	}

	public void verifyTokenWalletActivityHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblTokenWalletActitvity, Heading, "Heading");
	}

	public void clickdrpdwnTokenWalletActivity() {
		new CommonFunctions().elementView(drpdwnTokenWalletActivity, "Token Wallet Activity DropDown");
		click(drpdwnTokenWalletActivity, "Token Wallet Activity DropDown");
	}

	public void clickToday() {
		new CommonFunctions().verifyCursorAction(today, "Today");
		String str = getElement(today,"").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(today, "Today");
	}

	public void clickYesterday() {
		new CommonFunctions().verifyCursorAction(yesterday, "yesterday");
		String str = getElement(yesterday, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(yesterday, "Yesterday");
	}

	public void clickLast7Days() {
		new CommonFunctions().verifyCursorAction(last7Days, "last7Days");
		String str = getElement(last7Days, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(last7Days, "Last 7 Days");
	}

	public void clickMonthToDate() {
		new CommonFunctions().verifyCursorAction(MonthToDate, "MonthToDate");
		String str = getElement(MonthToDate, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(MonthToDate, "Month to Date (MTD)");
	}

	public void clickLastMonth() {
		new CommonFunctions().verifyCursorAction(lastMonth, "lastMonth");
		String str = getElement(lastMonth, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(lastMonth, "Last Month");
	}

	public void clickCustomDateRange() {
		new CommonFunctions().verifyCursorAction(customRange, "customRange");
		String str = getElement(customRange, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(customRange, "Custom Date Range");
	}

	public void verifyTokensTransferred() {
		new CommonFunctions().verifyLabelText(getTokens("Tokens Transferred"), "Tokens Transferred",
				"Tokens Transferred");
	}

	public void veirfyTokensPurchased() {
		new CommonFunctions().verifyLabelText(getTokens("Tokens Purchased"), "Tokens Purchased", "Tokens Purchased");
	}

	public void verifyTokensWithdrawn() {
		new CommonFunctions().verifyLabelText(getTokens("Tokens Withdrawn "), "Tokens Withdrawn ", "Tokens Withdrawn ");
	}

	public BuyTokensPaymentPopup buyTokensPaymentPopup() {
		return new BuyTokensPaymentPopup();
	}

	public TokenWalletTransferTokenPopup tokenWalletTransferTokenPopup() {
		return new TokenWalletTransferTokenPopup();
	}

	public WalletTransferPrieviewPopup walletTransferPrieviewPopup() {
		return new WalletTransferPrieviewPopup();
	}

	public VerifyYourIdentityPopup verifyYourIdentityPopup() {
		return new VerifyYourIdentityPopup();
	}

	public TransactionSuccessfulPopup transactionSuccessfulPopup() {
		return new TransactionSuccessfulPopup();
	}

	public BuyCoyniTokensPopup buyCoyniTokensPopup() {
		return new BuyCoyniTokensPopup();
	}

	public WithdrawCoyniToUSDPopup withdrawCoyniToUSDPopup() {
		return new WithdrawCoyniToUSDPopup();
	}

	public WithdrawToBankAccountPopup withdrawToBankAccountPopup() {
		return new WithdrawToBankAccountPopup();
	}

	public WithdrawCogentAccountPopup withdrawtoCogentAccountPopup() {
		return new WithdrawCogentAccountPopup();
	}

	public AddNewCogentAccountPopup addNewcogentAccountPopup() {
		return new AddNewCogentAccountPopup();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	public TransactionInProgessPopup transactionInProgessPopup() {
		return new TransactionInProgessPopup();
	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}

	public BuyCoyniTokensNoPaymentPopup buyCoyniTokensNoPaymentPopup() {
		return new BuyCoyniTokensNoPaymentPopup();
	}

	public ExportComponent exportsComponent() {
		return new ExportComponent();
	}
}
