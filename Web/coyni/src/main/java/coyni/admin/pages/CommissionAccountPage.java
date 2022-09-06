package coyni.admin.pages;

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

	private By lblViewFullTransactionHistory = By.xpath("//span[contains(text(),'View Full Transactions History')]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport("Account Balance: " + getText(lblAccountBalance, "Account Balance"));
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
		click(lnkBatchNow, "Batch Now");
	}

	public void clickFullPayOutHistory() {
		click(lblViewFullPayOutHistory, "Full PayOut History");
	}

	public void clickFullTransactionHistory() {
		click(lblViewFullTransactionHistory, "Full Transaction History");
	}

	public DaysMonthsDropDownComponent daysMonthsDropDownComponent() {
		return new DaysMonthsDropDownComponent();
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

}

