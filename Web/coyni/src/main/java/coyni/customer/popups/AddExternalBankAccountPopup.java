package coyni.customer.popups;


import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.customer.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddExternalBankAccountPopup extends BrowserFunctions {
	
	private By btnIamReady = By.xpath("//button[contains(text(),'Ready')]");
	private By txtBankName = By.xpath("//input[@id='searchbar']");
	private By lnkLearnMore = By.cssSelector(" ");
	private By btnBack = By.cssSelector(" ");
	private By headingNewPage = By.xpath("//h1[contains(text(),'Add Accounts')]");
	private By headingAddBankAccount = By.xpath("//h1[contains(text(),'Add Bank Account')]");
	private By lnkBankName = By.xpath("(//div[@class='autoResultBankName'])[1]");
	private By txtUserName = By.xpath("(//div[@class='form-group']//input[contains(@name,'acctForm:j_')] )[1]");
	private By txtPassword = By.xpath("(//div[@class='form-group']//input[contains(@name,'acctForm:j_')] )[2]");
	private By btnNext = By.xpath("(//span[text()='Next'])[1]");
	private By chckBoxBank1 = By.xpath("(//div[@class='custom-control custom-checkbox'])[1]");
	private By chckBoxBank2 = By.xpath("(//div[@class='custom-control custom-checkbox'])[2]");
	
	public void clickIamReady() {
		click(btnIamReady, "click IamReady");
	}
	public void clickLearnMore() {
		 click(lnkLearnMore, "Learm More");
	}
	
	
	
	public void clickBack() {
		click(btnBack, "Back");
	}
	
	public void switchToWindow() {
		new CommonFunctions().switchTodWindow();
	}
     
	public void verifyHeading() {
		new CommonFunctions().elementView(headingAddBankAccount, "Heading Add Account Bank");
	}
	
	public void verifyNewWindowHeading() {
		new CommonFunctions().elementView(headingNewPage, "Heading New Page");
	}
	
	public void enterBankName(String expBanName) {
		enterText(txtBankName, expBanName, "Bank Name");
	}
    
	public void clickOnBankName() {
		click(lnkBankName,"Bank Name");
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
	
	
	
	public void clickUncheckBank() {
		click(btnNext,"Click Next");
	}
	
	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
	}


