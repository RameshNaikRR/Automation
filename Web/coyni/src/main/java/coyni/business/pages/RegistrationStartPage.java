package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RegistrationStartPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1");
	private By lblDescription = By.cssSelector("div[class*=BusinessApplicationBanner_container]>div>p");
	private By lblBusinessApplication = By.xpath("//p[@class='text-xl font-bold leading-5 text-cgy4']");
	private By btnStartApplication = By.xpath("//button[text()='Start Application']");
	private By btnContinueApplication = By.xpath("//Button[text()='Continue Application']");
	private By lblStatus = By.xpath("//p[text()='Status:']/*[1]");
	private By twostep = By.xpath("//strong[text()='Activate Two-Step Authentication']");

	public void verifyHeading() {
		String heading = getText(lblHeading, "Heading");
		ExtentTestManager.setInfoMessageInReport(heading + " is displayed");
	}

	public void verifyPageDescription(String expDesc) {
		new CommonFunctions().verifyLabelText(lblDescription, "Page Description", expDesc);
	}

	public void clickTwoStep() {
		click(twostep, "Activate Two-Step Authentication");
	}

	public void clickStartApplication() {
		click(btnStartApplication, "Start Application");
	}

	public void clickContinueApplication() {
		click(btnContinueApplication, "Continue Application");
	}

	public void verifyBusinessApplicationView() {
		String businessApp = getText(lblBusinessApplication, "Business Application");
		ExtentTestManager.setInfoMessageInReport(businessApp + " is displayed");
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblStatus, ""));
	}

	public RegistrationCompanyInfoPage registrationCompanyInfoPage() {
		return new RegistrationCompanyInfoPage();
	}

	public RegistrationDBAPage registrationDBAPage() {
		return new RegistrationDBAPage();
	}

	public RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage() {
		return new RegistrationBeneficialOwnersPage();
	}

	public DocumentsUploadPage documentsUploadPage() {
		return new DocumentsUploadPage();
	}

	public AccountFeesAndLimitsPage accountFeesAndLimitsPage() {
		return new AccountFeesAndLimitsPage();
	}

	public AgreementsPage agreementsPage() {
		return new AgreementsPage();
	}

	public ApplicationSubmissionPage applicationSubmissionPage() {
		return new ApplicationSubmissionPage();
	}

	public ApplicationSummaryPage applicationSummaryPage() {
		return new ApplicationSummaryPage();
	}

	public ApplicationDecline applicationDecline() {
		return new ApplicationDecline();
	}
	public ActionRequired actionRequired() {
		return new ActionRequired();
	}

}
