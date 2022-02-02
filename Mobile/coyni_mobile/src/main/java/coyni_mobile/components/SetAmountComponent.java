package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SetAmountComponent extends MobileFunctions {

	private By txtAmount = MobileBy.xpath("//*[contains(@resource-id,'setAmountET')]");
	private By btnOk = MobileBy.xpath("//*[contains(@resource-id,'keyActionLL')]");

	public void fillAmount(String amount) {
		click(txtAmount, "Amount");
		enterText(txtAmount, amount, "amount");
	}

	public void clickOk() {
		click(btnOk, "Ok");
		click(btnOk, "Ok");
	}

}
