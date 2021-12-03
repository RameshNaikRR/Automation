package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.SuccessFailurePopupCardComponent;
import ilabs.WebFramework.BrowserFunctions;

public class PayingAccountHolderNamePopup extends BrowserFunctions {

	private By lnkCopy = By.className("copy-image");
	private By lblProcessingFee = By.xpath("//span[text()='Processing Fee']");
	private By btnPay = By.cssSelector("//button[text()='Pay']");

	public void clickOnCopyLink() {
		click(lnkCopy, "click copy");
	}

	public String getProcessingFee() {
		return getText(lblProcessingFee, "Processing Fee");
	}

	public void clickPay() {
		click(btnPay, "click confirm pay");
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}