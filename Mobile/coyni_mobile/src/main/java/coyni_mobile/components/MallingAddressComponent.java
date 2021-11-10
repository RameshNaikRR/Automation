package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class MallingAddressComponent extends MobileFunctions{
	
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
//	public void selectDropDown() {   ----pending?
//		selectDropDown();
//	}
	public void fillZipCode(String zipCode) {
		enterText(txtZipCode, zipCode, "ZipCode");
	}
//	public void verifyCountry() {------pending?
//		getText(lblCountry);
//	}
	public void clickAddCard() {
		click(btnAddCard, "Add Card");
	}

}
