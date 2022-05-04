package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PreferencesComponent extends MobileFunctions {

	private By lblPreferencesHeading = MobileBy.xpath("");
	private By drpDwnTimeZone = MobileBy.xpath("");
	private By lblLocalCurrency = MobileBy.xpath("");
	private By lblVerifyDefaultHeading = MobileBy.xpath("");
	private By lblDefaultAccount = MobileBy.xpath("");
	private By IconBackArrow = MobileBy.xpath("");
	private By txtTimeZone = MobileBy.xpath("");
	private By btnDone = MobileBy.xpath("");

	public void verifyPreferencesHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblPreferencesHeading, "Preferences Heading is", heading);
	}

	public void selectTimeZone(String timeZone) {
		click(drpDwnTimeZone, "Time Zone DropDown");
		ExtentTestManager.setInfoMessageInReport("Clicked on Element " + timeZone);
		getElementList(MobileBy.xpath(String.format("//*[@text='%s']", timeZone)), "Time Zone");
		new CommonFunctions().clickEnter();
		click(btnDone, "Done");
//		 selectDropdownOption(drpDwnTimeZone, txtTimeZone, "click on Drop Down", timeZone);
//		 click(btnDone, "Done");
	}

	public void verifyDefaultAccount(String heading) {
		new CommonFunctions().verifyLabelText(lblDefaultAccount, heading, "Default Account");
	}

	public void clickBackArrow() {
		click(IconBackArrow, "Back Arrow");

	}

}
