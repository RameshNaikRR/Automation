package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BuyTokenBankAccountPaymentMethodPage extends MobileFunctions {
	private By lblBuyTokenBankAccHeading = MobileBy.xpath("//*[contains(@text,'Buy Token')]");
	private By lblBuyTokenBankAccDescription = MobileBy.xpath("//*[contains(@text,'Payment Method')]");
	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By lblCurrency = MobileBy.xpath("//*[contains(@resource-id,'lyAmount')]");
	private By btnChangePaymentMethod = MobileBy.xpath("//*[contains(@resource-id,'tvBankName')]");
	private By lblBankNumber = MobileBy.xpath("//*[contains(@resource-id,'tvBAccNumber')]");
	private By btnConverter = MobileBy.xpath("//*[contains(@resource-id,'imgConvert')]");
	private By lblAmount = MobileBy.xpath("//*[contains(@resource-id,'etAmount')]");
	private By btnBuyToken = MobileBy.xpath("//*[contains(@resource-id,'keyActionTV')]");
	private By lblAmountDescription = MobileBy.xpath("//*[contains(@resource-id,'tvExchange')]");
	private By lblLimitDescription = MobileBy.xpath("//*[contains(@resource-id,'tvLimit')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'Close')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBuyTokenBankAccHeading, "Page Heading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblBuyTokenBankAccDescription, "Page Description", expDescription);
	}

	public void getExchangeRate() {
		ExtentTestManager.setInfoMessageInReport("Exchange Rate : " + getText(lblAmountDescription));

	}

	public void getLimitDescription() {
		ExtentTestManager.setInfoMessageInReport("Amount Limit Description : " + getText(lblLimitDescription));
	}

	public void verifyCurrency() {
		ExtentTestManager.setInfoMessageInReport("Currency in  : " + getText(lblCurrency));
	}

	public void clickChangePaymentMethod() {
		click(btnChangePaymentMethod, "Change Payment Method");
	}

	public void getPaymentMethodDetails() {
		ExtentTestManager.setInfoMessageInReport("Payment Method Bank Name is : " + getText(btnChangePaymentMethod));
		ExtentTestManager.setInfoMessageInReport("Payment Method Bank Number is : " + getText(lblBankNumber));
	}

	public void getAmount() {
		ExtentTestManager.setInfoMessageInReport("after click on convertor Amount is : " + getText(lblAmount));
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public void clickConvertor() {
		click(btnConverter, "Convertor");
	}

	public void clickBuyToken() {
		click(btnBuyToken, "Buy Token");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void buyTokenWithBankAccount(String expHeading,String expDescription,String amount) {
		verifyPageHeading(expHeading);
		verifyPageDescription(expDescription);
		getPaymentMethodDetails();
		getLimitDescription();
		fillAmount(amount);
		clickConvertor();
		getAmount();
		clickConvertor();
		getAmount();
		getExchangeRate();
		clickBuyToken();
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

}
