package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ProcessingFeesPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//h4[text()='Processing Fees']");
	private By subHeading = By.xpath("//div[text()='YOUR BUSINESS FEES']");
	private By lblWithdraw = By.xpath("//p[text()='Withdraws']");
	private By lblBankAccount = By.xpath("//div[text()='Bank Account']");
	private By lblInstantPay = By.xpath("//div[text()='Instant Pay']");
	private By lblSignet = By.xpath("//div[text()='Signet']");
	private By lblGiftCard = By.xpath("//div[text()='Gift Card']");
	private By lblFailedBankWithdraw = By.xpath("//div[text()='Failed Bank Withdraw']");
	private By lblBuyTokens = By.xpath("//p[text()='Buy Token']");
	private By chckbox = By.xpath("//input[@type='checkbox']");
	private By btnNext = By.xpath("//button[text()='Next']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().elementView(lblHeading, Heading);
	}

	public void verifysubHeading(String Heading) {
		new CommonFunctions().elementView(subHeading, Heading);

	}

	public void verifyWithdraws(String Withdraws) {
		new CommonFunctions().elementView(lblWithdraw, Withdraws);

	}

	public void verifyBankAccount(String bankAccount) {
		new CommonFunctions().elementView(lblBankAccount, "Bank Account");
	}

	public void verifyInstantPay(String bankAccount) {
		new CommonFunctions().elementView(lblInstantPay, "Instant Pay");
	}

	public void verifySignet(String bankAccount) {
		new CommonFunctions().elementView(lblSignet, "Bank Account");
	}

	public void verifyGiftCard(String bankAccount) {
		new CommonFunctions().elementView(lblGiftCard, "Bank Account");
	}

	public void verifyFailedBankWithdraw(String bankAccount) {
		new CommonFunctions().elementView(lblFailedBankWithdraw, "Bank Account");
	}

	public void verifyBuyTokens(String heading) {
		new CommonFunctions().elementView(lblBuyTokens, "Buy Tokens");
	}

	public void clickCheckBox(String checkBox) {
		click(chckbox, checkBox);
	}

	public void clickNext() {
		if (getElement(btnNext, "Next").isEnabled()) {
			click(btnNext, "Next ");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is in disabled mode");
		}
	}

}
