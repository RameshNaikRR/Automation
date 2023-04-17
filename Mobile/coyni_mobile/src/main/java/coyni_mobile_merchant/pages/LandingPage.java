package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class LandingPage extends MobileFunctions {

	private By btnGetStarted = MobileBy
			.xpath("//*[contains(@resource-id,'getStartedLL')]|(//*[@name='Get Started'])[1] ");
	private By btnLogin = MobileBy.id("com.coyni.mapp:id/layoutLogin");
	private By btnGetStartedLogin = MobileBy.xpath("//*[contains(@resource-id,'layoutLogin')]");
	private By lblIntroSecondSlideHeading = MobileBy.xpath("//*[contains(@text,'Tokenize')]");
//	private By lblIntroSecondSlideDescription = MobileBy.xpath("//*[contains(@text,'Log in')]");
	private By lblIntroThirdSlideHeading = MobileBy.xpath("//*[contains(@text,'Optimize')]");
	private By lblIntroThirdSlideDescrip1 = MobileBy.id("com.coyni.mapp:id/oneTV");
	private By lblIntroSlideDescFirstSecondLine = MobileBy.id("com.coyni.mapp:id/oneOneTV");
	private By lblIntroThirdSlideDescrip2 = MobileBy.id("com.coyni.mapp:id/twoTV");
	private By lblIntroThirdSlideDescrip3 = MobileBy.id("com.coyni.mapp:id/threeTV");
	private By lblIntroSlideDescripThirdSecondLine = MobileBy.id("com.coyni.mapp:id/threethreeTV");
//	private By lblIntroThirdSlideDescrip = MobileBy.id("com.coyni.mapp:id/threeTV");

	public void clickGetStarted() {
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
		click(btnGetStarted, "Get Started");
	}

	public void clickLogin() {
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
		click(btnLogin, "login");
	}

	public void clickGetStartedLogin() {
		click(btnGetStartedLogin, "Get Started Login button");
	}

	public void verifyFirstSlide() {
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
		new CommonFunctions().elementView(btnLogin, "Log in");
	}

	public void verifySecondSlide(String heading) {
		new CommonFunctions().verifyLabelText(lblIntroSecondSlideHeading, "Second Slide Heading", heading);
		new CommonFunctions().elementView(lblIntroThirdSlideDescrip1, "Description Line 1");
		new CommonFunctions().elementView(lblIntroSlideDescFirstSecondLine, "Description Line 1");
		new CommonFunctions().elementView(lblIntroThirdSlideDescrip2, "Description Line 2");
		new CommonFunctions().elementView(lblIntroThirdSlideDescrip3, "Description Line 3");
		new CommonFunctions().elementView(lblIntroSlideDescripThirdSecondLine, "Description Line 3");
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
		new CommonFunctions().elementView(btnLogin, "Log in");
	}

	public void verifyThirdSlide(String heading) {
		new CommonFunctions().verifyLabelText(lblIntroThirdSlideHeading, "Second Slide Heading", heading);
		new CommonFunctions().elementView(lblIntroThirdSlideDescrip1, "Description Line 1");
		new CommonFunctions().elementView(lblIntroThirdSlideDescrip2, "Description Line 2");
		new CommonFunctions().elementView(lblIntroThirdSlideDescrip3, "Description Line 3");
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
		new CommonFunctions().elementView(btnLogin, "Log in");
	}

	public void verifyTimeLineOfIntroSlides() throws InterruptedException {
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
		Thread.sleep(2500);
		new CommonFunctions().elementView(lblIntroSecondSlideHeading, "Second Slide Heading");
		Thread.sleep(2500);
		new CommonFunctions().elementView(lblIntroThirdSlideHeading, "Second Slide Heading");
		Thread.sleep(2500);
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
	}

	public void verifyLoginbtnView() {
		new CommonFunctions().elementView(btnLogin, "Login");

	}

	public void verifyLandingPage() {
		new CommonFunctions().elementView(btnGetStarted, "Get Started in Landing Page");
		new CommonFunctions().elementView(btnLogin, "Login in Landing Page");
	}

}
