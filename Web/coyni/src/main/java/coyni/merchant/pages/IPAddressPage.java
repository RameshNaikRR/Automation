package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.popups.AddIPAddressPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class IPAddressPage extends BrowserFunctions {

	private By lblAddNewIpAddress = By.xpath("//h3[text()='Add New IP Address']");
	private By lblAddIp = By.xpath("//button[text()='Add IP Address']");
	private By lblNoIPHeading = By.xpath("//p[text()='No IP Address Exists']");
	private By btnDelete = By.xpath("//div[@class='text-xs icon-trash cursor-pointer IpAddresses_trash__lNbmE '][1]");
	private By headingRemove = By.xpath("//h1[text()='Remove IP Address ?']");
	private By btnYes = By.xpath("//button[text()='Yes']");
	private By lbldesc = By.xpath("//p[contains(text(),'Are you sure')]");

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void verifyRemoveHeading(String expText) {
		new CommonFunctions().verifyLabelText(headingRemove, "Remove", expText);
	}

	public void verifydesc(String expText) {
		new CommonFunctions().verifyLabelText(lbldesc, "description", expText);
	}

	public void clickDelete() {
		click(btnDelete, "Delete");
	}

	public void verifyNoIp(String expText) {
		new CommonFunctions().verifyLabelText(lblNoIPHeading, "No IP Address Exits", expText);
	}

	public void clickIpAddress() {
		click(lblAddIp, "Add Ip Address");
	}

	public void clickAddNewIpAddress() {
//		if (verifyElementPresence(lblAddNewIpAddress, "Add New Ip Address")) {
		click(lblAddNewIpAddress, "Add New Ip Address");
//		} else {
//			click(lblAddIp, "Add  Ip Address");
//		}
	}

	public AddIPAddressPopup addIPAddressPopup() {
		return new AddIPAddressPopup();
	}

}
