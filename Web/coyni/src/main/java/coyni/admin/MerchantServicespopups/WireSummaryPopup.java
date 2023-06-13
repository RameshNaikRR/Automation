package coyni.admin.MerchantServicespopups;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WireSummaryPopup extends BrowserFunctions {

	private By lblWireSummary = By.xpath("");
	private By lblAmount = By.xpath("");
	private By btnConfirm = By.xpath("");
	private By backArrow = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyWireSummary(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWireSummary, "Heading is: ", expHeading);
	}

	public String getAmount() {
		String amount = getText(lblAmount, "Amount");
		ExtentTestManager.setInfoMessageInReport("amount is: " + amount);
		return amount;
	}

	public void clickConfirm() {
		if (getElement(btnConfirm, "Confirm").isEnabled()) {
			click(btnConfirm, "Amount");
			ExtentTestManager.setPassMessageInReport("Confirm Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Confirm Button is Disabled");
		}
	}

	public void clickBackArrow() {
		click(backArrow, "Back Arrow");
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}
