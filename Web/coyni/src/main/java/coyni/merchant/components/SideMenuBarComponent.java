package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.merchant.pages.BankAccountPage;
import coyni.merchant.pages.RegistrationBeneficialOwnersPage;
import coyni.merchant.pages.RegistrationCompanyInfoPage;
import coyni.merchant.pages.RegistrationDBAInformationPage;
import coyni.merchant.pages.RegistrationStartPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SideMenuBarComponent extends BrowserFunctions {

	private By userNameDrpDwn = By.xpath("//div[contains(@class,'DashboardMenu_username')]");
	private By btnMerchnatApplicationTracker = By
			.xpath("(//span[contains(.,'Merchant')][contains(., 'Application')])[1]");
	private By merchnatApplicationTracker = By.xpath("(//div[@class='flex mt-3 h-2.5 justify-around'])[1]");
	private By merchnatApplicationTrackerToolTip = By.xpath("(//div[text()='Merchant Application step 4 of 6'])[2]");

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	private By getMerchantActivityDrpDwn(String Activity) {
		return By.xpath(String.format("//div[.='Reserve History']", Activity));
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public void clickUserdrpdwn() {
		click(userNameDrpDwn, "User drop down");
	}

	public void verifyUserName() {
		new CommonFunctions().elementView(userNameDrpDwn, "User Name ");
	}

	public void clickLblMerchantApplicationTracker() {
		click(btnMerchnatApplicationTracker, "Label Merchant Application Tracker");
	}

	public void verifyLblMerchnatApplicationTracker() {
		new CommonFunctions().elementView(btnMerchnatApplicationTracker, "Label Merchant Application Tracker");
	}

	public void getMerchantApplicationTracker() {
		new CommonFunctions().verifyCursorAction(merchnatApplicationTracker, "Merchant Application tracker");
		new CommonFunctions().elementView(merchnatApplicationTracker, "Merchant Application tracker");

//		String toolTip = getText(merchnatApplicationTrackerToolTip, "");
//		ExtentTestManager.setInfoMessageInReport("toolTip for Merchant Application tracker: " + toolTip);
	}

	public void verifyMerchnatTracker() {
		new CommonFunctions().elementView(merchnatApplicationTracker, "Merchant Application tracker");
//		String tracker = getText(merchnatApplicationTracker, "");
//		ExtentTestManager.setInfoMessageInReport("Tracker status is displayed" + tracker);
	}

	public void clickMerchantActivity() {
		click(getDashBoardItems("Merchant Activity"), "Merchant Activity");
	}

	public void verifyMerchantActivityDrpDwn() {
		new CommonFunctions().elementView(getDashBoardItems("Merchant Activity"), "Merchant Activity");
	}

	public void clickTokenAccount() {
		click(getDashBoardItems("Token Account"), "Token Account");
	}

	public void verifyTokenAccountPushBtn() {
		new CommonFunctions().elementView(getDashBoardItems("Token Account"), "Token Account");
	}

	public void clickExportFiles() {
		click(getDashBoardItems("Export Files"), "Export Files");
	}

	public void verifyExportFilesPushBtn() {
		new CommonFunctions().elementView(getDashBoardItems("Export Files"), "Export Files");
	}

	public void clickMerchantSettings() {
		click(getDashBoardItems("Merchant Settings"), "Merchant Settings");
	}

	public void verifyMerchnatSettingsPushBtn() {
		new CommonFunctions().elementView(getDashBoardItems("Merchant Settings"), "Merchant Settings");
	}

	public void clickGetHelp() {
		click(getDashBoardItems("Get Help"), "Get Help");
	}

	public void verifyGetHelpPushBtn() {
		new CommonFunctions().elementView(getDashBoardItems("Get Help"), "Get Help");
	}

	public void clickDashboard() {
		click(getMerchantActivityDrpDwn("Dashboard"), "Dashboard");
	}

	public void clickTransactions() {
		click(getMerchantActivityDrpDwn("Transactions"), "Transactions");
	}

	public void clickPayoutHistory() {
		click(getMerchantActivityDrpDwn("Payout History"), "Payout History");
	}

	public void clickReserveHistory() {
		click(getMerchantActivityDrpDwn("Reserve History"), "Reserve History");
	}

	public RegistrationSideBarMenuComponent registrationSideBarMenuComponent() {
		return new RegistrationSideBarMenuComponent();
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
