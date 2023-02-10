package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AgreementsPage extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("(//span[.='Agreements'])[2]");

	private By getAgreements(String Agreements) {
		return By.xpath(
				String.format("(//button[contains(@class,'BusinessSettingsAgreements_AgreeCard')])[%s]", Agreements));
	}

	private By getAgreementsLbl(String AgreementsLabels) {
		return By.xpath(String.format("//span[text()='%s']", AgreementsLabels));
	}

	private By getAgreementsVersions(String AgreementsVersions) {
		return By.xpath(String.format("//span[text()='Merchant Agreement']/following-sibling::*", AgreementsVersions));
	}

	private By getAgreementsSignedOnLbl(String SignedOnLbl) {
		return By.xpath(String.format(
				"//span[text()='Merchant Agreement']/ancestor::div[2]/following-sibling::div[1]/span[1]", SignedOnLbl));
	}

	private By getAgreementsSignedOnDate(String SignedDate) {
		return By.xpath(String.format(
				"//span[text()='Merchant Agreement']/ancestor::div[2]/following-sibling::div[1]/span[2]", SignedDate));
	}

	private By getAgreementsIpAddressLbl(String IpAddressLbl) {
		return By.xpath(
				String.format("//span[text()='Merchant Agreement']/ancestor::div[2]/following-sibling::div[2]/span[1]",
						IpAddressLbl));
	}

	private By getAgreementsIpAddress(String IpAddress) {
		return By.xpath(String.format(
				"//span[text()='Merchant Agreement']/ancestor::div[2]/following-sibling::div[2]/span[2]", IpAddress));
	}

	private By getAgreementsDownload(String download) {
		return By.xpath(String.format("//span[text()='Merchant Agreement']/ancestor::div[2]/following-sibling::div[3]",
				download));
	}

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

//	public void verifyMerchantAgreementsTab() {
//		cf.elementView(getAgreements("1"), "Merchant Agreements tab ");
//	}

	public void verifyPrivacyPolicyTab() {
		cf.elementView(getAgreements("2"), "Privacy Policy tab ");
	}

	public void verifyTermsOfServicesTab() {
		cf.elementView(getAgreements("1"), "Terms Of Services tab ");
	}

	public void verifyMerchantAgreementsLbl() {
		cf.elementView(getAgreementsLbl("Merchant Agreement"), "Merchant Agreement Label ");
	}

	public void verifyPrivacyPolicyLbl() {
		cf.elementView(getAgreementsLbl("Privacy Policy"), "Privacy Policy Label ");
	}

	public void verifyTermsOfServiceLbl() {
		cf.elementView(getAgreementsLbl("Terms of Service"), "Terms of Service Label ");
	}

	public void verifyMerchantAgreementsVersion() {
		cf.elementView(getAgreementsVersions("Merchant Agreement"), "Merchant Agreement Version ");
	}

	public void verifyPrivacyPolicyVersion() {
		cf.elementView(getAgreementsVersions("Privacy Policy"), "Privacy Policy Version ");
	}

	public void verifyTermsOfServiceVersion() {
		cf.elementView(getAgreementsVersions("Terms of Service"), "Terms of Service Version ");
	}

	public void verifyMerchantAgreementsSignedOnLbl() {
		cf.elementView(getAgreementsSignedOnLbl("Merchant Agreement"), "Signed On Label ");
	}

	public void verifyPrivacyPolicySignedOnLbl() {
		cf.elementView(getAgreementsSignedOnLbl("Privacy Policy"), "Signed On Label ");
	}

	public void verifyTermsOfServiceSignedOnLbl() {
		cf.elementView(getAgreementsSignedOnLbl("Terms of Service"), "Signed On Label ");
	}

	public void verifyMerchantAgreementsSignedDate() {
		cf.elementView(getAgreementsSignedOnDate("Merchant Agreement"), "Signed On Date ");
	}

	public void verifyPrivacyPolicySignedDate() {
		cf.elementView(getAgreementsSignedOnDate("Privacy Policy"), "Signed On Date ");
	}

	public void verifyTermsOfServiceSignedDate() {
		cf.elementView(getAgreementsSignedOnDate("Terms of Service"), "Signed On Date ");
	}

	public void verifyMerchantAgreementsIpAddressLbl() {
		cf.elementView(getAgreementsIpAddressLbl("Merchant Agreement"), "Ip Address Label ");
	}

	public void verifyPrivacyPolicyIpAddressLbl() {
		cf.elementView(getAgreementsIpAddressLbl("Privacy Policy"), "Ip Address Label ");
	}

	public void verifyTermsOfServiceIpAddressLbl() {
		cf.elementView(getAgreementsIpAddressLbl("Terms of Service"), "Ip Address Label ");
	}

	public void verifyMerchantAgreementsIpAddress() {
		cf.elementView(getAgreementsIpAddress("Merchant Agreement"), "Ip Address ");
	}

	public void verifyPrivacyPolicyIpAddress() {
		cf.elementView(getAgreementsIpAddress("Privacy Policy"), "Ip Address ");
	}

	public void verifyTermsOfServiceIpAddress() {
		cf.elementView(getAgreementsIpAddress("Terms of Service"), "Ip Address ");
	}

	public void clickMerchantAgreementsDownload() {
		click(getAgreementsDownload("Merchant Agreement"), "Clicked on Merchant Agreements Download button");
	}

	public void clickPrivacyPolicyDownload() {
		click(getAgreementsDownload("Privacy Policy"), "Clicked on Merchant Agreements Download button");
	}

	public void clickTermsOfServiceDownload() {
		click(getAgreementsDownload("Terms of Service"), "Clicked on Merchant Agreements Download button");
	}
}
