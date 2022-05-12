package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TokenWalletTransferTokenPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Transfer Token']");
	private By lblDescription = By.xpath("//span[contains(.,'Transfer coyni token')]");
	private By txtAmount = By.cssSelector("#amount");
	private By lblAvailableBalance = By.xpath("//div[contains(@class,'relative flex-grow')]/div[1]");
	private By lblErrorMessage = By.xpath("//span[.='Amount is required.']");
	private By drpdwnTransferTo = By.cssSelector("div[class*='FormField_selected_option_wallet']");
	private By btnNext = By.xpath("//button[.='Next']");
	private By btnClose = By.xpath("//button[@type='button']/img");

	private By getWallets(String WalletNumber) {
		return By.xpath(String.format("//div[@class='FormField_options_wrap_wallet__2KyLr undefined']/div[1]/div[%s]",
				WalletNumber));
	}

	public void clickWallet1() {
		click(getWallets("1"), "Wallet 1 is clicked");
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
		}
		else {
			ExtentTestManager.setFailMessageInReport("Amount is not verified");
		}
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
		click(btnNext, "Next");
	}

	public void verifyClose() {
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
}
