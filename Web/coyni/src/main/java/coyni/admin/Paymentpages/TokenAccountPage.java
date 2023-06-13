package coyni.admin.Paymentpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.admin.Paymentcomponents.AuthyComponent;
import coyni.admin.Paymentcomponents.DaysMonthsDropDownComponent;
import coyni.admin.Paymentcomponents.FilterComponent;
import coyni.admin.Paymentcomponents.NavigationComponent;
import coyni.admin.Paymentcomponents.SuccessFailureComponent;
import coyni.admin.Paymentspopups.AddNewSignetAccountPopup;
import coyni.admin.Paymentspopups.NoSignetAccountsExistPopup;
import coyni.admin.Paymentspopups.RemoveSignetAccountPopup;
import coyni.admin.Paymentspopups.WithdrawToSignetPopup;
import coyni.admin.Paymentspopups.WithdrawToSignetPreviewPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenAccountPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Token Account']");

	private By lblTotalAvailable = By.xpath("//span[text()='Total Available']");

	private By lblTokenAccountActivity = By.xpath("//span[text()='Token Account Activity (CYN)']");

	private By lblPayOutsReceived = By.xpath("//span[.='Payouts Received']/../following-sibling::*[1]/span");

	private By lblSignetWithdraw = By.xpath("//span[.='Cogent Withdraws']/../following-sibling::*[1]/span");

	private By lnkWithdrawToCogent = By.xpath("//button[text()='Withdraw To Cogent']");

	private By btnFilter = By.xpath("//button[text()='Filter']");

	private By btnExport = By.xpath("//button[text()='Export']");

	private By lblTransactions = By.xpath("//h2[text()='Transactions']");

	private By lblTokenAccount = By.xpath("//p[text()='Token Account']");
	private By lblTokenAccountHeadings = By.xpath("//th[contains(@class,' col')]");

	CommonFunctions commonfunctions = new CommonFunctions();

	public void clickTokenAccount() {
		click(lblTokenAccount, "Token Account");
	}

	public void verifyTokenAccountHeadings(String headings) {
		List<WebElement> elementsList = getElementsList(lblTokenAccountHeadings, "Token Account Headings");
	//	commonfunctions.verifyHeadings(elementsList, headings, "Token Account Headings");
	}

	private By lblTransactionHeading = By.xpath("//h2[text()='Transactions']");

	public void verifyTransactionHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionHeading, "Transaction Heading", expHeading);
	}

	public void verifyPageHeading(String expHeading) {
		//new CommonFunctions().verifyLabelTextContains(lblHeading, "Heading", expHeading);
	}

	public void clickTab() {
		//new CommonFunctions().clickOutSideElement();
	}

	public String getTotalAvailable() {
		return getText(lblTotalAvailable, "Total Available");
	}

	public void verifyTokenAccountActivityView(String expHeading) {
	//	new CommonFunctions().verifyLabelTextContains(lblTokenAccountActivity, "Token Account Activity", expHeading);
	}

	public void getPayOutsReceived() {
		String Amount = getText(lblPayOutsReceived, "");
		ExtentTestManager.setInfoMessageInReport("Payouts amount is " + Amount);
	}

	public void clickWithdrawToCogent() {
		click(lnkWithdrawToCogent, "WithdrawToCogent");
	}

	public void getCogentWithdraw() {
		String Amount = getText(lblSignetWithdraw, "");
		ExtentTestManager.setInfoMessageInReport("Cogent Withdraw amount is " + Amount);
	}

	public void clickFilter() {
		click(btnFilter, "Filter");
	}

	public void clickExport() {
		click(btnExport, "Export");
	}

	public void verifyTransactionView(String expHeading) {
		//new CommonFunctions().verifyLabelTextContains(lblTransactions, "Transactions", expHeading);
	}

	public WithdrawToSignetPopup withdrawToSignetPopup() {
		return new WithdrawToSignetPopup();
	}

	public WithdrawToSignetPreviewPopup withdrawToSignetPreviewPopup() {
		return new WithdrawToSignetPreviewPopup();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	public NoSignetAccountsExistPopup noSignetAccountsExistPopup() {
		return new NoSignetAccountsExistPopup();
	}

	public AddNewSignetAccountPopup addNewSignetAccountPopup() {
		return new AddNewSignetAccountPopup();
	}


	public RemoveSignetAccountPopup removeSignetAccountPopup() {
		return new RemoveSignetAccountPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public TransactionPage transactionPage() {
		return new TransactionPage();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}
	
}
