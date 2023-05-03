package coyni.merchant.pages;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.admin.pages.FeatureControlPage;
import coyni.merchant.components.BankAccountsComponent;
import coyni.merchant.components.FilterComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.NotificationsComponent;
import coyni.merchant.components.TokenAccountActivityComponent;
import coyni.merchant.components.TokensPurchasedDetailsComponent;
import coyni.merchant.components.TokensWithdrawnDetailsComponent;
import coyni.merchant.components.TransactionDetailsComponent;
import coyni.merchant.components.TransactionsListComponent;
import coyni.merchant.components.UserNameDropDownComponent;
import coyni.merchant.popups.BuyCoyniTokensNoPaymentPopup;
import coyni.merchant.popups.BuyCoyniTokensPaymentMethodPopup;
import coyni.merchant.popups.BuyCoyniTokensPopup;
import coyni.merchant.popups.WithdrawCoyniToUSDPopup;
import coyni.merchant.popups.WithdrawToSignetAccountPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class TokenAccountPage extends BrowserFunctions {

	// added
	private By btnTokenAccount = By.xpath("(//span[text()='Token Account'])[1]");
	private By lblYourTokenAccount = By.xpath("//h1[text()='Merchant Token Account']");
	private By lblTotalFunds = By.xpath("//span[contains(text(),'Total Available Funds')]");
	private By lblHeading = By.xpath("(//span[text()='Token Account'])[1]");
	private By amount = By.xpath("//div[contains(@class,'MerchantWalletDashboard_wallet_ballance_wrap__nNo5D')]");
	private By btnBuyTokens = By.xpath("//span[text()='Buy Tokens']");
	private By btnWithdrawToUSD = By.xpath("//span[text()='Withdraw to USD']");
	private By lblYourTransactions = By.xpath("//h2[contains(text(),'Your Business Transactions')]");
	private By lblDateTime = By.xpath("//span[text()='Date & Time']");
	private By lblType = By.xpath("//span[text()='Type']");
	private By lblSubType = By.xpath("//span[text()='SUB TYPE']");
	private By lblDescription = By.xpath("//span[text()='Description']");
	private By lblAmount = By.xpath("//span[text()='Amount']");
	private By lblBalance = By.xpath("//span[text()='Balance']");
	private By lblStatus = By.xpath("//span[text()='Status']");
	private By lblPostedTransactions = By.xpath("//span[@class='posted']");
	// private By transaction = By.xpath("(//tr[@class=' hovered'])[1]");
	private By lblItemsPerPage = By.cssSelector(".entries-container .entries-message");
	private By rows = By.cssSelector(".custom-table-wrapper>tbody>tr");
	private By transaction = By.xpath("//tr[@class='  hovered']");
	private By lblBracesCount = By.cssSelector(".posted-txn .posted");
	private By btnExport = By.xpath("//button[text()='Export']");
	private By defaultEntries = By
			.xpath("//div[@class='custom-pagination-select__single-value css-1uccc91-singleValue']");
	private By lblEntriesMessage = By.xpath("//span[contains(@class,'entries-message')]");
	private By pagination = By.xpath("//li[@class='paginator__pagination__item active']");
	private By entriesPerPageDropDown = By.xpath(
			"//div[@class='custom-pagination-select__indicator custom-pagination-select__dropdown-indicator css-tlfecz-indicatorContainer']");

	private By lblNoTrasactons = By.xpath("//span[contains(text(),'You do not have any transactions.')]");

	// private By dropDownUserName = By.cssSelector(".down-arrow");

	public String getBracesCount() {
		String str = getText(lblBracesCount, "braces Count");
		return str;

	}

	public void clickExport() {
		if (getElement(btnExport, "Enabled").isEnabled()) {
			click(btnExport, "Export");
		} else {
			ExtentTestManager.setPassMessageInReport("Export button is Disabled");
		}

	}

	public int verifyTransactions() {
		return getElementsList(lblNoTrasactons, "").size();
	}

	public String verifyNoTrasactionsFound() {
		new CommonFunctions().elementView(lblNoTrasactons, "No Trasactions");
		return getText(lblNoTrasactons, "No Trasactions");
	}

	public void verifyLabelYourTokenAccount() {
		new CommonFunctions().elementView(lblYourTokenAccount, "Your Token Account");
	}

	private By firstPage = By.xpath("//a[contains(@aria-label, 'first page') or text() = '«']");

	private By seconPage = By.xpath("//a[@aria-label='Go to page number 2']");

	private By prevPage = By.xpath("//a[contains(@aria-label, 'previous page') or text() = '❮']");

	private By nextPage = By.xpath("//a[contains(@aria-label, 'next page') or text() = '❯']");

	private By lastPage = By.xpath("//a[contains(@aria-label, 'last page') and text() = '»']");

	public void clickGoToFirstPage() {
		click(firstPage, "first page '«'");
	}

	public void clickGoToPreviousPage() {
		click(prevPage, "previous page '❮'");
	}

	public void clickGoToNextPage() {
		click(nextPage, "next page '❯'");
	}

	public void clickGoToLastPage() {
		click(lastPage, "last page '»'");
	}

	public boolean isNextButtonEnabled() {
		return getElement(nextPage, "next page '❯'").isEnabled();
	}

	public void clickTokenAccount() throws InterruptedException {
		click(btnTokenAccount, "Token Account");
		Thread.sleep(2000);
	}

	public String getAvailableBalance() {
		return getText(amount, "Available Balance");

	}

	public WebElement verifyAmount() {
		// new CommonFunctions().elementView(amount, "Amount");
		WebElement txt = getElement(amount, " Amount ");
		return txt;

	}

	public void verifyTransactionList() {
//			List<WebElement> elements = getElementsList(lblPostedTransactions, "Posted Transactions List");
//			int noOfTransactions = elements.size();
//			for (int i = 0; i < noOfTransactions; i++) {
//				elements.get(i);
		//
//			}
		new CommonFunctions().elementView(lblPostedTransactions, "Posted Transaction");
	}

	public String getItemsPerPage() {
		return getText(lblItemsPerPage, "entries per page");
	}

	public void verifyPostedTransactions(String expCount) {
		int page1 = getElementsList(transaction, "page transaction count").size();
		int count = Integer.parseInt(expCount);
		if (page1 == count) {
			ExtentTestManager.setPassMessageInReport("No of Entries" + page1);

		} else {
			ExtentTestManager.setFailMessageInReport("Not Entries" + page1);

		}

	}

	public void verifyPageNumbersWithCount() {
		int actCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		int page = getElementsList(transaction, "page transaction count").size();
		int pageNumber = actCount / page;
		int remainder = actCount % page;
		if (!(remainder == 0)) {
			pageNumber++;
			if (!(pageNumber == 0)) {
				ExtentTestManager.setPassMessageInReport("No of pages is" + pageNumber);
			} else if (remainder == 0) {
				ExtentTestManager.setPassMessageInReport("No of pages is" + pageNumber);
			}
		} else {
			ExtentTestManager.setFailMessageInReport("No of Page is Null");
		}

	}

	public void verifyBracesCount(String query) throws SQLException {
		int expCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		int count = DBConnection.getDbCon().getCount(String.format(query));
		if (expCount == count) {
			ExtentTestManager.setPassMessageInReport("Braces are " + count);
		} else {
			ExtentTestManager.setFailMessageInReport("Braces are not" + count);
		}
	}

	public void verifyPageNumberHighlighted(String cssProp, String expValue, String expColor) {

		if (verifyElementDisplayed(nextPage, "Next Page")) {
			click(nextPage, "Clicked Next Page");
			new CommonFunctions().verifyChangedColor(seconPage, "Second Page", cssProp, expValue, expColor);
			ExtentTestManager.setPassMessageInReport("Page is Highlighted when clicked on Page number");
		} else {
			ExtentTestManager.setWarningMessageInReport("Page is Not Highlighted");
		}
	}

	public void verifyTableItemsCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(String.format(query));
		int expCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport(
					"Number of transactions in table matches with number of entries selected i.e ");
		} else {
			ExtentTestManager.setFailMessageInReport(
					"Number of transactions in table doesnot match with numer of entries selected");
		}
	}

//		public String getTransactionList() {
//			return getText(transaction, "Transaction");
//		}

	public void viewBuyTokens() {
		new CommonFunctions().elementView(btnBuyTokens, "Buy Tokens");
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "BuyTokens");
	}

	public void clickWithdrawToUSD() {
		click(btnWithdrawToUSD, "WithdrawToUSD");

	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "heading ", Heading);
	}

//	public List<String> getEntryOptions() {
//		return getElementsList(entriesPerPageDropDown, "options").stream().map(WebElement::getText)
//				.collect(Collectors.toList());
//	}

	// added
	public void verifyLabelYourTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblYourTransactions, "Your Transactions", expHeading);
		new CommonFunctions().elementView(lblYourTransactions, "Your Transactions");
	}

	public void verifyLabelTransactionListDetails() {
		new CommonFunctions().elementView(lblDateTime, "Date and Time");
		new CommonFunctions().elementView(lblType, "Type");
		new CommonFunctions().elementView(lblDescription, "Description");
		new CommonFunctions().elementView(lblAmount, "Amount");
		new CommonFunctions().elementView(lblBalance, "Balance");
		new CommonFunctions().elementView(lblStatus, "Status");
	}

	public void verifyLabelPostedTransactions(String expPostedTranasactionHeading) {
		new CommonFunctions().verifyLabelText(lblPostedTransactions, "Posted Transactions",
				expPostedTranasactionHeading);
		new CommonFunctions().elementView(lblPostedTransactions, "Posted Transactions");

	}

	public void verifyEntriesMessage() {
		new CommonFunctions().elementView(lblEntriesMessage, "Entries Message");
	}

	public void clickDropDownEntriesPage() {
		click(entriesPerPageDropDown, "Entries Per Page");
		// new CommonFunctions().elementView(defaultEntries, "Default Entries");

	}

	public String getDefaultEntriesPerPage() {
		return getText(defaultEntries, "Default Entries");

	}

	public String getEntriesMessage() {
		return getText(lblEntriesMessage, "Entries Message");
	}

	public void clickOnPages() {
		click(pagination, "Pagination");
	}
	// public TokenAccountActivityComponent tokenAccountActivityComponent() {
//				 	return new TokenAccountActivityComponent(); }
	// public TransactionsListComponent transactionsListComponent() {
	// return new TransactionsListComponent(); }
	// public TokensSentDetailsComponent tokensSentDetailsComponent() {
	// return new TokensSentDetailsComponent(); }
	// public TokensReceivedDetailsComponent tokensReceivedDetailsComponent() {
	// return new TokensReceivedDetailsComponent(); }
	// public TokensPurchasedDetailsComponent tokensPurchasedDetailsComponent() {
	// return new TokensPurchasedDetailsComponent() ;}
//				 	public  TokensWithdrawnDetailsComponent okensWithdrawnDetailsComponent() {
	// return new TokensWithdrawnDetailsComponent();}
	// public TokenPaidOrdersDetailsComponent tokenPaidOrdersDetailsComponent() {
	// return new TokenPaidOrdersDetailsComponent(); }

	public TokenAccountActivityComponent tokenAccountActivityComponent() {
		return new TokenAccountActivityComponent();
	}

	public TransactionsListComponent transactionsListComponent() {
		return new TransactionsListComponent();
	}

	public TokensPurchasedDetailsComponent tokensPurchasedDetailsComponent() {
		return new TokensPurchasedDetailsComponent();
	}

	public TokensWithdrawnDetailsComponent tokensWithdrawnDetailsComponent() {
		return new TokensWithdrawnDetailsComponent();
	}

//	public NavigationMenuPage navigationMenuPage() {
//		return new NavigationMenuPage();
//	}

	public BuyCoyniTokensPaymentMethodPopup buyCoyniTokensPaymentMethodPopup() {
		return new BuyCoyniTokensPaymentMethodPopup();
	}

	public WithdrawCoyniToUSDPopup withdrawCoyniToUSDPopup() {
		return new WithdrawCoyniToUSDPopup();
	}

	public BuyCoyniTokensPopup buyCoyniTokensPopup() {
		return new BuyCoyniTokensPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();

	}

	public BankAccountsComponent bankAccountsComponent() {
		return new BankAccountsComponent();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public ExportfilesPage exportfilesPage() {
		return new ExportfilesPage();
	}

	public FeatureControlPage featureControlPage() {
		return new FeatureControlPage();
	}

	public BuyCoyniTokensNoPaymentPopup buyCoyniTokensNoPaymentPopup() {
		return new BuyCoyniTokensNoPaymentPopup();
	}

	public WithdrawToSignetAccountPopup withdrawToSignetAccountPopup() {
		return new WithdrawToSignetAccountPopup();
	}

	public UserNameDropDownComponent userNameDropDownComponent() {
		return new UserNameDropDownComponent();
	}

	public NotificationsComponent notificationsComponent() {
		return new NotificationsComponent();
	}

	public TransactionDetailsComponent transactionDetailsComponent() {
		return new TransactionDetailsComponent();
	}

	public MerchantProfilePage merchantProfilePage() {
		return new MerchantProfilePage();
	}
}
