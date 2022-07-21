package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.admin.components.DaysMonthsDropDownComponent;
import coyni.admin.components.FilterComponent;
import coyni.admin.components.NavigationComponent;
import coyni.admin.components.SuccessFailureComponent;
import coyni.admin.popups.AddNewSignetAccountPopup;
import coyni.admin.popups.NoSignetAccountsExistPopup;
import coyni.admin.popups.RemoveSignetAccountPopup;
import coyni.admin.popups.WithdrawToSignetPopup;
import coyni.admin.popups.WithdrawToSignetPreviewPopup;
import coyni.customer.components.MailingAddressComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenAccountPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Token Account']");

	private By lblTotalAvailable = By.xpath("//span[text()='Total Available']");

	private By lblTokenAccountActivity = By.xpath("//span[text()='Token Account Activity (CYN)']");

	private By lblPayOutsReceived = By.xpath("//span[.='Payouts Received']/../following-sibling::*[1]/span");

	private By lblSignetWithdraw = By.xpath("//span[.='Signet Withdraws']/../following-sibling::*[1]/span");

	private By lnkWithdrawToSignet = By.xpath("//button[text()='Withdraw To Signet']");

	private By btnFilter = By.xpath("//button[text()='Filter']");

	private By btnExport = By.xpath("//button[text()='Export']");

	private By lblTransactions = By.xpath("//h2[text()='Transactions']");
	
	private By lblTokenAccount = By.xpath("//p[text()='Token Account']");
	
	public void clickTokenAccount() {
		click(lblTokenAccount, "Token Account");
	}

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblHeading, "Heading", expHeading);
	}

	public void clickTab() {
		new CommonFunctions().clickOutSideElement();
	}

	public String getTotalAvailable() {
		return getText(lblTotalAvailable, "Total Available");
	}

	public void verifyTokenAccountActivityView(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblTokenAccountActivity, "Token Account Activity", expHeading);
	}

	public void getPayOutsReceived() {
		String Amount = getText(lblPayOutsReceived, "");
		ExtentTestManager.setInfoMessageInReport("Payouts amount is " + Amount);
	}

	public void clickWithdrawToSignet() {
		click(lnkWithdrawToSignet, "WithdrawToSignet");
	}

	public void getSignetWithdraw() {
		String Amount = getText(lblSignetWithdraw, "");
		ExtentTestManager.setInfoMessageInReport("Signet Withdraw amount is " + Amount);
	}

	public void clickFilter() {
		click(btnFilter, "Filter");
	}

	public void clickExport() {
		click(btnExport, "Export");
	}

	public void verifyTransactionView(String expHeading) {
		new CommonFunctions().verifyLabelTextContains(lblTransactions, "Transactions", expHeading);
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

	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
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
