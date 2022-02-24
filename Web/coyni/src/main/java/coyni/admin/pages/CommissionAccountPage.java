package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CommissionAccountPage extends BrowserFunctions {

	private By lblHeading = By.xpath("");

	private By lblCommissionActivity = By.xpath("");

	private By lblAccountBalance = By.xpath("");

	private By lblBatchPayOuts = By.xpath("");

	private By lnkBatchNow = By.xpath("");

	private By lblViewFullPayOutHistory = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void getAccountBalance() {
		ExtentTestManager.setInfoMessageInReport("Phone Number: " + getText(lblAccountBalance, "Account Balance"));
	}

	public void getBatchPayOuts() {
		ExtentTestManager.setInfoMessageInReport("Phone Number: " + getText(lblBatchPayOuts, "Batch PayOuts"));
	}

	public void clickBatchNow() {
		click(lnkBatchNow, "Batch Now");
	}

	public void clickFullPayOutHistory() {
		click(lblViewFullPayOutHistory, "Full PayOut History");
	}
}
