package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayRequestPage extends MobileFunctions {
	private By iconSearch = MobileBy.xpath(" ");
	private By txtSearchBx = MobileBy.xpath("(//*[@name='search'])[2]/following-sibling::*[1]");
	private By lblUser =MobileBy.xpath("(//*[@name='Recent Contacts'])[1]/following-sibling::*[1]");
	
	public void clickSearch() {
		click(iconSearch,"Search");
	}
	public void fillSearchBx(String userName) {
		enterText(txtSearchBx, userName, "userName");
	}
	public void selectUser() {
		click(lblUser,"user");
	}
	public ScanPage scanPage() {
		return new ScanPage();
	}
//	public SelectUserPage selectUserPage() {
//		return new SelectUserPage();
//	}
	
	public PayandRequestAccountHolderPage payandRequestAccountHolderPage() {
		return new PayandRequestAccountHolderPage() ;
		
	}
    
}
