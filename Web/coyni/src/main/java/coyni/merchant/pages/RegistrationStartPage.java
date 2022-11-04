package coyni.merchant.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	private By lblcolor = By.xpath(
			"//span[contains(text(),'Merchant Application')]/..//div[contains(@class,'BusinessApplicationProcess_bullet')]");
	private By lblChangeColor = By.xpath(
			"(//div[contains(@class,'BusinessApplicationProcess_bullet_completed')]/../following-sibling::*[1]//div[1])[last()]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyPageDescription(String expDesc) {
		new CommonFunctions().verifyLabelText(lblDescription, "Page Description", expDesc);
	}

	public ArrayList<String> verifyColorOfRegistration() {
		List<WebElement> eles = getElementsList(lblcolor, " ");
		ArrayList<String> st = new ArrayList<>();

		for (WebElement ele : eles) {
			String str = ele.getCssValue("background-color");
			st.add(str);
			ExtentTestManager.setInfoMessageInReport("the hex value is " + str);
		}
		return st;

//		int i = this.Color.size();
		// ExtentTestManager.setInfoMessageInReport("the color count is" + );
		// return this.Color;
	}

	public void verifyColor() {
		String str = getElement(lblChangeColor, "Color").getCssValue("background-color");
		ExtentTestManager.setInfoMessageInReport("the Color is " + str);
	}

	public ArrayList<String> VerifyChangeColorofRegistration() {
		List<WebElement> eles = getElementsList(lblChangeColor, " ");
		ArrayList<String> st = new ArrayList<>();

		for (WebElement ele : eles) {
			String str = ele.getCssValue("background-color");
			st.add(str);
			ExtentTestManager.setInfoMessageInReport("the hex value is " + str);
		}
		return st;

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
