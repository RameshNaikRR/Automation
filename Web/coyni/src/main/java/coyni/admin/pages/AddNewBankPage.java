package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddNewBankPage extends BrowserFunctions {

	private By lblAddNewBank = By.xpath("");
	private By txtBankName = By.xpath("");
	private By drpdwnType = By.xpath("");
	private By txtBankDescription = By.xpath("");
	private By drpdwnBusiness = By.xpath("");
	private By drpdwnCompliance = By.xpath("");
	private By drpdwnAccounting = By.xpath("");
	private By drpdwnBank = By.xpath("");
	private By drpdwnSelectType = By.xpath("");
	private By btnCancel = By.xpath("");
	private By btnSave = By.xpath("");
	private By lnkAmount = By.xpath("");
	private By lnkReference = By.xpath("");
	private By crossClose = By.xpath("");
	private By drpdwnIntegrationPartner = By.xpath("");
	private By txtAPIKey = By.xpath("");
	private By txtUserName = By.xpath("");
	private By txtPassword = By.xpath("");

	public void verifyAddNewBank(String addNewBank) {
		new CommonFunctions().verifyLabelText(lblAddNewBank, "Heading is: ", addNewBank);
	}

	public void fillBankName(String bankName) {
		enterText(txtBankName, bankName, "Bank Name");
	}

	public void selectType(String type) {
		selectDropdown(drpdwnType, type, "Type");
	}

	public void fillBankDescription(String bankDescription) {
		selectDropdown(txtBankDescription, bankDescription, "Bank Description");
	}

	public void selectBusiness(String business) {
		selectDropdown(drpdwnBusiness, business, "Business");
	}

	public void selectCompliance(String compliance) {
		selectDropdown(drpdwnCompliance, compliance, "Compliance");
	}

	public void selectAccounting(String accounting) {
		selectDropdown(drpdwnAccounting, accounting, "Accounting");
	}

	public void selectBank(String bank) {
		selectDropdown(drpdwnBank, bank, "Bank");
	}

	public void type(String selectType) {
		selectDropdown(drpdwnSelectType, selectType, "Select Type");
	}

	public void clickCancel() {
		if (getElement(btnCancel, "Cancel").isEnabled()) {
			click(btnCancel, "Cancel");
			ExtentTestManager.setPassMessageInReport("Cancel button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Cancel button is Disabled");
		}
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
			ExtentTestManager.setPassMessageInReport("Save button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Save button is Disabled");
		}
	}

	public void clickAmount() {
		click(lnkAmount, "Amount");
	}

	public void clickReference() {
		click(lnkReference, "Reference");
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

	public void selectInegrationPartner(String integrationPartner) {
		selectDropdown(drpdwnIntegrationPartner, integrationPartner, "Integration Partner");
	}

	public void fillAPIKeys(String apiKeys) {
		enterText(txtAPIKey, apiKeys, "API Key");
	}

	public void fillUserName(String userName) {
		enterText(txtUserName, userName, "User Name");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
	}
	
	public BankDetailsPage bankDetailsPage() {
		return new BankDetailsPage();
	}

}
