package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayRequestPage extends MobileFunctions {

	private By allow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	// private By iconSearch = MobileBy.xpath(" ");
	private By txtSearchBx = MobileBy.xpath("//*[contains(@resource-id,'etSearch')]");// *[@name='search'])[2]/following-sibling::*[1]|
	private By lblUser = MobileBy.xpath("//*[contains(@resource-id,'lyRecentUsers')]");// *[@name='Recent
																						// Contacts'])[1]/following-sibling::*[1]|

//	public void clickSearch() {
//		click(iconSearch, "Search");
//	}

	public void fillSearchBx(String userName) {
		enterText(txtSearchBx, userName, "userName");
	}

	public void selectUser() {
		click(lblUser, "user");
	}

	public void clickAllow() {
		click(allow, "Allow");
	}

	public ScanPage scanPage() {
		return new ScanPage();
	}
//	public SelectUserPage selectUserPage() {
//		return new SelectUserPage();
//	}

	public PayandRequestAccountHolderPage payandRequestAccountHolderPage() {
		return new PayandRequestAccountHolderPage();

	}

}
