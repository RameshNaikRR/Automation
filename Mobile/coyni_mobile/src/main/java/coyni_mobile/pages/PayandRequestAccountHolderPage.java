package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.FieldValidationsComponent;
import coyni_mobile.components.NavigationComponent;
import coyni_mobile.components.PayRequestConfirmPopup;
import coyni_mobile.components.PayRequestOptionalPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PayandRequestAccountHolderPage extends MobileFunctions {

	private By lblName = MobileBy.xpath("//*[contains(@resource-id,'tvName')]");// (*[contains(@name,'Account
	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'payrequestET')]");// *[@name='currency//
																						// toggle']/preceding-sibling::*[1]|
	private By btnPay = MobileBy.xpath("//*[contains(@resource-id,'tvPay')]");
	private By btnRequest = MobileBy.xpath("//*[contains(@resource-id,'tvRequest')]");// (*[@name='Request'])[1]|
	// private By btnMessage =
	// MobileBy.xpath("(//*[contains(@name,'Available')])[1]/following-sibling::*[2]");
	private By lnkConverter = MobileBy.xpath(" ");
	private By errorMessage = MobileBy.xpath("//*[contains(@resource-id,'tvError')]");

	public void verifyName() {
		ExtentTestManager.setInfoMessageInReport("User Name is : "+ getText(lblName));
//		new CommonFunctions().verifyLabelText(lblName, "Name", expName);
	}

	public void verifyErrorMessage(String errMessage) {
		new CommonFunctions().verifyLabelText(errorMessage, "Error Message", errMessage);
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

//	public void clickMessageButton() {
//		click(btnMessage, "Message Button");
//	}

	public PayRequestOptionalPopup payRequestOptionalPopup() {
		return new PayRequestOptionalPopup();
	}

	public PayRequestConfirmPopup payRequestConfirmPopup() {
		return new PayRequestConfirmPopup();
	}
	public FieldValidationsComponent fieldValidationsComponent() {
		return new FieldValidationsComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
