package coyni.customer.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.customer.components.TokenAccountActivityComponent;
import coyni.customer.components.TokenPaidOrdersDetailsComponent;
import coyni.customer.components.TokensPurchasedDetailsComponent;
import coyni.customer.components.TokensReceivedDetailsComponent;
import coyni.customer.components.TokensSentDetailsComponent;
import coyni.customer.components.TokensWithdrawnDetailsComponent;
import coyni.customer.components.TransactionsListComponent;
import coyni.customer.components.UserNameDropDownComponent;
import coyni.customer.popups.BuyCoyniTokensPaymentMethodPopup;
import coyni.customer.popups.PayAndRequestTokensPopup;
import coyni.customer.popups.WithdrawCoyniToUSDPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenAccountPage extends BrowserFunctions {

	// added
	private By btnTokenAccount = By.xpath("(//span[text()='Token Account'])[1]");
	private By lblTotalFunds = By.cssSelector(".text-6xl");
	private By amount = By.cssSelector(".text-6xl");
	private By btnPayRequestToken = By.xpath("//span[text()='Pay / Request Tokens']");
	private By btnBuyTokens = By.xpath("//span[text()='Buy Tokens']");
	private By btnWithdrawToUSD = By.xpath("//span[text()='Withdraw to USD']");
	private By btnPay = By.xpath("//button[text()='Pay']");
	private By lblYourTransactions = By.xpath("//h2[contains(text(),'Your Transactions')]");
//		private By lblDateTime = By.xpath("//span[text()='Date & Time']");
//		private By lblType = By.xpath("//span[text()='Type']");
//		private By lblSubType = By.xpath("//span[text()='SUB TYPE']");
//		private By lblDescription = By.xpath("//span[text()='Description']");
//		private By lblAmount = By.xpath("//span[text()='Amount']");
//		private By lblBalance = By.xpath("//span[text()='Balance']");
//		private By lblStatus = By.xpath("//span[text()='Status']");
	private By lblPostedTransactions = By.xpath("//div[@class='posted-txn']");
	// private By transaction = By.xpath("(//tr[@class=' hovered'])[1]");
	private By lblItemsPerPage = By.cssSelector(".entries-container .entries-message");
	private By rows = By.cssSelector(".custom-table-wrapper>tbody>tr");
	private By defaultEntries = By
			.xpath("//div[@class='custom-pagination-select__single-value css-1uccc91-singleValue']");
	private By lblEntriesMessage = By.xpath("//span[@class='entries-message']");
	private By pagination = By.xpath("//li[@class='paginator__pagination__item active']");
	private By entriesPerPageDropDown = By.xpath(
			"//div[@class='custom-pagination-select__indicator custom-pagination-select__dropdown-indicator css-tlfecz-indicatorContainer']");

	// private By dropDownUserName = By.cssSelector(".down-arrow");

	public void clickTokenAccount() throws InterruptedException {
		click(btnTokenAccount, "Token Account");
		Thread.sleep(2000);
	}

	public String getAvailableBalance() {
		return getText(lblTotalFunds, "Available Balance");

	}

	public void verifyAmount() {

		new CommonFunctions().elementView(amount, "Amount");
	}

//		public void clickUserName() {
//		   click(dropDownUserName, "UserName");
//		}

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

	public void verifyTableItemsCount() {
		int actCount = Integer.parseInt(getItemsPerPage().split(" ")[3]);
		int rowInTable = getElementsList(rows, "Table Rows").size();
		if (actCount == rowInTable) {
			ExtentTestManager.setPassMessageInReport(
					"Number of rows in transactions table matches with number of entries selected i.e " + actCount);
		} else {
			ExtentTestManager.setFailMessageInReport(String.format(
					"Number of rows in transactions table = %s and entries selected in show drop down = %s", rowInTable,
					actCount));
		}
	}

//		public String getTransactionList() {
//			return getText(transaction, "Transaction");
//		}

	public void clickPayRequestToken() {
		click(btnPayRequestToken, "PayRequestToken");
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "BuyTokens");
	}

	public void clickWithdrawToUSD() {
		click(btnWithdrawToUSD, "WithdrawToUSD");

	}

	public List<String> getEntryOptions() {
		return getElementsList(entriesPerPageDropDown, "options").stream().map(WebElement::getText)
				.collect(Collectors.toList());
	}

	// added
	public void verifyPay() {
		new CommonFunctions().elementView(btnPay, "Pay is verified");
	}

	// added
	public void verifyLabelYourTransactions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblYourTransactions, "Your Transactions", expHeading);
		new CommonFunctions().elementView(lblYourTransactions, "Your Transactions");
	}

//		public void verifyLabelTransactionListDetails() {
//			new CommonFunctions().elementView(lblDateTime, "Date and Time");
//			new CommonFunctions().elementView(lblType, "Type");
//			new CommonFunctions().elementView(lblDescription, "Description");
//			new CommonFunctions().elementView(lblAmount, "Amount");
//			new CommonFunctions().elementView(lblBalance, "Balance");
//			new CommonFunctions().elementView(lblStatus, "Status");
//		}

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

	public TokensSentDetailsComponent tokensSentDetailsComponent() {
		return new TokensSentDetailsComponent();
	}

	public UserNameDropDownComponent userNameDropDownComponent() {
		return new UserNameDropDownComponent();
	}

	public TokensReceivedDetailsComponent tokensReceivedDetailsComponent() {
		return new TokensReceivedDetailsComponent();
	}

	public TokensPurchasedDetailsComponent tokensPurchasedDetailsComponent() {
		return new TokensPurchasedDetailsComponent();
	}

	public TokensWithdrawnDetailsComponent tokensWithdrawnDetailsComponent() {
		return new TokensWithdrawnDetailsComponent();
	}

	public TokenPaidOrdersDetailsComponent tokenPaidOrdersDetailsComponent() {
		return new TokenPaidOrdersDetailsComponent();
	}

	public NavigationMenuPage navigationMenuPage() {
		return new NavigationMenuPage();
	}

	public PayAndRequestTokensPopup payAndRequestTokensPopup() {
		return new PayAndRequestTokensPopup();
	}

	public BuyCoyniTokensPaymentMethodPopup buyCoyniTokensPaymentMethodPopup() {
		return new BuyCoyniTokensPaymentMethodPopup();
	}

	public WithdrawCoyniToUSDPopup withdrawCoyniToUSDPopup() {
		return new WithdrawCoyniToUSDPopup();
	}

}
