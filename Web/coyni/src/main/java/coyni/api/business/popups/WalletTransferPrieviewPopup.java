package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WalletTransferPrieviewPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Wallet Transfer Preview']");
	private By btnConfirm = By.xpath("//button[.='Confirm']");

	private By lblAmount = By.xpath("//p[.='2.00']");

	private By getLblItems(String elementName) {
		return By.xpath(String.format(elementName, "//span[text()='%s']//following-sibling::span"));
	}

	public void VerifyTransferFromView() {
		new CommonFunctions().elementView(getLblItems("Transferring from:"), "Transferring from");
	}

	public void verifyTransferToView() {
		new CommonFunctions().elementView(getLblItems("Transferring to:"), "Transferring to");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}
	public void verifyWalletTransferPreviewPopupHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", heading);
	}
    

	public void verifyAmount(String expAmount) {
		String actAmount = getTextBoxValue(lblAmount, "Amount");
		if (actAmount.equals(expAmount)) {
			ExtentTestManager.setPassMessageInReport("Amount is verified ");
		}
		else {
			ExtentTestManager.setFailMessageInReport("Amount is not verified ");
		}
	}

	public void clickConfirm() {
		click(btnConfirm, "Confirm");
	}
	public VerifyYourIdentityPopup verifyYourIdentityPopup() {
		return new VerifyYourIdentityPopup();
	}
}
