package coyni.admin.Paymentpages;

import org.openqa.selenium.By;

import coyni.admin.Paymentspopups.ChangeAchAndWireBankPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BankDetailsPage extends BrowserFunctions {

	private By lblBankDeatils = By.xpath("");
	private By lblDescription = By.xpath("");
	private By lnkDeactivate = By.xpath("");
	private By lnkEdit = By.xpath("");
	private By lnkEditAssignedBusinesses = By.xpath("");
	private By chkbxSelectAll = By.xpath("");
	private By lnkCancel = By.xpath("");
	private By btnChangeBank = By.xpath("");

	public void verifyBankName(String bankDetails) {
		new CommonFunctions().verifyLabelText(lblBankDeatils, "Heading is: ", "Bank Deatils");
	}

	public void lblDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Heading is: ", "Description");
	}

	public void clickDeactivated() {
		click(lnkDeactivate, "Deactivated");
	}

	public void clickEdit() {
		click(lnkEdit, "Edit");
	}

	public void clickEditAssignedBusinesses() {
		click(lnkEditAssignedBusinesses, "Edit Assigned Businesses");
	}

	public void clickSelectAll() {
		click(chkbxSelectAll, "Select All");
	}

	public void clickCancel() {
		click(lnkCancel, "Cancel");
	}

	public void clickChangeBank() {
		click(btnChangeBank, "Change Bank");
	}

	public ChangeAchAndWireBankPopup changeAchAndWireBankPopup() {
		return new ChangeAchAndWireBankPopup();

	}

	public BankDetailsPage bankDetailsPage() {
		return new BankDetailsPage();
	}

}
