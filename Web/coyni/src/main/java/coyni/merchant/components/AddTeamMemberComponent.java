package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.MailHelper;

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
		enterText(txtFirstName, name, "Name");
	}

	public void switchTab() {
		new CommonFunctions().clickOutSideElement();
	}

	public void navigateToUrl(String url) throws Exception {
		new CommonFunctions().switchtoUrl(url);
	}

	public void verifyLastName(String lastName) {
		enterText(txtLastName, lastName, "LastName");
	}

	public void verifyEmail(String email) {
		enterText(txtEmail, email, "Email");
	}



	public String getMail() {
		String str = MailHelper.getRandomMailID();
		return str;
	}

	public String getUrl() {
		// issue with getURL
		String str = MailHelper.getURLFromMail();
		System.out.println(str);
		return str;
	}
	
	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void verifyPhone(String Phone) {
		enterText(txtPhone, Phone, "Phone");
	}

	public void clickSendInvitation() {
		if (getElement(lblSendInvitation, "Send Invitation").isEnabled()) {
			click(lblSendInvitation, "Send Invitation ");
		} else {
			ExtentTestManager.setPassMessageInReport("Send Invitation button is in disabled mode");
		}

	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
