package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BuyCoyniTokensPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Buy coyni Tokens']");
	private By lblSubheading = By.xpath("//h2[text()='Choose Your Payment Method:']");
	private By btnRadio = By.cssSelector("#radio-BANK-838");
	private By lnkAddnewpaymentmethod = By.xpath("//span[text()='Add New Payment Method']");
	private By btnDelete = By.xpath("(//button[@data-tip='Delete'])[1]");
	private By btnNext = By.xpath("//button[text()='Next']");

	public void VerifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void VerifySubHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSubheading, "expHeading", expHeading);
	}

	public void clickRadio() {
		click(btnRadio, "Radio");
	}

	public void clickAddnewpaymentmethod() {
		click(lnkAddnewpaymentmethod, "Addnewpaymentmethod");
	}

	public void clickDelete() {
		click(btnDelete, "Delete");

	}

	public void clickNext() {
		click(btnNext, "Next");

	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}

	public AddNewPaymentMethodPopup addNewPaymentMethodPopup() {
		return new AddNewPaymentMethodPopup();
	}

	public AddNewSignetAccountPopup addNewSignetAccountPopup() {
		return new AddNewSignetAccountPopup();
	}

	public BuyCoyniTokensNoPaymentPopup buyCoyniTokensNoPaymentPopup() {
		return new BuyCoyniTokensNoPaymentPopup();
	}
}