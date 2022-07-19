package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AccountLimitsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[contains(@class,'BusinessSettings_page')]//span[.='Account Limits']");

	private By lblMonthlyProcessing = By.xpath("//p[contains(text(),'Merchant Processing')]");

	private By lblMonthlyProcessingVolume = By
			.xpath("//span[contains(text(),'Monthly Processing Volume')]/following-sibling::*[2]");

	private By lblHighTicketLimit = By.xpath("//span[contains(text(),'High Ticket Limit')]/following-sibling::*[2]");

	private By lblBuyToken = By.xpath("//p[contains(text(),'Buy Token')]]");

	private By lblBuyTokenBankAccount = By
			.xpath("(//span[contains(text(),'Bank Account')])[1]/following-sibling::*[2]");

	private By lblBuyTokenSignetAccount = By
			.xpath("(//span[contains(text(),'Signet Account')])[1]/following-sibling::*[2]");

	private By lblWithdrawToken = By.xpath("//p[contains(text(),'Withdraws')]");

	private By lblWithdrawBankAccount = By
			.xpath("(//span[contains(text(),'Bank Account')])[2]/following-sibling::*[2]");

	private By lblWithdrawSignetAccount = By
			.xpath("(//span[contains(text(),'Signet Account')])[2]/following-sibling::*[2]");

	private By lblWithdrawInstantPay = By.xpath("//span[contains(text(),'Instant Pay')]/following-sibling::*[2]");

	private By lblWithdrawGiftCard = By.xpath("//span[contains(text(),'Gift Card')]/following-sibling::*[2]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void getMerchantProcessingVolume() {
		new CommonFunctions().elementView(lblMonthlyProcessingVolume, "Merchant Processing Volume");
		String text = getText(lblMonthlyProcessingVolume, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void getHighTicket() {
		new CommonFunctions().elementView(lblHighTicketLimit, "High Ticket");
		String text = getText(lblHighTicketLimit, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void getBuyTokenBankAccount() {
		new CommonFunctions().elementView(lblBuyTokenBankAccount, "Buy Token Bank Account");
		String text = getText(lblBuyTokenBankAccount, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void getBuyTokenSignetAccount() {
		new CommonFunctions().elementView(lblBuyTokenSignetAccount, "Buy Token Signet Account");
		String text = getText(lblBuyTokenSignetAccount, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);

	}

	public void getWithdrawBankAccount() {
		new CommonFunctions().elementView(lblWithdrawBankAccount, "Buy Token Bank Account");
		String text = getText(lblWithdrawBankAccount, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void getWithdrawSignetAccount() {
		new CommonFunctions().elementView(lblWithdrawSignetAccount, "Withdraw Signet Account");
		String text = getText(lblWithdrawSignetAccount, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}

	public void getInstantPay() {
		new CommonFunctions().elementView(lblWithdrawInstantPay, "Instant Pay");
		String text = getText(lblWithdrawInstantPay, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);

	}

	public void getGiftCard() {
		new CommonFunctions().elementView(lblWithdrawGiftCard, "Gift Card");
		String text = getText(lblWithdrawGiftCard, "Description");
		ExtentTestManager.setInfoMessageInReport("Description " + text);
	}
}
