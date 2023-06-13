package coyni.admin.Paymentpages;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.EntriesAndPaginationsComponent;
import coyni.admin.Paymentcomponents.ExportComponent;
import coyni.admin.Paymentcomponents.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WalletPage extends BrowserFunctions {

	private By lblWallets = By.xpath("");
	private By txtSearch = By.xpath("");
	private By lblTotalBalance = By.xpath("");
	private By lblAvalableFunds = By.xpath("");

	public void verifyWallets(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWallets, "Heading is: ", expHeading);
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public String getTotalBalance() {
		String text = getText(lblTotalBalance, "Total Balance");
		ExtentTestManager.setInfoMessageInReport("Total Balance is: " + text);
		return text;
	}

	public String getAvailableFunds() {
		String text = getText(lblAvalableFunds, "");
		ExtentTestManager.setInfoMessageInReport("Available Funds is: " + text);
		return text;
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}

	public EntriesAndPaginationsComponent entriesAndPaginationsComponent() {
		return new EntriesAndPaginationsComponent();
	}

}
