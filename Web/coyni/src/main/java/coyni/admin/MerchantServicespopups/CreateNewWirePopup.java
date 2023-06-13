package coyni.admin.MerchantServicespopups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CreateNewWirePopup extends BrowserFunctions {

	private By lblCreateNewWire = By.xpath("");
	private By lblDescription = By.xpath("");
	private By txtSearch = By.xpath("");
	private By btnNext = By.xpath("");
	private By crossClose = By.xpath("");
	private By backArrow = By.xpath("");
	private By txtWireAmount = By.xpath("");
	private By txtInternalNote = By.xpath("");

	public void verifyCreateNewWire(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCreateNewWire, "Heading is: ", expHeading);
	}

	public void verifyDescription(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDescription, "Heading is: ", expHeading);
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Search");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

	public void clickBackArrow() {
		click(backArrow, "Back Arrow");
	}

	public void fillWireAmount(String wireAmount) {
		enterText(txtWireAmount, wireAmount, "Wire Amount");
	}

	public void fillInternalNote(String internalAmount) {
		enterText(txtInternalNote, internalAmount, "Internal Amount");
	}

	public WireSummaryPopup wireSummaryPopup() {
		return new WireSummaryPopup();
	}

}
