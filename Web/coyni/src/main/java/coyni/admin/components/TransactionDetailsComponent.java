package coyni.admin.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TransactionDetailsComponent extends BrowserFunctions {

	private By lblTransactionType = By.cssSelector(" ");
	private By lblAmountSent = By.cssSelector(" ");
	private By lblProcessingFee = By.cssSelector(" ");
	private By lblTotalAmount = By.cssSelector(" ");
	private By lblAccountBalance = By.cssSelector(" ");
	
	public String getlblTransactionType() {
	return	getText(lblTransactionType, "Transaction type");
	}
	public String getlblAmountSent() {
		return getText(lblAmountSent, "Amount sent");
	}
    public String getlblProcessingFee() {
    	return getText(lblAccountBalance, "Procesing Fee");
    }
    public String getlblTotalAmount(){
    	return getText(lblTotalAmount, "Total Amount");
    	}
    public String getlblAccountBalance() {
    	return getText(lblAccountBalance, "Account Balance");
    }
}
