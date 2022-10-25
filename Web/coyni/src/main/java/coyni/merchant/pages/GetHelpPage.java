package coyni.merchant.pages;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class GetHelpPage extends BrowserFunctions {

	private By lblHeading = By.xpath("(//span[contains(text(),'Get Help')])[2]");

	private By lblContent = By.xpath("//p[text()='Need help with coyni?']");

	private By getHelpContent = By.xpath("(//p['text-[16px'])[2]");

	private By lblMessage = By.xpath("(//p['text-[14px]'])[3]");

	private By btnGetHelp = By.xpath("(//span[text()='Get Help'])[1]");

	private By fullName = By.cssSelector("#answer-name>div>input");

	private By accountIDNumber = By.cssSelector("#answer-raised_by>div>input");

	private By feedbackIssue = By.cssSelector("#answer-long_text>div>div>textarea");

	private By email = By.cssSelector("#answer-text>div>input");

	private By country = By.xpath("//div[text()='Country']/parent::div");

	private By phoneNumber = By.cssSelector("input[aria-label='Phone number without country code']");

	private By inquiryType = By.xpath("//div[@class=' css-tlfecz-indicatorContainer']");

	private By iosOrAndroid = By.cssSelector("#answer-text2>div>input");

	private By drpDwninquiryType = By.xpath("//div[text()='Select your answer']/parent::div");

	private By addFiles = By.xpath("");

	private By btnsubmit = By.xpath("//button[text()='Submit']");

	private By errorMessage = By.xpath("//div[@class='submit-error-text']");

	private By message = By.xpath("//div[text()='Thank you!']");

	private By btnSubmitAgain = By.xpath("//button[text()='Submit another']");

	private By Submitheading = By.xpath("//div[text()='Never submit passwords through forms']");
	private By iframe = By.xpath("//iframe");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Get help page heading ", Heading);
	}

	public void clickGetHelp() {
		click(btnGetHelp, "Get Help");
	}

	public void view() {
		new CommonFunctions().elementView(fullName, "Full Name");
		new CommonFunctions().elementView(accountIDNumber, "Account ID");
		new CommonFunctions().elementView(email, "Email");
		new CommonFunctions().elementView(phoneNumber, "Phone Number");
		new CommonFunctions().elementView(inquiryType, "Inquiry Type");
	}

	public void fillFullName(String name) {
		// click(fullName, "Full Name");
		switchToFrame(iframe, "");
		enterText(fullName, name, "Full Name");
	}

	public void fillIosOrAndroid(String ios) {
		// click(iosOrAndroid, "IosOrAndroid");
		enterText(iosOrAndroid, ios, "IosOrAndroid");
	}

	public void fillAccountIDNumber(String accountID) {
		// click(accountIDNumber, "Account Number");
		enterText(accountIDNumber, accountID, "Account ID");
	}

	public void fillFeedBackIssue(String issue) {
		// click(feedbackIssue, "FeedBack Issue");
		enterText(feedbackIssue, issue, "Feed Back Issue");
	}

	public void fillEmail(String Email) {
		click(email, "Email");
		enterText(email, Email, "Email");
	}

	public void selectCountry(String Country) {
		click(country, "Country");
		click(getElement(Country), Country);

	}

	public void getContent() {
		String content = getText(lblContent, "Content");
		ExtentTestManager.setInfoMessageInReport("Get Help : " + content);
	}

	public void getContentHelp() {
		String contentHelp = getText(getHelpContent, "Content");
		ExtentTestManager.setInfoMessageInReport("Get Help : " + contentHelp);
	}

	public void getMessage() {
		String message = getText(lblMessage, "Message");
		ExtentTestManager.setInfoMessageInReport("Get Help Message : " + message);
	}

	public void fillPhoneNumber(String PhoneNumber) {
		click(phoneNumber, "Phone Number");
		scrollToElement(phoneNumber, "Phone Number");
		enterText(phoneNumber, PhoneNumber, "Phone Number");
	}

	public By getElement(String state) {
		return By.xpath(String.format("//div[text()='%s']", state));
	}

	public void selectInquiryType(String state) {
		click(drpDwninquiryType, " DropDown");
		click(getElement(state), state);
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
}