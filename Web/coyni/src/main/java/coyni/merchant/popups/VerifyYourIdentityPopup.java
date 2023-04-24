package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.NavigationComponent;
import coyni.merchant.components.PhoneVerificationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class VerifyYourIdentityPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Verify Your Identity']");
	private By lblDescription = By.xpath("//h3[contains(.,'Enter the code')]");
	private By lblMsg = By.xpath("//div[text()='Having an issue with your authentication app?']");
	private By lnkSmsCode = By.xpath("//span[text()='Get an SMS code.']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription() {
		String text = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyMsg() {
		String msg = getText(lblMsg, "");
		ExtentTestManager.setInfoMessageInReport(msg + " is displayed");
	}

	public void verifyLink() {
		new CommonFunctions().elementView(lnkSmsCode, "Get An SMS Code");
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

//	public TransactionSuccessfulPopup transactionSuccessfulPopup() {
//		return new TransactionSuccessfulPopup();
//	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public TransactionInProgessPopup transactionInProgessPopup() {
		return new TransactionInProgessPopup();
	}

	public PhoneVerificationComponent phoneVerificationComponent() {
		return new PhoneVerificationComponent();
	}
}
