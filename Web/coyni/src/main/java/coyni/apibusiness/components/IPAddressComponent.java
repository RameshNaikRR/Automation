package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.api.business.popups.AddIPAddressPopups;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class IPAddressComponent extends BrowserFunctions {
	private By lblAddNewIpAddress = By.xpath("//h3[text()='Add New IP Address']");
	private By lblAddIp = By.xpath("//button[text()='Add IP Address']");
	private By lblNoIPHeading = By.xpath("//p[text()='No IP Address Exists']");
	private By btnDelete = By.xpath("//div[@class='text-xs icon-trash cursor-pointer IpAddresses_trash__lNbmE '][1]");
	private By headingRemove= By.xpath("//h1[text()='Remove IP Address ?']");
	private By btnYes = By.xpath("//button[text()='Yes']");
	
	public void clickYes() {
		click(btnYes, "Yes");
	}
	public void verifyRemoveHeading(String expText) {
		new CommonFunctions().verifyLabelText(headingRemove, expText, "Remove");
	}
	
	public void clickDelete() {
		click(btnDelete, "Delete");
	}

	public void verifyNoIp(String expText) {
		new CommonFunctions().verifyLabelText(lblNoIPHeading, expText, "No Ip Address Exits");
	}

	public void clickIpAddress() {
		if (verifyElementPresence(lblAddNewIpAddress, "Add Ip Address")) {
			click(lblAddNewIpAddress, "Add Ip Address");
		} else {
			click(lblAddIp, "Add Ip Address");
		}
	}

	public AddIPAddressPopups addIPAddressPopups() {
		return new AddIPAddressPopups();
	}
}
