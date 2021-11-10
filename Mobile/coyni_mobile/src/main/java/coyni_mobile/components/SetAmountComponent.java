package coyni_mobile.components;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SetAmountComponent extends MobileFunctions {

	private By txtAmount =  MobileBy.xpath(" ");
	private By btnOk = MobileBy.xpath(" ");
	private By btnCross = MobileBy.xpath(" ");

	public void fillAmount(String amount) {
		enterText(txtAmount, "amount", amount);
	}
	public void clickOk() {
		click(btnOk, "Ok");
	}
	public void clickCross() {
		click(btnCross, "Cross");
	}
}
