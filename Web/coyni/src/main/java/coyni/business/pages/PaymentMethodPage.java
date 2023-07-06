package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodPage extends BrowserFunctions {
	private By btnAddNewPayment = By.xpath("//span[text()='Add New Payment Method']");
	private By lblPaymentMethods = By.xpath("//span[contains(@class,'text-base text-cgy4')]");
	private By lblAddNewPaymentMethods = By.xpath("//h1[text()='Add New Payment Method']");
	private By lblBankName = By.xpath("//p[contains(text(),'4219')]");
	private By btnDelete = By.xpath("(//button[@data-tip='Delete'])[1]");
	private By btnEdit = By.xpath("//button[@data-tip='Edit'][1]");

	public void clickAddNewPayment() {
		click(btnAddNewPayment, "Add New Payment Method");
	}

	public void verifyPaymentMethodsview() {
		new CommonFunctions().elementView(lblPaymentMethods, "PaymentMethods");
	}

	public void clickDeleteBank() {
		moveToElement(lblBankName, "Move to Bank name");
		click(btnDelete, "Click Delete");
	}

	public void verifyAddNewPaymentMethods(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddNewPaymentMethods, "Add New Payment Methods PopUp Heading",
				expHeading);
	}

	public void clickEdit() {
		moveToElement(btnEdit, "Edit Debit Card");
		click(btnEdit, "Click Edit");
	}

	public void verifyBankName() {
		moveToElement(lblBankName, "Bank Name");
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

}
