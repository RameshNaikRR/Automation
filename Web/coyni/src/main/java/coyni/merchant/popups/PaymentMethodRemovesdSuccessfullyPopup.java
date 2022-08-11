package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodRemovesdSuccessfullyPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[starts-with(.,'Payment')]");
	private By btnWithdrawCoyni = By.xpath("//button[.='Withdraw coyni']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyWithdrawCoyniBtn() {
		new CommonFunctions().elementView(btnWithdrawCoyni, "Withdraw coyni");
	}

	public void clickWithdrawCoyniBtn() {
		click(btnWithdrawCoyni, "Withdraw coyni");
	}

	public WithdrawCoyniToUSDPopup withdrawCoyniToUSDPopup() {
		return withdrawCoyniToUSDPopup();
	}
}
