package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SelectUserPage extends MobileFunctions {
	
	private By txtAmount = MobileBy.xpath(" ");
	private By lnkConverter = MobileBy.xpath(" ");
	private By lblAvailableBalance = MobileBy.xpath(" ");
	private By btnPay = MobileBy.xpath(" ");
	private By btnRequest = MobileBy.xpath(" ");
	
	public void fillAmount(String amount) {
	enterText(txtAmount, "amount", amount);	
	}
	public void clickConverter() {
	click(lnkConverter, "Converter");
	}
	public void getAvailableBalance(String availableBalance) {
	//	getText(lblAvailableBalance); doubt
		
	}
	public void clickPay() {
		click(btnPay, "Pay");
	}
	public void clickRequest() {
		click(btnRequest, "Request");
	}

}
