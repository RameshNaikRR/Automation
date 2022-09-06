package coyni.checkout;

import org.openqa.selenium.By;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PayPage extends BrowserFunctions {

	private By exchangeRate = By.xpath("//p[contains(text(),'hello')]/following-sibling::*");
	private By paymingMethod = By.xpath("//p[contains(text(),'Paying Method')]/following-sibling::*");
	private By btnBuyTokens = By.xpath("//button[contains(text(),'Buy Tokens')]");
	private By btnReturnToMerchant = By.xpath("//span[contains(text(),'Return to merchant')]");

	public void clickBuyTokens() {
		click(btnBuyTokens, "Buy Tokens");
	}

	public void clickReturnToMerchant() {
		click(btnReturnToMerchant, "Return To Merchant");
	}

	public void getExchangeRate() {
		String ExchangeRate = getText(exchangeRate, "Exchange Rate");
		ExtentTestManager.setInfoMessageInReport("Exchange Rate is: " + ExchangeRate);
	}

	public void getPaymentMethod() {
		String PaymentMethod = getText(paymingMethod, "Payment Method");
		ExtentTestManager.setInfoMessageInReport("Payment Method is: " + PaymentMethod);
	}

}
