package coyni.admin.components;

import java.awt.AWTException;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import coyni.uitilities.YOPMail;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.MailHelper;

public class AddBusinessComponent extends BrowserFunctions {
	private By lblHeadingBusiness = By.xpath("//h1[text()='Invite Recipient']");
	private By txtFirstName = By.xpath("(//input[@ui-auto='labe_text_value'])[1]");
	private By txtLastName = By.xpath("(//input[@ui-auto='labe_text_value'])[2]");
	private By txtEmail = By.xpath("(//input[@ui-auto='labe_text_value'])[3]");

	private By btnNext = By.xpath("//button[@ui-auto='Next']");
	private By lblConfiguration = By.xpath("//h1[text()='Business Configuration']");

	private By radUSCountry = By.xpath("//div[text()='United States']");
	private By radInternaltionalCountry = By.xpath("//div[text()='International']");
	private By selectVerticalBusiness = By.xpath("//div[text()='Business Vertical']");
	private By btnSend = By.xpath("//button[text()='Send']");
	private By btnAddNewBusiness = By.xpath("//button[text()='Invite New Business']");

	private By lblContent = By.xpath("//p[text()='Accounting, Auditing, and Bookkeeping Services']");

	public void clickBusinessVerticalContent() {
		click(lblContent, "Accounting, Auditing, and Bookkeeping Services");
	}

	public void clickAddNewBusiness() {
		click(btnAddNewBusiness, "Add New Business User");
	}

	public void verifyMerchantHeading() {
		if (getElement(lblHeadingBusiness, "Invite Recipient").isDisplayed()) {
			ExtentTestManager.setInfoMessageInReport("Invite Recipient");
		} else {
			ExtentTestManager.setFailMessageInReport("Invite Recipient is not displayed");
		}

	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblConfiguration, "Business Configuration", expHeading);
	}

	public void clickBusiness() {
		click(selectVerticalBusiness, "Business");
	}

	public void clickUSCountry() {
		click(radUSCountry, "US Country");
	}

	public void clickInternational() {
		click(radInternaltionalCountry, "Internaltional Country");
	}

	public void fillFirstName(String txt) {
		enterText(txtFirstName, txt, "First Name");

	}

	public void fillLastName(String txt) {
		enterText(txtLastName, txt, "Last Name");

	}

	public void fillEmail() {
		enterText(txtEmail, generateEmail(), "Email");
	}

	public void fillEditEmail() throws InterruptedException {
		clearText(txtEmail, "clear Email");
		enterText(txtEmail, generateEmail(), "Email");
		ExtentTestManager.setInfoMessageInReport(" Email Edited Successfully");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next Button").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setFailMessageInReport("Next  button is disabled");
		}
	}

	public void clickSend() {
		if (getElement(btnSend, "Send Button").isEnabled()) {
			click(btnSend, "Send ");
		} else {
			ExtentTestManager.setFailMessageInReport("Send  button is disabled");
		}
	}

	public static String generateEmail() {
		int length = 4;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
		return generatedString + "@yopmail.com";
	}

	/**
	 * Order -minChar, minCharPlus, maxCharMinus, maxChar, specialChar, Number,
	 * spaces maxiPlus
	 */
	public void validateNameField(By ele, String eleName, String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 4; i++) {
			// new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 4; j < 7; j++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
		// new CommonFunctions().validateFieldMaxichar(ele, eleName, field[7]);
	}

	public void fillEmail(String mail) {
		enterText(txtEmail, mail, "Email");
	}

	public String getUrl() {
		String str = MailHelper.getURLFromMail();
		return str;
	}

	public void navigateUrl(String url) throws InterruptedException {
		new CommonFunctions().switchtoUrl(url);
	}

	public String getEmail() {
		return YopMail;
	}

	public void validateFirstNameField(String firstName) {
		validateNameField(txtFirstName, "First Name", firstName);
	}

	public void validateLastNameField(String LastName) {
		validateNameField(txtLastName, "Last Name", LastName);
	}

	public void switchToYopmailWindow() {
		String gmailWindow = DriverFactory.getDriver().getWindowHandle();
		Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
		for (String string : windowHandles) {
			if (!string.equals(gmailWindow)) {
				DriverFactory.getDriver().switchTo().window(string);
				ExtentTestManager.setPassMessageInReport("Switched to Merchant portal");
				break;
			}
		}
	}
//	public void clickActivateAccountInYOPMail(String firstname) throws InterruptedException, AWTException {
//		YOPMail mail = new YOPMail();
//		mail.openYopMail();
//		mail.switchToYopmailWindow();
//		mail.clickActivateAccount(YopMail, firstname);
//
//	}

	private static String YopMail = generateEmail();

	public void clickActivateAccountInYOPMail(String firstname) throws InterruptedException, AWTException {
		YOPMail mail = new YOPMail();
		mail.openYopMail();
		mail.switchToYopmailWindow();
		mail.clickActivateAccount(YopMail, firstname);

	}
	
	public BusinessInviteComponent businessInviteComponent() {
		return new BusinessInviteComponent();
	}
	
	
}
