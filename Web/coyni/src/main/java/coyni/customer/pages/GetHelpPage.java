package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class GetHelpPage extends BrowserFunctions {

	private By getHelp = By.xpath("");

	private By fullName = By.xpath("");

	private By accountIDNumber = By.xpath("");

	private By email = By.xpath("");

	private By phoneNumber = By.xpath("");

	private By inquiryType = By.xpath("");

	private By customerTopics = By.xpath("");

	private By drpDwninquiryType = By.xpath("");

	private By drpDwnCustomertopics = By.xpath("");

	private By infodetails = By.xpath("");

	private By addFiles = By.xpath("");

	private By btnsubmit = By.xpath("");

	public void view() {
		new CommonFunctions().elementView(fullName, "Full Name");
		new CommonFunctions().elementView(accountIDNumber, "Account ID");
		new CommonFunctions().elementView(email, "Email");
		new CommonFunctions().elementView(phoneNumber, "Phone Number");
		new CommonFunctions().elementView(inquiryType, "Inquiry Type");
		new CommonFunctions().elementView(customerTopics, "Customer Topics");
		new CommonFunctions().elementView(infodetails, "Details");
	}

	public void clickGetHelp() {
		click(getHelp, "Get Help");
	}

	public void fillFullName(String name) {
		enterText(fullName, "Full Name", name);
	}

	public void fillAccountIDNumber(String accountID) {
		enterText(accountIDNumber, "Account ID", accountID);
	}

	public void fillEmail(String Email) {
		enterText(email, "Email", Email);
	}

	public void fillPhoneNumber(String PhoneNumber) {
		enterText(phoneNumber, "Phone Number", PhoneNumber);
	}

	public void selectInquiryType(String inquiry) {
		click(drpDwninquiryType, "Inquiry DropDown");
		new CommonFunctions().selectCustomDropDown(inquiry, "Inquiry Type");
	}

	public void selectdrpDwnCustomertopics(String customerTopics) {
		click(drpDwnCustomertopics, "CustomerTopics DropDown");
		new CommonFunctions().selectCustomDropDown(customerTopics, "CustomerTopics");
	}

	public void fillDetails(String details) {
		enterText(infodetails, "Details", details);
	}

	public void clickOnFiles() {
		click(addFiles, "Add Files");
	}

	public void clickOnSubmit() {
		click(btnsubmit, "Submit");
	}
}
