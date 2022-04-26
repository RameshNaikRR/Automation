package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BusinessSettingsPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Business Settings']");
	private By lblApplication = By.xpath("//span[.='Application ']");
	private By lblIdInformation = By.cssSelector("div[class*='flex flex-col text-xs lg:flex-row text-cgy2 lg:gap-1']");
	private By lblAccountStatus = By.xpath("//div[text()='Account Status:']");
	private By lblActive = By.xpath("//div[.='Active']");

	private By getSideMenuBarItems(String btnNumber) {
		return By.cssSelector(String.format(
				"div[class*='BusinessSettings_container']>div:nth-of-type(1)>div:nth-of-type(2)>a:nth-of-type(%s)",
				btnNumber));
	}

	public void clickCompanyInformation() {
		click(getSideMenuBarItems("1"), "Company Information");
	}

	public void clickDBAinformation() {
		click(getSideMenuBarItems("2"), "DBA Infromation");
	}

	public void clickBeneficiaryOwner() {
		click(getSideMenuBarItems("3"), "Beneficiary Owner");
	}

	public void clickPaymentMethods() {
		click(getSideMenuBarItems("4"), "Payment Methods");
	}

	public void clickPreferences() {
		click(getSideMenuBarItems("5"), "Preferences");
	}

	public void clickAgreements() {
		click(getSideMenuBarItems("6"), "Agreements");
	}

	public void clickFees() {
		click(getSideMenuBarItems("7"), "Fees");
	}

	public void clickAccountLimits() {
		click(getSideMenuBarItems("8"), "Account Limits");
	}

	public void clickTeam() {
		click(getSideMenuBarItems("9"), "Team");
	}

	public void clickIpAddresses() {
		click(getSideMenuBarItems("10"), "Ip Addresses");
	}

	public void clickApiKey() {
		click(getSideMenuBarItems("11"), "Api Key");
	}

	public void clickWebhooks() {
		click(getSideMenuBarItems("12"), "Wenhooks");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public void verifyApplication(String Application) {
		new CommonFunctions().verifyLabelText(lblApplication, Application, "Application");
	}

	public void verifyIdInformation(String Idinformation) {
		new CommonFunctions().verifyLabelText(lblIdInformation, Idinformation, "Idinformation");
	}

	public void verifyAccountStatus(String AccountStatus) {
		new CommonFunctions().verifyLabelText(lblAccountStatus, AccountStatus, "AccountStatus");
	}

	public void verifyActive(String Active) {
		new CommonFunctions().verifyLabelText(lblActive, Active, "Active");
	}

}
