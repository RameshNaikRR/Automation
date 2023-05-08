package coyni_mobile_merchant.pages;

import java.text.DecimalFormat;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.components.AddNewPaymentComponent;
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
	private By lblAmount = MobileBy
			.xpath("//*[contains(@resource-id,'amountET')]|//*[contains(@resource-id,'etAmount')]");
	private By btnBuyToken = MobileBy.xpath("//*[contains(@resource-id,'keyActionLL')]");
	private By lblAmountDescription = MobileBy.xpath("//*[contains(@resource-id,'tvExchange')]");
	private By lblLimitDescription = MobileBy.xpath("//*[contains(@resource-id,'tvLimit')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'Close')]");
	private By btnAddNewPaymentMethod = MobileBy.xpath("//*[contains(@text,'Add New Payment ')]");
	private By lblFees = MobileBy.id("com.coyni.mapp:id/tvFeePer");

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

	public void clickAddNewPaymentMethod() {
		click(btnAddNewPaymentMethod, "Add New Payment Method");
	}

	public void getPaymentMethodDetails() {
		ExtentTestManager.setInfoMessageInReport("Payment Method Bank Name is : " + getText(btnChangePaymentMethod));
		ExtentTestManager.setInfoMessageInReport("Payment Method Bank Number is : " + getText(lblBankNumber));
	}

	public Double getAmount() {
		ExtentTestManager.setInfoMessageInReport("after click on convertor Amount is : " + getText(lblAmount));
		Double amount = Double.parseDouble(getText(lblAmount));
		return amount;
	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public void clickConvertor() {
		click(btnConverter, "Convertor");
	}

	public void clickBuyToken() {
		new CommonFunctions().clickEnabledElement(btnBuyToken, "Buy Token");
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public Double validateProcessingFees() {
		String[] fees = getText(lblFees).split("\\+");
		String[] fee1 = fees[0].replace(" ", "").split(":");
		String feeDollars = fee1[1].replace("$", "");
		Double feeDollar = Double.parseDouble(feeDollars) + validateFeesPercentage();
		DecimalFormat df = new DecimalFormat("#.##");
		double fee = Double.parseDouble(df.format(feeDollar));
		System.out.println(fee);
		return fee;
	}

	public Double validateTotal() {
		Double amount = validateProcessingFees() + getAmount();
		DecimalFormat df = new DecimalFormat("#.##");
		double totalAmount = Double.parseDouble(df.format(amount));
		System.out.println(totalAmount);
		return totalAmount;
	}

	public Double validateFeesPercentage() {
		String[] fees = getText(lblFees).split("\\+");
		String fee2 = fees[1].replace(" ", "").replace("%", "");
		Double feePercentage = Double.parseDouble(fee2);
		Double fee = feePercentage / 100 * getAmount();
		DecimalFormat df = new DecimalFormat("#.##");
		double feees = Double.parseDouble(df.format(fee));
		System.out.println(feees);
		return feees;

	}

	public void buyTokenWithBankAccount(String expHeading, String expDescription, String amount) {
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
//		clickBuyToken();
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public AddNewPaymentComponent addNewPaymentComponent() {
		return new AddNewPaymentComponent();
	}

	public PaymentMethodsPage paymentMethodsPage() {
		return new PaymentMethodsPage();
	}
}
