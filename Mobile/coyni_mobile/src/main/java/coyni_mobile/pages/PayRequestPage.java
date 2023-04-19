package coyni_mobile.pages;

import org.apache.commons.math3.ode.ExpandableStatefulODE;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class PayRequestPage extends MobileFunctions {

	private By allow = MobileBy.xpath("//*[contains(@resource-id,'permission_allow_button')]");
	private By firstAndLastLetterName = MobileBy.xpath("//*[contains(@resource-id,'tvNameHead')]");
	private By txtSearchBx = MobileBy.xpath("//*[contains(@resource-id,'etSearch')]");// *[@name='search'])[2]/following-sibling::*[1]|
	private By lblUser = MobileBy.xpath("(//*[contains(@resource-id,'tvUserName')])[1]");// *[@name='Recent//
																							// Contacts'])[1]/following-sibling::*[1]|
	private By lblRecentContacts = MobileBy.xpath("//*[@text='Recent Contacts']");
	private By lblContactList = MobileBy.xpath("//*[@text='Contact List']");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);

	public void fillSearchBx(String userName) {
		wait.until(ExpectedConditions.presenceOfElementLocated(txtSearchBx));
		enterText(txtSearchBx, userName, "User Name");
	}

	public void verifySearchBx() {
		new CommonFunctions().elementView(txtSearchBx, "Search");
	}

	public void verifyRecentContacts() {
		new CommonFunctions().elementView(lblRecentContacts, "Recent Contacts");
	}

	public void verifyContactList() {
		new CommonFunctions().elementView(lblContactList, "Contact List");
	}

	public void verifyFirstAndLastLetter(String expHeading) {
		new CommonFunctions().verifyLabelText(firstAndLastLetterName, "First and Last Letter", expHeading);
	}

	public void selectUser() {
		click(lblUser, "User");
	}

	public void clickAllow() throws InterruptedException {
		Thread.sleep(1500);
		if (getElementList(allow, "Allow").size() > 0) {
			click(allow, "Allow");
		}
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
