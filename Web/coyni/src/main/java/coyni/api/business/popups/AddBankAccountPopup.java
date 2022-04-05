package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.SuccessFailureComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddBankAccountPopup extends BrowserFunctions{
	
	private By btnIamReady = By.xpath("");
    private By headingNewWindow = By.xpath("//h1[text()='Add Accounts']");
    private By txtBankName = By.xpath("//input[@id='searchbar']");
    private By lnkBankName = By.xpath("(//div[@class='autoResultBankName'])[1]");
	private By txtUserName = By.xpath("//input[@name='acctForm:j_idt143:0:login_']");
	private By txtPassword = By.xpath("//input[@name='acctForm:j_idt147:0:password_']");
	private By btnNext = By.xpath("(//span[text()='Next'])[1]");
	private By chckBoxBank1 = By.xpath("(//div[@class='custom-control custom-checkbox'])[1]");
	private By chckBoxBank2 = By.xpath("(//div[@class='custom-control custom-checkbox'])[2]");
    		
	
	public void clickIamReady() {
		click(btnIamReady, "I am Ready");
	}
	
	public void switchToWindow() {
		new CommonFunctions().switchTodWindow();
	}
	
	public void verifyNewHeading(String expNewWindowHeading) {
		new CommonFunctions().verifyLabelText(headingNewWindow, "New Window Heading", expNewWindowHeading);
	}
	
	public void enterBankName(String expBankName) {
		enterText(txtBankName, expBankName, "Bank Name");
	}
	
	public void enterUserName(String expUserName) {
		enterText(txtUserName,expUserName,"User Name");
	}
	
	public void enterPassword(String expPassword) {
		enterText(txtPassword, expPassword, "User Name");
	}
	
	public void clickNext() {
		click(btnNext,"Click Next");
	}
	
	public void unSelectBank() {
		click(chckBoxBank1, "UnSelect Bank");
		click(chckBoxBank2, "UnSelect Bank");
		
	}
	
	public void clickOnBankName() {
		click(lnkBankName,"Click Bank Name");
	}
	
	
	
	public void clickUncheckBank() {
		click(btnNext,"Click Next");
	}
	
	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}
	
}
