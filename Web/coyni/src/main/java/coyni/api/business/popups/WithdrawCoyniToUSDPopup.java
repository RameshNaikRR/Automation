package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WithdrawCoyniToUSDPopup extends BrowserFunctions {

	public By lblHeading = By.xpath("//h1[text()='Withdraw coyni to USD']");
	public By lblBankAccount = By.xpath("//span[text()='Bank Account']");
	public By lblInstantPay = By.xpath("//span[text()='Instant Pay']");
	public By lblSignetAccount = By.xpath("//span[text()=' Signet Account']");

	public void verifylblHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}
	public void verifyBankAccountHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBankAccount, "Heading", expHeading);
	}

	public void verifyInstantPayHeading(String InstantPayHeading) {
		new CommonFunctions().verifyLabelText(lblInstantPay, "Instant Pay Heading", InstantPayHeading);
	}

	public void verifySignetAccountHeading(String SignetAccountHeading) {
		new CommonFunctions().verifyLabelText(lblSignetAccount, "Signet Account Heading", SignetAccountHeading);
	}
}