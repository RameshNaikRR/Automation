package coyni.admin.MerchantServicesPages;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.EntriesAndPaginationsComponent;
import coyni.admin.Paymentcomponents.ExportComponent;
import coyni.admin.Paymentcomponents.FilterComponent;
import ilabs.WebFramework.BrowserFunctions;

public class UnderwritingPage extends BrowserFunctions {

	private By btnStatusKey = By.xpath("");
	private By txtSearch = By.xpath("");
	private By btnDropDown = By.xpath("");
	private By btnAssignePlus = By.xpath("");

	public void clickAssignee() {
		click(btnAssignePlus, "Add Assignee");
	}

	public void clickStatuskey() {
		click(btnStatusKey, "Status Key");
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}

	public FilterComponent component() {
		return new FilterComponent();
	}

	public EntriesAndPaginationsComponent entriesAndPaginationsComponent() {
		return new EntriesAndPaginationsComponent();
	}
}
