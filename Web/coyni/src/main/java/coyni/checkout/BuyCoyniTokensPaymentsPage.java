package coyni.checkout;

import org.openqa.selenium.By;

import coyni.merchant.popups.BuyCoyniTokensPopup;
import coyni.merchant.popups.PreAuthorizationPopup;
import coyni.uitilities.CommonFunctions;

public class BuyCoyniTokensPaymentsPage extends BuyCoyniTokensPopup {

	private By lblCard = By.xpath("(//input[@name='buy-token-radio'])[1]");
	private By txtCvv = By.xpath("//input[contains(@class,'Input_form_input__yl3pD ')]");
	private By btnNext = By.xpath("//button[text()='Next']");
	
	private By btnAddPaymentMethod=By.xpath("//span[text()='Add New Payment Method']");
	
	public void clickAddPaymentMethod() {
		click(btnAddPaymentMethod, "Add Payment Method");
	}
	
	public void clickOutSide() {
		new CommonFunctions().clickOutSideElement();
	}

	public void clickNext() {
		click(btnNext, "");
	}

	public void txtCVV(String cvv) {
		enterText(txtCvv, cvv, "");
	}

	public void clickCard() {
		click(lblCard, "Card");
	}
	
	public int verifyCard() {
		return getElementsList(lblCard, "lblCard").size();
	}

	public int cardSize() {
		return getElementsList(lblCard, "Card").size();
	}
	
	
	public BuyCoyniTokensOrderPreviewPage buyCoyniTokensOrderPreviewPage() {
		return new BuyCoyniTokensOrderPreviewPage();
	}
	
	public PreAuthorizationPopup authorizationPopup() {
		return new PreAuthorizationPopup();
	}
	public AddCardComponent addCardComponent() {
		return new AddCardComponent();
	}

}
