package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.business.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RemovePaymentMethodPopup extends BrowserFunctions {

	private By lblRemovePaymentHeading = By.xpath("//h1[text()='Remove Payment Method']");
	private By lblRemovePayDesc = By.xpath("//span[@class='text-cgy4']");
	private By lblRemovePaymentDes = By.xpath("//span[@class='text-cgy4']/following-sibling::span");
	private By btnRemove = By.xpath("//button[text()='Remove']");
	private By backArrow = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyRemovePaymentHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblRemovePaymentHeading, "Heading ", expHeading);
	}

	public void verifyRemovePayDescription(String expDes) {
//		new CommonFunctions().verifyLabelText(lblRemovePayDesc, "Description is: ", expDes);
		String expDesc = getText(lblRemovePayDesc, expDes);
		ExtentTestManager.setInfoMessageInReport(expDesc);
	}

	public void verifyRemovePaymentDescription(String expDes) {
//		new CommonFunctions().verifyLabelText(lblRemovePaymentDes, "Description is: ", expDes);
		String expDesc = getText(lblRemovePaymentDes, expDes);
		ExtentTestManager.setInfoMessageInReport(expDesc);
	}

	public void clickRemove() {
		new CommonFunctions().verifyCursorAction(btnRemove, "Remove");
		if (getElement(btnRemove, "Remove").isEnabled()) {
			click(btnRemove, "Remove");
			ExtentTestManager.setInfoMessageInReport("Remove Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("Remove Button is Disabled");
		}
	}

	public void clickClose() {
		new CommonFunctions().verifyCursorAction(crossClose, "Close");
		click(crossClose, "Close");
	}

	public void clickBackArrow() {
		new CommonFunctions().verifyCursorAction(backArrow, "Back Arrow");
		click(backArrow, "Back Arrow");
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
