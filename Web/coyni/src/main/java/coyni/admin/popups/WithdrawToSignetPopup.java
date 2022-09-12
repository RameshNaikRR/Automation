package coyni.admin.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawToSignetPopup extends BrowserFunctions {

	public By lnkDeleteSignet = By.xpath("//div[@data-tip='Delete' or data-for='delete']");
	public By lblHeading = By.xpath("//h1[text()='Withdraw to Signet Account']");
	public By txtAmount = By.xpath("//input[@type='text']");
	public By lblAvailableBalance = By.xpath("//span[@class='text-sm text-cgy4']");
	public By lblSignetAccount = By.xpath("");
	public By txtMessage = By.xpath("//textarea[@id='message']");
	public By btnNext = By.xpath("//button[text()='Next'] ");
	public By lnkConvertOption = By.xpath("//div[@class='relative mt-14']//img[1]");
	public By lblTransDescription = By.id("message");

	public void verifyPageHeading() {
		ExtentTestManager
				.setInfoMessageInReport("Withdraw Amount is " + getElement(lblHeading, "Withdraw to Signet Account"));

		// new CommonFunctions().verifyLabelText(lblHeading, "Withdraw To Signet Account
		// Heading", expHeading);
	}

	private By lblInsufficent = By.xpath("//p[text()='Insufficient funds.']");

	public int lblError() {
		return getElementsList(lblInsufficent, "").size();
	}

	public void getAvailableBalance() {
		ExtentTestManager
				.setInfoMessageInReport("Withdraw Amount is " + getElement(lblAvailableBalance, "Available Balance"));

	}

	public void fillAmount(String amount) {
		enterText(txtAmount, amount, "Amount");
	}

	public void fillMessage(String message) {
		enterText(txtMessage, message, "Message");
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Click on Next");
		} else {
			ExtentTestManager.setInfoMessageInReport("Next Button is disabled");
		}
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
