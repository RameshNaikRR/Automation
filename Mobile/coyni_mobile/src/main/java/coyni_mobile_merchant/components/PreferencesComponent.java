package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PreferencesComponent extends MobileFunctions {

	private By lblPreferencesHeading = MobileBy.xpath("//*[contains(@resource-id,'PreferencesLL')]");
	private By drpDwnTimeZone = MobileBy.xpath("//*[contains(@resource-id,'timeZoneET')]");
	private By lblLocalCurrency = MobileBy.xpath("//*[contains(@resource-id,'currencyET')]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");

	public void verifyPreferencesHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblPreferencesHeading, "Preferences Heading is", heading);
	}

	public void selectTimeZone(String timeZone) {
		click(drpDwnTimeZone, "Time Zone DropDown");
		ExtentTestManager.setInfoMessageInReport("Clicked on Element " + timeZone);
		getElementList(MobileBy.xpath(String.format("//*[@text='%s']", timeZone)), "Time Zone");
		new CommonFunctions().clickEnter();
		click(btnSave, "Save");
//		 selectDropdownOption(drpDwnTimeZone, txtTimeZone, "click on Drop Down", timeZone);
//		 click(btnDone, "Done");
	}

	public void getLocalCurrency() {
		String localCurrency = getText(lblLocalCurrency);
		ExtentTestManager.setInfoMessageInReport("localCurrency: " + localCurrency);
	}

}
