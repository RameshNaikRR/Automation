package coyni.admin.Paymentcomponents;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantResendAndCancelComponent extends BrowserFunctions {

	private By btnMerchantName = By.xpath("(//p[text()='Ideyalabs'])[1]");

	private By lblHeading = By.xpath("//h1[text()='Pending Merchant Invite']");

	private By btnResendInvite = By.xpath("//button[text()='Resend Invite']");
	private By btnCancelInvite = By.xpath("//button[text()='Cancel Invite']");
	private By lblcancelHeading = By.xpath("//h1[text()='Cancel Merchant Invite']");
	private By lblName = By.xpath("(//p[contains(@class,'ml-8')])[1]");

	public void ClickMerchantUserBasedOnMerchantName() {
		if (getElement(btnMerchantName, "Merchant Name").isDisplayed()) {
			click(btnMerchantName, "Click Merchant Based On Merchant Name");
		} else {
			ExtentTestManager.setInfoMessageInReport("Merchant not present in the List");
		}
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Pending Merchant Invite", expHeading);
	}

	public void clickResendInvite() {
		click(btnResendInvite, "ResendInvite");
	}

	public void clickCancelInvite() {
		click(btnCancelInvite, "CancelInvite");
	}


public void VerifyCancelHeading(String data) {
	new CommonFunctions().verifyLabelText(lblcancelHeading, "Cancel Merchant Invite", data);
}
	

	public String getName() {
		String text = getText(lblName, "Full Name");
		return text;
	}

	public MerchantEditInviteComponent merchantEditInviteComponent() {
		return new MerchantEditInviteComponent();

	}
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
