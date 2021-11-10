package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ErrorWithBackAccountVerificationPage extends MobileFunctions{
	
	private By btnAddCreditAndDebitCard = MobileBy.xpath("");
	
	public void clickAddCreditAndDebitCard() {
		click(btnAddCreditAndDebitCard, "AddCredit/DebitCard");
	}

}
