package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.EntriesAndPaginationsComponent;
import coyni.admin.components.SideBarComponent;
import coyni.admin.popups.CreateNewWirePopup;
import ilabs.WebFramework.BrowserFunctions;

public class IncomingPaymentsPage extends BrowserFunctions {

	private By drpdwnAllStatuses = By.xpath("");
	private By txtSearch = By.xpath("");
	private By btnNewWire = By.xpath("");

	public void selectAllStatuses(String allStuses) {
		selectDropdown(drpdwnAllStatuses, allStuses, "All Statuses");
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public void clickNewWire() {
		click(btnNewWire, "New Wire");
	}

	public SideBarComponent sideBarComponent() {
		return new SideBarComponent();
	}

	public EntriesAndPaginationsComponent entriesAndPaginationsComponent() {
		return new EntriesAndPaginationsComponent();
	}
	public CreateNewWirePopup createNewWirePopup() {
		return new CreateNewWirePopup();
	}

}