package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.PreAuthorizationPage;
import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class MailingAddressComponent extends MobileFunctions{
	
	private By txtAddressLine1 = MobileBy.xpath("//*[contains(@resource-id,'etAddress1')]");
	private By txtAddressLine2 = MobileBy.xpath("//*[contains(@resource-id,'etAddress2')]");
	private By txtCity = MobileBy.xpath("//*[contains(@resource-id,'etCity')]");
	private By drpDwnState = MobileBy.xpath("//*[contains(@resource-id,'etState')]");
	private By txtZipCode = MobileBy.xpath("//*[contains(@resource-id,'etZipCode')]");
	private By lblCountry = MobileBy.xpath("//*[contains(@resource-id,'etCountry')]");
	private By btnAddCard = MobileBy.xpath("//*[contains(@resource-id,'cvAddCard')]");
	private By txtState = MobileBy.xpath("//*[contains(@resource-id,'searchET')]");
	private By btnConfirmState = MobileBy.xpath("//*[contains(@resource-id,'cvAction')]");
	private By btnSave = MobileBy.xpath("//*[contains(@resource-id,'cvSave')]");
	private By btnRemove = MobileBy.xpath("//*[contains(@resource-id,'cvRemove')]");
	private By btnNo = MobileBy.xpath("//*[contains(@resource-id,'tvNo')]");
	private By btnYes = MobileBy.xpath("//*[contains(@resource-id,'tvYes')]");
	
	public void fillAddressLine1(String addressLine1) {
		click(txtAddressLine1, "Address Line1");
		enterText(txtAddressLine1, addressLine1, "Address Line1");
	}
	public void fillAddressLine2(String addressLine2) {
		scrollDownToElement(txtAddressLine2, "Address Line2");
		click(txtAddressLine2, "Address Line2");
		enterText(txtAddressLine2, addressLine2, "Address Line2");
	}
	public void fillCity(String city) {
		scrollDownToElement(txtAddressLine2, "Address Line2");
		click(txtCity, "City");
		enterText(txtCity, city, "City");
		new CommonFunctions().clickEnter();
		}
	
	public void selectState(String state) throws InterruptedException { 
		click(drpDwnState, "State Drop down");
		enterText(txtState, state, "State");
		Thread.sleep(2000);
		new CommonFunctions().clickEnter();
		//click(MobileBy.xpath(String.format("//*[@text='%s']", state)), "state");
		new CommonFunctions().clickEnter();
		click(btnConfirmState, "Done");
	}
	public void fillZipCode(String zipCode) {
		scrollDownToElement(txtZipCode, "Zip Code");
		click(txtZipCode, "zip Code");
		enterText(txtZipCode, zipCode, "Zip Code");
		new CommonFunctions().clickEnter();
		}
	public void verifyCountry(String expCountry) {
		new CommonFunctions().verifyLabelText(lblCountry, "Country", expCountry);
	}
	public void clickAddCard() {
		scrollDownToElement(btnAddCard, "Add Card");
		click(btnAddCard, "Add Card");
	}
	public void clickSave() {
		scrollDownToElement(btnSave, "Save");
		click(btnSave, "Save");
	}
	public void clickRemove() {
		scrollDownToElement(btnRemove, "Remove");
		click(btnRemove, "Remove");
	}
	public void clickNo() {
		click(btnNo, "No");
	}
	public void clickYes() {
		click(btnYes, "Yes");
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
   public PreAuthorizationPage preAuthorizationPage() {
	   return new PreAuthorizationPage();
   }
	
}
