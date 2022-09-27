package coyni.admin.components;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;
import ilabs.web.actions.WaitForElement;

public class FilterComponent extends BrowserFunctions {

	public static WebDriver driver;

	private By lblFilters = By.xpath("//button[text()='Filter']");
	private By lblDate = By.xpath("//label[text()='Date']");
	private By lnkClear = By.xpath("//label[text()='Date']//button[text()='Clear']");
	private By lblTransactionType = By.xpath("//span[text()='Transaction Type']");
	private By lnkClearAll = By.xpath("//span[text()='Transaction Type']//button[text()='Clear All']");
	private By lblTransactionAmount = By.xpath("//label[text()='Transaction Amount']");
	private By txtFromAmount = By.xpath("//span[text()='From (CYN)']/preceding-sibling::input");
	private By txtToAmount = By.xpath("//span[text()='To (CYN)']/preceding-sibling::input");
	private By lblReferenceId = By.xpath("//button[text()='Clear']/ancestor::label[text()='Reference ID']");
	private By txtReferenceId = By.xpath("//input[@id='Reference ID']");
	private By lblTransactionStatus = By.xpath("//span[text()='Transaction Status']");
	// private By lnkClaerAll = By.xpath("");
	private By lblEmployeeName = By.xpath("//label[contains(text(),'Withdraw ID')]/following-sibling::*//input "); // label[text()='Employee
																													// Name']
	private By drpdwn = By.xpath("div[class*='selected_option']");
	private By lnkResetAllFilters = By.xpath("//button[text()='Reset all filters']");
	private By btnApplyFilters = By.xpath("//button[text()='Apply Filters']");
	private By lblDepositId = By.xpath("//button[text()='Clear']/ancestor::label[text()='Deposit ID']");
	private By textDepositId = By.xpath("//input[@id='Deposit ID']");
	private By lblUserId = By.xpath("//button[text()='Clear']/ancestor::label[text()='User ID']");
	private By textUserId = By.xpath("//input[@id='User ID']");
	private By lblUserType = By.xpath("//button[text()='Clear All']/ancestor::span[text()='User Type']");
	private By lblBusiness = By
			.xpath("//span[text()='Business']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblPersonal = By
			.xpath("//span[text()='Personal']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblCoyniAdmin = By
			.xpath("//span[text()='Coyni Admin']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblDepositAmount = By.xpath("//label[text()='Deposit Amount']");
	private By lblNameOnAccount = By.xpath("//label[text()='Name on Account']");
	private By txtName = By.xpath("//input[@id='NameName']");
	private By lblBankAccountNum = By.xpath("//label[text()='Bank Account Number']");
	private By txtAccountNum = By.xpath("//input[@id='Account Number']");
	private By lblPaid = By.xpath("//span[text()='Paid']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblFailed = By
			.xpath("//span[text()='Failed']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblInProgress = By
			.xpath("//span[text()='In Progress']/ancestor::div[@class='flex items-center mr-3 selectOption']");
	private By lblFiltersList = By.xpath("//button[.='Clear All']/../following-sibling::div[1]/div");

	public void fillWithdrawID(String id) {
		enterText(getTextFieldElements("Withdraw ID"), id, "Withdraw ID");
	}

	public void verifyDate(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDate, "Heading is", expHeading);
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(lblFilters, "Filters", expCssProp, expValue, expColor);
	}

	public void clickFilters() {

		click(lblFilters, "Filters");

	}

	private By lblNoTransaction = By.xpath("//span[text()='No Transactions Found']");

	public int noTransaction() {
		return getElementsList(lblNoTransaction, "").size();
	}

	public By getElement(String elementName) {
		return By.xpath(String.format("//button[text()='Clear']/ancestor::label[text()='%s']", elementName));
	}

	public void verifyFiltersLabelView(String elements) {
		String[] list = elements.split(",");
		for (int i = 0; i < list.length; i++) {
			new CommonFunctions().elementView(getElement(list[i]), list[i]);
		}
	}

	public By getTextFieldElements(String elementId) {
		return By.xpath(String.format("//input[@placeholder='%s']", elementId));

	}

	public void fillDepositId(String DepositId) {
		enterText(getTextFieldElements("Deposit ID"), DepositId, "Deposit Id");
	}

	public void fillReferenceId(String ReferenceId) {
		enterText(getTextFieldElements("Reference ID"), ReferenceId, "Reference Id");
	}

	public void fillUserId(String UserId) {
		enterText(getTextFieldElements("ID"), UserId, "User Id");
	}

	public void fillNameOnAccount(String Name) {
		enterText(getTextFieldElements("Name"), Name, "Name on Account");
	}

	public void fillBankAccountNumber(String AccountNumber) {
		enterText(getTextFieldElements("Account Number"), AccountNumber, "BankAccountNumber");
	}

	public void viewFilters() {
		new CommonFunctions().elementView(lblDate, "Date");
		// new CommonFunctions().elementView(lblTransactionType, "Transaction Type");
		new CommonFunctions().elementView(lblTransactionAmount, "Transaction Amount");
		// new CommonFunctions().elementView(lblReferenceId, "Reference ID");
		new CommonFunctions().elementView(lblTransactionStatus, "Transaction Status");
		// new CommonFunctions().elementView(lblEmployeeName, "Date");
	}

	public void verifyTransactionType(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionType, "Transaction Type Heading is", expHeading);
	}

	public void clickClearAll() {
		click(lnkClearAll, "Claer All");
	}

	public void verifyTrasactionAmount(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionAmount, "Transaction Amount Heading is", expHeading);
	}

	public void fillFromAmount(String fromAmount) {
		enterText(txtFromAmount, fromAmount, "From Amount");
	}

	public void fillToAmount(String toAmount) {
		enterText(txtToAmount, toAmount, "To Amount");
	}

	public void verifyReferenceId(String expGeading) {
		new CommonFunctions().verifyLabelText(lblReferenceId, "Reference ID Heading is", expGeading);
	}

	public void fillReferenceID(String referenceID) {
		enterText(txtReferenceId, referenceID, "Reference ID");
	}

	public void verifyTransactionStatus(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionStatus, "Transaction Status Heading is", expHeading);
	}

	public void verifyEmployeeName(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEmployeeName, "Employee Name Heading is", expHeading);
	}

	public void selectDropDown(String employees) {
		selectDropdown(drpdwn, employees, "Employees");
	}

	public void clickResetAllFilters() {
		click(lnkResetAllFilters, "Reset All Filters");
	}

	public void clickApplyFilters() {
		click(btnApplyFilters, "Apply Filters");
	}

	private By getClearElements(String elementName) {
		return By.xpath(String.format("//label[text()='%s']//following-sibling::button[text()='Clear']", elementName));
	}

	private By getClearAllElements(String elementName) {
		return By.xpath(
				String.format("//span[text()='%s']//following-sibling::button[text()='Clear All']", elementName));
	}

	public void clickUserTypeClearAll() {
		click(getClearAllElements("User Type"), "User Type Clear All");
	}

	public void clickTransactionStatusClr() {
		click(getClearAllElements("Transaction Status"), "Transaction Status Clear All");
	}

	public void clickDepositIdClr() {
		click(getClearElements("Deposit ID"), "Deposit Id Clear");
	}

	public void clickReferenceIdClr() {
		click(getClearElements("Reference ID"), " Reference Id Clear");
	}

	public void clickUserIdClr() {
		click(getClearElements("User ID"), "User Id Clear");
	}

	public void clickDepositAmtClr() {
		click(getClearElements("Deposit Amount"), "Deposit Amount Clear");
	}

	public void clickFromAmountClr() {
		click(getClearElements(" From (CYN)"), "From CYN");
	}

	public void clickTOAmountClr() {
		click(getClearElements("To (CYN)"), "To (CYN)");
	}

	public void clickNameOnAccountClr() {
		click(getClearElements("Name on Account"), "Name on Account Clear");
	}

	public void clickBankAccountnumClr() {
		click(getClearElements("Bank Account Number"), "Bank Account Number");
	}

	public void selectFilter(String type) {
		click(getCheckBox(type), type);
	}

	private By getCheckBox(String elementName) {
		return By.xpath(String.format("//span[text()='%s']//preceding-sibling::input", elementName));
	}

	public void clickWithdraw() {
		click(getCheckBox("Withdraw"), "Withdraw");
	}

	public void clickCommissionPayOut() {
		click(getCheckBox("Commission Payout"), "Commission Payout");
	}

	public void clickInProgress() {
		click(getCheckBox("In Progress"), "In Progress");
	}

	// buyToken
	public void clickBuyToken() {
		click(getCheckBox("Buy Token"), "Buy Token");
	}

	public void clickGiftCard() {
		click(getCheckBox("Gift Card"), "Gift Card");
	}

	public void clickDebitCard() {
		click(getCheckBox("Debit Card"), "Debit Card");
	}

	public void clickExternalBankAccount() {
		click(getCheckBox("External Bank Account"), "External Bank Accoun");
	}

	public void clickCreditCard() {
		click(getCheckBox("Credit Card"), "Credit Card");
	}

	public void clickInstantPay() {
		click(getCheckBox("Instant Pay"), "Instant Pay");
	}

	public void clickCompleted() {
		click(getCheckBox("Completed"), "Completed");
	}

	public void clickFailed() {
		click(getCheckBox("Failed"), "Failed");
	}

	public void clickWon() {
		click(getCheckBox("Won"), "Won");
	}

	public void clickLost() {
		click(getCheckBox("Lost"), "Lost");
	}

	public void clickchkbxBusiness() {
		click(getCheckBox("Business"), "Business");
	}

	public void clickchkbxPersonal() {
		click(getCheckBox("Personal"), "Personal");
	}

	public void clickchkbxCoyniAdmin() {
		click(getCheckBox("Coyni Admin"), "Coyni Admin");
	}

	public void clickchkbxPaid() {
		click(getCheckBox("Paid"), "Paid");
	}

	public void clickchkbxFailed() {
		click(getCheckBox("Failed"), "Failed");
	}

	public void clickchkbxInprogress() {
		click(getCheckBox("In Progress"), "In Progress");
	}

	public void filtersComponent(String data) {
		List<WebElement> elementsList = getElementsList(lblFiltersList, "Filters List");
		for (WebElement webElement : elementsList) {
			String text = webElement.getText();
			String[] split = data.split(",");
			int count = 0;
			for (int i = 0; i < split.length; i++) {
				if (text.equalsIgnoreCase(split[i])) {
					ExtentTestManager.setPassMessageInReport(text + " Filter Data match");
					break;
				}

				else {
					count++;
					if (count == split.length) {
						ExtentTestManager.setWarningMessageInReport(text + " Filter Data Not Found");
					}
				}
			}

		}

	}

	public boolean filterEna() {
		return getElement(lblFilters, "").isEnabled();
	}

	private By getCancelDebitCard(String data) {
		return By.xpath(String.format("//span[text()='%S']//following-sibling::button", data));
	}

	private By lbDebitCard = By.xpath("//span[text()='Debit Card']//following-sibling::button");

	public void clickBackDebitCard() {
		click(lbDebitCard, "");
	}

	private By lblCheckBox = By.xpath("//span[text()='Debit Card']//preceding-sibling::input");

	// lblCheckBox.is

	public void verifyDebitCardCheckBox() {
		if (getElement(lblCheckBox, "Debit Card").isSelected()) {
			ExtentTestManager.setFailMessageInReport("Check Box is Enabled");
		}

		else {
			ExtentTestManager.setInfoMessageInReport("CheckBox is Disabled");
		}
	}

	public TransactionDetailsComponent transactionDetailsComponent() {
		return new TransactionDetailsComponent();
	}

	// --------------------------

	private By countWithdrawTransaction = By.cssSelector(".entries-message");

	public String count() {
		return getText(countWithdrawTransaction, "");

	}

	public void verifyTableItemsCount(String query) throws SQLException {
		int count = DBConnection.getDbCon().getCount(String.format(query));
		int expCount = Integer.parseInt(count().split(" ")[3]);
		if (count == expCount) {
			ExtentTestManager
					.setPassMessageInReport("Number of transactions in table matches with number of entries selected ");
		} else {
			ExtentTestManager.setFailMessageInReport("No Transaction Found");
		}
	}

	public void containsInList(By listXpath, String data) {
		List<WebElement> elementsList = getElementsList(listXpath, "filtersHeadings");
		for (WebElement webElement : elementsList) {
			String text = webElement.getText();
			String[] split = data.split(",");
			int count = 0;
			for (int i = 0; i < split.length; i++) {
				if (text.equalsIgnoreCase(split[i])) {
					ExtentTestManager.setPassMessageInReport(text + " Filter Haedings match");
					break;
				}

				else {
					count++;
					if (count == split.length) {
						ExtentTestManager.setWarningMessageInReport(text + " Filter Haedings Not Found");
					}
				}
			}
		}
	}

	private By txtfiltersHeadings = By.xpath("//label[contains(@class,'text-sm font-semibold')]");

	public void verifyFiltersHeadings(String data) {
		containsInList(txtfiltersHeadings, data);
	}

	private By txtcaseNum = By.xpath("//input[@name='caseNumber']");
	public String a;

	public void enterCaseNum(String caseNum) {
		enterText(txtcaseNum, caseNum, "caseNumber");
	}

	private By txtResultsCaseNum = By.xpath("//h1[@class='font-semibold']");

	public String getCaseNum() {
		return getText(txtResultsCaseNum, "CaseNumber");
	}

	private By txtStatusCaseID = By.xpath("//span[@class='ml-1 text-xs font-bold text-cm3']");

	public void verifyDisputesExportStatusCaseID(String data) {
		waitForElement(txtStatusCaseID, waittime, WaitForElement.presence);
		containsInList(txtStatusCaseID, data);
	}

}
