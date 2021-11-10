package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddExternalBankAccountPage extends MobileFunctions{
	
	private By lnkLearnMore = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By btnBackArrow = MobileBy.xpath("");
	
	public void clickLearnMore() {
		click(lnkLearnMore, "Learn More");
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
	public void clickBackArrow() {
		click(btnBackArrow, "Back Arrow");
	}

	
}
