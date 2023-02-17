package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PreferencesComponent extends MobileFunctions {
	private By lblPreferencesHeading = MobileBy.xpath("//*[@text='Preferences']");
	private By drpDwnTimeZone = MobileBy.xpath("//*[contains(@resource-id,'timeZoneET')]");
	private By lblLocalCurrency = MobileBy.xpath("//*[@text='US dollar']");
	private By lblVerifyDefaultHeading = MobileBy.xpath("");
	private By lblDefaultAccount = MobileBy.xpath("//*[@text='Default Account']");
	private By IconBackArrow = MobileBy.xpath("//*[contains(@resource-id,'preferencesCloseLL')]");
	private By txtTimeZone = MobileBy.xpath("//*[contains(@resource-id,'tvPreference')]");
	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'tvAction')]");

	public void verifyPreferencesHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblPreferencesHeading, "Preferences Heading is", heading);
	}

	public void verifyPreferencesHeading() {
		new CommonFunctions().elementView(lblPreferencesHeading, "Preferences Heading");
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
