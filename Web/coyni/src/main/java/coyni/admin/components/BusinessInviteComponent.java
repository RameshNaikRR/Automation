package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.MailHelper;

public class BusinessInviteComponent extends BrowserFunctions {

	private By lblInvite = By.xpath("//span[text()='Business Account Invite']");
	private By btnNewAccount = By.xpath("//div[text()='Create New Account']");
	private By lblCreateNewAccount = By.xpath("//span[text()='Create New Business Account']");
	private By lblAddToExistingAccount = By.xpath("//div[text()='Add to Existing Account']");
	private By btnCheckBox = By.xpath("//input[@type='checkbox']");
	private By txtEmail = By.xpath("//input[@data-ui-auto='login_email_field']");
	private By txtPassword = By.xpath("//input[@data-ui-auto='login_password_field']");
	private By eyeIcon = By.cssSelector(".icon-button");
	private By btnNext = By.xpath("//button[@data-ui-auto='login_next_button']");
	private By clickonAccount=By.xpath("//div[@class=' text-center truncate DashboardMenu_username__WkUW+']");

	public void verifyInviteHeading(String data) {
		new CommonFunctions().verifyLabelText(lblInvite, "Business Account Invite", data);
	}

	public String getUrl() {
		String str = MailHelper.getURLFromMail();
		return str;
	}

	public void navigateUrl(String url) throws InterruptedException {
		new CommonFunctions().switchtoUrl(url);
	}

	public void verifyCreateAccountHeading(String data) {
		new CommonFunctions().verifyLabelText(lblCreateNewAccount, "Create New Business Account", data);
	}
	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, password, "Password");
	}
	

	public void clickEyeIcon() {
		click(eyeIcon, "EyeIcon");
	}

	public void clickNext() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next button is Enabled");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}

	public void clickNewAccount() {
		click(btnNewAccount, "New Account");
	}
	public void clickOnAccount() {
		click(clickonAccount, "Existing Account");
	}

	public void clickAddToExistingAccount() {
		click(lblAddToExistingAccount, "Add To Existing Account");
	}
	public void clickExistingAccountCheckBox() {
		click(btnCheckBox, "checkBox");
	}

	public ActivateAccountComponent activateAccountComponent() {
		return new ActivateAccountComponent();
	}

}
