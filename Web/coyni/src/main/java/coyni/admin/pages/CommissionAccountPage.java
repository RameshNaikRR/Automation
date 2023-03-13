package coyni.admin.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.admin.components.DaysMonthsDropDownComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CommissionAccountPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[text()='Commission Account']");

	private By lblCommissionActivity = By.xpath("//span[text()='Commission Activity']");

	private By lblTotalCommissionEarned = By
			.xpath("//h2[contains(text(),'Total Commission Earned')]/../following-sibling::*[1]");

	private By lblAccountBalance = By.xpath("//span[contains(text(),'Account Balance')]/../following-sibling::*[1]");

	private By lblBatchPayOuts = By.xpath("//span[contains(text(),'Batch Payouts')]/../following-sibling::*[1]");

	private By lblNextPayOut = By.xpath("//h2[contains(text(),'Next Payout')]/..//span[text()=' ']");

	private By lblLastPayOut = By.xpath("//h2[contains(text(),'Last Payout')]/..//span[text()=' ']");

	private By lnkBatchNow = By.xpath("//button[text()='Batch Now']");

	private By lblViewFullPayOutHistory = By.xpath("//button[text()='View Full Payout History']");

	private By lblViewFullTransactionHistory = By.xpath("//button[contains(text(),'View Full Transactions History')]");

	private By lblTotalCommissionAmount = By
			.xpath("//span[contains(@class,'Gbox_wallet_balance_larger__Gqdxt font-bold cursor-default text-cgy4 ')]");
	private By lblTotalAmount = By
			.xpath("//span[contains(@class,'Gbox_wallet_balance3_larger__xYteD font-bold cursor-default text-cgy4 ')]");

	public String getcommissionAmount() {
		String text = getText(lblTotalCommissionAmount, "Commission Amount");
		ExtentTestManager.setInfoMessageInReport("Total Commission Earned is " + text);
		return text;
	}

	public String getTotalAmount() {
		String text = getText(lblTotalAmount, "Total Amount");
		ExtentTestManager.setInfoMessageInReport("Total Amount  is " + text);
		return text;
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport("Account Balance: " + getText(lblAccountBalance, "Account Balance"));
		verifyElementContainsText(lblAccountBalance, "CYN", "AccountBalance");
	}

	public void getBatchPayOuts() {
		ExtentTestManager.setInfoMessageInReport("Batch PayOuts: " + getText(lblBatchPayOuts, "Batch PayOuts"));
	}

	public void getNextPayOut() {
		ExtentTestManager.setInfoMessageInReport("Next PayOut: " + getText(lblNextPayOut, "Next PayOut"));
	}

	public void getLastPayOut() {
		ExtentTestManager.setInfoMessageInReport("Last PayOut: " + getText(lblLastPayOut, "Last PayOut"));
	}

	public void getTotalCommissionEarned() {
		ExtentTestManager.setInfoMessageInReport(
				"Total Commission Earned: " + getText(lblTotalCommissionEarned, "Total Commission Earned"));
	}

	public void clickBatchNow() {
		if (getElement(lnkBatchNow, "Batch Now").isDisplayed()) {
			click(lnkBatchNow, "Batch Now");
		} else {
			ExtentTestManager.setInfoMessageInReport("Batch Now Button is disable please you pay after 12 hr");
		}
	}

	public void clickFullPayOutHistory() {
		scrollToElement(lblViewFullPayOutHistory, "");
		new CommonFunctions().verifyTextUnderLine(lblViewFullPayOutHistory, "Full PayOut History ");
		click(lblViewFullPayOutHistory, "Full PayOut History");
	}

	public void clickFullTransactionHistory() {
		new CommonFunctions().verifyTextUnderLine(lblViewFullTransactionHistory, "Full Transaction History ");
		click(lblViewFullTransactionHistory, "Full Transaction History");
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
	}

	public String currentDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format = simpleDateFormat.format(new Date());
		return format;
	}

	public PayOutsPage payOutsPage() {
		return new PayOutsPage();
	}

	private By lblTransactionList = By.xpath("//td[contains(@class,'businessData cell-col-0 createdAt')]");
	private By lblPatoutTransactions = By.xpath("//td[contains(@class,'cell-col-0 createdAt')]");
	private By btnCommissionAccount = By.xpath("//a[text()='Commission Account']");

	public void clickCommssion() {
		click(btnCommissionAccount, "");
	}

	List<WebElement> elementsList;
	List<WebElement> payOutElementsList;

	public void verifyTransactionList() throws InterruptedException {

		elementsList = getElementsList(lblTransactionList, "Transaction List in Commission Account");

		for (int i = 0; i < 6; i++) {
			Thread.sleep(2000);
			String tec = elementsList.get(i).getText();
			System.out.println(tec);
			Thread.sleep(2000);
			clickFullPayOutHistory();
			payOutElementsList = getElementsList(lblPatoutTransactions,
					"Transaction payout List in Commission Account");
			for (int j = 1; j < 6; j++) {

				String text = payOutElementsList.get(j).getText();
				System.out.println(text);
				if (tec.equals(text)) {
					ExtentTestManager.setInfoMessageInReport(tec + " is matched");
					System.out.println("ok");

				} else {
					ExtentTestManager.setWarningMessageInReport(tec + " not matched");
					System.out.println("Not Ok");
				}

			}

			clickCommssion();

		}

	}

	// Earing By category

	public By getLabelItem(String Type) {
		return By.xpath(String.format("(//span[text()='%s'])", Type));
	}

	public By getTransactionCount(String Type) {
		return By.xpath(String.format(
				"(//div[contains(@class,'flex flex-row-reverse justify-center -ml-16 text-sm font-semibold text-cgy4')])[%s]",
				Type));
	}

	public By getValumeAndCommissionAmountCount(String Type) {
		return By.xpath(String.format(
				"(//div[contains(@class,'flex flex-row-reverse text-sm font-semibold mr-9 text-cgy4')])[%s]", Type));
	}

	// (//span[contains(@class,'font-semibold text-cgy4')])[2]

	public By getPercentageTransaction(String Type) {
		return By.xpath(String.format("(//span[contains(@class,'font-semibold text-cgy4')])[%s]", Type));
	}

	public void verifyWithdrawTransaction() {
		String text = getText(getLabelItem("Withdraw"), "Withdraw");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed in the Earnings by category");
		String tAmount = getText(getTransactionCount("1"), "Transaction Count");
		ExtentTestManager.setInfoMessageInReport("Transaction Count Is " + tAmount);
		String val = getText(getValumeAndCommissionAmountCount("1"), "Volume Cyn");
		ExtentTestManager.setInfoMessageInReport("Volume Cyn Is " + val);
		String comm = getText(getValumeAndCommissionAmountCount("2"), "Commission in Cyn");
		ExtentTestManager.setInfoMessageInReport("Commission in Cyn is " + comm);

		click(getLabelItem("Withdraw"), "Withdraw");
		String text1 = getText(getPercentageTransaction("1"), "Withdraw instantPay");
		ExtentTestManager.setInfoMessageInReport("Withdraw percentage " + text1);
		String text2 = getText(getPercentageTransaction("2"), "Withdraw Bank Account");
		ExtentTestManager.setInfoMessageInReport("Withdraw percentage " + text2);
		String text3 = getText(getPercentageTransaction("3"), "Gift card");
		ExtentTestManager.setInfoMessageInReport("Withdraw percentage " + text3);
		String text4 = getText(getPercentageTransaction("4"), "Withdrae cogent");
		ExtentTestManager.setInfoMessageInReport("Withdraw percentage " + text4);
	}

	public void verifyBuyTokenTransaction() {
		String text = getText(getLabelItem("Buy Token"), "Buy Token");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed in the Earnings by category");
		String tAmount = getText(getTransactionCount("2"), "Transaction Count");
		ExtentTestManager.setInfoMessageInReport("Transaction Count Is " + tAmount);
		String val = getText(getValumeAndCommissionAmountCount("3"), "Volume Cyn");
		ExtentTestManager.setInfoMessageInReport("Volume Cyn Is " + val);
		String comm = getText(getValumeAndCommissionAmountCount("4"), "Commission in Cyn");
		ExtentTestManager.setInfoMessageInReport("Commission in Cyn is " + comm);

		click(getLabelItem("Buy Token"), "Buy Token");
		String text1 = getText(getPercentageTransaction("1"), "Buy Token Debit Card");
		ExtentTestManager.setInfoMessageInReport("Buy Token percentage " + text1);
		String text2 = getText(getPercentageTransaction("2"), "Buy Token Credit card");
		ExtentTestManager.setInfoMessageInReport("Buy Token percentage " + text2);
		String text3 = getText(getPercentageTransaction("3"), "Bank Account");
		ExtentTestManager.setInfoMessageInReport("Buy Token percentage " + text3);

	}

	public void verifyPayRequestTransaction() {
		String text = getText(getLabelItem("Pay / Request"), "Pay / Request");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed in the Earnings by category");
		String tAmount = getText(getTransactionCount("3"), "Transaction Count");
		ExtentTestManager.setInfoMessageInReport("Transaction Count Is " + tAmount);
		String val = getText(getValumeAndCommissionAmountCount("5"), "Volume Cyn");
		ExtentTestManager.setInfoMessageInReport("Volume Cyn Is " + val);
		String comm = getText(getValumeAndCommissionAmountCount("6"), "Commission in Cyn");
		ExtentTestManager.setInfoMessageInReport("Commission in Cyn is " + comm);
		click(getLabelItem("Pay / Request"), "Pay / Request");
		String text1 = getText(getPercentageTransaction("1"), "Pay / Request sent");
		ExtentTestManager.setInfoMessageInReport("Pay / Request percentage " + text1);
		String text2 = getText(getPercentageTransaction("2"), "Pay / Request  Receive");
		ExtentTestManager.setInfoMessageInReport("Pay / Request percentage " + text2);

	}

	public void verifySaleOrderTransaction() {
		String text = getText(getLabelItem("Sale Order"), "Sale Order");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed in the Earnings by category");
		String tAmount = getText(getTransactionCount("4"), "Transaction Count");
		ExtentTestManager.setInfoMessageInReport("Transaction Count Is " + tAmount);
		String val = getText(getValumeAndCommissionAmountCount("7"), "Volume Cyn");
		ExtentTestManager.setInfoMessageInReport("Volume Cyn Is " + val);
		String comm = getText(getValumeAndCommissionAmountCount("8"), "Commission in Cyn");
		ExtentTestManager.setInfoMessageInReport("Commission in Cyn is " + comm);
		click(getLabelItem("Sale Order"), "Sale Order");
		String text1 = getText(getPercentageTransaction("1"), "Sale Order eCommerence");
		ExtentTestManager.setInfoMessageInReport("Sale Order percentage " + text1);
		String text2 = getText(getPercentageTransaction("2"), "Sale Order  Retail&Mobile");
		ExtentTestManager.setInfoMessageInReport("Sale Order percentage " + text2);
	}

	public void verifyRefundTransaction() {
		String text = getText(getLabelItem("Refund"), "Refund");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed in the Earnings by category");
		String tAmount = getText(getTransactionCount("5"), "Transaction Count");
		ExtentTestManager.setInfoMessageInReport("Transaction Count Is " + tAmount);
		String val = getText(getValumeAndCommissionAmountCount("9"), "Volume Cyn");
		ExtentTestManager.setInfoMessageInReport("Volume Cyn Is " + val);
		String comm = getText(getValumeAndCommissionAmountCount("10"), "Commission in Cyn");
		ExtentTestManager.setInfoMessageInReport("Commission in Cyn is " + comm);

	}

}
