package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.api.business.popups.ActionRequired;
import coyni.api.business.popups.ApplicationDecline;
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

	public ApplicationSummaryPage applicationSummaryPage() {
		return new ApplicationSummaryPage();
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

	public ApplicationSubmissionPage applicationSubmissionPage() {
		return new ApplicationSubmissionPage();
	}

	public AuthyComponent authyComponent() {
		return new AuthyComponent();
	}

	public ActionRequired actionRequired() {
		return new ActionRequired();
	}

	public ApplicationDecline applicationDecline() {
		return new ApplicationDecline();
	}
}
