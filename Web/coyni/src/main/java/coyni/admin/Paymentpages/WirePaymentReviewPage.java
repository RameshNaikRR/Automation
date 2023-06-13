package coyni.admin.Paymentpages;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.EntriesAndPaginationsComponent;
import coyni.admin.Paymentcomponents.SideBarComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WirePaymentReviewPage extends BrowserFunctions {

	private By lblPaymentReview = By.xpath("");
	private By tabACHs = By.xpath("");
	private By tabWires = By.xpath("");
	private By drpDown = By.xpath("");
	private By btnStatusKey = By.xpath("");
	private By txtSearch = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyPaymentReview(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPaymentReview, "Heading is: ", expHeading);
	}

	public void clickACHs() {
		click(tabACHs, "ACHs");
	}

	public void clickWires() {
		click(tabWires, "Wires");
	}

	public void selectDropDown(String drpDwn) {
		selectDropdown(drpDown, drpDwn, "DropDown");
	}

	public void clickStatusKey() {
		click(btnStatusKey, "Status Key");
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

	public SideBarComponent sideBarComponent() {
		return new SideBarComponent();
	}

	public EntriesAndPaginationsComponent entriesAndPaginationsComponent() {
		return new EntriesAndPaginationsComponent();
	}

}
