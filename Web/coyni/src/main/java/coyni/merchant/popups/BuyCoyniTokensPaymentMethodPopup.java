package coyni.merchant.popups;

import org.openqa.selenium.By;
import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.SuccessFailurePopupCardComponent;
import coyni.reusable.components.ProcessingFeeComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BuyCoyniTokensPaymentMethodPopup extends BrowserFunctions {

	private By headingBuyCoyniToken = By.xpath("//h1[contains(text(),'Buy coyni Tokens')]");
	private By lnkAddNewPayment = By.cssSelector("");
	private By btnNext = By.xpath("//button[contains(text(),'Next')]");
	private By lblSignetAccount = By.xpath("(//p[contains(text(),'Signet Wallet ID')])[1]");
	private By lblBankErrorMessage = By.cssSelector("");
	private By buyCoyniTokensDescp = By.xpath("//h2[contains(text(),'Choose Your Payment Method:')]");
	private By btnDelete = By.xpath("//button[@class=' ml-2 icon-trash BuyTokenPaymentMethod_action_icon__2nonE']");
	private By btnDeleteSignet = By.xpath("//button[@data-tip='Delete'][1]");

	public void clickDelete(String number) {
		click(By.xpath(String.format(
				"//p[contains(text(),'%s')]/following-sibling::button[contains(@class, 'icon-trash')]", number)),
				number);
		ExtentTestManager.setInfoMessageInReport("Delete button clicked for bank " + (number));
	}

	public void clickDeleteSignetAccount(String number) {
		moveToElement(lblSignetAccount, "Signet Account");
		click(btnDelete, "Delete");
	}

	public void clickBank(String number) {
		click(By.xpath(String.format("//p[contains(text(),'%s')]", number)), number);
		ExtentTestManager.setInfoMessageInReport("button clicked for Bank " + (number));
	}

	public void clickDelete() {
		click(btnDelete, "Click Delete");
	}

	public void clickNext() {
		click(btnNext, "Click Next");
	}

	public void clickLinkAddNewPayment() {
		click(lnkAddNewPayment, "Click AddNewPayment");
	}

	public void VerifyBankErrorMessage(String BankErrorMessage) {
		new CommonFunctions().verifyLabelText(lblBankErrorMessage, BankErrorMessage, "BankErrorMessage");
	}

	public BuyCoyniTokensPopup buyCoyniTokensPopup() {
		return new BuyCoyniTokensPopup();
	}

	public void verifyBuyCoyniTokenDescription() {
		new CommonFunctions().elementView(buyCoyniTokensDescp, "Choose Your Paayment Method  ");
	}

	public void verifyBuyCoyniTokenHeading(String expBuyCoyniTokenHeading) {
		new CommonFunctions().verifyLabelText(headingBuyCoyniToken, "Buy Coyni Token Heading is",
				expBuyCoyniTokenHeading);
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public RemovePaymentMethodPopup removePaymentMethodPopup() {
		return new RemovePaymentMethodPopup();
	}

	public ProcessingFeeComponent processingFeeComponent() {
		return new ProcessingFeeComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
