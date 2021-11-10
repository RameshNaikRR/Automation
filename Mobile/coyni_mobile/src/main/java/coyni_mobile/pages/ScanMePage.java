package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanMePage extends MobileFunctions{
	private By lblUserName = MobileBy.xpath(" ");
	private By lnkSetAmount = MobileBy.xpath(" ");
	private By lnkClearAmount = MobileBy.xpath(" ");
	private By lnkSaveToAlbum = MobileBy.xpath(" ");
	private By lnkCopy = MobileBy.xpath(" ");
	private By lnkShare = MobileBy.xpath(" ");
	
	
	public void verifylblUserName(String userName) {
		//new CommonFunctions().verifyLabelText(lbluserName, "userName", userName);    //doubt
	}
	public void clickSetAmount() {
		click(lnkSetAmount,"SetAmount");
	}
	public void clickClearAmount() {
		click(lnkClearAmount,"ClearAmount");
	}
	public void clickSaveToAlbum() {
		click(lnkSaveToAlbum, "Save To Album");
	}
	public void clickCopy() {
		click(lnkCopy, "Copy");
	}
    public void clickShare() {
    	click(lnkShare, "Share");
    }
}
