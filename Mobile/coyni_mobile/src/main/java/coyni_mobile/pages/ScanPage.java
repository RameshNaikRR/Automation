package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.SetAmountComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ScanPage extends MobileFunctions {
	private By  btnScanCode = MobileBy.xpath(" ");
	private By btnScanMe = MobileBy.xpath(" ");
	
	public void clickScanCode() {
		click(btnScanCode, "ScanCode");
	}
	public void clickScanMe() {
		click(btnScanMe, "ScanMe");
	}
	
	public ScanCodePage scanCodePage() {
		return new ScanCodePage();
	}
	public  ScanMePage scanMePage() {
		return new ScanMePage();
	}
    public SetAmountComponent setAmountComponent() {
    	return new SetAmountComponent();
    }
}
