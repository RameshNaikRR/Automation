package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.EmailVerificationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class ForgotPasswordPage extends MobileFunctions {

	private By forgotHeading = MobileBy
			.xpath("//*[contains(@resource-id,'tvHead')]|//*[@name='Forgot Your Password?']");
	private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'etEmail')]|//*[@name='Email']");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'llClose')]");
	private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]|(//*[@name='Next'])[1]");
	private By contentForgot = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]|//*[contains(@name,'Before')]");

	private By popErrorMessage = MobileBy.xpath("//*[contains(@resource-id,'textTV')]"); //
	private By popHeading = MobileBy.xpath("//*[@text='Coyni']");

	public void verifyPopEHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(popHeading, "PopUp Heading ", expHeading);
	}

	public void verifyPopErrMessa(String expHeading) {
		new CommonFunctions().verifyLabelText(popErrorMessage, "User data not found ", expHeading);
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(forgotHeading, "Forgot Password ", expHeading);
	}

	public void verifyContentHeading(String expContent) {
		new CommonFunctions().verifyLabelText(contentForgot, "Forgot Content ", expContent);
	}

	public void fillEmail(String email) {
		enterText(txtEmail, email, "Email");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void clickNext() {
		new CommonFunctions().clickTab();
		boolean enabled = new MobileFunctions().getElement(btnNext, "").isEnabled();
		if (enabled) {
			click(btnNext, "Next");
			ExtentTestManager.setPassMessageInReport("Next button is in Disabled mode");
		} else {
			ExtentTestManager.setInfoMessageInReport("Next button is in Enable mode");
		}
	}

	public EmailVerificationComponent verifyEmailComponent() {
		return new EmailVerificationComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public CreatePasswordPage createPasswordPage() {
		return new CreatePasswordPage();
	}

	public void validateEmailField(String minChar, String minCharPlus, String maxLessChar, String maxChar,
			String moreThanMax) {

		new CommonFunctions().validateFieldMaxichar(txtEmail, "Email", moreThanMax);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", minChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", minCharPlus);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxLessChar);
		new CommonFunctions().clearText(txtEmail, "Email");
		new CommonFunctions().validateField(txtEmail, "Email", maxChar);

	}
}