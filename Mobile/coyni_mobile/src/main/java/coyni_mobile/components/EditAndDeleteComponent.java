package coyni_mobile.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditAndDeleteComponent extends MobileFunctions{
	private By cardNumber = MobileBy.xpath("//*[contains(@resource-id,'tvCardNumber')]");
	
	public String getCardNumber(int number) {
		 List<WebElement> cardNumbers = getElementList(cardNumber, "card number");
		 String  cardNumber = cardNumbers.get(number).getText();
		 ExtentTestManager.setInfoMessageInReport("card number is" + cardNumber);
		 return cardNumber;
		
	}
	public void clickEdit(String number) {
		click(MobileBy.xpath(String.format("//*[@text='%s']", number)), number);
		ExtentTestManager.setInfoMessageInReport("Edit button clicked for card" + number);
	}
	
	

}
