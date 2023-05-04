package coyni.merchant.popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddIPAddressPopup extends BrowserFunctions {

	private By lblAddNewIpAddress = By.xpath("//h3[text()='Add New IP Address']");
	private By lblHeading = By.xpath("//h1[text()='New IP Address Request']");
	private By txtIpAddress = By.xpath("//label[text()='IP Address']/following-sibling::input");
	private By txtIpAddress1 = By.xpath("(//label[text()='IP Address']/following-sibling::input)[2]");
	private By txtIpAddress2 = By.xpath("(//label[text()='IP Address']/following-sibling::input)[3]");
	private By txtDescription = By.xpath("//label[text()='IP Address Description']/following-sibling::textarea");
	private By txtDescription1 = By.xpath("(//label[text()='IP Address Description']/following-sibling::textarea)[2]");
	private By txtDescription2 = By.xpath("(//label[text()='IP Address Description']/following-sibling::textarea)[3]");
	private By btnSubmit = By.xpath("//button[text()='Submit']");
	private By lblAddIp = By.xpath("//button[text()='Add IP Address']");
	private By lblNoIPHeading = By.xpath("//p[text()='No IP Address Exists']");
	private By btnAdditionalIPAddress = By.xpath("//p[contains(text(),'Add Additional IP Address')]");
	private By headingIpSuccess = By.xpath("//h1[text()='IP Address Request Submitted Successfully']");
	private By btnClose = By.xpath("//button[text()='Close']");
	private By lblAccountID = By.xpath("//div[contains(@class,'items-center mb-5 ')]");
	private By lblAccountName = By.xpath("//div[contains(@class,'items-center mb-5')][2]");
	private By errIPAddress = By.xpath("//div[text()='IP Address is required']");
	private By errIPAddress1 = By.xpath("//div[text()='Description is required']");

	public void verifySuccessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingIpSuccess, "SuccessMessage", expHeading);
	}

	public void clickOnAdditionalIpAddress() {
		click(btnAdditionalIPAddress, "Additional IP Address");
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

	public void verifyerrMsg(String expText) {
		new CommonFunctions().verifyLabelText(errIPAddress, "IP Address", expText);
	}

	public void verifyerrMsg1(String expText) {
		new CommonFunctions().verifyLabelText(errIPAddress1, "Description", expText);
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

	public void fillIpAddress1(String data) {
		enterText(txtIpAddress1, data, "IP Address");
	}

	public void fillIpAddress2(String data) {
		enterText(txtIpAddress2, data, "IP Address");
	}

	public void fillDescription(String data) {
		enterText(txtDescription, data, "Description");
	}

	public void fillDescription1(String data) {
		enterText(txtDescription1, data, "Description");
	}

	public void fillDescription2(String data) {
		enterText(txtDescription2, data, "Description");
	}

	public void verifyAccountId() {
		new CommonFunctions().elementView(lblAccountID, "Account ID");
	}

	public void verifyAccountName() {
		new CommonFunctions().elementView(lblAccountName, "Account Name");

	}

	public int getLabelsize() {
		return getElementsList(lblAddIp, "").size();
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
}
