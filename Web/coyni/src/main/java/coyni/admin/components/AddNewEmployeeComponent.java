package coyni.admin.components;

import java.awt.AWTException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import coyni.uitilities.YOPMail;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddNewEmployeeComponent extends BrowserFunctions {
	private By lblAddNewEmployee=By.xpath("//span[text()='Add New Employee']");
	private By txtFirstName=By.name("firstName");
	private By txtLastName=By.name("lastName");
	private By txtEmail=By.name("email");
	private By txtPhoneNumber=By.name("phoneNumber");
	private By ddDepartment=By.className("FormField_selected_option__7Rw29");
	private static String YopMail=generateEmail();
	private By ddElmAdministrator=By.xpath("//div[text()='Administrator']");
	private By clkAccounting=By.xpath("//p[text()='Accounting']");
	private By btnSendInvitation=By.xpath("//button[@type='submit']");
	
	
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

	public void fillEmail() {
		enterText(txtEmail, YopMail, "Email");
	}
	
	public void fillPhonenNumber(String phone) {
		enterText(txtPhoneNumber, phone, "Phone Number");
	}
	
	public void selectDepartment() {
		new CommonFunctions().verifyCursorAction(ddDepartment, "Department dropdown");
		click(ddDepartment, "Department Dropdown");
		click(ddElmAdministrator, "Administrator");
		
	}
	
	public void clickAccounting() {
		new CommonFunctions().verifyCursorAction(clkAccounting, "Accounting");
		click(clkAccounting, "Accounting ");
	}
	
	public void clickSendInvitaion() {
		
		new CommonFunctions().verifyCursorAction(btnSendInvitation, "Send Invitation");
		click(btnSendInvitation, "Send Invitation");
	}
	
	public void clickActivateAccountInYOPMail(String firstname) throws InterruptedException, AWTException {
		YOPMail mail=new YOPMail();
		mail.openYopMail();
		mail.switchToYopmailWindow();
		mail.clickActivateAccount(YopMail, firstname);
		
	}
	
	public ActivateAccountComponent activateAccount() {
		return new ActivateAccountComponent();
	}
	
	
	public static String generateEmail() {
		int length = 10;
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
