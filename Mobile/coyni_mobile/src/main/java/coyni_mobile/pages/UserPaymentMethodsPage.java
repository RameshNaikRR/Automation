package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class UserPaymentMethodsPage extends MobileFunctions{
	
	private By btnAddNewPaymentMethod = MobileBy.xpath("");
	private By lblCardNumber = MobileBy.xpath("");
	private By lblCardBrand = MobileBy.xpath("");
	
	public void clickAddNewPaymentMethods() {
		click(btnAddNewPaymentMethod, "Add New Payment Methods");
	}
	public void verifyCardNumber(String cardNumber) {
	//	new CommonFunctions().verifyLabelText(lblCardNumber, "cardNumber", cardNumber);
		
	}
	
	public void verifyCardBrand(String cardBrand) {
	//	new CommonFunctions().verifyLabelText(lblCardBrand, "cardBrand", cardBrand);
	}
	
	

}
