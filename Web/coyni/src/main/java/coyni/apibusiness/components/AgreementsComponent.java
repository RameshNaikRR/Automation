package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AgreementsComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[text()='Agreements'])[2]");
	private By lblMerchantAgreements = By.xpath("//span[text()='Merchant Agreement']");

	private By getAgreements(String Agreements) {
		return By.cssSelector(String.format(
				"div[class*='bg-cwhite BusinessSettingsAgreements_agreements']>div:nth-of-type(%s)", "Agreements"));
	}

	private By lnkAgreements = By.xpath("//span[@aria-hidden=\"true\"]");

	private By getHeading(String Heading) {
		return By.xpath(String.format("(//span[.='%s'])[2]", Heading));
	}

	private By lnkDownloadPDF = By.xpath("//span[.='Download PDF']");
	private By lblVersion1 = By.xpath("(//span[text()='v1.0'])[1]");
	private By lblVersion2 = By.xpath("(//span[text()='v1.0'])[2]");
	private By lblVersion3 = By.xpath("(//span[text()='v1.0'])[3]");
	private By iconDownload = By.xpath("(//div[@data-tip='Download'])[1]");
	private By ipAddress1 = By.xpath("");
	private By ipAddress2 = By.xpath("");
	private By ipAddress3 = By.xpath("");

	public void clickMerchantAgreement() {
		click(getAgreements("2"), "Merchant Agreements");
	}

	public void clickPrivacyPolicy() {
		click(getAgreements("3"), "Privacy Policy");
	}

	public void clickTermsOfServices() {
		click(getAgreements("4"), "Terms Of Services");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public void VerifyAgreements() {
		new CommonFunctions().elementView(lnkAgreements, "Agreements");
	}

	public void verifyMerchantAgreements(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMerchantAgreements, expHeading, "Merchant Agreements");
	}

	public void verifyPrivacyPolicy() {
		new CommonFunctions().verifyLabelText(getHeading("Privacy Policy"), "Privacy Policy", "Privacy Policy");
	}

	public void verifyTermsOfService() {
		new CommonFunctions().verifyLabelText(getHeading("Terms of Service"), "Terms of Service", "Terms of Service");
	}

	public void verifyDownloadPDFlnk() {
		new CommonFunctions().elementView(lnkDownloadPDF, "Download PDF lnk");
	}

	public void verifyVersionMerchant() {
		new CommonFunctions().elementView(lblVersion1, "Merchant Agreement Version");
	}

	public void verifyVersionPrivacyPolicy() {
		new CommonFunctions().elementView(lblVersion2, "Privacy Policy Version");
	}

	public void verifyVersionTermsOfService() {
		new CommonFunctions().elementView(lblVersion3, "Terms Of Service");
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

}
