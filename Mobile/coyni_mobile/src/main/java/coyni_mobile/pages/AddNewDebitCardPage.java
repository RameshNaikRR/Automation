package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddNewDebitCardPage extends MobileFunctions {
	
	private By txtNameOnCard = MobileBy.xpath("");
	private By txtCardNumber = MobileBy.xpath("");
	private By txtCardExp = MobileBy.xpath("");
	private By txtCVVorCVC = MobileBy.xpath("");
	private By btnNext = MobileBy.xpath("");
	private By iconCamera = MobileBy.xpath("");
	
	public void fillNameOnCard(String nameOnCard) {
		enterText(txtNameOnCard, nameOnCard, "NameOnCard");
	}
	public void fillCardNumber(String cardNumber) {
		enterText(txtCardNumber, cardNumber, "Card Number");
	}
	public void fillCardExp(String cardExp) {
		enterText(txtCardExp, cardExp, "CardExp");
	}
	public void fillCVVorCVC(String cVVorCVC) {
		enterText(txtCVVorCVC, cVVorCVC, "CVVorCVC");
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
	public void clickCamera() {
		click(iconCamera, "Camera");
	}
	
	

}
