package coyni.admin.MerchantServicespopups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ChangeAchAndWireBankPopup extends BrowserFunctions {

	private By lblChangeBank = By.xpath("");
	private By lblDescription = By.xpath("");
	private By txtReason = By.xpath("");
	private By crossMark = By.xpath("");
	private By btnChangeBank = By.xpath("");
	private By drpdwnSelectedBankName = By.xpath("");

	public void verifyChangeBank(String changeBank) {
		new CommonFunctions().verifyLabelText(lblChangeBank, "Heading is: ", changeBank);
	}

	public void verifyChangeBankDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Heading is: ", description);
	}

	public void fillReason(String reason) {
		enterText(txtReason, reason, "Reason");
	}

	public void clickCrossMark() {
		click(crossMark, "Cross Mark");
	}

	public void clickChangeBank() {
		if (getElement(btnChangeBank, "Change Bank").isEnabled()) {
			click(btnChangeBank, "Change Bank");
			ExtentTestManager.setPassMessageInReport("Change Bank Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Change Bank Button is Disabled");
		}

	}
	public void selectedBankName(String selectedBankName) {
		selectDropdown(drpdwnSelectedBankName, selectedBankName, "Selected Bank Name");
	}

}
