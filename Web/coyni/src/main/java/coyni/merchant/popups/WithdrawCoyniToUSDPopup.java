package coyni.merchant.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawCoyniToUSDPopup extends BrowserFunctions {

	private By withdrawToUSDHeading = By.xpath("//h1[contains(text(),'Withdraw coyni to USD')]");
	private By PaymentBtns = By.xpath("//span[@class='labelWithoutHover']");

	private By getPaymentBnts(String buttons) {
		return By.xpath(String.format("(//button[@class='payment-method-button '])[%s]", buttons));
	}

	private By withdrawToUSDColor = By.xpath("//span[contains(text(),'Withdraw to')]/preceding-sibling::div");

	public void verifyBtns() {
		List<WebElement> elementsList = getElementsList(PaymentBtns, "");
		for (WebElement webElement : elementsList) {
//			new CommonFunctions().verifyCursorAction((By) webElement, "");
			boolean displayed = webElement.isDisplayed();
			String text = webElement.getText();
			ExtentTestManager.setInfoMessageInReport(displayed + "  " + text + "  " + "Button is displayed ");
		}
	}

	public void clickOnExternalBankAccount() {
		click(getPaymentBnts("1"), "click ExternalBankAccount");
	}

	public void clickOnInstantPay() {
		click(getPaymentBnts("2"), "InstantPay");
	}

	public void clickOnGiftCard() {
		click(getPaymentBnts("3"), "GiftCard");
	}

	public void clickOnSignetAccount() {
		click(getPaymentBnts("4"), "Signet Account");
	}

	public void cursorhoverWithdrawToUSD() {
		new CommonFunctions().verifyCursorAction(getPaymentBnts("3"), "Gift Card");
	}

	public void verifyLabelWithdrawToUSDHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(withdrawToUSDHeading, "Withdraw Coyni to USD", expHeading);
	}

	public void verifyWithdrawBackgroundcolor(String cssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(withdrawToUSDColor, "WithdrawToUSD", cssProp, expValue, expColor);
	}

	public WithdrawViaInstantPayPopup withdrawViaInstantPaypopup() {
		return new WithdrawViaInstantPayPopup();
	}

	public WithdrawToBankAccountSelectBankPopup withdrawToBankAccountSelectBankPopup() {
		return new WithdrawToBankAccountSelectBankPopup();
	}

	public GiftCardPurchasePopup giftCardPurchasePopup() {
		return new GiftCardPurchasePopup();
	}

	public ChooseYourBankAccountPopup chooseYourBankAccountPopup() {
		return new ChooseYourBankAccountPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}