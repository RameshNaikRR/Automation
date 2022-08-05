package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AgreementsComponent extends BrowserFunctions {
	private By lblMerchantAgreements = By.xpath("//span[text()='Merchant Agreement']");
	private By lblBusinessAgreements = By.xpath("//span[text()='Business Agreement']");
	private By lblPrivacyPolicy = By.xpath("//span[text()='Privacy Policy']");
	private By lblTermsOfService = By.xpath("//span[text()='Terms of Service']");

//	private By getAgreements(String Agreements) {
//		return By.cssSelector(String.format(
//				"div[class*='bg-cwhite BusinessSettingsAgreements_agreements']>div:nth-of-type(%s)", "Agreements"));
//	}
	private By iconDownload(String iconDownload) {
		return By.xpath(
				"((//div[@class='icon-Download-Icon-Downloading z-50  BusinessSettingsAgreements_downloadImg__VmtqT'])[%s]");
	}

	private By lnkAgreements = By
			.xpath("//span[@class='relative text-base text-cgy9 hover:underline hover:text-cgy4']");

	private By lnkDownloadPDF = By.xpath("//span[.='Download PDF']");
	private By lblVersion1 = By.xpath("(//span[text()='v1.0'])[1]");
	private By lblVersion2 = By.xpath("(//span[text()='v1.0'])[2]");
	private By lblVersion3 = By.xpath("(//span[text()='v1.0'])[3]");

	private By ipAddress1 = By.xpath("");
	private By ipAddress2 = By.xpath("");
	private By ipAddress3 = By.xpath("");

//	public void clickMerchantAgreement() {
//		click(getAgreements("2"), "Merchant Agreements");
//	}

	public void verifyBusinessAgreements() {
		new CommonFunctions().elementView(lblBusinessAgreements, getCopiedData());
	}

	public void clickPrivacyPolicy() {
		click(lblPrivacyPolicy, "Privacy Policy");
	}

	public void clickTermsOfServices() {
		click(lblTermsOfService, "Terms Of Services");
	}

	public void clickBusinessAgreements() {
		click(lblBusinessAgreements, "Business Agreement");
	}

	public void VerifyAgreements() {
		new CommonFunctions().elementView(lnkAgreements, "Agreements");
	}

	public void verifyMerchantAgreements(String expHeading) {
		new CommonFunctions().verifyLabelText(lblMerchantAgreements, expHeading, "Merchant Agreements");
	}

	public void verifyPrivacyPolicy() {
		new CommonFunctions().verifyLabelText(lblPrivacyPolicy, "Privacy Policy", "Privacy Policy");
	}

	public void verifyTermsOfService() {
		new CommonFunctions().verifyLabelText(lblTermsOfService, "Terms of Service", "Terms of Service");
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

	public void clickiconDownloadBusiness() {
		click(iconDownload("1"), " Download Agreements");
	}

	public void clickiconDownloadPrivacyPolicy() {
		click(iconDownload("2"), " Download Agreements");
	}

	public void clickiconDownloadTermsOfService() {
		click(iconDownload("3"), " Download Agreements");
	}

	public void clickLinkAgreements() {
		click(lnkAgreements, "Agreements");
	}

	public void clickDownloadPDF() {
		click(lnkDownloadPDF, "Download PDF");
	}

}
