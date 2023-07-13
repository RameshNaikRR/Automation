package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.business.components.AddCardComponent;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewPaymentMethodPopup extends BrowserFunctions {
	private By headingAddNewPaymentMethod = By.xpath("//h1[text()='Add New Payment Method']");
	private By btnExternalBankAccount = By.xpath("//span[@data-ui-auto='Bank Account']");
	private By btnDebitCard = By.xpath("//p[@data-ui-auto='credit_card_details']");
	private By lblDebitCardCount = By.xpath("//span[@data-ui-auto='count']");

	public void clickaddExternalBankAccount() {
		click(btnExternalBankAccount, "Click ExternaBankAccount");

	}

	public void clickDebitCard() {
		click(btnDebitCard, "Click DebitCard");

	}

	public String getDebitCardCount() {
		return getText(lblDebitCardCount, "Debit Card Count");
	}

	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}
//
//	public AddNewDebitCardPopup addNewDebitCardPopup() {
//		return new AddNewDebitCardPopup();
//	}
//
//	public void verifyAddNewPaymentMethodHeading() {
//		new CommonFunctions().elementView(headingAddNewPaymentMethod, "Add New Payment Method heading");
//	}
//
//	public NavigationComponent navigationComponent() {
//		return new NavigationComponent();
//	}
//
//	public AddExternalBankAccountPopup addExternalBankAccountPopup() {
//		return new AddExternalBankAccountPopup();
//	}
//
//	public AddBankAccountPopup addBankAccountPopup() {
//		return new AddBankAccountPopup();
//	}
}
