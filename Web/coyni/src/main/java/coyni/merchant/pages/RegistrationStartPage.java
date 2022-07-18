package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RegistrationStartPage extends BrowserFunctions {

	private By lblHeading = By.cssSelector("div[class*=BusinessApplicationBanner_container__UXCpJ]>div>h1");
	private By lblDescription = By.cssSelector("div[class*=BusinessApplicationBanner_container__UXCpJ]>div>p");
	private By lblMerchantApplication = By.xpath("//p[text()='Merchant']");
	private By btnStartApplication = By.xpath("//button[text()='Start Application']");
	private By btnContinueApplication = By.xpath("//button[text()='Continue Application']");
	private By lblStatus = By.xpath("//p[text()='Status:']/*[1]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPageDescription(String expDesc) {
		new CommonFunctions().verifyLabelText(lblDescription, "Page Description", expDesc);
	}

	public void clickStartApplication() {
		click(btnStartApplication, "Start Application");
	}

	public void clickContinueApplication() {
		click(btnContinueApplication, "Continue Application");
	}

	public void verifyMerchantApplicationView() {
		new CommonFunctions().elementView(lblMerchantApplication, "Merchant Application");
	}

	public void getStatus() {
		ExtentTestManager.setInfoMessageInReport("Status: " + getText(lblStatus, ""));
	}

	public RegistrationCompanyInfoPage registrationCompanyInfoPage() {
		return new RegistrationCompanyInfoPage();
	}

	public RegistrationDBAInformationPage registrationDBAInformationPage() {
		return new RegistrationDBAInformationPage();
	}

	public RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage() {
		return new RegistrationBeneficialOwnersPage();
	}

	public BankAccountPage bankAccountPage() {
		return new BankAccountPage();
	}

	public MerchantAgreementsPage merchantAgreementsPage() {
		return new MerchantAgreementsPage();
	}

	public ApplicationSummaryPage applicationSummaryPage() {
		return new ApplicationSummaryPage();
	}

	public ApplicationSubmissionPage applicationSubmissionPage() {
		return new ApplicationSubmissionPage();
	}

	public ApplicationDeclinedPage applicationDeclinedPage() {
		return new ApplicationDeclinedPage();
	}

	public ApplicationCancelledPage applicationCancelledPage() {
		return new ApplicationCancelledPage();
	}

	public ApplicationApprovedReservedPage applicationApprovedReservedPage() {
		return new ApplicationApprovedReservedPage();
	}

	public ApplicationAdditionalInfoReqPage applicationAdditionalInfoReqPage() {
		return new ApplicationAdditionalInfoReqPage();
	}
}
