package coyni.customer.components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class MailingAddressComponent extends BrowserFunctions {
	
	private By txtAddress1 = By.name("addressLine1");

	private By txtAddresss2 = By.name("addressLine2");

	private By txtCity = By.name("city");

	private By drpDwnState = By.xpath("//div[text()='State']/parent::div");

	private By txtZipCode = By.name("zipCode");
	
	private By labelCardBrand = By.xpath("//div[contains(@class,'absolute right-0 -top-0.5 text-3xl')]");
	private By txtCountry = By.xpath("//div[text()='United States']");

	private By btnSave = By.xpath("//button[@type=\"submit\"]");
	private By lblState =By.xpath("//div[text()='State']/parent::div");

	
	public void fillAddress1(String address1) {
		enterText(txtAddress1, address1, "address line 1");
	}

	public void fillAddress2(String address2) {
		enterText(txtAddresss2, address2, "address line 2");
	}

	public void fillCity(String city) {
		enterText(txtCity, city, "city");
	}
	public void selectState(String state) {
		click(drpDwnState, "State DropDown");
		new CommonFunctions().selectCustomDropDown(state, "State");
	}

	public void fillZipCode(String zipCode)
	{
		enterText(txtZipCode, zipCode, "ZipCode");
	}
	public void verifyCountry(String country) {
		new CommonFunctions().verifyLabelText(txtCountry, country, "country");
	}
	public void clickCountry() {
		click(txtCountry, "Country");
	}

	public void clickSave() {
		click(btnSave, "click save");
	 }
	 public void clickstate() {
	    	click(lblState, "State");
	 }  
	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return  new SuccessFailurePopupCardComponent();
	}
	public BackandCrossIconComponent backandCrossIconComponent() {
		return new BackandCrossIconComponent();
	}
	 public void clickTab() throws AWTException {
	    	Robot robot = new Robot();
	    	robot.keyPress(KeyEvent.VK_TAB);
	    	robot.keyRelease(KeyEvent.VK_TAB);
	    	}
	    
	 public void validateCardBrand(String cardType) {
			String brandClass = getAttributeValue(labelCardBrand, "class", "card brand");
			cardType = cardType.toLowerCase();
			if (brandClass.contains(cardType)) {
				ExtentTestManager.setPassMessageInReport("valid card type: "+cardType.toUpperCase());
			}else {
				ExtentTestManager.setFailMessageInReport("invalid card type: "+cardType.toUpperCase());
			}
		}



}