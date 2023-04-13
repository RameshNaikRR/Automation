package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.EnterYourPINComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PreAuthorizationPage extends MobileFunctions {

	private By heading = MobileBy.xpath("//*[@text='Pre-Authorization']");
	private By lblPreauthDescription = MobileBy.xpath("//*[contains(@resource-id,'tvMessage')]");
	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By btnVerify = MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");
	

	public void fillAmount(String amount) throws InterruptedException {
//		enterText(txtAmount, amount, "amount");
		new EnterYourPINComponent().fillPin(amount);

	}
	public void verifyPreAuthHeading(String expHeading, String expDescription) {
		new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
		new CommonFunctions().verifyLabelText(lblPreauthDescription, "Pre Auth Description", expDescription);
	}

	public void clickVerify() {
		click(btnVerify, "Verify");
	}
	
	public AllDonePage allDonePage() {
		return new AllDonePage();
	}
	public PreAuthorizationFailedPage preAuthorizationFailedPage() {
		return new PreAuthorizationFailedPage();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
