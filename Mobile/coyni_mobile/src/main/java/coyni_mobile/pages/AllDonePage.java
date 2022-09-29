package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AllDonePage extends MobileFunctions {

	private By btnDone = MobileBy.xpath("//*[contains(@resource-id,'cvDone')]");
	private By txtAllDone = MobileBy.xpath("//*[@text='All Done']");

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void verifyAllDone(String expHeading) {
		new CommonFunctions().verifyLabelText(txtAllDone, "All Done", expHeading);
	}

	public int verifyDoneHeading() {
		int a = DriverFactory.getDriver().findElements(txtAllDone).size();
		return a;

	}

}
