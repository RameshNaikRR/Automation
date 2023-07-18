package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessInviteComponent extends BrowserFunctions {

	private By lblInvite = By.xpath("//span[text()='Business Account Invite']");
	private By btnNewAccount = By.xpath("//div[text()='Create New Account']");
	private By lblCreateNewAccount = By.xpath("//span[text()='Create New Business Account']");

	public void verifyInviteHeading(String data) {
		new CommonFunctions().verifyLabelText(lblInvite, "Business Account Invite", data);
	}

	public void verifyCreateAccountHeading(String data) {
		new CommonFunctions().verifyLabelText(lblCreateNewAccount, "Create New Business Account", data);
	}

	public void clickNewAccount() {
		click(btnNewAccount, "New Account");
	}

	public ActivateAccountComponent activateAccountComponent() {
		return new ActivateAccountComponent();
	}

}
