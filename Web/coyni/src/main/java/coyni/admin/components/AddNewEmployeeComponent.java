package coyni.admin.components;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import coyni.uitilities.YOPMail;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.MailHelper;

public class AddNewEmployeeComponent extends BrowserFunctions {
	private By lblAddNewEmployee = By.xpath("//span[text()='Add New Employee']");
	private By txtFirstName = By.name("firstName");
	private By txtLastName = By.name("lastName");
	private By txtEmail = By.name("email");
	private By txtPhoneNumber = By.name("phoneNumber");
	private By ddDepartment = By.className("FormField_selected_option__7Rw29");
	private static String YopMail = generateEmail();
//	private By ddElmAdministrator=By.xpath("//div[text()='Administrator']");
	private By clkAccounting = By.xpath("//p[text()='Accounting']");
	private By btnSendInvitation = By.xpath("//button[@type='submit']");

	public void verifyAddNewEmployeeHeading() {

		if (getElement(lblAddNewEmployee, "Add New Employee").isDisplayed()) {
			ExtentTestManager.setInfoMessageInReport("Add New Employee Heading is displayed");
		} else {
			ExtentTestManager.setFailMessageInReport("Add New Employee Heading is not displayed");
		}
	}

	public void verifyHeading(String expHeading) throws InterruptedException {
		new CommonFunctions().verifyLabelText(lblAddNewEmployee, "Add New Employee", expHeading);
		Thread.sleep(5000);

	}

	public void fillFirstName(String txt) {
		enterText(txtFirstName, txt, "First Name");
	}

	public void fillLastName(String txt) {
		enterText(txtLastName, txt, "Last Name");
	}

	public String getUrl() {
		String str=MailHelper.getURLFromMail();
		return str;
	}
	
	public void navigateUrl(String url) throws InterruptedException {
		new CommonFunctions().switchtoUrl(url);
	}
	
	public String getEmail() {
		String str=MailHelper.getRandomMailID();
		return str;
	}

	public void fillEmail(String mail) {
		enterText(txtEmail, mail, "Email");
	}
	public String getYOPMail() {
		return YopMail;
	}

	public void fillPhonenNumber(String phone) {
		enterText(txtPhoneNumber, phone, "Phone Number");
	}

	private By getXpath(String depName) {
		return By.xpath(String.format("//div[text()='%s']", depName));
	}

	/**
	 * parameter <b>deptName</b> must be same with the Drop down names available in
	 * the drop down.<br>
	 * for an example:
	 * <ul>
	 * Administrator, Underwriting, Development, Accounting, Support etc.
	 * </ul>
	 * 
	 * @param deptName
	 */
	public void selectDepartment(String deptName) {
		new CommonFunctions().verifyCursorAction(ddDepartment, "Department dropdown");
		click(ddDepartment, "Department Dropdown");
		click(getXpath(deptName), deptName); // "Administrator"

	}

	private By getPermissionsXpath(String permsName) {
		return By.xpath(String.format("//p[contains(@class,'GreenBoxUserForm_role_name')][text()='%s']", permsName));
	}

	/**
	 * parameter <b>permsName</b> must be same with the Permission roles available in
	 * the section<br>
	 * for an example:
	 * <ul>
	 * Super Administrator, Administrator (Full Access), Product, Development,
	 * Accounting, Support etc.
	 * </ul>
	 * 
	 * @param permsName
	 */
	public void clickOnPermissionRole(String permsName) {
		new CommonFunctions().verifyCursorAction(getPermissionsXpath(permsName), permsName);
		click(getPermissionsXpath(permsName), permsName);
//		click(clkAccounting, "Accounting ");
	}

	public void clickSendInvitaion() {

		new CommonFunctions().verifyCursorAction(btnSendInvitation, "Send Invitation");
		click(btnSendInvitation, "Send Invitation");
	}

	public void clickActivateAccountInYOPMail(String firstname) throws InterruptedException, AWTException {
		YOPMail mail = new YOPMail();
		mail.openYopMail();
		mail.switchToYopmailWindow();
		mail.clickActivateAccount(YopMail, firstname);

	}

	public ActivateAccountComponent activateAccountComponent() {
		return new ActivateAccountComponent();
	}

	public static String generateEmail() {
		int length = 15;
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
			new CommonFunctions().validateField(ele, eleName, field[i]);
		}
		System.out.println(textField.length());
		for (int j = 4; j < 7; j++) {
			new CommonFunctions().validateTextFeild(ele, eleName, field[j]);
		}
		new CommonFunctions().validateFieldMaxichar(ele, eleName, field[7]);
	}

}
