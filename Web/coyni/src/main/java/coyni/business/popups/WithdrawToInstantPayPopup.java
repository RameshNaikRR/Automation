package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawToInstantPayPopup extends BrowserFunctions {
	private By heading = By.xpath("");
	private By lbldescription = By.xpath("");
	private By subHeading = By.xpath("");
	private By toggledelete = By.xpath("");
	private By toggleEdit = By.xpath("");
	private By toggleradio = By.xpath("");
	private By lnkAddDebitcard = By.xpath("");
	private By next = By.xpath("");
	private By amount = By.xpath("");
	private By availableBalance = By.xpath("");
	private By lnkChange = By.xpath("");
	private By note = By.xpath("");

	public void verifyHeading(String instantPayHeading) {
		new CommonFunctions().verifyLabelText(heading, "Heading is :", instantPayHeading);
	}

	public void verifyDescription(String description) {
		new CommonFunctions().verifyLabelText(lbldescription, "Description is :", description);
	}

	public void verifySubHeading(String cardHeading) {
		new CommonFunctions().verifyLabelText(subHeading, "Sub Heading is :", cardHeading);
	}

	public void clickEdit() {
		click(toggleEdit, "Edit");
	}

	public void clickDelete() {
		click(toggledelete, "Delete");
	}

	public void clickRadioButton() {
		click(toggleradio, "Radio button");
	}

	public void clickAddDebitCard() {
		click(lnkAddDebitcard, "Add Debit Card");
	}

	public void clickNext() {
		click(next, "next");
	}

	public void getAvailableBalance() {
		String str = getText(availableBalance, "Available balance");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void amount(String enterAmount) {
		enterText(amount, "Amount is:", enterAmount);
	}

	public void clickChange() {
		click(lnkChange, "change");
	}

	public void Inputnote(String enterNote) {
		enterText(note, "Note", enterNote);
	}

	public WithdrawSummaryPopup withdrawSummaryPopup() {
		return new WithdrawSummaryPopup();
	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}
}
