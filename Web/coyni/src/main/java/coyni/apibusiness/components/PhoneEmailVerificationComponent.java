package coyni.apibusiness.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.admin.pages.ChooseAccountPage;
import coyni.admin.pages.CreatePasswordPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PhoneEmailVerificationComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("//div[text()='Email Verification']");
	private By lblDescription = By.cssSelector(".text-base");
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

	public void clickResend() {
		click(lnkResend, " Resend ");

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

	public CreatePasswordPage createPasswordPage() {
		return new CreatePasswordPage();
	}

	public ChooseAccountPage chooseAccountPage() {
		return new ChooseAccountPage();
	}

}
