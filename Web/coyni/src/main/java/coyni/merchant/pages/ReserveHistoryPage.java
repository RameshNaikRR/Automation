package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.admin.components.ExportComponent;
import coyni.admin.components.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ReserveHistoryPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[contains(text(),'Reserve Release History')]");

	private By btnRolling = By.xpath("//div[contains(text(),'Rolling')]");

	private By btnManual = By.xpath("//div[contains(text(),'Manual')]");

	private By btnAllStatuses = By.xpath("//p[text()='All Statuses']");

	private By btnOpen = By.xpath("//p[text()='Open']");

	private By btnOnHold = By.xpath("//p[text()='On Hold']");

	private By btnReleased = By.xpath("//p[text()='Released']");

	private By btnCancelled = By.xpath("//p[text()='Cancelled']");

	private By txtSearch = By
			.cssSelector("EditSearchInput_form_input__iuhcE  MerchantReserveHistory_search_bar_gbox__PKxFs");

	private By lnkRolling = By.cssSelector("tbody>tr:nth-of-type(5)>td:nth-of-type(1)");

	private By lnkManual = By.cssSelector("tbody>tr:nth-of-type(5)>td:nth-of-type(1)");

	public void verifyReserveHistory(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Reserve History", expHeading);
	}

	public void fillSearch(String search) {
		enterText(txtSearch, "Search", search);
	}

	public void clickRolling() {
		click(btnRolling, "Rolling");
	}

	public void clickManual() {
		click(btnManual, "Manual");
	}

	public void clickAllStatuses() {
		click(btnAllStatuses, "All Statuses");
	}

	public void clickOpen() {
		click(btnOpen, "Open");
	}

	public void clickOnHold() {
		click(btnOnHold, "On Hold");
	}

	public void clickReleased() {
		click(btnReleased, "Released");
	}

	public void clickCancelled() {
		click(btnCancelled, "Cancelled");
	}

	public ReserveHistoryIDPage reserveHistoryIDPage() {
		return new ReserveHistoryIDPage();
	}

}
