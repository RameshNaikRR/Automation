package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.api.business.popups.AddNewPaymentMethodPopup;
import coyni.api.business.popups.RemovePaymentMethodPopup;
import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodComponent extends BrowserFunctions{

	private By btnAddNewPayment = By.xpath("//button[@id='big-add-payment-button']");
	private By lblbankName = By.xpath("//p[contains(text(),'3456')]");
	private By btnDelete = By.xpath("(//button[@data-tip='Delete'])[1]");
	
	
	public void clickAddNewPayment() {
		click(btnAddNewPayment, "Add New Payment Method");
	}
	
	public void clickDeleteBank() {
		moveToElement(lblbankName, "Move to Bank name");
	    click(btnDelete, "Click Delete");
	}
	
	public AddNewPaymentMethodPopup addNewPaymentMethodPopup() {
		return new AddNewPaymentMethodPopup();
	}
	
	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}
	
}
