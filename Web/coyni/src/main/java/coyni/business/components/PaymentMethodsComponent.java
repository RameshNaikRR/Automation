package coyni.business.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.business.popups.AddBankAccountPopup;
import coyni.business.popups.AddBankCheckingAccountPopup;
import coyni.business.popups.AddNewPaymentMethodPopup;
import coyni.business.popups.RemovePaymentMethodPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PaymentMethodsComponent extends BrowserFunctions {
	private By btnAddNewPaymentMethod = By.xpath("//button[@data-ui-auto='add_payment_method_button']");
	private By lblNoActivePaymentMethods = By.cssSelector("");
	private By lblPaymentMethods = By.xpath("//div[@data-ui-auto='payment_method']");
	private By lblAddNewPaymentMethods = By.xpath("//h1[text()='Add New Payment Method']");
	private By lblBankName = By.xpath(" //p[contains(text(),'BANK')]");
	private By btnDelete = By.xpath("//button[contains(@class,'icon-trash')]");
	private By lblCardList = By.xpath("");
	private By lblBankList = By.xpath("");

	public void clickAddNewPaymentMethod() {
		click(btnAddNewPaymentMethod, "Add Payment Method");
	}

	/*
	 * public void verifyNoActiveMethods(String expLabel) { new
	 * CommonFunctions().verifyLabelText(lblNoActivePaymentMethods,
	 * "No Active Payment methods", expLabel); }
	 */
	public void verifyPaymentMethodsview() {
		new CommonFunctions().elementView(lblPaymentMethods, "PaymentMethods");
	}

	public void verifyAddNewPaymentMethods(String expHeading) {
		new CommonFunctions().verifyLabelText(lblAddNewPaymentMethods, "Add New Payment Methods PopUp Heading",
				expHeading);
	}

//	public CardsComponent cardsComponent() {
//		return new CardsComponent();
//	}
	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}

//	 public BankAccountsComponent bankAccountsComponent(){
//	 return new BankAccountsComponent();

//	 }
	public void verifyBankName() {
		moveToElement(lblBankName, "Bank Name");
	}

	public void clickDelete() {
		click(btnDelete, "Delete Bank");
	}

	public void cardDetails() {

		// String[] column = columns.split(",");
		List<WebElement> list = getElementsList(lblCardList, "Card list ");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String label = list.get(i).getText();
			ExtentTestManager.setInfoMessageInReport("Card details" + ": " + label);
		}
	}

	public void bankDetails() {

		// String[] column = columns.split(",");
		List<WebElement> list = getElementsList(lblBankList, "Bank list ");
		int size = list.size();
		for (int i = 0; i < size; i++) {
			String label = list.get(i).getText();
			ExtentTestManager.setInfoMessageInReport("Bank details" + ": " + label);
		}
	}

	public AddNewPaymentMethodPopup addNewPaymentMethodPopup() {
		return new AddNewPaymentMethodPopup();
	}

	public CardsComponent cardsComponent() {
		return new CardsComponent();
	}

	public EditandDeleteComponent editandDeleteComponent() {
		return new EditandDeleteComponent();
	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}

	public AddBankAccountPopup addBankAccountPopup() {
		return new AddBankAccountPopup();
	}

	public AddBankCheckingAccountPopup addBankCheckingAccountPopup() {
		return new AddBankCheckingAccountPopup();
	}
}
