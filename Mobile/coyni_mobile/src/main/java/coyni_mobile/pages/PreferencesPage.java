package coyni_mobile.pages;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;

import coyni_mobile.components.ToastComponent;
import coyni_mobile.utilities.CommonFunctions;
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
		new CommonFunctions().verifyLabelText(lblPreferencesHeading, "Preferences Heading is", heading);
	}

	public void selectTimeZone(String timeZone) {
		click(drpDwnTimeZone, "Time Zone DropDown");
		getElementList(MobileBy.xpath(String.format("//*[@text='%s']", timeZone)), timeZone);
		ExtentTestManager.setPassMessageInReport("Clicked on Element " + timeZone);
		new CommonFunctions().clickEnter();
		new CommonFunctions().clickEnter();
		click(btnSave, "Save");
	}

	public void verifyTimeZone(String timeZone) {
		new CommonFunctions().verifyLabelText(lblPreferencesHeading, "Preferences Heading is", timeZone);
	}

	public void getTimeZone() {
		String preferencesDescription = getText(lblTimeZone);
		ExtentTestManager.setInfoMessageInReport("Updated Time Zone is : " + preferencesDescription);
	}

	public void getLocalCurrency() {
		new CommonFunctions().elementView(lblLocalCurrency, "Local Currency");
		ExtentTestManager.setInfoMessageInReport("localCurrency: " + getText(lblLocalCurrency));
	}
	
	public void timezones() {
//		PST
//		ZoneId pstZone = ZoneId.of("America/Los_Angeles");

//		MST
//		ZoneId pstZone = ZoneId.of("America/Edmonton");

//		CST
		ZoneId pstZone = ZoneId.of("America/Mexico_City");

//		EST
//		ZoneId pstZone = ZoneId.of("America/Port-au-Prince");

//		AST
//		ZoneId pstZone = ZoneId.of("America/Tortola");

//		Hawali(HST)
//		ZoneId pstZone = ZoneId.of("Pacific/Honolulu");
	
//		SST
//		ZoneId pstZone = ZoneId.of("Pacific/Apia");

		// Get the current date and time in the PST zone
		LocalDateTime currentTime = LocalDateTime.now(pstZone);

		// Format the date and time using a specific pattern
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		String formattedDateTime = currentTime.format(formatter);
		System.out.println(formattedDateTime);
	}
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
