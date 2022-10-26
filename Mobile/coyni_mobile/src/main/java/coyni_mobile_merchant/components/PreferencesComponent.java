package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PreferencesComponent extends MobileFunctions {

	private By lblPreferencesHeading = MobileBy.xpath("//*[contains(@text,'Preferences')]");
	private By lblPreferencesDescription = MobileBy.xpath("//*[contains(@resource-id,'timezoneTextTV')]");
	private By drpDwnTimeZone = MobileBy.xpath("//*[contains(@resource-id,'timeZoneET')]");
	private By lblTimeZone = MobileBy.xpath("//*[contains(@resource-id,'timeZoneET')]");
	private By lblLocalCurrency = MobileBy.xpath("//*[contains(@resource-id,'currencyET')]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'back')]");

	public void verifyPreferencesHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblPreferencesHeading, "Preferences Heading is", heading);
	}
	
	public void selectTimeZone(String timeZone) {
		click(drpDwnTimeZone, "Time Zone DropDown");
		ExtentTestManager.setInfoMessageInReport("Clicked on Element " + timeZone);
		getElementList(MobileBy.xpath(String.format("//*[@text='%s']", timeZone)), "Time Zone");
		new CommonFunctions().clickEnter();
		new CommonFunctions().clickEnter();
		click(btnSave, "Save");
//		 selectDropdownOption(drpDwnTimeZone, txtTimeZone, "click on Drop Down", timeZone);
//		 click(btnDone, "Done");
	}
	
	public By getElement(String elementName) {
			return MobileBy.xpath("//*[@text='']");
	}
	
//	public void selectTimeZones(String timeZone) {
//		click(drpDwnTimeZone, "Time Zone DropDown");
//		ExtentTestManager.setInfoMessageInReport("Clicked on Element " + timeZone);
////		click(getElement(timeZone), timeZone);
////		click(getElementList(btnBack, timeZone),"dfgk");
//		click(getElementList(btnBack, ""), timeZone);
//		new CommonFunctions().clickEnter();
//		click(btnSave, "Save");
////		 selectDropdownOption(drpDwnTimeZone, txtTimeZone, "click on Drop Down", timeZone);
////		 click(btnDone, "Done");
//	}

	public void getTimeZone() {
		String preferencesDescription = getText(lblTimeZone);
		ExtentTestManager.setInfoMessageInReport("Updated Time Zone is : " + preferencesDescription);
	}

	public void getDecscription() {
		String preferencesDescription = getText(lblPreferencesDescription);
		ExtentTestManager.setInfoMessageInReport("Preferences Description: " + preferencesDescription);
	}

	public void getLocalCurrency() {
		String localCurrency = getText(lblLocalCurrency);
		ExtentTestManager.setInfoMessageInReport("localCurrency: " + localCurrency);
	}

	public void clickBack() {
		click(btnBack, "Back");
	}
	
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
