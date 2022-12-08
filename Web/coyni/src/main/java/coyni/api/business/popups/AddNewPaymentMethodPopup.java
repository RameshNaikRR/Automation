package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.AddCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddNewPaymentMethodPopup extends BrowserFunctions {
	private By lblAddNewPaymentMethodhdg = By.xpath("//h1[text()='Add New Payment Method']");
	private By btnBankAccount = By
			.xpath("//span[text()='Bank Account']");
	private By btnDebit = By
			.xpath("//button[@class='payment-method-button ']/following-sibling::*[1]/div/span[text()='Debit Card']");
	private By btnCogentAccount = By.xpath(
			"//button[@class='payment-method-button ']/following-sibling::*[1]/div/span[text()='Cogent Account']");

	public void clickBankAccount() {
		click(btnBankAccount, "Bank Account");
	}

	public void clickDebit() {
		click(btnDebit, "Click Debit");
	}

	public void clickCogentAccount() {
		click(btnCogentAccount, "Cogent Account");

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
	public void verifyHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblAddNewPaymentMethodhdg, "add New Payment Method", heading);
	}
}
