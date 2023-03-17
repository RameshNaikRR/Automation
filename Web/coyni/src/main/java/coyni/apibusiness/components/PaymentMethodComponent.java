package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.api.business.popups.AddBankAccountPopup;
import coyni.api.business.popups.AddNewPaymentMethodPopup;
import coyni.api.business.popups.CardAddedSuccessfullyPopup;
import coyni.api.business.popups.PreAuthorizationPopup;
import coyni.api.business.popups.RemovePaymentMethodPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodComponent extends BrowserFunctions {

	private By btnAddNewPayment = By.xpath("//button[@id='big-add-payment-button']");
	private By lblbankName = By.xpath("//p[contains(text(),'%s')]");
	private By btnDelete = By.xpath("//button[@data-tip='Delete'][1]");
	private By btnEdit = By.xpath("//button[@data-tip='Edit'][1]");
	private By btnAddNewDebit = By.xpath("//span[text()='Debit Card']");
	private By clickClose = By.xpath("//img[@src='/static/media/x.85c835f41baf2a064acc5c6ba4aa0e89.svg']");
	private By clickDeleteClose = By.xpath("//img[@src='/static/media/x.85c835f41baf2a064acc5c6ba4aa0e89.svg']");

	public void clickAddNewPayment() {
		moveToElement(btnAddNewPayment, "Add New Payment Method");
		new CommonFunctions().verifyCursorAction(btnAddNewPayment, "Add New Payment");
//		new CommonFunctions().verifyTextUnderLine(btnAddNewPayment, "Add New Payment");
		click(btnAddNewPayment, "Add New Payment Method");
	}

	public void viewBankAccount() {
		new CommonFunctions().elementView(By.xpath(String.format("//button[@class='payment-method-button '][1]")), "Bank Account");
	}

	public void viewDebitCard() {
		new CommonFunctions().elementView(By.xpath(String.format("//button[@class='payment-method-button '][2]")), "Debit Card");
	}

	public void viewCogentAccount() {
		new CommonFunctions().elementView(By.xpath(String.format("//button[@class='payment-method-button '][3]")), "Cogent Account");
	}

	public void clickAddNewDebit() {
		click(btnAddNewDebit, "Add New Debit Card");
	}

	public void clickDeleteBank() {
		moveToElement(lblbankName, "Move to Bank name");
		click(btnDelete, "Click Delete");
	}

	public void clickEdit() {
		moveToElement(btnEdit, "Edit Debit Card");
		click(btnEdit, "Click Edit");
	}

	public void viewDeleteCard() {
		new CommonFunctions().verifyCursorAction(btnDelete, "Delete Debit Card");
		moveToElement(btnDelete, "Moved to Trash");

	}

	public void clickClose() {
		click(clickClose, "close");
	}

	public void viewEditCard() {
		new CommonFunctions().verifyCursorAction(btnEdit, "Edit Debit Card");
		moveToElement(btnEdit, "Edit Debit Card");

	}

	public void clickDeleteSignet(String SignetAccountNumber) {
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", SignetAccountNumber)), "Signet Account");
		click(btnDelete, "Delete Signet");
	}

	public void clickDebitCard(String DeleteDebit) {
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", DeleteDebit)), "Delete Debit Card");
		click(By.xpath(String.format("//p[contains(text(),'%s')]", DeleteDebit)), "Delete Debit");
	}

	public void clickDeleteBankAccount(String DeleteBank) {
		moveToElement(By.xpath(String.format("//p[contains(text(),'%s')]", DeleteBank)), "Delete Bank Account");
		click(btnDelete, "Delete Bank ");
	}

	public void clickDeleteClose() {
		click(clickDeleteClose, "close");
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

	public CardAddedSuccessfullyPopup cardAddedSuccessfullyPopup() {
		return new CardAddedSuccessfullyPopup();
	}

	public PreAuthorizationPopup preAuthorizationPopup() {
		return new PreAuthorizationPopup();
	}

	public AddBankAccountPopup addBankAccountPopup() {
		return new AddBankAccountPopup();
	}
}
