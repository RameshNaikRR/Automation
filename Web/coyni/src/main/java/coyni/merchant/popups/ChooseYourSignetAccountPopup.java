package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ChooseYourSignetAccountPopup extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//h1[text()='Withdraw to Signet Account']");
	private By lblDescription = By.xpath("//h3[text()='Choose Your Signet Account:']");

	private By getBanks(String Bank) {
		return By.xpath(String.format("(//p[contains(@class,'font-semibold text-cgy4')])[%s]", Bank));
	}

	private By getBtnRadio(String radio) {
		return By.xpath(String.format("//input[@type='radio']", radio));
	}

	private By getDeleteIcon(String Delete) {
		return By.xpath(String.format("(//button[@data-tip='Delete'])[%s]", Delete));
	}

	private By btnAddNewSignetAccount = By.xpath("//button[contains(@class,'AddPaymentButtons_payment')]");
	private By btnNext = By.xpath("//button[.='Next']");

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription(String Description) {
		cf.verifyLabelText(lblDescription, "Description", Description);
	}

	public void clickBank1RadioBtn() {
		click(getBtnRadio("1"), "Radio");
	}

	public void clickBank2RadioBtn() {
		click(getBtnRadio("2"), "Radio");
	}

	public void verifyBank1() {
		cf.verifyCursorAction(getBanks("1"), "Bank one ");
		cf.elementView(getDeleteIcon("1"), "Delete Icon ");
	}

	public void verifyBank2() {
		cf.verifyCursorAction(getBanks("2"), "Bank two ");
		cf.elementView(getDeleteIcon("2"), "Delete Icon ");
	}

	public void verifyAddNewBankAccountBtn() {
		cf.elementView(btnAddNewSignetAccount, "Add New Bank Account");
	}

	public void clickAddNewBankAccountBtn() {
		click(btnAddNewSignetAccount, "Add New Bank Account");
	}

	public void verifyNextBtn() {
		cf.elementView(btnNext, "Next");
	}

	public void clickNextBtn() {
		click(btnNext, "Next");
	}
}
