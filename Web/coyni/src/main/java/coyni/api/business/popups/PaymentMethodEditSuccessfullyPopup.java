package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PaymentMethodEditSuccessfullyPopup extends BrowserFunctions {

	private By paymenteditedHeading = By.xpath("//h1[text()='Payment Method Edited Successfully']");
	private By withdrawCoyni = By.xpath("//button[text()='Withdraw Coyni']");

	public void clickWithdrawCoyni() {
		click(withdrawCoyni, "Withdraw Coyni");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(paymenteditedHeading, "Payment Method Edited Successfully", expHeading);
	}

}
