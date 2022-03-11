package coyni.admin.components;

import org.openqa.selenium.By;

//import coyni.admin.pages.ChooseAccountPage;
import coyni.admin.pages.CreatePasswordPage;
import coyni.apibusiness.pages.ChooseAccountPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PhoneEmailVerificationComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("//div[text()='Email Verification']");
	private By lblDescription = By.cssSelector(".text-base");
	private By lblPhoneHeading = By.xpath("//div[text()='Phone Verification']");
	private By lnkResend = By.xpath("//div[text()='Resend Verification Code']");
	// private By txtInput = By.cssSelector(".verification-input-wrapper ");
	private By lnkLogin = By.xpath("");
	private By lnkCoyni = By.xpath("");
	private By lnkBackToLogin = By.xpath("//div[text()='Back to Login']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Email Verification", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Email Verification", expDescription);
	}

	public void verifyPhoneHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblPhoneHeading, "Phone Verification", expHeading);
	}
	public void clickResend() {
		click(lnkResend, " Resend ");

	}
	
	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public void fillpin(String code) {
		new AuthyComponent().fillInput(code);
	}

	public void clickLogin() {
		if (getElement(lnkLogin, "Login").isEnabled()) {
			click(lnkLogin, " Login ");
		} else {
			ExtentTestManager.setInfoMessageInReport(" Login Button is Disabled");
		}
	}

	public void clickCoyni() {
		click(lnkCoyni, "Coyni");
	}

	public void clickBackToLogin() {
		click(lnkBackToLogin, "Back to Login");
	}
	public void verifyMessage(String message) throws InterruptedException {
		new AuthyComponent().verifyMessage(message);
	}

	public CreatePasswordPage createPasswordPage() {
		return new CreatePasswordPage();
	}

	public ChooseAccountPage chooseAccountPage() {
		return new ChooseAccountPage();
	}

}
