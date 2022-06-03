package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PayRequestPage extends MobileFunctions {

	private By allow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	private By firstAndLastLetterName = MobileBy.xpath("//*[contains(@resource-id,'tvNameHead')]");
	private By txtSearchBx = MobileBy.xpath("//*[contains(@resource-id,'etSearch')]");// *[@name='search'])[2]/following-sibling::*[1]|
	private By lblUser = MobileBy.xpath("(//*[contains(@resource-id,'tvUserName')])[1]");// *[@name='Recent
																							// Contacts'])[1]/following-sibling::*[1]|
//	public void clickSearch() {
//	click(iconSearch, "Search");
//}

	public void fillSearchBx(String userName) {
		enterText(txtSearchBx, userName, "userName");
	}

	public void verifyFirstAndLastLetter(String expHeading) {
		new CommonFunctions().verifyLabelText(firstAndLastLetterName, "First and Last Letter", expHeading);
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
//public SelectUserPage selectUserPage() {
//	return new SelectUserPage();
//}

	public PayandRequestAccountHolderPage payandRequestAccountHolderPage() {
		return new PayandRequestAccountHolderPage();

	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
