package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddBankAccountPopup extends BrowserFunctions {

	private By lblNameOnBankAccount = By.xpath("//input[@name='fullName']");
	private By txtRoutingNumber = By.xpath("//input[@id='Routing Number']");
    private By txtConfirmRouting = By.xpath("//input[@id='Confirm Routing Number']");
    private By txtAccountNumber = By.xpath("//input[@id='Checking Account Number']");
    private By txtConfirmAccount = By.xpath("//input[@id='Confirm Account Number']");
    private By btnAdd = By.xpath("//button[text()='Add']");
    private By btnFindYourAccount =By.xpath("//button[text()='Find Your Account Numbers']");
    private By heading = By.xpath("//h1[text()='Add Bank Account']");
    
    
    public void verifyHeading() {
    	new CommonFunctions().elementView(heading, "Heading");
    }
    
    
    public void verifyNameOnAccount () {
    	String str = getText(lblNameOnBankAccount, "Name On Bank Account");
    	ExtentTestManager.setInfoMessageInReport(" Name on Bank Account " + str);
    }
    
    public void enterRoutingNumber(String expRoutingNumber) {
    	enterText(txtRoutingNumber, expRoutingNumber, "Routing Number");
    }
    
    public void enterConfirmRouting(String expConfirmRouting) {
    	enterText(txtConfirmRouting, expConfirmRouting, "Confirm Routing Number");
    }
    
    public void enterAccountNumber(String expAccountNumber) {
    	enterText(txtAccountNumber, expAccountNumber, "Account Number");
    }
   
    public void enterConfirmAccountNumber(String expConfirmAccount) {
    	enterText(txtConfirmAccount, expConfirmAccount, "Confirm Account Number");
    }
    
    public void clickAdd() {
    	click(btnAdd, "Add");
    }
    
    public void clickFindYourAccount() {
    	click(btnFindYourAccount, "Find Your Account Number");
    }
    
    public BankAccountAddedPopup bankAccountAddedPopup() {
    	return new BankAccountAddedPopup();
    }
    
    public FindYourAccountNumbersPopup findYourAccountNumbersPopup() {
    	return new FindYourAccountNumbersPopup();
    }
}
	