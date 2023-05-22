package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.EntriesAndPaginationsComponent;
import coyni.admin.components.ExportComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BalanceReportPage extends BrowserFunctions {

	private By lblBalanceReports = By.xpath("");
	private By lblTotalBalance = By.xpath("");
	private By lblAmount = By.xpath("");
	private By txtSearch = By.xpath("");

	public void verifyBalanceReport(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBalanceReports, "Heading is: ", expHeading);
	}

	public void verifyTotalBalance(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTotalBalance, "Heading is: ", expHeading);
	}

	public String getAmount() {
		String amount = getText(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("amount is: " + amount);
		return amount;
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}

	public EntriesAndPaginationsComponent entriesAndPaginationsComponent() {
		return new EntriesAndPaginationsComponent();
	}

}
