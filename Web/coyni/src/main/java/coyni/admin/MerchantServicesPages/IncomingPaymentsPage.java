package coyni.admin.MerchantServicesPages;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.EntriesAndPaginationsComponent;
import coyni.admin.Paymentcomponents.SideBarComponent;
import coyni.admin.Paymentspopups.CreateNewWirePopup;
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