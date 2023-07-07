package coyni.business.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AgreementsComponent extends BrowserFunctions {
	private By lblPrivacyPolicy = By.xpath("//span[text()='Privacy Policy']");
	private By lblTermsOfService = By.xpath("//span[text()='Terms of Service']");
	private By getVersionAgreements = By.xpath("//div[@class='flex flex-col gap-2']");

	private By getAgreements(String Agreements) {
		return By.xpath(String.format("//button[contains(@class,'BusinessSettingsAgreements_AgreeCard__YzGq7')][%s]",
				Agreements));
	}

	private By iconDownload(String iconDownload) {
		return By.xpath(
				String.format("(//div[contains(@class,'icon-Download-Icon-Downloading z-50 ')])[%s]", iconDownload));
	}

	private By lnkAgreements = By
			.xpath("//span[@class='relative text-base text-cgy9 hover:underline hover:text-cgy4']");

	private By lnkDownloadPDF = By.xpath("//span[.='Download PDF']");

	public void termsOfService() {
		new CommonFunctions().elementView(getAgreements("1"), "Terms Of Service");
		List<WebElement> rows = getElementsList(getAgreements("1"), "Terms of Service");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}

	}

	public void privacyPolicy() {
		List<WebElement> rows = getElementsList(getAgreements("2"), "Privacy Policy");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
		new CommonFunctions().elementView(getAgreements("2"), "Privacy Policy");
	}

	public void clickTermsOfServices() {
		new CommonFunctions().verifyCursorAction(lblTermsOfService, "Terms Of Service");
		click(lblTermsOfService, "Terms Of Services");
	}

	public void clickPrivacyPolicy() {
		new CommonFunctions().verifyCursorAction(lblPrivacyPolicy, "Privacy Policy");
		click(lblPrivacyPolicy, "Privacy Policy");
	}

	public void getAllVersionAgreements() {
		new CommonFunctions().verifyCursorAction(getVersionAgreements, "Versions");
		List<WebElement> rows = getElementsList(getVersionAgreements, "All Versions");
		for (WebElement row : rows) {
			String replace = row.getText().replace("\n\n", "");
			ExtentTestManager.setInfoMessageInReport(replace + " is Displayed");
		}
	}

	public void verifyDownloadPDFlnk() {
		new CommonFunctions().elementView(lnkDownloadPDF, "Download PDF lnk");
	}

	public void clickiconDownloadPrivacyPolicy() {
		new CommonFunctions().elementView(iconDownload("2"), "Download");
		click(iconDownload("2"), "Privacy Policy Downlaod Icon");
	}

	public void clickiconDownloadTermsOfService() {
		new CommonFunctions().elementView(iconDownload("1"), "Download");
		click(iconDownload("1"), "Terms of Service Download Icon");
	}

	public void clickLinkAgreements() {
		new CommonFunctions().verifyCursorAction(lnkAgreements, "Agreements");
		String str = getElement(lnkAgreements, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(lnkAgreements, "Agreements");
	}

	public void clickDownloadPDF() {
		new CommonFunctions().verifyCursorAction(lnkDownloadPDF, "Download PDF");
		String str = getElement(lnkDownloadPDF, "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(lnkDownloadPDF, "Download PDF");
	}

}
