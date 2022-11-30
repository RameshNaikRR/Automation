package coyni_mobile_merchant.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class RegistrationProcessPage extends MobileFunctions {

	private By btnGetStarted = MobileBy.xpath("//*[contains(@text,'Get Started')]");
	private By btnCompanyInfo = MobileBy.xpath("//*[contains(@resource-id,'caIncompleteLL')]");
	private By btnDBAInfo = MobileBy.xpath("//*[contains(@resource-id,'dbaIncompleteLL')]");
	private By btnBeneficialOwners = MobileBy.xpath("//*[contains(@resource-id,'boIncompleteLL')]");
	private By btnAddBank = MobileBy.xpath("//*[contains(@resource-id,'addBankIncompleteLL')]");
	private By btnMerchantAgreement = MobileBy.xpath("//*[contains(@resource-id,'aggrementsIncompleteLL')]");
	private By btnReviewApplication = MobileBy.xpath("//*[contains(@resource-id,'reviewCv')]");

	public void clickGetStarted() throws InterruptedException {
		Thread.sleep(2000);
		if (DriverFactory.getDriver().findElements(btnGetStarted).size()==1) {
		click(btnGetStarted, "Get Started");
		}
	}

	public void clickCompanyInfo() {
		click(btnCompanyInfo, "Company Information");
	}

	public void clickDBAInfo() {
		click(btnDBAInfo, "DBA Information");
	}

	public void clickBeneficialOwners() {
		click(btnBeneficialOwners, "Beneficial Owners");
	}

	public void clickAddBank() {
		click(btnAddBank, "Add Bank Account");
	}

	public void clickMerchantAgreement() {
		click(btnMerchantAgreement, "Merchant's Agreement");
	}

	WebDriverWait wait=new WebDriverWait(DriverFactory.getDriver(), 20);
	public void clickReviewApplication() throws InterruptedException {
	wait.until(ExpectedConditions.elementToBeClickable(btnReviewApplication));
		TouchAction touch = new TouchAction(DriverFactory.getDriver());
		touch.press(PointOption.point(300, 1500)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
				.moveTo(PointOption.point(100, (int) (1200))).release().perform();

		click(btnReviewApplication, "Review Application");
	}

	public RegistrationCompanyInfoPage registrationCompanyInfoPage() {
		return new RegistrationCompanyInfoPage();
	}

	public RegistrationDBAPage registrationDBAPage() {
		return new RegistrationDBAPage();
	}

	public RegistrationBeneficialOwnerPage registrationBeneficialOwnerPage() {
		return new RegistrationBeneficialOwnerPage();
	}

	public RegistrationMerchantAgreementsPage registrationMerchantAgreementsPage() {
		return new RegistrationMerchantAgreementsPage();
	}

	public ReviewApplicationPage reviewApplicationPage() {
		return new ReviewApplicationPage();
	}

}
