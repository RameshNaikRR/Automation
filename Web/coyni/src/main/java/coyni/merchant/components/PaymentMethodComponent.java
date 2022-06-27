package coyni.merchant.components;

import org.openqa.selenium.By;
import coyni.merchant.popups.AddNewPaymentMethodPopup;
import coyni.merchant.popups.PreAuthorizationPopup;
import coyni.merchant.popups.RemovePaymentMethodPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodComponent extends BrowserFunctions {

	private By btnAddNewPayment = By.xpath("//span[text()='Add New Payment Method']");
	private By lblbankName = By.xpath("//p[contains(text(),'3456')]");
	private By btnDelete = By.xpath("//button[@data-tip='Delete'][1]");
	private By btnEdit = By.xpath("//button[@data-tip='Edit'][1]");

	public void clickAddNewPayment() {
		click(btnAddNewPayment, "Add New Payment Method");
	}

	public void clickDeleteBank() {
		moveToElement(lblbankName, "Move to Bank name");
		click(btnDelete, "Click Delete");
	}

	public void clickEdit() {
		moveToElement(btnEdit, "Edit Debit Card");
		click(btnEdit, "Click Edit");
	}

	public void clickDeleteSignet(String SignetAccountNumber) {
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", SignetAccountNumber)), "Signet Account");
		click(btnDelete, "Delete Signet");
	}

	public void clickDebitCard(String DeleteDebit) {
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", DeleteDebit)), "Delete Debit Card");
		click(btnDelete, "Delete Debit");
	}

	public void clickDeleteBankAccount(String DeleteBank) {
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", DeleteBank)), "Delete Bank Account");
		click(btnDelete, "Delete Bank ");
	}

	public void verifyAddNewPayment() {
		new CommonFunctions().elementView(btnDelete, getCopiedData());
	}

	public AddNewPaymentMethodPopup addNewPaymentMethodPopup() {
		return new AddNewPaymentMethodPopup();
	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}

	public PreAuthorizationPopup preAuthorizationPopup() {
		return new PreAuthorizationPopup();
	}
}
