package coyni.merchant.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ChooseYourBankAccountPopup extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//h1[.='Withdraw to Bank Account']");
	private By lblDescription = By.xpath("//h3[contains(.,'Choose Your ')]");

	private By getBtnRadio(String radio) {
		return By.xpath(String.format("//input[@type='radio']", radio));
	}

	private By getBanks(String Bank) {
		return By.xpath(String.format("(//p[contains(@class,'font-semibold text-cgy4')])[%s]", Bank));
	}

	private By getDeleteIcon(String Delete) {
		return By.xpath(String.format("(//button[@data-tip='Delete'])[%s]", Delete));
	}

	private By btnAddNewBankAccount = By.xpath("//button[contains(@class,'AddPaymentButtons_payment')]");
	private By btnNext = By.xpath("//button[.='Next']");

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription(String Description) {
		int size = getElementsList(lblDescription, "").size();
		if (size == 1) {
			cf.verifyLabelText(lblDescription, "Description", Description);
		} else {
			new NavigationComponent().clickBack();
			cf.verifyLabelText(lblDescription, "Description", Description);
		}
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

	public void clickBank(String number) {
		click(By.xpath(String.format("//p[contains(text(),'%s')]", number)), number);
		ExtentTestManager.setInfoMessageInReport("button clicked for Bank " + (number));
	}

	public void clickDelete(String number) {
		click(By.xpath(String.format(
				"//p[contains(text(),'%s')]/following-sibling::button[contains(@class, 'icon-trash')]", number)),
				number);
		ExtentTestManager.setInfoMessageInReport("Delete button clicked for bank " + (number));
	}

	public void clickDelete() {
		int size = getElementsList(getDeleteIcon("1"), "").size();
		if (size == 1) {
			click(getDeleteIcon("1"), "Delete icon");
		} else {
			new NavigationComponent().clickBack();
			click(getDeleteIcon("1"), "Delete icon");
		}
	}

	public void verifyAddNewBankAccountBtn() {
		cf.elementView(btnAddNewBankAccount, "Add New Bank Account");
	}

	public void clickAddNewBankAccountBtn() {
		int size = getElementsList(btnAddNewBankAccount, "").size();
		if (size == 1) {
			click(btnAddNewBankAccount, "Add New Bank Account");
		} else {
			new NavigationComponent().clickBack();
			click(btnAddNewBankAccount, "Add New Bank Account");
		}
	}

	public void verifyNextBtn() {
		cf.elementView(btnNext, "Next");
	}

	public void clickNextBtn() {
		click(btnNext, "Next");
	}

	public WithdrawToBankAccountPopUp withdrawToBankAccountPopUp() {
		return new WithdrawToBankAccountPopUp();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public AddBankAccountPopup addBankAccountPopup() {
		return new AddBankAccountPopup();
	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}
}
