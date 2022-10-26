package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AccountCreatedPage extends MobileFunctions{
	private By heading = MobileBy.xpath("//*[@text='Your Account Has Been Created']");
	private By btnSkip =MobileBy.xpath("(//*[@text='Skip'])[1]");
	private By btnGetStarted = MobileBy
			.xpath("//*[contains(@text,'Get Started')]");
	
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
	}
	public void clickSkip() {
		click(btnSkip, "Skip");
	}
	
	public void clickGetStarted() {
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
		click(btnGetStarted, "Get Started");
	}

	
	public  TokenAccountPage tokenAccountPage() {
		   return new TokenAccountPage();
	  }
	
	public  IdentityVerificationPage identityVerificationPage() {
		   return new IdentityVerificationPage();
	  }

}
