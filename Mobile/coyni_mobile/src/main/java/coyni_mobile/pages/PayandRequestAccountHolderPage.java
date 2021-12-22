package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.PayRequestConfirmPopup;
import coyni_mobile.components.PayRequestOptionalPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;


public class PayandRequestAccountHolderPage extends MobileFunctions{
	private By lblName = MobileBy.xpath("(//*[contains(@name,'Account Address')])[2]/preceding-sibling::*[1]");
	private By txtAmount = MobileBy.xpath("//*[@name='currency toggle']/preceding-sibling::*[2]");
	private By btnPay = MobileBy.xpath("(//*[@name='Pay'])[1]");
	private By btnRequest = MobileBy.xpath("(//*[@name='Request'])[1]");
	private By btnMessage = MobileBy.xpath("(//*[contains(@name,'Available')])[2]/following-sibling::*[2]");
	private By lnkConverter = MobileBy.xpath(" ");
	
	public void verifyName(String expName) {
		new CommonFunctions().verifyLabelText(lblName, "Name",expName);
	}
	public void clickConverter() {
		click(lnkConverter, "Converter");
		}
	public void clickPay() {
		click(btnPay, "Pay");
	}
	public void clickRequest() {
		click(btnRequest, "Request");
	}
	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "amount");	
		}
	public void clickMessageButton() {
		click(btnMessage, "Message Button");
	}
	
	public PayRequestOptionalPopup payRequestOptionalPopup() {
		return new PayRequestOptionalPopup();
	}

	public PayRequestConfirmPopup payRequestConfirmPopup() {
		return new PayRequestConfirmPopup();
	}
	
}
