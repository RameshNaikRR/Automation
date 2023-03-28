package coyni.api.business.popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletTransferTokenPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Transfer Token']");
	private By lblDescription = By.xpath("//span[contains(.,'Transfer coyni token')]");
	private By txtAmount = By.xpath("//input[@id='amount']");
	private By lblAvailableBalance = By.xpath("//span[text()='Available Balance:']/following-sibling::span");
	private By lblErrorMessage = By.xpath("//span[.='Amount is required.']");
	private By drpdwnTransferTo = By.cssSelector("div[class*='FormField_selected_option_wallet']");
	private By btnNext = By.xpath("//button[.='Next']");
	private By btnConfirm = By.xpath("//button[.='Confirm']");
	private By btnClose = By.xpath("//button[@type='button']/img");
	private By lblSelectTrasanfer = By
			.xpath("//div[contains(@class,'FormField_form_select_container')]/div/div/../div[3]");
//	private By btnTransferWallet = By
//			.xpath("//div[contains(@class,'FormField_form_select_container')]//*[text()='Info']");
	private By btnTransferWallet = By
			.xpath("//div[contains(@class,'FormField_form_select_container')]/div[1]/div[4]/div[%s]");
	private By insufficientFunds = By
			.xpath("//span[@class='absolute -bottom-1 left-0 right-0 text-xs text-center text-crd5']");

	private By getWallets(String WalletNumber) {
		return By.xpath(String.format(
				" //div[contains(@class,'FormField_options_wrap_wallet__xaQiZ undefined')]/div[%s]", WalletNumber));
	}

	public void insufficientFunds() {
		String str = getText(insufficientFunds, "Error Message");
		ExtentTestManager.setInfoMessageInReport(str);
	}

	public void selectTransferWallet() {
		click(lblSelectTrasanfer, "Click on Transfer");
		click(btnTransferWallet, "Select Wallet");
	}

	public void clickWallet1() {
		click(getWallets("2"), "Wallet 1 is clicked");
	}

	public void clickWallet3() {
		click(getWallets("3"), "Wallet 3 is clicked");
	}

	public void verifyWallet1View() {
		new CommonFunctions().elementView(getWallets("1"), "Wallet 2");
	}

	public void verifytxtAmountView() {
		new CommonFunctions().elementView(txtAmount, "Amount");
	}

	public void verifyTransferToView() {
		new CommonFunctions().elementView(drpdwnTransferTo, "Transferring To");
	}

	public void verifyAvailableBalanceView() {
		new CommonFunctions().elementView(lblAvailableBalance, "AvailableBalance");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Transfer Popup Heading", Heading);
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Transfer Popup Description", Description);
	}

	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}

	public void verifyAmount(String expAmount) {
		String actAmount = getTextBoxValue(txtAmount, "Amount");
		if (actAmount.equals(expAmount)) {
			ExtentTestManager.setPassMessageInReport("Amount is verified");
		} else {
			ExtentTestManager.setFailMessageInReport("Amount is not verified");
		}
	}

	public void clickTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void verifyAvailableBalance() {
		new CommonFunctions().elementView(lblAvailableBalance, "Available Balance");
	}

	public void verifyErrorMessage() {
		new CommonFunctions().elementView(lblErrorMessage, "Error Message");
	}

	public void clickTransferToDropDown() {
		click(drpdwnTransferTo, "Transfer To");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}
	}

	public void clickConfirm() {
		if (getElement(btnConfirm, "Confirm").isEnabled()) {
			click(btnConfirm, "Confirm ");
		} else {
			ExtentTestManager.setPassMessageInReport("Confirm button is in disabled mode");
		}
	}

	public void clickClose() {
		click(btnClose, "close");
	}

	public void verifyCloseView() {
		new CommonFunctions().elementView(btnClose, "Close Icon");
	}

	public WalletTransferPrieviewPopup walletTransferPrieviewPopup() {
		return new WalletTransferPrieviewPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public CommonFunctions commonFunctions() {
		return new CommonFunctions();
	}

	public VerifyYourIdentityPopup verifyYourIdentityPopup() {
		return new VerifyYourIdentityPopup();
	}
}
