package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.merchant.pages.BankAccountPage;
import coyni.merchant.pages.DashBoardPage;
import coyni.merchant.pages.ExportfilesPage;
import coyni.merchant.pages.GetHelpPage;
import coyni.merchant.pages.MerchantSettingsPage;
import coyni.merchant.pages.PayOutHistoryPage;
import coyni.merchant.pages.RegistrationBeneficialOwnersPage;
import coyni.merchant.pages.RegistrationCompanyInfoPage;
import coyni.merchant.pages.RegistrationDBAInformationPage;
import coyni.merchant.pages.RegistrationStartPage;
import coyni.merchant.pages.ReserveHistoryPage;
import coyni.merchant.pages.TokenAccountPage;
import coyni.merchant.pages.TransactionsPage;
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
		return By.xpath(String.format("//button[.='%s']", Activity));
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

	public void clickMerchantActivityDrpDwn() {
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

	public void verifyDashboard() {
		new CommonFunctions().elementView(getMerchantActivityDrpDwn("Dashboard"), "Dashboard push button ");
	}

	public void clickTransactions() {
		click(getMerchantActivityDrpDwn("Transactions"), "Transactions");
	}

	public void verifyTransactions() {
		new CommonFunctions().elementView(getMerchantActivityDrpDwn("Transactions"), "Transactions push button ");
	}

	public void clickPayoutHistory() {
		click(getMerchantActivityDrpDwn("Payout History"), "Payout History");
	}

	public void verifyPayoutHistory() {
		new CommonFunctions().elementView(getMerchantActivityDrpDwn("Payout History"), "Payout History push button ");
	}

	public void clickReserveHistory() {
		click(getMerchantActivityDrpDwn("Reserve History"), "Reserve History");
	}

	public void verifyReserveHistory() {
		new CommonFunctions().elementView(getMerchantActivityDrpDwn("Reserve History"), "Reserve History push button ");
	}

	public RegistrationSideBarMenuComponent registrationSideBarMenuComponent() {
		return new RegistrationSideBarMenuComponent();
	}

	public DashBoardPage dashBoardPage() {
		return new DashBoardPage();
	}

	public TransactionsPage transactionsPage() {
		return new TransactionsPage();
	}

	public PayOutHistoryPage payOutHistoryPage() {
		return new PayOutHistoryPage();
	}

	public ReserveHistoryPage reserveHistoryPage() {
		return new ReserveHistoryPage();
	}

	public TokenAccountPage tokenAccountPage() {
		return new TokenAccountPage();
	}

	public ExportfilesPage exportfilesPage() {
		return new ExportfilesPage();
	}

	public MerchantSettingsPage merchantSettingsPage() {
		return new MerchantSettingsPage();
	}

	public GetHelpPage getHelpPage() {
		return new GetHelpPage();
	}
}
