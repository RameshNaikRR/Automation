package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class MailingAddressComponent extends MobileFunctions{
	
	private By txtAddressLine1 = MobileBy.xpath("//*[@name='Address Line 1']");
	private By txtAddressLine2 = MobileBy.xpath("//*[contains(@name,'Line 2')]");
	private By txtCity = MobileBy.xpath("//*[@name='City']");
	private By drpDwnState = MobileBy.xpath("//*[@name='State']");
	private By txtZipCode = MobileBy.xpath("//*[@name='Zip Code']");
	private By lblCountry = MobileBy.xpath("//*[@name='Country']");
	private By btnAddCard = MobileBy.xpath("");
	private By txtState = MobileBy.xpath("//*[@name='search']/following-sibling::*[1]");
	private By btnConfirmState = MobileBy.xpath("//*[@name='search']/../following-sibling::*[@name='Done']");
	private By btnDone = MobileBy.xpath("//*[@name='Title']/preceding-sibling::*[1]");
	
	public void fillAddressLine1(String addressLine1) {
		new CommonFunctions().clearText(txtAddressLine1, "Address Line1");
		enterText(txtAddressLine1, addressLine1, "Address Line1");
	}
	public void fillAddressLine2(String addressLine2) {
		//new CommonFunctions().clearText(txtAddressLine2, "Address Line2");
		//enterText(txtAddressLine2, addressLine2, "Address Line2");
	}
	public void fillCity(String city) {
		new CommonFunctions().clearText(txtCity, "City");
		enterText(txtCity, city, "City");
		click(btnDone, "Done");	}
	
	public void selectState(String state) { 
		click(drpDwnState, "State Drop down");
		enterText(txtState, state, "State");
		click(MobileBy.xpath(String.format("//*[@name='%s']", state)), "state");
		click(btnDone, "Done");
		click(btnConfirmState, "Done");
	}
	public void fillZipCode(String zipCode) {
		new CommonFunctions().clearText(txtZipCode, "Zip Code");
		enterText(txtZipCode, zipCode, "Zip Code");
		click(btnDone, "Done");	}
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
