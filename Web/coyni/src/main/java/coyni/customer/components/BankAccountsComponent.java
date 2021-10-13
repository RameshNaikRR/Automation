package coyni.customer.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BankAccountsComponent extends BrowserFunctions {
	
	private By lblAccountNumber = By.cssSelector("");
	
	private By lblBankName =By.cssSelector("");
	
	private By lblAddress = By.cssSelector("");
	
	private By iconDelete = By.cssSelector("");
	
	private By iconRelink = By.cssSelector("");
	
	public void verifyAccountNumber(String last4digits) {
	List<WebElement> accountNumbers = getElementsList(lblAccountNumber, "account number");
//	String account_number = accountNumbers.get(last4digits).getText();//
	
	}
	
	public void verifyBankName(String bankName) {
		new CommonFunctions().verifyLabelText(lblBankName, "bank name", bankName);
	}
 
	public void verifyAddress(String address) {
		new CommonFunctions().verifyLabelText(lblAddress, "address", address);
	}
	
	public void clickDelete(int accNumber) {
		 //
	}






}
