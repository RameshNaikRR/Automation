package coyni.admin.Paymentspopups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CountryNamePopup extends BrowserFunctions {

	private By lblCountryName = By.xpath("");
	private By lnkEditCountry = By.xpath("");
	private By crossClose = By.xpath("");
	private By txtNote = By.xpath("");
	private By chkbx = By.xpath("");
	private By btnSave = By.xpath("");

	public void verifyCountryName(String expHeading) {
		new CommonFunctions().verifyLabelText(lblCountryName, "Heading is: ", expHeading);
	}

	public void clickEditCountry() {
		click(lnkEditCountry, "Edit Country");
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

	public void fillNote(String note) {
		enterText(txtNote, note, "Note");
	}

	public void clickCheckBox() {
		click(chkbx, "Check Box");
	}

	public void clickSave() {
		if (getElement(btnSave, "Save").isEnabled()) {
			click(btnSave, "Save");
			ExtentTestManager.setPassMessageInReport("Save Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Save Button is Disabled");
		}
	}

	private By getRadioButton(String elementName) {
		return By.xpath(String.format("//span[text()='%s']//preceding-sibling::input", elementName));
	}

	public void clickLowRisk() {
		click(getRadioButton("Low Risk"), "Low Risk");
	}

	public void clickMediumRisk() {
		click(getRadioButton("Medium Risk"), "Medium Risk");
	}

	public void clickHighRisk() {
		click(getRadioButton("High Risk"), "High Risk");
	}

	public void clickSactioned() {
		click(getRadioButton("Sactioned"), "Sactioned");
	}

	public void clickIBAN() {
		click(getRadioButton("IBAN"), "IBAN");
	}

	public void clickBankAccount() {
		click(getRadioButton("Bank Account"), "Bank Account");
	}

}
