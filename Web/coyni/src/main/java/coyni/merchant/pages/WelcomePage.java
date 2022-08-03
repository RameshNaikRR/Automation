package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WelcomePage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[contains(.,'Welcome,')]");
	private By lblDescription = By.xpath("//h1[contains(.,'Welcome,')]/following-sibling::p");
	private By lblMerchantApplication = By.xpath("(//p[contains(.,'Merchant')])[2]");
	private By lblStatus = By.xpath("//p[text()='Status:']");
	private By btnContinueApplication = By.xpath("//button[.='Continue Application']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescvription() {
		String text = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(text + " Is displayed");
	}

	public void verifyMerchantApplicationLbl() {
		String text = getText(lblMerchantApplication, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyStatus() {
		String text = getText(lblStatus, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyContinueApplicationBtn() {
		new CommonFunctions().elementView(btnContinueApplication, "Continue Application button");
	}

	public void clickContinueApplicationBtn() {
		click(btnContinueApplication, "Continue Application button");
	}
}
