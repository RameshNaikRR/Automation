package coyni.business.pages;

import org.openqa.selenium.By;
import coyni.business.components.AuthyComponent;
import coyni.business.components.PhoneVerificationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TwoStepAuthenticationPage extends BrowserFunctions {

	private By lblHeading = By.xpath("(//span[.='2-Step Authentication'])[2]");

	private By btnReconfigure = By.xpath("//button[contains(text(),'Reconfigure')]");

	private By lblMessage = By
			.xpath("//p[contains(text(),'Your 2-Step Authentication Was Reconfigured Successfully!')]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Two step authentication", Heading);
	}

	public void clickReconfigure() {
		click(btnReconfigure, "Reconfigure");
	}

	public void getMessage() {
		ExtentTestManager.setInfoMessageInReport("Message: " + getText(lblMessage, "Successfull Message"));
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public ReConfigturationTwoStepAuthenticationPage reConfigturationTwoStepAuthenticationPage() {
		return new ReConfigturationTwoStepAuthenticationPage();
	}

}
