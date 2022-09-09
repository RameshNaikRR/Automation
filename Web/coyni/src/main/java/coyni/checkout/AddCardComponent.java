package coyni.checkout;

import org.openqa.selenium.By;

public class AddCardComponent extends coyni.merchant.components.AddCardComponent{
	
	
	private By lblDebitCard=By.xpath("//span[text()='Debit Card']");
	private By lblCreditCard=By.xpath("//span[text()='Credit Card']");
	
	public void clickDebitCard() {
		click(lblDebitCard, "");
	}
	public void clickCreditCard() {
		click(lblCreditCard, "");
	}

}
