package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.EntriesAndPaginationsComponent;
import coyni.admin.components.ExportComponent;
import coyni.admin.components.FilterComponent;
import ilabs.WebFramework.BrowserFunctions;

public class UnderwritingPage extends BrowserFunctions {

	private By btnStatusKey = By.xpath("");
	private By txtSearch = By.xpath("");

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

	public EntriesAndPaginationsComponent entriesAndPaginationsComponent() {
		return new EntriesAndPaginationsComponent();
	}
}
