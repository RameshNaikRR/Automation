package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.merchant.popups.AddCustomRolePopup;
import coyni.merchant.popups.FiltersPage;
import coyni.merchant.popups.SaveChangePopUp;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddTeamMemberComponent extends BrowserFunctions {
	

	private By lblAddTeam = By.xpath("//span[text()='Add New Team Member']");
	private By txtFirstName = By.xpath("//input[@name='firstName']");
	private By txtLastName = By.xpath("//input[@name='lastName']");
	private By txtEmail = By.xpath("//input[@name='email']");
	private By txtPhone = By.xpath("//input[@name='phoneNumber']");
	private By lblSendInvitation = By.xpath("//button[text()='Send Invitation']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddTeam, "Add New Team", expHeading);
	}

	public void verifyFirstName(String name) {
		enterText(txtFirstName, "Name", name);
	}

	public void verifyLastName(String lastName) {
		enterText(txtLastName, "LastName", lastName);
	}

	public void verifyEmail(String email) {
		enterText(txtEmail, "Email", email);
	}

	public void verifyPhone(String Phone) {
		enterText(txtPhone, "Phone", Phone);
	}

	public void clickSendInvitation() {
		if (getElement(lblSendInvitation, "Send Invitation").isEnabled()) {
			click(lblSendInvitation, "Send Invitation ");
		} else {
			ExtentTestManager.setPassMessageInReport("Send Invitation button is in disabled mode");
		}

	}
}
