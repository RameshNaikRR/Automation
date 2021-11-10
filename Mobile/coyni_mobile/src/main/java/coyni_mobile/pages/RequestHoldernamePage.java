package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;


public class RequestHoldernamePage extends MobileFunctions{
	private By lblHolderName = MobileBy.xpath(" ");
	private By lnkCopy = MobileBy.xpath(" ");
	private By btnSlideToConfirm = MobileBy.xpath(" ");
	private By lblAvailableBalance = MobileBy.xpath(" ");
	private By btnDone = MobileBy.xpath(" ");
	
	public void getHolderName(String holderName) {
		// getText(lblAvailableBalance);  doubt
	}
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
