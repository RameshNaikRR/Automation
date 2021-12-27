package coyni_mobile.components;

import org.openqa.selenium.By;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class SuccessFailureComponent extends MobileFunctions {
	private By lblSucessFailure = MobileBy.xpath("//*[contains(@name,'security')]/preceding-sibling::*[1]");
	private By lblHeading = MobileBy.xpath("//*[contains(@name,'total amount')]/preceding-sibling::*[3]");
	private By ImgSuccessFailure = MobileBy.xpath("");
	private By btnLogout = MobileBy.xpath("(//*[@name='Log Out'])[1]");
	private By btnDone = MobileBy.xpath("(//*[@name='Done'])[1]");
	
	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status: "+getText(lblHeading));
	 }
	public void clickDone() {
		click(btnDone, "Done");
	}
	public void verifySuccessFailureHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessFailure, "heading", expHeading);
		
	}
	public void clickLogOut() {
		click(btnLogout, "LogOut");
	}

}
