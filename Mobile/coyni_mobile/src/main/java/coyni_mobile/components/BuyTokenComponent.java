package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.popups.OrderPreviewPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class BuyTokenComponent extends MobileFunctions {

	private By lblBuyToken = MobileBy.xpath("(//*[@name='Buy Token'])[1]|//*[@text='Buy Token']");
	private By lblPaymentMethod = MobileBy
			.xpath("//*[@text='Payment Method']|//*[@name ='arrow-right']/preceding-sibling::*[1]/child::*");
	private By lblDailylimits = MobileBy.xpath("//*[@name ='arrow-right']/following-sibling::*[1]");
	private By btnChangePayment = MobileBy.xpath("//*[@name ='arrow-right']");
	private By txtAmount = MobileBy.xpath("//*[@name ='currency toggle']/preceding-sibling::XCUIElementTypeTextField");
	private By btnBuyToken = MobileBy.xpath("(//*[@name='Buy Token'])[2]|//*[contains(@resource-id,'keyActionTV')]");
	private By btnConvert = MobileBy.xpath("//*[@name ='currency toggle']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBuyToken, "heading", expHeading);
	}

	public void verifyPayment(String expPayment) {
		String method = getText(lblPaymentMethod);
		if (method.contains(expPayment)) {
			ExtentTestManager.setPassMessageInReport("Payment Method: " + expPayment);
		} else {
			ExtentTestManager.setFailMessageInReport("Payment method is not " + expPayment);
		}
	}

	public void getDailyLimits() {
		ExtentTestManager.setInfoMessageInReport(getText(lblDailylimits));
	}

	public void clickArrow() {
		click(btnChangePayment, "Arrow");
	}

	public void fillAmount(String Amount) {
		new EnterYourPINComponent().fillPin(Amount);
		ExtentTestManager.setInfoMessageInReport("Entered Amount: " + Amount);
	}

	public void clickBuyToken() {
		click(btnBuyToken, "Buy Token");
	}

	public void clickConvert() {
		click(btnConvert, "convert");
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}
}
