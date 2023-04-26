package coyni.api.business.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.web.actions.WaitForElement;

public class BuyCoyniTokensNoPaymentPopup extends BrowserFunctions {
	BrowserFunctions objBrowserFunctions = new BrowserFunctions();
	private By lnkAddNewPayment = By.xpath("//button[@id='small-add-payment-button']");
	private By lblNoPayment = By.xpath("//h2[text()='No Payment Method Available']");
	private By BankAccounts = By.xpath("//div[@class='BuyTokenModal_paymentMethods__p2987']//p");

	public void clickOnAddNewPayment() {
		new CommonFunctions().verifyCursorAction(lnkAddNewPayment, "Add New Bank Account");
//		new CommonFunctions().verifyTextUnderLine(lnkAddNewPayment, "Add New Bank Account");
		click(lnkAddNewPayment, "click Add New Payment");
	}

	public int getLabelsize() {
		return getElementsList(lblNoPayment, "").size();
	}

	public int getBankLabelSize() {
		return getElementsList(BankAccounts, "").size();
	}

	public void selectBankAccount() {
		objBrowserFunctions.waitForElement(BankAccounts, BrowserFunctions.waittime, WaitForElement.presence);
		List<WebElement> optionsEles = objBrowserFunctions.getElementsList(BankAccounts, "BankAccounts");
		for (WebElement optionEle : optionsEles) {
			if (optionEle.getText().contains("MX Bank")) {
				optionEle.click();
				break;
			}
		}
	}

	public void verifyNoPayment() {
		new CommonFunctions().elementView(lblNoPayment, "No Payment");
	}
}
