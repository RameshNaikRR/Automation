package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddIPAddressPopups extends BrowserFunctions {

	private By lblAddNewIpAddress = By.xpath("//h3[text()='Add New IP Address']");
	private By lblHeading = By.xpath("//h1[text()='New IP Address Request']");

	private By txtIpAddress = By.xpath("//label[text()='IP Address']/following-sibling::input");
	private By txtDescription = By.xpath("//label[text()='IP Address Description']/following-sibling::textarea");

	private By btnSubmit = By.xpath("//button[text()='Submit']");
	private By lblAddIp = By.xpath("//button[text()='Add IP Address']");
	private By lblNoIPHeading = By.xpath("//p[text()='No IP Address Exists']");

	private By headindIpSuccess = By.xpath("//h1[text()='IP Address Request Submitted Successfully']");
	private By btnClose = By.xpath("//button[text()='Close']");

	public void verifySuccessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headindIpSuccess, expHeading, "Success");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void clickAddIp() {
		click(lblAddIp, "Add Ip Address");
	}

	public void verifyNoIp(String expText) {
		new CommonFunctions().verifyLabelText(lblNoIPHeading, expText, "No Ip Address Exits");
	}

	public void clickSubmit() {
		if (getElement(btnSubmit, "submit").isEnabled()) {
			click(btnSubmit, "Submit");
		} else {
			ExtentTestManager.setInfoMessageInReport("Submit button is disable");
		}
	}

	public void clickIpAddress() {
		if (verifyElementPresence(lblAddNewIpAddress, "Add Ip Address")) {
			click(lblAddNewIpAddress, "Add Ip Address");
		} else {
			click(lblAddIp, "Add Ip Address");
		}
	}

	public void clickOutSide() {
		new CommonFunctions().clickOutSideElement();
	}

	public void verifyIpHeading(String expText) {
		new CommonFunctions().verifyLabelText(lblHeading, expText, "New IP Address Request");
	}

	public void fillIpAddress(String data) {
		enterText(txtIpAddress, data, "IP Address");
	}

	public void fillDescription(String data) {
		enterText(txtDescription, data, "Description");
	}

	public By getItems(String item) {
		return By.xpath(String.format("//p[text()='%s']/following-sibling::h2", item));

	}

	public void verifyAccountId() {
		ExtentTestManager.setPassMessageInReport("Account ID IS " + getElement(getItems("Account ID"), "Account ID"));
	}

	public void verifyAccountName() {
		ExtentTestManager.setPassMessageInReport(
				"Account Name " + getElement(getItems("Account Name (DBA)"), "Account Name (DBA)"));
	}

}
