package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AccountCreatedPage extends MobileFunctions{
	private By heading = MobileBy.xpath("//*[@text='Your Account Has Been Created']");
	private By btnSkip =MobileBy.xpath("(//*[@text='Skip'])[1]");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}
	public void clickSkip() {
		click(btnSkip, "Skip");
	}
//	public  TokenAccountPage tokenAccountPage() {
//		   return new TokenAccountPage();
//	  }

}
