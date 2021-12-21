package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayRequestPopup extends MobileFunctions{

	private By lnkCopy = MobileBy.xpath(" ");
	private By btnSlideToConfirm = MobileBy.xpath(" ");
	private By lblAvailableBalance = MobileBy.xpath(" ");
	private By btnDone = MobileBy.xpath(" ");
	
	public void clickCopy() {
		click(lnkCopy,"Copy");	
		}
		public void clickSlideToConfirm() {
			click(btnSlideToConfirm, "SlideToConfirm");
		}
		public void getAvailableBalance() {
		//	getText(lblAvailableBalance);   doubt
		}
		public void clickDone() {
			click(btnDone, "Done");
		}
}
