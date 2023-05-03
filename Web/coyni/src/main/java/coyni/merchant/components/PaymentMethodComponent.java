package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.admin.pages.FeatureControlPage;
import coyni.merchant.popups.AddBankAccountPopup;
import coyni.merchant.popups.AddNewPaymentMethodPopup;
import coyni.merchant.popups.PreAuthorizationPopup;
import coyni.merchant.popups.RemovePaymentMethodPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodComponent extends BrowserFunctions {

	private By btnAddNewPayment = By.xpath("//span[text()='Add New Payment Method']");
	private By lblPaymentMethods = By.xpath("//span[contains(@class,'text-base text-cgy4')]");
	private By lblAddNewPaymentMethods = By.xpath("//h1[text()='Add New Payment Method']");
	private By lblBankName = By.xpath("//p[contains(text(),'Bank')]");
	private By btnDelete = By.xpath("//button[@data-tip='Delete'][1]");
	private By btnEdit = By.xpath("//button[@data-tip='Edit'][1]");
	private By lblSignetAccount = By.xpath("(//p[contains(text(),'Signet Wallet ID')])[1]");
	private By lblCogentAccount = By.xpath("(//p[contains(text(),'Cogent Wallet ID')])[1]");
	private By lblBankAccount = By.xpath("(//p[contains(text(),'WELLS FARGO BANK NA (ARIZ')])[1]");
	private By lblDebitCard = By.xpath("//p[contains(text(),'Mastercard')]");

	public void clickAddNewPayment() {
		click(btnAddNewPayment, "Add New Payment Method");
	}

	public void verifyPaymentMethodsview() {
		new CommonFunctions().elementView(lblPaymentMethods, "PaymentMethods");
	}

	public void clickDeleteSignetAccount(String number) {
		moveToElement(lblSignetAccount, "Signet Account");
		click(btnDelete, "Delete");
	}

	public void clickDeleteCogentAccount(String number) {
		moveToElement(lblCogentAccount, "Cogent Account");
		click(btnDelete, "Delete");
	}

	public void clickOnDeleteBankAccount(String number) {
		moveToElement(lblBankAccount, "Bank Account");
		click(btnDelete, "Delete");
	}

	public void clickDeleteDebitCard(String number) {
		moveToElement(lblDebitCard, "Debit Card");
		click(btnDelete, "Delete");
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

	public AddBankAccountPopup addExternalBankAccountPopup() {
		return new AddBankAccountPopup();
	}

	public EditCardComponent editCardComponent() {
		return new EditCardComponent();
	}

	public FeatureControlPage featureControlPage() {
		return new FeatureControlPage();

	}

	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}

	public AddBankAccountPopup addBankAccountPopup() {
		return new AddBankAccountPopup();
	}

	public CardsComponent cardsComponent() {
		return new CardsComponent();
	}

}
