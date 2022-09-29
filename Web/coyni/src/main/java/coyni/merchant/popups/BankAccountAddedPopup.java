package coyni.merchant.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BankAccountAddedPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[.='Bank Account Added']");

	private By status = By.xpath("//span[contains(text(),'Status')]/following-sibling::*");

	private By nameOnAccount = By.xpath("//span[contains(text(),'Name on Account')]/following-sibling::*");

	private By institution = By.xpath("//span[contains(text(),'Institution')]/following-sibling::*");

	private By routingNumber = By.xpath("//span[contains(text(),'Routing Number')]/following-sibling::*");

	private By accountNumber = By.xpath("//span[contains(text(),'Account Number')]/following-sibling::*");

	private By btnDone = By.xpath("//span[contains(text(),'Done')]");

	public void verifyHeading() {
		String text = getText(lblHeading, "Headinf");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyStatus() {
		String lstatus = getText(status, "Status");
		ExtentTestManager.setInfoMessageInReport(lstatus + " is displayed");
	}

	public void verifyNameOnAccount() {
		String name = getText(nameOnAccount, "Name");
		ExtentTestManager.setInfoMessageInReport(name + " is displayed");
	}

	public void verifyRoutingNumber() {
		String routingNumberl = getText(routingNumber, "Routing Number");
		ExtentTestManager.setInfoMessageInReport(routingNumberl + " is displayed");
	}

	public void verifyAccount() {
		String account = getText(accountNumber, "Institution");
		ExtentTestManager.setInfoMessageInReport(account + " is displayed");
	}

	public void verifyInstitution() {
		String inst = getText(institution, "Institution");
		ExtentTestManager.setInfoMessageInReport(inst + " is displayed");
	}

	public void clickDone() {
		click(btnDone, "Dones");
	}
}
