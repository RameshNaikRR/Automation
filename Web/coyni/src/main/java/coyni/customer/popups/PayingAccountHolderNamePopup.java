package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.AuthyComponent;
import coyni.customer.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PayingAccountHolderNamePopup extends BrowserFunctions {

	private By lnkCopy = By.className("copy-image");
	private By lblamount = By.xpath("//div[@class='flex justify-center items-baseline mt-3 mb-2']//p");
	private By lblProcessingFee = By.xpath("//span[text()='Processing Fee']");
	private By btnPay = By.xpath("//button[text()='Pay']");
	private By heading = By.xpath("//h1[text()='Verify Your Identity']");

	public void clickOnCopyLink() {
		click(lnkCopy, "click copy");
	}

//	public String getProcessingFee() {
//		return getText(lblProcessingFee, "Processing Fee");
//	}

	public void verifyProcessingFee() {
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
	}

	public void clickPay() {
		click(btnPay, "click confirm pay");
	}

	public void verifyAmount() {
		new CommonFunctions().elementView(lblamount, "Amount displayed");
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Autentication Heading", expHeading);
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}
}