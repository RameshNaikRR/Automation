package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.AddCardPage;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddNewPaymentComponent extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[@text='Add Payment Method']|//*[@text='Add Bank Account']");
	private By btnExternalBank = MobileBy
			.xpath("//*[contains(@resource-id,'tvBankHead')]|//*[contains(@resource-id,'tvPayMethod')]");
	private By btnDebitCard = MobileBy
			.xpath("//*[contains(@resource-id,'tvBDCHead')]|//*[contains(@resource-id,'tvPayMethod')]");
//	private By btnCreditCard = MobileBy.xpath("//*[contains(@resource-id,'layoutCCard')]");
	private By btnCogentAccount = MobileBy.xpath("//*[@text='Cogent Account']");
	private By numberOfBankAccounts = MobileBy.xpath("//*[contains(@resource-id,'tvBankCount')]");
	private By numberOfDebitCards = MobileBy.xpath("//*[contains(@resource-id,'tvDCardCount')]");
	private By numberOfCogentAccounts = MobileBy.xpath("//*[contains(@resource-id,'tvCogentCount')]");
	private By errMsgMaxBankAccounts = MobileBy.xpath("//*[contains(@resource-id,'tvBBankError')]");
	private By errMsgMaxDebit = MobileBy.xpath("//*[contains(@resource-id,'tvBDCardError')]");
	private By errMsgMaxSignet = MobileBy.xpath("//*[contains(@resource-id,'tvCogentError')]");
	private By withdrawAddBankHeading = MobileBy.xpath("//*[contains(@resource-id,'tvPayMethod')]");
	private By btnInstantPay = MobileBy.xpath("//*[contains(@resource-id,'tvPayMethod')]");
	private By btnSignet = MobileBy.xpath("//*[contains(@resource-id,'tvPayMethod')]");
	private By withdrawInstantPayHeading = MobileBy.xpath("//*[@text='Add Instant Pay']");
	private By withdrawCogentHeading = MobileBy.xpath("//*[@text='Add Cogent Account']");

	public void verifyHeading(String expHeading) {
//		if (getElementList(lblHeading, "Heading").size() > 0) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);

//		}

	}

	public void verifywithdrawAddBankHeading(String expHeading) throws InterruptedException {
		if (getElementList(withdrawAddBankHeading, "Heading").size() > 0) {
//				DriverFactory.getDriver().findElements(withdrawAddBankHeading).size()==1
			new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
//			click(btnExternalBank, "Bank");
		}

	}

	public void verifywithdrawAddInstantHeading(String expHeading) throws InterruptedException {
		Thread.sleep(2000);
		if (getElementList(withdrawInstantPayHeading, "Heading").size() > 0) {
//				DriverFactory.getDriver().findElements(withdrawAddBankHeading).size()==1
			new CommonFunctions().verifyLabelText(withdrawInstantPayHeading, "Heading", expHeading);
//			click(btnInstantPay, "Instant Pay");
		}

	}

	public void verifywithdrawAddCogentHeading(String expHeading) throws InterruptedException {
//		Thread.sleep(2000);
		if (getElementList(withdrawCogentHeading, "Heading").size() > 0) {
//				DriverFactory.getDriver().findElements(withdrawAddBankHeading).size()==1
			new CommonFunctions().verifyLabelText(withdrawCogentHeading, "Heading", expHeading);
//			click(btnSignet, "Signet Account");
		}

	}

	public void verifyErrorMessageOfDebitCard(String expHeading) {
		new CommonFunctions().verifyLabelText(errMsgMaxDebit, "", expHeading);
	}

	public int verifyErrorMessageDebitCard() {
		return DriverFactory.getDriver().findElements(errMsgMaxDebit).size();

	}

	public void verifyErrorMessageOfSignetAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(errMsgMaxSignet, "error message of maximum Cogent Accounts", expHeading);
	}

	public int verifyErrorMessageSignetAccount() {
		return DriverFactory.getDriver().findElements(errMsgMaxSignet).size();

	}

	public void verifyErrorMessageOfBankAccount(String expHeading) {
		new CommonFunctions().verifyLabelText(errMsgMaxBankAccounts, "", expHeading);
	}

	public int verifyErrorMessageBankAccount() throws InterruptedException {
		Thread.sleep(2000);
		return DriverFactory.getDriver().findElements(errMsgMaxBankAccounts).size();

	}

	public int verifyAddNewPaymentHeading() throws InterruptedException {
//		Thread.sleep(2000);
		return DriverFactory.getDriver().findElements(lblHeading).size();
	}

	public void clickBankAcount() throws InterruptedException {
		Thread.sleep(2000);
		if (getElementList(btnExternalBank, "Bank Account").size() > 0) {
			click(btnExternalBank, "Bank Account");
		}
	}

	public void clickDebitCard() throws InterruptedException {
//		Thread.sleep(2000);
//		if (getElementList(btnDebitCard, "Debit Card").size() > 0) {
		click(btnDebitCard, "Debit Card");
//		}
	}

//	public void clickCreditCard() {
//		click(btnCreditCard, "Credit Card");
//	}

	public void clickCogentAccount() {
		click(btnCogentAccount, "Cogent Account");
	}

	public String getBankAccounts() {
		String str = getText(numberOfBankAccounts);
		return str;
	}

	public void verifyDebitCards(String expDebitCards) {
		if (getElementList(numberOfDebitCards, "Present Debit Cards number").size() > 0) {
			new CommonFunctions().verifyLabelText(numberOfDebitCards, "Present Debit Cards number", expDebitCards);
		}
	}

	public int verifyNumberOfDebitCards() {
		return getElementList(numberOfDebitCards, "Present Debit Cards number").size();

	}

	public void verifyCogentAccounts(String expCogentAccount) {
		if (getElementList(numberOfCogentAccounts, "Present Cogent Accounts number").size() > 0) {
			new CommonFunctions().verifyLabelText(numberOfCogentAccounts, "Present Cogent Accounts", expCogentAccount);
		}
	}

	public String getCogentAccounts() {
		String a = getText(numberOfCogentAccounts);
		return a;

	}

	public String getDebitCards() {
		String a = getText(numberOfBankAccounts);
		return a;

	}

	public String getBanks() {
		String a = getText(numberOfBankAccounts);
		return a;

	}

	public void verifyBankAccounts(String expBank) {
		if (getElementList(numberOfBankAccounts, "Present Bank Account number").size() > 0) {
			new CommonFunctions().verifyLabelText(numberOfBankAccounts, "Present Bank Account number", expBank);
		}

	}

	public Integer getPresentDebitCards() {
		String str = getText(numberOfDebitCards);
		String presentNumber = str.split("/")[0];
		String one = presentNumber.replace("(", "");
		Integer qty = Integer.valueOf(one);
		return qty;
	}

	public Integer getMaxDebitCardsLimit() {
		String str = getText(numberOfDebitCards);
		String MaxLimit = str.split("/")[1];
		String one = MaxLimit.replace(")", "");
		Integer qty = Integer.valueOf(one);
		return qty;

	}

	public Integer getPresentBankAccounts() {
		String str = getText(numberOfBankAccounts);
		String presentNumber = str.split("/")[0];
		String one = presentNumber.replace("(", "");
		Integer qty = Integer.valueOf(one);
		return qty;
	}

	public Integer getMaxBankAccounts() {
		String str = getText(numberOfBankAccounts);
		String MaxLimit = str.split("/")[1];
		String one = MaxLimit.replace(")", "");
		Integer qty = Integer.valueOf(one);
		return qty;

	}

	public Integer getPresentCogentAccounts() {
		String str = getText(numberOfCogentAccounts);
		String presentNumber = str.split("/")[0];
		String one = presentNumber.replace("(", "");
		Integer qty = Integer.valueOf(one);
		return qty;
	}

	public Integer getMaxCogentAccounts() {
		String str = getText(numberOfCogentAccounts);
		String MaxLimit = str.split("/")[1];
		String one = MaxLimit.replace(")", "");
		Integer qty = Integer.valueOf(one);
		return qty;
	}

	public AddBankAccountComponent addBankAccountComponent() {
		return new AddBankAccountComponent();
	}
//	public AddExternalBankAccountComponent addExternalBankAccountComponent() {
//		return new AddExternalBankAccountComponent();
//	}

	public AddCardPage addCardPage() {
		return new AddCardPage();
	}
}
