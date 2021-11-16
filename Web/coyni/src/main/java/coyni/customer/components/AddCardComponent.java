package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddCardComponent extends BrowserFunctions{
	
	private By txtNameOnCard =By.id("name-on-card");
	
	private By txtCardNumber = By.name("cardNumber");
	
	private By lblCardType =By.name("");
	
	private By txtCardExp =By.name("expiryDate");
	
	private By txtCVVorCVC =By.name("cvv");
	private By lblErrorMsg = By.cssSelector("span.text-crd5 ");

    public void fillNameOnCard(String nameOnCard) {
    	enterText(txtNameOnCard, nameOnCard, "Name On Card");
    }
    public void fillCardNumber(String cardNumber) {
    	enterText(txtCardNumber, cardNumber, "Card Number");
    }
    public void verifyCardType(String cardType) {
    	new CommonFunctions().verifyLabelText(lblCardType, "Card Type", cardType);
    }
    public void fillCardExpiry(String cardExpiry) {
    	enterText(txtCardExp, cardExpiry, "Card Expiry");
    }
    public void fillCVVorCVC(String cvvOrCvc) {
    	enterText(txtCVVorCVC, cvvOrCvc, "CVV or CVC");
    }
    public void verifylblErrorMsg(String expErrorMsg) {
    	new CommonFunctions().verifyLabelText(lblErrorMsg, "Error Message", expErrorMsg);
    	
    }
    
  
    public MailingAddressComponent mailingAddressComponent() {
    	return new MailingAddressComponent();
    }






   



}
