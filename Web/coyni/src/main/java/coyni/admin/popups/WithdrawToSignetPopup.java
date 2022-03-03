package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawToSignetPopup extends BrowserFunctions {
	public By lblHeading = By.xpath("//h1[text()='Withdraw to Signet Account']");
	public By txtAmount = By.id("amount");
	public By lblAvailableBalance = By.xpath("//span[@class='text-sm text-cgy4']");
	public By lblSignetAccount = By.xpath("");
	public By lnkDeleteSignet = By.xpath("//img[@class='cursor-pointer']");
	public By txtMessage = By.xpath("//textarea[@id='message']");
	public By btnNext = By.xpath("//button[text()='Next'] ");
	public By lnkConvertOption = By.xpath("//div[@class='relative mt-14']//img[1]");
	public By lblTransDescription = By.id("message");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Withdraw To Signet Account Heading", expHeading);
	}

//	public void verifyTransDescription(String expHeading) {
//		new CommonFunctions().verifyLabelText(lblTransDescription, " ", expHeading);
//	}

	public void getAvailableBalance() {
		ExtentTestManager
				.setInfoMessageInReport("Withdraw Amount is " + getElement(lblAvailableBalance, "Available Balance"));

	}

	public void fillAmount(String amount) {
		new CommonFunctions().verifyLabelText(txtAmount, amount, "Amount");
	}

	public void fillMessage(String message) {
		new CommonFunctions().verifyLabelText(txtMessage, message, "Message");
	}

	public void clickNext() {
		click(btnNext, "Click on Next");
	}

	public void clickConvertOption() {
		click(lnkConvertOption, "Click on Convert");
	}

	public void clickDeleteSignetIcon() {
		click(lnkDeleteSignet, "Click on Delete");
	}

	public WithdrawToSignetPreviewPopup withdrawToSignetPreviewPopup() {
		return new WithdrawToSignetPreviewPopup();
	}

	public RemoveSignetAccountPopup removeSignetAccountPopup() {
		return new RemoveSignetAccountPopup();
	}

}
