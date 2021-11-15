package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class HomePage extends MobileFunctions {
	private By btnGetStarted = MobileBy.xpath("");
	private By btnLogIn = MobileBy.xpath("");
	private By btnBusiness = MobileBy.xpath("");
	private By btnPersonal = MobileBy.xpath("");
	private By lblCoyni = MobileBy.xpath(" ");
    
	public void verifyCoyniView() {
		new CommonFunctions().elementView(lblCoyni, "Coyni");
	}
	public void clickGetStarted() {
		click(btnGetStarted, "Get Started ");
	}

	public void clickLogIn() {
		click(btnLogIn, "Login ");
	}

	public void clickBusiness() {
		click(btnBusiness, "Business ");
	}

	public void clickPersonal() {
		click(btnPersonal, "Personal ");
	}

	public CreateAnAccountPage createAnAccountPage() {

		return new CreateAnAccountPage();

	}

}
