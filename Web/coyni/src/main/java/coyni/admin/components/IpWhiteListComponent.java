package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class IpWhiteListComponent extends BrowserFunctions {

	private By addIpAddress = By.xpath("//button[text()='Add IP Address']");
	private By lblHeading = By.xpath("//h1[text()='New IP Address Request']");
	private By lblVendorName = By.xpath("//p[text()='Vendor:']/following-sibling::*");
	private By lblVendorId = By.xpath("//p[text()='Vendor ID']/following-sibling::*");
	private By txtIpAddress = By.xpath("//input[@name='ipArray.[0].ipAddress']");
	private By txtDescription = By.xpath("//label[@for='IP Description']");
	private By btnIpAddress = By.xpath("//button[text()='Add IP']");
	private By btnIpWhiteList = By.xpath("//button[text()='IP Whitelist']");
	private By btnActiveLog = By.xpath("//button[text()='Activity Log']");
	public void clickIpWhiteList() {
		click(btnIpWhiteList, "IpWhiteList");
	}

	public void clickActivityLog() {
		click(btnActiveLog, "ActivityLog");
	}
	public void clickAddIpAddress() {
		click(addIpAddress, "Add IP Address");
	}

	public void VerifyIpHeading() {
		new CommonFunctions().verifyLabelText(lblHeading, "New IP Address Request", "New IP Address Request");
	}

	public void getVendorName() {
		String text = getText(lblVendorName, "");
		ExtentTestManager.setInfoMessageInReport("Vendor name is : " + text);
	}

	public void getVendorId() {
		String text = getText(lblVendorId, "");
		ExtentTestManager.setInfoMessageInReport("Vendor Id is : " + text);
	}

	public void fillIpAddress(String ip) {
		enterText(txtIpAddress, ip, "Ip Address");
	}

	public void fillDescription() {
		click(txtDescription, "Description");
		enterText(txtDescription, "IP Adress", "Description");
	}

	public void clickIpAdd() {
		click(btnIpAddress, "Add IP ");
	}
	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
	// Activity logs
	private By lblActivityLogs = By.xpath("(//p[contains(@class,'text-cgy4 text-sm mb-1.5')])[1]");

	public void getActivityLog() {
		String text = getText(lblActivityLogs, "");
		ExtentTestManager.setInfoMessageInReport("Activity log is" + text);
	}
}
