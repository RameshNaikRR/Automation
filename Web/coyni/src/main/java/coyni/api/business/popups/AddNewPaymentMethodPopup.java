package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.AddCardComponent;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewPaymentMethodPopup extends BrowserFunctions {

	private By btnBankAccount = By
			.xpath("//span[text()='Bank Account']");
	private By btnDebit = By
			.xpath("//button[@class='payment-method-button ']/following-sibling::*[1]/div/span[text()='Debit Card']");
	private By btnSignetAccount = By.xpath(
			"//button[@class='payment-method-button ']/following-sibling::*[1]/div/span[text()='Signet Account']");

	public void clickBankAccount() {
		click(btnBankAccount, "Bank Account");
	}

	public void clickDebit() {
		click(btnDebit, "Click Debit");
	}

	public void clickSignetAccount() {
		click(btnSignetAccount, "Signet Account");

	}

	public AddBankAccountPopup addBankAccountPopup() {
		return new AddBankAccountPopup();
	}

	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}

	public AddNewSignetAccountPopup addNewSignetAccountPopup() {
		return new AddNewSignetAccountPopup();
	}
}
