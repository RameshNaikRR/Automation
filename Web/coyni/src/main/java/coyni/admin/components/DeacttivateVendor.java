package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class DeacttivateVendor extends BrowserFunctions {

	private By btnDeactivate = By.xpath("//button[text()='Deactivate Vendor'] | //button[text()='Deactivate']");
	private By lblDeactivateHeading = By.xpath("//h1[text()='Deactivate Vendor?']");
	private By btnCheckBox = By.xpath("//input[@type='checkbox']");

	// private By btnDeactivate=By.xpath("//button[text()='Deactivate']");

	public void clickDeactivate() {
		click(btnDeactivate, "Deactivate");
	}

	public void verifyDeactivateHeading(String heading) {
		new CommonFunctions().verifyLabelTextContains(lblDeactivateHeading, "Deactivate Vendor", heading);
	}

	public void clickCheckbox() {
		moveToElement(btnCheckBox, "Check Box");
		click(btnCheckBox, "CheckBox");
	}
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
