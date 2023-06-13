package coyni.admin.Paymentpages;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.SideBarComponent;
import coyni.admin.Paymentspopups.CreateNewWirePopup;
import ilabs.WebFramework.BrowserFunctions;

public class OutgoingPaymentsPage extends BrowserFunctions {

	private By tabACHs = By.xpath("");
	private By tabWires = By.xpath("");
	private By tabMT = By.xpath("");
	private By btnACHCutoffTimes = By.xpath("");
	private By btnStatusKey = By.xpath("");
	private By txtSearch = By.xpath("");

	public void clickACHs() {
		click(tabACHs, "ACHs");
	}

	public void clickWites() {
		click(tabWires, "Wires");
	}

	public void clickMT() {
		click(tabMT, "MT-103");
	}

	public void clickACHCutoffTimes() {
		click(btnACHCutoffTimes, "ACH Cutoff Times");
	}

	public void clickStatusKey() {
		click(btnStatusKey, "Status Key");
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public SideBarComponent sideBarComponent() {
		return new SideBarComponent();
	}

	public CreateNewWirePopup createNewWirePopup() {
		return new CreateNewWirePopup();
	}

}
