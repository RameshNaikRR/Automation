package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PreAuthorizationPage extends MobileFunctions {

	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By btnVerify = MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");

	public void fillAmount(String amount) {
		click(txtAmount, "Amount");
		enterText(txtAmount, amount, "Amount");
		
	}

	public void clickVerify() {
		click(btnVerify, "Verify");
	}

	public AllDonePage allDonePage() {
		return new AllDonePage();
	}
	
	private By getOneNumberOfPin(char num) {
		return MobileBy.xpath(
				String.format("(//*[@text='%s' or @name='%s'])", Character.toString(num), Character.toString(num)));
	}

	public void fillPin(String pin) {
		System.out.println(pin.length());
		for (int i = 0; i < pin.length(); i++) {
			click(getOneNumberOfPin(pin.charAt(i)), "pin " + pin.charAt(i));
		}
	}
}
