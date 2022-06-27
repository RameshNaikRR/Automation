package coyni.merchant.popups;

import org.openqa.selenium.By;


import coyni.merchant.components.AddCardComponent;
import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewPaymentMethodPopup extends BrowserFunctions {

	private By headingAddNewPaymentMethod = By.xpath("//h1[contains(text(),'Add New Payment Method')]");
	private By btnExternalBankAccount = By.xpath("//span[contains(text(),'Bank Account')]");
	private By btnDebitCard = By.xpath("//span[text()='Debit Card'] | //span[text()='Add New Debit Card']");
	private By btnCreditCard = By.xpath("//span[text()='Credit Card']");
	private By lblExternalBankAccountCount = By.xpath("(//span[@class='count'])[1]");
	private By lblDebitCardCount = By.xpath("(//span[@class='count'])[2]");
	private By lblCreditCardCount = By.xpath("(//span[@class='count'])[3]");

	public void clickaddExternalBankAccount() {
		click(btnExternalBankAccount, "Click ExternaBankAccount");

	}

	public void clickDebitCard() {
		click(btnDebitCard, "Click DebitCard");

	}

	public void clickCreditCard() {
		click(btnCreditCard, "Click CreditCard");
	}

	public String getExternalBankAccountCount() {
		return getText(lblExternalBankAccountCount, "External Bank Account Count");
	}

	public String getDebitCardCount() {
		return getText(lblDebitCardCount, "Debit Card Count");
	}

	public String getCreditCardCount() {
		return getText(lblCreditCardCount, "Credit Card Count");
	}

	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}

	public PreAuthorizationPopup preAuthorizationPopup() {
		return new PreAuthorizationPopup();
	}

	public AddNewDebitCardPopup addNewDebitCardPopup() {
		return new AddNewDebitCardPopup();
	}

	public void verifyAddNewPaymentMethodHeading() {
		new CommonFunctions().elementView(headingAddNewPaymentMethod, "Add New Payment Method heading");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public AddExternalBankAccountPopup addExternalBankAccountPopup() {
		return new AddExternalBankAccountPopup();
	}

}
