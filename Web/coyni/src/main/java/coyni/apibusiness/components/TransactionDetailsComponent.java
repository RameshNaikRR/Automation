package coyni.apibusiness.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionDetailsComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("//p[@class='TokenTransactionDetails_MainTitle__N089R']");
	private By lblTransactionType = By.xpath("//span[.='Transaction Type']");
//	private By verifylblTransactionType(String lblTransactionType) {
//		return By.xpath(String.format("//span[.='Transaction Type']", lblTransactionType));
//	}
	private By lblTransactionSubType = By.xpath("//p[text()='Transaction Sub-type']");
	private By verifyAccountname = By.xpath("//p[text()='Name On Account']");

	// Reference ID is 2 and Deposit ID is 3 (Lables)
	private By getLblIDheadings(String lblIdHeadings) {
		return By.xpath(String.format("(//p[@class='TokenBuyTokenDetails_row_title_sub__zlwva'])[%s]", lblIdHeadings));
	}

	private By getlblCreatedDate(String CreatedDateNum) {
		return By.xpath(String.format("(//p[contains(@class,'row')])[%s]", CreatedDateNum));
	}

	private By getStatus(String Status) {
		return By.xpath(String.format("//div[.='%s']", Status));
	}

//	private String TransactionType = getText(By.xpath("//p[.='Buy Token']"), "");
	private By verifyTransactionType(String TransactionType) {
		return By.xpath(String.format("//p[.='%s']", TransactionType));
	}

	private By verifyLblTransactionSubType = By.xpath("//p[.='Bank Account ']");

//	private By getTransactionType(String ) {
//		return By.xpath(String.format("//p[.='Buy Token']", null));
//	}

	private By lblBankAccount = By.cssSelector("p[class*='TokenBuyTokenDetails_referenceTitle']");

	// Reference and Deposit ID'S
//	private By getId(String ID) {
//		return By.xpath(String.format("(//span[contains(@class,'referenceTitle')])[%s]", ID));
//	}

	// Reference ID and Deposit ID
	private By verifyBuyTokensIdLnks(String IdLnks) {
		return By.xpath(String.format("(//span[contains(@class,'TokenBuyTokenDetails')])[%s]", IdLnks));
	}

	// Reference ID and Deposit ID
	private By verifyWithdrawIdLnks(String IdLnks) {
		return By.xpath(String.format("(//p[@class='TokenWithdrawDetails_row_title_sub__ED6ct'])[%s]", IdLnks));
	}

//	private By verifyCreatedDate = By.xpath("(//span[contains(@class,'referenceTitle')])[3]");

	public By getCreatedDate(String Date) {
		return By.xpath(String.format("(//span[contains(@class,'referenceTitle')])[%s]", Date));
	}

	private By withdrawAccountBalance(String getAccountBal) {
		return By.xpath("//div[contains(@class,'account_amount')][1]");
	}

	private By lblAmountCategory = By.cssSelector("div[class*='amount'][class*='cyn']>div:nth-of-type(1)");
	private By lblAmount = By.cssSelector("div[class*='amount'][class*='cyn']>div:nth-of-type(2)>span:nth-of-type(1)");

	private By getAmountDetails(String AmountDetailsNum) {
		return By.xpath(String.format("(//div[contains(@class,'account_amount')])[%s]", AmountDetailsNum));
	}

	private By getWithdrawAmountDetails(String AmountDetails) {
		return By.xpath(String.format("//div[@class='flex justify-between mt-6'][%s]", AmountDetails));
	}

	private By getInformationHeadings(String Headings) {
		return By.xpath(
				String.format("//div[contains(@class,'Token')][contains(@class,'Title')]/span[.='%s']", Headings));
	}

	private By getType(String type) {
		return By.xpath(String.format("//tr[contains(@class,'  hovered')]//td[.='%s']", type));
	}

	private By getSubType(String subType) {
		return By.xpath(String.format("//tr[contains(@class,'  hovered')]//td[.='%s']", subType));
	}

	private By transactions = By.xpath("//tr[contains(@class,'posted-txn')]/following-sibling::tr");

	private By getInformationDetails(String Type, String subType) {
		return By.xpath(String.format("//div[contains(@class,'%s')]/..//p[text()='%s']/following-sibling::*[1]", Type,
				subType));
	}

	private By getAccountAddressInfo(String Address) {
		return By.xpath(String.format("//span[.='%s']//following-sibling::*[1]/*[2]", Address));
	}

	private By getLedgerInfo(String Type) {
		return By.xpath(String.format("//span[.='%s']/following-sibling::*[1]//span[2]", Type));
	}

	private By getTransactionIPaddress = By.xpath("//span[.='Transaction IP Address']/following-sibling::*[1]");

	public void verifyLblTransactionDetailsHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyLblTransactionType(String TransactionType) {
		new CommonFunctions().verifyLabelText(lblTransactionType, "TransactionType      ", TransactionType);
	}

	public void verifyLblTransactionSubType(String TransactionSubType) {
		new CommonFunctions().verifyLabelText(lblTransactionSubType, "TransactionSubType     ", TransactionSubType);
	}

	public void verifyLblBuyTokenCreatedDate() {
		new CommonFunctions().verifyLabelText(getlblCreatedDate("4"), "Created Date      ", "Created Date");
	}

	public void verifyLblWalletTransferCreatedDate(String CreatedDate) {
		new CommonFunctions().verifyLabelText(getlblCreatedDate("1"), "Created Date", CreatedDate);
	}

	public void verifyFailed() {
		new CommonFunctions().verifyLabelText(getStatus("Completed"), "Completed", "Completed");
	}

	public void verifyCompleted() {
		new CommonFunctions().verifyLabelText(getStatus("Failed"), "Failed", "Failed");
	}

	public void verifyInProgress() {
		new CommonFunctions().verifyLabelText(getStatus("In Progress"), "In Progress", "In Progress");
	}

	public void verifyLblReferenceID(String ReferenceID) {
		new CommonFunctions().verifyLabelText(getLblIDheadings("2"), "ReferenceID     ", ReferenceID);
	}

	public void verifyLblDepositID(String DepositID) {
		new CommonFunctions().verifyLabelText(getLblIDheadings("3"), "DepositID      ", DepositID);
	}

	public void verifyLblWithdrawId(String withdrawID) {
		new CommonFunctions().verifyLabelText(getLblIDheadings("4"), "WithdrawID", withdrawID);
	}

//	public void getBuyTokenTransactionType() {
//		new CommonFunctions().verifyLabelText(verifyTransactionType("Buy Token"), "Buy Token", "Buy Token");
//	}
	public void getBuyTokenTransactionType() {
		String TransactionType = getText(verifyTransactionType("Buy Token"), "");
		ExtentTestManager.setInfoMessageInReport("Transaction Type:   " + TransactionType);
	}

	public void getWithdrawTransactionType() {
		String TransactionType = getText(verifyTransactionType("Withdraw"), "");
		ExtentTestManager.setInfoMessageInReport("Transaction Type:   " + TransactionType);
	}

//	public void getWalletTransferTransactionType() {
//		new CommonFunctions().verifyLabelText(verifyTransactionType("Wallet Transfer"), "Wallet Transfer",
//				"Wallet Transfer");
//	}
	public void getWalletTransferTransactionType() {
		String TransactionType = getText(verifyTransactionType("Wallet Transfer"), "");
		ExtentTestManager.setInfoMessageInReport("Wallet Transfer: " + TransactionType);
	}

//	public void getWalletReceivedTransactionType() {
//		new CommonFunctions().verifyLabelText(verifyTransactionType("Wallet Received"), "Wallet Received",
//				"Wallet Received");
//	}
	public void getWalletReceivedTransactionType() {
		String TransactionType = getText(verifyTransactionType("Wallet Received"), "");
		ExtentTestManager.setInfoMessageInReport("Wallet Received:    " + TransactionType);
	}

	public void getBuyTokenTransactionSubType() {
		String TransactionsubType = getText(verifyLblTransactionSubType, "");
		ExtentTestManager.setInfoMessageInReport("TransactionsubType:   " + TransactionsubType);
	}

	public void getWithdrawTransactionSubType() {
		String TransactionsubType = getText(verifyLblTransactionSubType, "");
		ExtentTestManager.setInfoMessageInReport("TransactionsubType:   " + TransactionsubType);
	}

	public void verifyBankAccount(String BankAccount) {
		new CommonFunctions().verifyLabelText(lblBankAccount, BankAccount, "BankAccount");
	}

//	public void verifyReferenceID(String ReferenceID) {
//		new CommonFunctions().verifyLabelText(getId("1"), ReferenceID, "ReferenceID");
//	}
//
//	public void verifyDepositID(String DepositID) {
//		new CommonFunctions().verifyLabelText(getId("2"), DepositID, "DepositID");
//	}

	public void getReferenceID() {
		String idLink = getText(verifyBuyTokensIdLnks("1"), "");
		click(verifyBuyTokensIdLnks("1"), idLink);
		ExtentTestManager.setInfoMessageInReport("ReferenceID:  " + idLink);
	}

	public void getDepositID() {
		String idLink = getText(verifyBuyTokensIdLnks("2"), "");
		click(verifyBuyTokensIdLnks("2"), idLink);
		ExtentTestManager.setInfoMessageInReport("DepositID:    " + idLink);
	}

	public void getWithdrawReferenceID() {
		String idLink = getText(verifyWithdrawIdLnks("2"), "");
		click(verifyWithdrawIdLnks("2"), idLink);
		ExtentTestManager.setInfoMessageInReport("ReferenceID:  " + idLink);
	}

	public void getWithdrawDepositID() {
		String idLink = getText(verifyWithdrawIdLnks("3"), "");
		click(verifyWithdrawIdLnks("3"), idLink);
		ExtentTestManager.setInfoMessageInReport("DepositID:    " + idLink);
	}

//	public void getCreatedDateValue() {
//		String date = getText(verifyCreatedDate, "");
//		if (!date.isEmpty()) {
//			ExtentTestManager.setInfoMessageInReport("Created Date: " + date);
//		} else {
//			ExtentTestManager.setWarningMessageInReport("Created Date: " + date);
//		}
//	}
	public void getWalletTransferCreatedDate() {
		String date = getText(getCreatedDate("1"), "");
		if (!date.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Wallet Transfer Created date: " + date);
		} else {
			ExtentTestManager.setWarningMessageInReport("Wallet Transfer Created date: " + date);
		}
	}

	public void getWalletRecievedCreatedDate() {
		String date = getText(getCreatedDate("1"), "");
		if (!date.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Wallet Transfer Created date: " + date);
		} else {
			ExtentTestManager.setWarningMessageInReport("Wallet Transfer Created date: " + date);
		}
	}

	public void getBuyTokenCreatedDate() {
		String date = getText(getCreatedDate("3"), "");
		if (!date.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Wallet Transfer Created date: " + date);
		} else {
			ExtentTestManager.setWarningMessageInReport("Wallet Transfer Created date: " + date);
		}
	}

	public void getWithdrawCreatedDate() {
		String date = getText(getCreatedDate("4"), "");
		if (!date.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Wallet Transfer Created date: " + date);
		} else {
			ExtentTestManager.setWarningMessageInReport("Wallet Transfer Created date: " + date);
		}
	}

	public void verifyAmountCategory(String AmountCategory) {
		new CommonFunctions().verifyLabelText(lblAmountCategory, "AmountCategory      ", AmountCategory);
	}

	public void verifyAmount() {
		String Amount = getText(lblAmount, "");
		if (!Amount.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Amount: " + Amount);
		} else {
			ExtentTestManager.setWarningMessageInReport("Amount: " + Amount);
		}
	}

	public void getWalletTransferProcessingFee() {
		String ProcessingFee = getText(getAmountDetails("1"), "");
		if (!ProcessingFee.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Processing Fee: " + ProcessingFee);
		} else {
			ExtentTestManager.setWarningMessageInReport("Processing Fee: " + ProcessingFee);
		}
	}

	public void getWalletTransferTotalAmount() {
		String TotalAmount = getText(getAmountDetails("2"), "");
		if (!TotalAmount.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Total Amount : " + TotalAmount);
		} else {
			ExtentTestManager.setWarningMessageInReport("Total Amount: " + TotalAmount);
		}
	}

	public void getBuyTokenPurchaseAmount() {
		String PurchaseAmount = getText(getAmountDetails("1"), "");
		if (!PurchaseAmount.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Purchase Amount: " + PurchaseAmount);
		} else {
			ExtentTestManager.setWarningMessageInReport("Purchase Amount: " + PurchaseAmount);
		}
	}

	public void getBuyTokenProcessingFee() {
		String ProcessingFee = getText(getAmountDetails("2"), "");
		if (!ProcessingFee.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Processing Fee: " + ProcessingFee);
		} else {
			ExtentTestManager.setWarningMessageInReport("Processing Fee: " + ProcessingFee);
		}
	}

	public void getBuyTokenTotalAmount() {
		String TotalAmount = getText(getAmountDetails("3"), "");
		if (!TotalAmount.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Total Amount: " + TotalAmount);
		} else {
			ExtentTestManager.setWarningMessageInReport("Total Amount: " + TotalAmount);
		}
	}

	public void getBuyTokenAccountBalance() {
		String AccountBalance = getText(getAmountDetails("4"), "");
		if (!AccountBalance.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Account Balance: " + AccountBalance);
		} else {
			ExtentTestManager.setWarningMessageInReport("Account Balance: " + AccountBalance);
		}
	}

	public void getWithdrawAmount() {
		String withdrawAmount = getText(getWithdrawAmountDetails("1"), "");
//		if (!withdrawAmount.isEmpty()) {
		ExtentTestManager.setInfoMessageInReport("Withdraw Amount: " + withdrawAmount);
//		} else {
//			ExtentTestManager.setWarningMessageInReport("Withdraw Amount: " + withdrawAmount);
//		}
	}

	public void getWithdrawProcessingFee() {
		String ProcessingFee = getText(getWithdrawAmountDetails("2"), "");
		if (!ProcessingFee.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Processing Fee: " + ProcessingFee);
		} else {
			ExtentTestManager.setWarningMessageInReport("Processing Fee: " + ProcessingFee);
		}
	}

	public void getWithdrawTotalAmount() {
		String TotalAmount = getText(getWithdrawAmountDetails("3"), "");
//		if (!TotalAmount.isEmpty()) {
		ExtentTestManager.setInfoMessageInReport("Total Amount: " + TotalAmount);
//		} else {
//			ExtentTestManager.setWarningMessageInReport("Total Amount: " + TotalAmount);
//		}
	}

	public void getWithdrawAccountBalance() {
		String AccountBalance = getText(withdrawAccountBalance("1"), "");
		if (!AccountBalance.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Account Balance: " + AccountBalance);
		} else {
			ExtentTestManager.setWarningMessageInReport("Account Balance: " + AccountBalance);
		}
	}

	public void verifyLedgerInfoHeading() {
		new CommonFunctions().verifyLabelText(getInformationHeadings("Ledger Information"), "Ledger Information",
				"Ledger Information");
	}

	public void verifyRecipientInfoHeading() {
		new CommonFunctions().verifyLabelText(getInformationHeadings("Recipient Information"), "Recipient Information",
				"Recipient Information");
	}

	public void verifySenderInfoHeading() {
		new CommonFunctions().verifyLabelText(getInformationHeadings("Sender Information"), "Sender Information",
				"Sender Information");
	}

	public void verifyBankAccountInfoHeading() {
		new CommonFunctions().verifyLabelText(getInformationHeadings("Bank Account Information"),
				"Bank Account Information", "Bank Account Information");
	}

	public void verifyActivityLogHeading() {
		new CommonFunctions().verifyLabelText(getInformationHeadings("Activity Log"), "Activity Log", "Activity Log");
	}

	public void getNameOnAccount() {
		String NameOnAccount = getText(getInformationDetails("Recipient", "Name On Account"), "");
		if (!NameOnAccount.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Name On Account: " + NameOnAccount);
		} else {
			ExtentTestManager.setWarningMessageInReport("Name On Account: " + NameOnAccount);
		}
	}

	public void getBankName() {
		String BankName = getText(getInformationDetails("Recipient", "Bank Name"), "");
		if (!BankName.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Bank Name: " + BankName);
		} else {
			ExtentTestManager.setWarningMessageInReport("Bank Name: " + BankName);
		}
	}

	public void getBankAccountNumber() {
		String BankAccountNumber = getText(getInformationDetails("Recipient", "Bank Account Number"), "");
		if (!BankAccountNumber.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Bank Account Number: " + BankAccountNumber);
		} else {
			ExtentTestManager.setWarningMessageInReport("Bank Account Number: " + BankAccountNumber);
		}
	}

	public void getRecipientAccountID() {
		String RecipientAccountID = getText(getInformationDetails("Recipient", "Recipient Account ID"), "");
		if (RecipientAccountID != null) {
			ExtentTestManager.setInfoMessageInReport("Recipient Account ID: " + RecipientAccountID);
		} else {
			ExtentTestManager.setWarningMessageInReport("Recipient Account ID: " + RecipientAccountID);
		}
	}

	public void getRecipientName() {
		String RecipientName = getText(getInformationDetails("Recipient", "Recipient Name"), "");
		if (!RecipientName.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Recipient Name: " + RecipientName);
		} else {
			ExtentTestManager.setWarningMessageInReport("Recipient Name: " + RecipientName);
		}
	}

	public void getRecipientAccountIDaddress() {
		click(getAccountAddressInfo("Recipient Account ID"), "");
		ExtentTestManager.setInfoMessageInReport("Recipient Account ID Address: " + getCopiedData());
	}

	public void getRecipientEmail() {
		String RecipientEmail = getText(getInformationDetails("Recipient", "Recipient Email"), "");
		if (!RecipientEmail.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Recipient Email: " + RecipientEmail);
		} else {
			ExtentTestManager.setWarningMessageInReport("Recipient Email: " + RecipientEmail);
		}
	}

	public void getRecipientPhone() {
		String RecipientPhone = getText(getInformationDetails("Recipient", "Recipient Phone"), "");
		if (!RecipientPhone.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Recipient Phone: " + RecipientPhone);
		} else {
			ExtentTestManager.setWarningMessageInReport("Recipient Phone: " + RecipientPhone);
		}
	}

	public void getSenderAccountID() {
		String SenderAccountID = getText(getInformationDetails("Sender", "Sender Account ID"), "");
		if (!SenderAccountID.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Sender Account ID: " + SenderAccountID);
		} else {
			ExtentTestManager.setWarningMessageInReport("Sender Account ID: " + SenderAccountID);
		}
	}

	public void getSenderName() {
		String SenderName = getText(getInformationDetails("Sender", "Sender Name"), "");
		if (!SenderName.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Sender Name: " + SenderName);
		} else {
			ExtentTestManager.setWarningMessageInReport("Sender Name: " + SenderName);
		}
	}

	public void getSenderAccountAddress() {
		click(getAccountAddressInfo("Sender Account Address"), "");
		ExtentTestManager.setInfoMessageInReport("Sender Account Address: " + getCopiedData());
	}

	public void getSenderEmail() {
		String SenderEmail = getText(getInformationDetails("Sender", "Sender Email"), "");
		if (!SenderEmail.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Sender Email: " + SenderEmail);
		} else {
			ExtentTestManager.setWarningMessageInReport("Sender Email: " + SenderEmail);
		}
	}

	public void getSenderPhone() {
		String SenderPhone = getText(getInformationDetails("Sender", "Sender Phone"), "");
		if (!SenderPhone.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Sender Phone: " + SenderPhone);
		} else {
			ExtentTestManager.setWarningMessageInReport("Sender Phone: " + SenderPhone);
		}
	}

	public void getLedgerReferenceID() {
		click(getLedgerInfo("Reference ID"), "");
		ExtentTestManager.setInfoMessageInReport("Reference ID: " + getCopiedData());
	}

	public void getLedgerCordaID() {
		click(getLedgerInfo("Corda ID"), "");
		ExtentTestManager.setInfoMessageInReport("Corda ID: " + getCopiedData());
	}

	public void getLedgerTransactionIPaddress() {
		String TransactionIPaddress = getText(getTransactionIPaddress, "");
		if (!TransactionIPaddress.isEmpty()) {
			ExtentTestManager.setInfoMessageInReport("Transaction IP Address: " + TransactionIPaddress);
		} else {
			ExtentTestManager.setWarningMessageInReport("Transaction IP Address: " + TransactionIPaddress);
		}
	}

	public void verifyWalletType() {
		new CommonFunctions().elementView(getType("Wallet"), "Wallet");
	}

	public void verifyBuyTokenType() {
		new CommonFunctions().elementView(getType("Buy Token"), "Buy Token");
	}

	public void verifyAccountName() {
		new CommonFunctions().elementView(verifyAccountname, "Name on Account");
	}

	public void verifyWithdrawType() {
		new CommonFunctions().elementView(getType("Withdraw"), "Withdraw");
	}

	public void verifyWalletTransferSubType() {
		new CommonFunctions().elementView(getSubType("Transfer"), "Transfer");
	}

	public void verifyWalletRecievedSubType() {
		new CommonFunctions().elementView(getSubType("Received"), "Received");
	}

	public void verifyBuyTokenSubType() {
		new CommonFunctions().elementView(getSubType("Bank Account"), "Bank Account");
	}

	public void verifyWithdrawSubType() {
		new CommonFunctions().elementView(getSubType("Bank Account"), "Bank Account");
	}

	public void clickTransactions(String type, String subType, String status) {

		List<WebElement> rows = getElementsList(transactions, "Transactions");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", " ");
			if (replace.contains(type) && replace.contains(subType) && replace.contains(status)) {
				row.click();
				ExtentTestManager.setInfoMessageInReport("Clicked on " + type + " first occurance in the table");
				break;
			}
		}

	}

	public void clickTransactions(String type, String subType) {
		this.clickTransactions(type, subType, "");
	}

	public void getTransactionDetails() {
		if (getText(getType("Buy Token"), "").equalsIgnoreCase("Buy Token")) {
			if (getText(getSubType("Bank Account"), "").equalsIgnoreCase("Bank Account")) {

			} else {
//
			}
		}
		if (getText(getType("Wallet"), "").equalsIgnoreCase("Wallet")) {

		}
		if (getText(getType("Wallet"), "").equalsIgnoreCase("Wallet")) {
			if (getText(getSubType("Transfer"), "").equalsIgnoreCase("Transfer")) {

			} else {
//
			}
		}
	}

	public void WalletTransferTransactionDetails(String lblHeading, String lblTransactionType,
			String lblAmountCategory) {
		verifyLblTransactionDetailsHeading(lblHeading);
		verifyLblTransactionType(lblTransactionType);
		verifyLblWalletTransferCreatedDate(lblAmountCategory);
		verifyTransactionType(lblTransactionType);
		getWalletTransferTransactionType();
//		getCreatedDateValue();
		verifyAmountCategory(lblAmountCategory);
		verifyAmount();
		getWalletTransferProcessingFee();
		getWalletTransferTotalAmount();
		verifyLedgerInfoHeading();
		getLedgerReferenceID();
		getLedgerCordaID();
		getLedgerTransactionIPaddress();
		verifyRecipientInfoHeading();
		getRecipientAccountID();
		getRecipientName();
		getRecipientAccountIDaddress();
		getRecipientEmail();
		getRecipientPhone();
		verifySenderInfoHeading();
		getSenderAccountID();
		getSenderName();
		getSenderAccountAddress();
		getSenderEmail();
		getSenderPhone();

	}
}
