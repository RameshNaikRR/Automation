package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionInProgessPopup extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//h1[text()='Transaction In Progress']");
	private By lblDescription = By.xpath("//p[contains(.,'We are processing')]");

	private By lnkLearnMore = By.xpath("//span[.='Learn More']");
	private By lblAmount = By.xpath("//div[contains(@class,'BankInstantPayWithdrawModal_a')]");
	private By lblAmountMsg = By
			.xpath("//div[contains(@class,'BankInstantPayWithdrawModal_a')]/../following-sibling::div[1]");
	private By lblRecipient = By.xpath("//span[text()='Recipient']");
	private By lblRecipientBank = By.xpath("//span[text()='Recipient']/following-sibling::span");
	private By lblReferenceID = By.xpath("//span[text()='Reference ID']");
	private By lnkReferenceID = By.xpath("//div[@class='copy-clipboard__content']");
	private By btnDone = By.xpath("//button[text()='Done']");

	public void verifyHeading(String expHeading) {
		cf.verifyLabelText(lblHeading, "Transaction InProgress", expHeading);
	}

	public void verifyDescription() {
		String text = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void switchToAdmin(String url) throws InterruptedException {
		new CommonFunctions().switchtoUrl(url);
	}

	public void clickLearnMoreLnk() {
		click(lnkLearnMore, "Click LearnMore");
	}

	public void verifyLearnMoreLnk() {
		cf.elementView(lnkLearnMore, "Learn more lnk");
	}

	public void verifyAmount() {
		cf.elementView(lblAmount, "Amount");
	}

	public void verifyAmountMsg() {
		String text = getText(lblAmountMsg, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyRecipientLbl() {
		cf.elementView(lblRecipient, "Recipient Label");
	}

	public void verifyRecipientBankLbl() {
		cf.elementView(lblRecipientBank, "Recipient Bank Label");
	}

	public void verifyReferenceIdLbl() {
		cf.elementView(lblReferenceID, "ReferenceID Label ");
	}

	public void verifyReferenceID() {
		click(lnkReferenceID, "ReferenceID Link");
		ExtentTestManager.setInfoMessageInReport("Reference ID is :" + getCopiedData());
	}

	/**
	 * this is used to perform click action
	 */

	public void clickDone() {
		click(btnDone, "Click Done");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
