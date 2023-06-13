package coyni.admin.components;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.MailHelper;

public class AddMerchantComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Add New Merchant']");
	private By lblContent = By.xpath("//p[contains(@class,'mx-4 mt-6')]");
	private By btnMerchant = By.xpath("//p[text()='+']");
	private By txtFirstName = By.xpath("//input[@id='firstName']");
	private By txtLastName = By.xpath("//input[@id='lastName']");
	private By txtEmail = By.xpath("//input[@id='Email']");
	private By txtCompanyName = By.xpath("//input[@id='companyName']");
	private By txtPartnerName = By.xpath("//input[@id='PartnerName']");
	private By btnSendInvitation = By.xpath("//button[text()='Send Invite']");
	private By lblMerchant = By.xpath("//span[text()='Merchants']");

	public void verifyMerchantHeading() {
		if (getElement(lblMerchant, "Merchant").isDisplayed()) {
			ExtentTestManager.setInfoMessageInReport("Merchant List is displayed");
		} else {
			ExtentTestManager.setFailMessageInReport("Merchant List is not displayed");
		}

	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Add New Merchant", expHeading);
	}

	public void verifyContent(String expHeading) {
		new CommonFunctions().verifyLabelText(lblContent, "Content", expHeading);
	}

	public void clickAddMerchant() {
		click(btnMerchant, "Add Merchant User");
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

	public void fillCompanyName(String txt) {
		enterText(txtCompanyName, txt, "Company Name");

	}

	public void fillPartnerName(String txt) {
		enterText(txtPartnerName, txt, "Partner Name");

	}

	public void clickSendInvitation() {
		if (getElement(btnSendInvitation, "Send Invitation").isEnabled()) {
			click(btnSendInvitation, "Send Invitation");
		} else {
			ExtentTestManager.setFailMessageInReport("Send invitation button is disabled");
		}
	}


	public String generateEmail() {
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
		//	new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 4; j < 7; j++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
	//	new CommonFunctions().validateFieldMaxichar(ele, eleName, field[7]);
	}
	
	public void fillEmail(String mail) {
		enterText(txtEmail, mail, "Email");
	}
	public String getUrl() {
		String str=MailHelper.getURLFromMail();
		return str;
	}
	
	public void navigateUrl(String url) throws InterruptedException {
	// CommonFunctions().switchtoUrl(url);
	}
	
	public String getEmail() {
		String str=MailHelper.getRandomMailID();
		return str;
	}


	public void validateFirstNameField(String firstName) {
		validateNameField(txtFirstName, "First Name", firstName);
	}

	public void validateCompantNameField(String CompanyName) {
		validateNameField(txtCompanyName, "Company Name", CompanyName);
	}

	public void validatePartnerNameField(String PartnerName) {
		validateNameField(txtPartnerName, "Partner Name", PartnerName);
	}

	public void validateLastNameField(String LastName) {
		validateNameField(txtLastName, "Last Name", LastName);
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

	public MerchantResendAndCancelComponent merchantResendAndCancelComponent() {
		return new MerchantResendAndCancelComponent();
	}
	
}
