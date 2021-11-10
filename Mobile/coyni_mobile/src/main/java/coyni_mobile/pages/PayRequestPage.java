package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.PayRequestOptionalComponent;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayRequestPage extends MobileFunctions {
	private By iconSearch = MobileBy.xpath(" ");
	private By txtSearchBx = MobileBy.xpath(" ");
	
	public void clickSearch() {
		click(iconSearch,"Search");
	}
	public void fillSearchBx(String userName) {
		enterText(txtSearchBx, "userName", userName);
	}
	public ScanPage scanPage() {
		return new ScanPage();
	}
	public SelectUserPage selectUserPage() {
		return new SelectUserPage();
	}
	public PayRequestOptionalComponent payRequestOptionalComponent() {
		return new PayRequestOptionalComponent();
	}
	public RequestHoldernamePage requestHolderNamePage() {
		return new RequestHoldernamePage() ;
		
	}
    
}
