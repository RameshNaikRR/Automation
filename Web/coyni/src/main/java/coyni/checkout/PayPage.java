package coyni.checkout;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class PayPage extends BrowserFunctions {

	private By exchangeRate = By.xpath("//p[contains(text(),'hello')]/following-sibling::*");
	private By paymingMethod = By.xpath("//p[contains(text(),'Paying Method')]/following-sibling::*");
	private By btnBuyTokens = By.xpath("//button[contains(text(),'Buy Tokens')]");
	private By btnReturnToMerchant = By.xpath("//span[contains(text(),'Return to merchant')]");
	private By btnPayNow = By.xpath("//span[text()='Pay Now']");
	private By lblContent = By.xpath("//p[text()='You successfully paid']");
	private By lblInsufficient = By.xpath("//p[text()='Insufficient balance']");

	private By lblBackToLogin = By.xpath("//button[text()='Go Back to Login Page']");

	public void clickBackToMerchantLogin() {
		click(lblBackToLogin, "Back To merchant login");

	}

	public int getSizeBackToLogin() {
		return getElementsList(lblBackToLogin, "").size();
	}

	private By btnBack = By.xpath("//img[@alt='back-button']");

	public void verifyInsufficient(String content) {
		if (getElement(lblInsufficient, "").isDisplayed()) {
			new CommonFunctions().verifyLabelText(lblInsufficient, "Insufficient balance", content);
		} else {
			ExtentTestManager.setInfoMessageInReport("Insufficient Found is not Displayed");
		}
	}

	public void clickBackButton() {
		click(btnBack, "Back Button");
	}

	public void verifyContent(String content) {
		new CommonFunctions().verifyLabelText(lblContent, "You successfully paid", content);
	}

	public void clickPaynow() {
		click(btnPayNow, "Pay Now");
	}

	public int getPaynowButton() {
		return getElementsList(btnPayNow, "").size();
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "Buy Tokens");
	}

	private By lblBuyToke = By.xpath("//button[text()='Buy Tokens']");

	public int verifyBuyToken() {
		return getElementsList(lblBuyToke, "").size();

	}

	private By btnBackToBuyToken = By.xpath("//button[text()='Back to buy token']");

	public void clickBackToBuyToken() {
		click(btnBackToBuyToken, "");
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

	public CancelTransaction cancelTransaction() {
		return new CancelTransaction();
	}

	public BuyCoyniTokensPaymentsPage buyCoyniTokensPaymentsPage() {
		return new BuyCoyniTokensPaymentsPage();
	}

}
