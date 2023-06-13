package coyni.admin.Paymentpages;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.EntriesAndPaginationsComponent;
import coyni.admin.Paymentcomponents.FilterComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PaymentsPage extends BrowserFunctions {

	private By lblPaymentsHeading = By.xpath("");
	private By tabACHs = By.xpath("");
	private By tabWires = By.xpath("");
	private By tabBankConfiguration = By.xpath("");
	private By lblACHSummary = By.xpath("");
	private By txtSearch = By.xpath("");
	private By lnkACHSummary = By.xpath("");
	private By lblWireSummary = By.xpath("");
	private By lblBankConfiguration = By.xpath("");
	private By lnkEditACHBank = By.xpath("");
	private By lnkEditWireBank = By.xpath("");
	private By drpdwnCogentBank = By.xpath("");
	private By btnCancel = By.xpath("");
	private By btnSave = By.xpath("");

	public void verifyBusinessProfiles(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPaymentsHeading, "Payments Heading is: ", expHeading);
	}

	public void clickTabACHs() {
		click(tabACHs, "ACHs");
	}

	public void clickWires() {
		click(tabWires, "Wires");
	}

	public void clickBankConfiguration() {
		click(tabBankConfiguration, "Bank Configuration");
	}

	public void verifyACHSummary(String expHeading) {
		new CommonFunctions().verifyLabelText(lblACHSummary, "Heading is: ", expHeading);
	}

	public void verifyWireSummary(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWireSummary, "Heading is: ", expHeading);
	}

	public void verifyBankConfiguration(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBankConfiguration, "Heading is: ", expHeading);
	}

	public void fillSearch(String search) {
		enterText(txtSearch, search, "Serach");
	}

	public void clickACHSummary() {
		click(lnkACHSummary, "ACH Summary");
	}

	public void clickEditACHBank() {
		click(lnkEditACHBank, "Edit ACH Bank");
	}

	public void clickEditWireBank() {
		click(lnkEditWireBank, "Edit Wire Bank");
	}

	public void selectCogentBank(String cogentBank) {
		selectDropdown(drpdwnCogentBank, cogentBank, "Cogent Bank");
	}

	public void clickCancel() {
		if (getElement(btnCancel, "Cancel").isEnabled()) {
			click(btnCancel, "Cancel");
			ExtentTestManager.setPassMessageInReport("Cancel Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Cancel Button is Disabled");
		}

	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
			ExtentTestManager.setPassMessageInReport("Save Button is Enabled");
		} else {
			ExtentTestManager.setPassMessageInReport("Save Button is Disabled");
		}

	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public EntriesAndPaginationsComponent entriesAndPaginationsComponent() {
		return new EntriesAndPaginationsComponent();
	}

}
