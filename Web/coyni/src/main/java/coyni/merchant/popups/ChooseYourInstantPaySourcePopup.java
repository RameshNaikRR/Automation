package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ChooseYourInstantPaySourcePopup extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//h1[text()='Withdraw via Instant Pay']");
	private By lblDescription = By.xpath("//h3[text()='Choose Your Instant Pay Source:']");
	private By lblMsg = By.xpath("//h2[contains(.,'Instant Pay')]");

	private By getBanks(String Bank) {
		return By.xpath(String.format("(//p[contains(@class,'font-semibold text-cgy4')])[%s]", Bank));
	}

	private By getBtnRadio(String radio) {
		return By.xpath(String.format("//input[@type='radio']", radio));
	}

	private By getDeleteIcon(String Delete) {
		return By.xpath(String.format("(//button[@data-tip='Delete'])[%s]", Delete));
	}

	private By btnAddNewDebitCard = By.xpath("//button[contains(@class,'AddPaymentButtons_payment')]");
	private By btnNext = By.xpath("//button[.='Next']");

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription(String Description) {
		cf.verifyLabelText(lblDescription, "Description", Description);
	}

	public void verifyMsg() {
		String Msg = getText(lblMsg, "");
		ExtentTestManager.setInfoMessageInReport(Msg + " is displayed");
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
		cf.elementView(btnAddNewDebitCard, "Add New Bank Account");
	}

	public void clickAddNewBankAccountBtn() {
		click(btnAddNewDebitCard, "Add New Bank Account");
	}

	public void verifyNextBtn() {
		cf.elementView(btnNext, "Next");
	}

	public void clickNextBtn() {
		click(btnNext, "Next");
	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}
}
