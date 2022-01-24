package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class GetHelpPage extends BrowserFunctions {

	private By heading = By.xpath("//div[text()='Customer Support Form']");

	private By getHelp = By.xpath("(//span[text()='Get Help'])[1]");

	private By fullName = By.cssSelector("#name");

	private By accountIDNumber = By.xpath("//input[@aria-labelledby='raised_by']");

	private By email = By.xpath("//div[contains(text(),'Enter the best')]/following-sibling::*[1]/div/input");

	private By country = By.xpath("(//span[@class='Select-arrow-zone'])[1]");

	private By phoneNumber = By.xpath("(//input[@class='form-input'])[4]");

	private By inquiryType = By.xpath("//div[text()=' Inquiry Type']");

	private By customerTopics = By.xpath("//div[text()='Customer Topics']");

	private By drpDwninquiryType = By.xpath("(//div[text()='Select your answer'])[1]");

	private By drpDwnCustomertopics = By.xpath("(//div[text()='Select your answer'])[2]");

	private By infodetails = By.xpath("//div[text()='Details']");

	private By addFiles = By.xpath("");

	private By btnsubmit = By.xpath("//button[text()='Submit']");

	private By errorMessage = By.xpath("//div[@class='submit-error-text']");

	private By message = By.xpath("//div[text()='Thank you!']");

	private By btnSubmitAgain = By.xpath("//button[text()='Submit again']");

	private By Submitheading = By.xpath("//div[text()='Never submit passwords through forms']");

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
		click(fullName, "Full Name");
		enterText(fullName, name, "Full Name");
	}

	public void fillAccountIDNumber(String accountID) {
		click(accountIDNumber, "Account Number");
		enterText(accountIDNumber, "Account ID", accountID);
	}

	public void fillEmail(String Email) {
		enterText(email, "Email", Email);
	}

	public void selectCountry(String Country) {
		click(country, "Country");
		new CommonFunctions().selectCustomDropDown(Country, "Country");

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

	public void verifySubmitHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(Submitheading, "Submit Heading", expHeading);
	}

	public void clickOnSubmitAgain() {
		click(btnSubmitAgain, "Submit again");
	}

	public void verifyErrorMessage(String expHeading) {
		new CommonFunctions().verifyLabelText(errorMessage, "All Fields are Required", expHeading);
	}

	public void verifyMessage(String expHeading) {
		new CommonFunctions().verifyLabelText(message, "Thank You!", expHeading);

	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Customer Support Form", expHeading);
	}
}