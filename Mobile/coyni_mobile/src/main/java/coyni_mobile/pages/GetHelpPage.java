package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class GetHelpPage extends MobileFunctions{

	private By heading = MobileBy.xpath("//*[contains(@text,'Need help')]");
	private By lblSupportDescription = MobileBy.xpath("//*[contains(@resource-id,'support_text_click')]");
	private By lblDetails = MobileBy.xpath("//*[contains(@resource-id,'text_support_tv')]");
	private By btnBack = MobileBy.xpath("//*[contains(@resource-id,'IVBack')]");



	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Get Help Heading", expHeading);
	}

	public void clickBack() {
	click(btnBack, "Back");
	}

	public void getHelpDetails() {
		ExtentTestManager.setInfoMessageInReport("Get Help Support Description is " + getText(lblSupportDescription));
		ExtentTestManager.setInfoMessageInReport("Get Help Details " + getText(lblDetails));	
	}

	
}
