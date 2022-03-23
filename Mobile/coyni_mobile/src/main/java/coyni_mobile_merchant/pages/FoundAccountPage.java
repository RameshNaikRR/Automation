package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.NavigationComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class FoundAccountPage extends MobileFunctions {
	private By lblHeading = MobileBy.xpath("//*[@text='We’ve Found Your Account!']");
	private By lblDescription = MobileBy.xpath("//*[@text='Click the Link below to log in']");
	private By btnCoyniAccount = MobileBy.xpath("//*[contains(@resource-id,'tvEmail')]/../following-sibling::*[1]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'lyClose')]/*[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", expDescription);
	}

	public void verifyCoyniAccountView() {
		new CommonFunctions().elementView(btnCoyniAccount, "Coyni Account");
	}

	public void verifyCloseIconView() {
		new CommonFunctions().elementView(btnClose, "Close Icon");
	}

	public void clickCoyniAccount() {
		click(btnCoyniAccount, "Coyni Account");
	}

	public void clickCloseIcon() {
		click(btnClose, "Close");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
