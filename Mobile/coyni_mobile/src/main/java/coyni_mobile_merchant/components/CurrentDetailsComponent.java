package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.EditAddressPage;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CurrentDetailsComponent extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[contains(@resource-id,'intentName')]");
	private By lblDescription = MobileBy.xpath("//*[contains(@resource-id,'/titleTV')]");
	private By lblCurrentComponent = MobileBy.xpath("//*[contains(@resource-id,'contentTV')]");
	private By btnChange = MobileBy.xpath("//*[contains(@resource-id,'/tvEnableFace')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'dialogCLoseLL')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Current Details Heading ", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Current Details Description", expDescription);
	}

	public void getCurrentDetails() {
		String str = getText(lblCurrentComponent);
		ExtentTestManager.setInfoMessageInReport(str);
	}
//	public void verifyCurrentDetails(String expCurrentDetails) {
//		new CommonFunctions().verifyLabelText(lblCurrentComponent, "Current Details", expCurrentDetails);
//	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void clickChange() {
		click(btnChange, "Change");
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public EditDetailsComponent editDetailsComponent() {
		return new EditDetailsComponent();
	}

	public EditAddressPage editAddressPage() {
		return new EditAddressPage();

	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
