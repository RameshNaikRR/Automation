package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.ExportComponent;
import coyni.admin.components.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PayOutsPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[contains(text(),'Payouts')]");

	private By lblPayOutHistory = By.xpath("//span[contains(text(),'Payout History')]");

	private By txtSearch = By.xpath("//input[@class='form-input  payOut_search_bar_gbox__E8xRn mb-2']");

	private By payOut = By.cssSelector("tbody>tr:nth-of-type(3)>td:nth-of-type(1)");

	private static By lblPayoutId = By.cssSelector("tbody>tr:nth-of-type(3)>td:nth-of-type(2)");
	private By lblDate = By.xpath("//td[contains(@class,'cell-col-1 batchId')]");
	private By btnSearch = By.xpath("//button[@type='submit']");
	
	
	//public final  String grpID=getPayoutId();
	
	
	
	public  String getPayoutId() {
		String text = getText(lblPayoutId, "PayOut Id");
		ExtentTestManager.setInfoMessageInReport(text);
		return text;
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPayOutHistory(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPayOutHistory, "Pay Out History", expHeading);
	}

	public void fillSearch() {
		click(txtSearch, "Search to enter");
		enterText(txtSearch, getPayoutId(), "Search");
		click(btnSearch, "Search");
	}

	public void clickPayOut() {
		click(payOut, "Pay Out");
	}

	public void clickPayOutDate() {
		click(lblDate, "Pay Out");
	}

	//// td[contains(@class,'cell-col-1 batchId')]

	public PayOutIDPage payOutIDPage() {
		return new PayOutIDPage();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}
}
