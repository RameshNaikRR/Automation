package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AgreementsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[.='Agreements'])[2]");

	private By lblAgreements = By.xpath("(//span[text()='Agreements'])[2]");
	private By lnkDownloadPDF = By.xpath("//span[text()='Download PDF']");
	private By lblVersion1 = By.xpath("(//span[text()='v1.0'])[1]");
	private By lblVersion2 = By.xpath("(//span[text()='v1.0'])[2]");
	private By iconDownload = By.xpath("(//button[@data-tip='Download'])[1]");
	private By privacyPolicy = By.xpath("//span[text()='Privacy Policy']");
	private By termsOfService = By.xpath("//span[text()='Terms of Service']");
	private By lblTermsOfService = By.xpath("(//span[text()='Terms of Service'])[1]");
	private By lblPrivacyPolicy = By.xpath("(//span[text()='Privacy Policy'])[1]");

//	private By getAgreements(String Agreements) {
//		return By.cssSelector(String.format(
//				"div[class*='bg-cwhite Agreements_agreements__Jzhhs]>div:nth-of-type(%s)", "Agreements"));
//	}

	private By lnkAgreements = By.xpath("(//span[text()='Agreements'])[1]");

//	public void clickMerchantAgreement() {
//		click(getAgreements("2"), "Merchant Agreements");
//	}

	public void clickPrivacyPolicy() {
		click(privacyPolicy, "Privacy policy");
	}

	public void clickOnAgreements() {
		click(lblAgreements, "Agreements");
	}

	public void getTermsOfService() {
		String text = getText(lblTermsOfService, "Terms of Service");
		ExtentTestManager.setInfoMessageInReport("Terms of Service " + text);
	}

	public void getPrivacyPolicy() {
		String text = getText(lblPrivacyPolicy, "Privacy Policy");
		ExtentTestManager.setInfoMessageInReport("Privacy Policy " + text);
	}

	public void clickTermsOfServices() {
		click(termsOfService, "Terms Of Service");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public void VerifyAgreements() {
		new CommonFunctions().elementView(lnkAgreements, "Agreements");
	}

	public void clickAgreements() {
		click(lnkAgreements, "Agreements");
	}

//	public void verifyPrivacyPolicy() {
//		new CommonFunctions().verifyLabelText(getHeading("Privacy Policy"), "Privacy Policy", "Privacy Policy");
//	}
//
//	public void verifyTermsOfService() {
//		new CommonFunctions().verifyLabelText(getHeading("Terms of Service"), "Terms of Service", "Terms of Service");
//	}
//
	public void verifyDownloadPDFlnk() {
		new CommonFunctions().elementView(lnkDownloadPDF, "Download PDF lnk");
	}

	public void verifyVersionMerchant() {
		new CommonFunctions().elementView(lblVersion1, "Merchant Agreement Version");
	}

	public void verifyVersionPrivacyPolicy() {
		new CommonFunctions().elementView(lblVersion2, "Privacy Policy Version");
	}

	public void clickiconDownload() {
		click(iconDownload, " Download Agreements");
	}

	public void clickLinkAgreements() {
		click(lnkAgreements, "Agreements");
	}

	public void clickDownloadPDF() {
		click(lnkDownloadPDF, "Download PDF");
	}

	public void verifyHeading() {
		new CommonFunctions().elementView(lblHeading, "Agreements Page ");
	}
}
