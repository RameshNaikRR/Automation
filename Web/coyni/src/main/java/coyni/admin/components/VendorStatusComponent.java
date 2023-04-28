package coyni.admin.components;

import java.awt.AWTException;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class VendorStatusComponent extends BrowserFunctions {

	private By btnAllVendorStatus = By.xpath("//span[text()='All Vendor Statuses']");
	private By btnActive = By.xpath("//span[text()='Active']");
	private By btnInactive = By.xpath("//span[text()='Inactive']");

	public void clickAllVendorStatus() {
		click(btnAllVendorStatus, "AllVendorStatus");
	}

	public void clickActiveStatus() {
		click(btnActive, "Active");
	}

	public void clickInActiveStatus() {
		click(btnInactive, "btnInactive");
	}
	public void clickOutSide() throws AWTException {
		new CommonFunctions().clickTab();
	}
	
	public VendorListComponent vendorListComponent() {
		return new VendorListComponent();
	}
}
