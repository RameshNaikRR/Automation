package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class CardsComponent extends BrowserFunctions {
	
	private By lblCardNumber = By.cssSelector("");
	private By lblCardBrand  = By.cssSelector("");
	private By lblCardType = By.cssSelector("");
	private By iconEdit = By.cssSelector("");
	private By iconDelete = By.cssSelector("");
	private By lblAddress = By.cssSelector("");
	private By lblExpired = By.cssSelector("");
	
	
	public void verifyCardNumber(String last4digts) {
		new CommonFunctions().verifyLabelText(lblCardNumber, "Last 4 Digits", last4digts);
	}
	public void verifyCardBrand(String cardBrand) {
		new CommonFunctions().verifyLabelText(lblCardBrand, "Card Brand", cardBrand);
	}
	public void verifyCardType(String cardType) {
		new CommonFunctions().verifyLabelText(lblCardType, "Card Type", cardType);
	}
    public void verifyCardAddresss(String address) {
    	new CommonFunctions().verifyLabelText(lblAddress, "Address", address);
    }
    
    //DOUBT - are we going  to add the parameter "card Number " in the xpath of lblExpired?
    public void verifyCardExpired(String cardNumber ,String expExpired) {
    	new CommonFunctions().verifyLabelText(lblExpired, "Expired", expExpired);
    }
    //DOUBT 
    public void clickEdit(String cardNumber) {
    	click(iconEdit, "Edit icon");
    }
    //DOUBT
    public void clickDelete(String cardNumber) {
    	click(iconDelete, "Delete icon");
    }




	
    

}
