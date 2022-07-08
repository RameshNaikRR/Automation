package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.admin.components.ExportComponent;
import coyni.admin.components.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PayOutHistoryPage extends BrowserFunctions {

	private By lblPayOutHistory = By.xpath("//h1[.='Payout History']");

	private By txtSearch = By.xpath("//input[@class='form-input  payOut_search_bar_gbox__zmdaq mb-2']");

	private By payOut = By.cssSelector("tbody>tr:nth-of-type(3)>td:nth-of-type(1)");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutHistory, "Pay Out History page heading", expHeading);
	}

	public void fillSearch(String search) {
		enterText(txtSearch, "Search", search);
	}

	public void clickPayOut() {
		click(payOut, "Pay Out");
	}

	public PayOutIDPage payOutIDPage() {
		return new PayOutIDPage();
	}

}
