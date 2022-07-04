package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.merchant.pages.BankAccountPage;
import coyni.merchant.pages.RegistrationBeneficialOwnersPage;
import coyni.merchant.pages.RegistrationCompanyInfoPage;
import coyni.merchant.pages.RegistrationDBAInformationPage;
import coyni.merchant.pages.RegistrationStartPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SideBarMenuComponent extends BrowserFunctions {

	private By drpdwnHello = By.xpath("//div[contains(@class,'DashboardMenu_username')]");

	private By BusinessApplicationArrow = By.xpath("//div[@class='items-center text-xs -ml-2 4xl:mr-2']");
	private By BusinessApplicationTracker = By.xpath("//div[@class='flex mt-3 h-2.5 justify-around']");
	private By btnContinueApplication = By.xpath("//button[contains(@class,'w-60')]");

	private By lblBusinessSetting = By.xpath("//span[text()='Business Settings']");

	public void clickBusinessSettings() {
		click(lblBusinessSetting, "Business Settings");
		// click(getDashBoardItems("Business Settings"), "Business Settings");
	}

	public void clickBusinessApplicationArrow() {
		click(BusinessApplicationArrow, "Business Application Arrow");
	}

	public void clickContinueApplication() {
		click(btnContinueApplication, "Continue Application");
	}

	public void verifyBusinessApplicationTrackerView() {
		new CommonFunctions().elementView(BusinessApplicationTracker, "Business Application Tracker");
	}

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	private By getMerchantActivity(String Activity) {
		return By.xpath(String.format("//div[.='Reserve History']", Activity));
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public void clickUserdrpdwn() {
		click(drpdwnHello, "User drop down");
	}

	public void clickMerchantActivity() {
		click(getDashBoardItems("Merchant Activity"), "Merchant Activity");
	}

	public void clickTokenAccount() {
		click(getDashBoardItems("Token Account"), "Token Account");
	}

	public void clickExportFiles() {
		click(getDashBoardItems("Export Files"), "Export Files");
	}

	public void clickMerchantSettings() {
		click(getDashBoardItems("Merchant Settingss"), "Merchant Settingss");
	}

	public void clickGetHelp() {
		click(getDashBoardItems("Get Help"), "Get Help");
	}

	public void clickDashboard() {
		click(getMerchantActivity("Dashboard"), "Dashboard");
	}

	public void clickTransactions() {
		click(getMerchantActivity("Transactions"), "Transactions");
	}

	public void clickPayoutHistory() {
		click(getMerchantActivity("Payout History"), "Payout History");
	}

	public void clickReserveHistory() {
		click(getMerchantActivity("Reserve History"), "Reserve History");
	}

	public RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage() {
		return new RegistrationBeneficialOwnersPage();
	}

	public RegistrationCompanyInfoPage registrationCompanyInfoPage() {
		return new RegistrationCompanyInfoPage();
	}

	public RegistrationDBAInformationPage registrationDBAInformationPage() {
		return new RegistrationDBAInformationPage();
	}

	public RegistrationStartPage registrationStartPage() {
		return new RegistrationStartPage();
	}

	public BankAccountPage bankAccountPage() {
		return new BankAccountPage();
	}

}
