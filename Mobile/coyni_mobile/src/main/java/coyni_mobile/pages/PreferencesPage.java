package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PreferencesPage extends MobileFunctions {

	private By drpDwnTimeZone = MobileBy.xpath("");
	private By lblLocalCurrency = MobileBy.xpath("");
	private By lblVerifyDefaultHeading = MobileBy.xpath("");
	private By lblDefaultAccount = MobileBy.xpath("");
	private By IconBackArrow = MobileBy.xpath("");

	public void selectTimeZone() {
		click(drpDwnTimeZone, "Time Zone DropDown");
		// new CommonFunctions().selectCustomDropDown(drpDwnTimeZone, "Time Zone");

	}

	public void verifyLocalCurrency(String expCurrency) {

		// new CommonFunctions().verifyLabelText(lblLocalCurrency, "Local Currency",
		// expCurrency);

	}

	public void verifyDefaultHeading() {

	}

	public void verifyDefaultAccount() {

	}

	public void clickBackArrow() {
		click(IconBackArrow, "Back Arrow");

	}

}
