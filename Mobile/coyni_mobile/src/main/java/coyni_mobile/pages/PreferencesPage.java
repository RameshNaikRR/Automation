package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.ToastComponent;
import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PreferencesPage extends MobileFunctions {

	private By btnPreferences= MobileBy.AccessibilityId("");
	private By lblPreferencesHeading = MobileBy.AccessibilityId("");
	private By drpDwnTimeZone = MobileBy.AccessibilityId("");
	private By lblTimeZone = MobileBy.AccessibilityId("");
	private By lblLocalCurrency = MobileBy.AccessibilityId("");
	private By btnSave = MobileBy.AccessibilityId("");
	private By btnBack = MobileBy.AccessibilityId("");

	public void clickPreferences() {
		click(btnPreferences, "Preferences");
	}
	
	public void verifyPreferencesHeading(String heading) {
		new AndroidCommonFunctions().verifyLabelText(lblPreferencesHeading, "Preferences Heading is", heading);
	}

	public void selectTimeZone(String timeZone) {
		click(drpDwnTimeZone, "Time Zone DropDown");
		getElementList(MobileBy.xpath(String.format("//*[@text='%s']", timeZone)), timeZone);
		ExtentTestManager.setPassMessageInReport("Clicked on Element " + timeZone);
		new AndroidCommonFunctions().clickEnter();
		new AndroidCommonFunctions().clickEnter();
		click(btnSave, "Save");
	}

	public void verifyTimeZone(String timeZone) {
		new AndroidCommonFunctions().verifyLabelText(lblPreferencesHeading, "Preferences Heading is", timeZone);
	}

	public void getTimeZone() {
		String preferencesDescription = getText(lblTimeZone);
		ExtentTestManager.setInfoMessageInReport("Updated Time Zone is : " + preferencesDescription);
	}

	public void getLocalCurrency() {
		new AndroidCommonFunctions().elementView(lblLocalCurrency, "Local Currency");
		ExtentTestManager.setInfoMessageInReport("localCurrency: " + getText(lblLocalCurrency));
	}
	
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
