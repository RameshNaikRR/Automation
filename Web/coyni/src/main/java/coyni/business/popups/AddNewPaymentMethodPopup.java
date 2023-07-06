package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.business.components.AddCardComponent;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewPaymentMethodPopup extends BrowserFunctions {
	private By headingAddNewPaymentMethod = By.xpath("");
	private By btnExternalBankAccount = By.xpath("");
	private By btnDebitCard = By.xpath("");
	private By lblExternalBankAccountCount = By.xpath("");
	private By lblDebitCardCount = By.xpath("");

	public void clickaddExternalBankAccount() {
		click(btnExternalBankAccount, "Click ExternaBankAccount");

	}

	public void clickDebitCard() {
		click(btnDebitCard, "Click DebitCard");

	}

	public String getExternalBankAccountCount() {
		return getText(lblExternalBankAccountCount, "External Bank Account Count");
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
