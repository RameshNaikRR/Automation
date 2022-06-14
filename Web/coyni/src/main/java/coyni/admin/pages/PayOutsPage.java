package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.ExportComponent;
import coyni.admin.components.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PayOutsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[contains(text(),'Payouts')]");

	private By lblPayOutHistory = By.xpath("//span[contains(text(),'Payout History')]");

	private By txtSearch = By.xpath("//input[@class='form-input  payOut_search_bar_gbox__zmdaq mb-2']");

	private By payOut = By.cssSelector("tbody>tr:nth-of-type(2)>td:nth-of-type(1)");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPayOutHistory(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutHistory, "Pay Out History", expHeading);
	}

	public void fillSearch(String search) {
		enterText(txtSearch, "Search", search);
	}

	public void clickPayOut() {
		click(payOut, "Pay Out");
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}
}
