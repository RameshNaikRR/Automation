package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class MailingAddressComponent extends MobileFunctions{
	
	private By txtAddressLine1 = MobileBy.xpath("");
	private By txtAddressLine2 = MobileBy.xpath("");
	private By txtCity = MobileBy.xpath("");
	private By drpDwnState = MobileBy.xpath("");
	private By txtZipCode = MobileBy.xpath("");
	private By lblCountry = MobileBy.xpath("");
	private By btnAddCard = MobileBy.xpath("");
	
	public void fillAddressLine1(String addressLine1) {
		enterText(txtAddressLine1, addressLine1, "Address Line1");
	}
	public void fillAddressLine2(String addressLine2) {
		enterText(txtAddressLine2, addressLine2, "Address Line2");
	}
	public void fillCity(String city) {
		enterText(txtCity, city, "City");
	}
	public void selectState() {  
		//
	}
	public void fillZipCode(String zipCode) {
		enterText(txtZipCode, zipCode, "ZipCode");
	}
	public void verifyCountry(String expCountry) {
		new CommonFunctions().verifyLabelText(lblCountry, "Country", expCountry);
	}
	public void clickAddCard() {
		click(btnAddCard, "Add Card");
	}
   public void verifyAddressLine1View() {
	   new CommonFunctions().elementView(txtAddressLine1, "Address line1 text field");
   }
	
   public void verifyAddressLine2View() {
	   new CommonFunctions().elementView(txtAddressLine2, "Address line2  text field");
   }
   public void verifyCityView() {
	   new CommonFunctions().elementView(txtCity, "City text field");
   }
   public void verifyStateView() {
	   new CommonFunctions().elementView(drpDwnState, "State dropdown");
   }
   public void verifyZipCodeView() {
	   new CommonFunctions().elementView(txtZipCode, "ZipCode  text field");
   }
	
}
