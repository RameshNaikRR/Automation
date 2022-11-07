package coyni.merchant.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
import coyni.merchant.popups.AddDBABusinessPopup;
import coyni.merchant.popups.CompleteVerificationPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class SideMenuBarComponent extends BrowserFunctions {

	private By userNameDrpDwn = By.xpath("//div[contains(@class,'DashboardMenu_username')]");
	private By btnAddDBA = By.xpath("//button[text()='Add New DBA']");
	private By btnDBA = By.xpath("//p[contains(text(),'New Merchant / DBA')]");
	private By personalAccount = By.xpath("//div[@class='UserNameDropDown_userName__oCwHu']");
	private By btnPersonalAccount = By.xpath("//p[text()='Add Personal Account']");
	private By btnMerchantAccount = By.xpath("(//div[@class='UserNameDropDown_image__jUgDC bg-cm3'])[2]");
	private By btnPersonalDropDown = By.xpath("//div[contains(@class,'DashboardMenu_downArrow__YA3Vr')]");
	private By sharedDropDown = By.xpath("//div[contains(@class,'UserNameDropDown_userName__oCwHu')]");
	private By sharedDropsDown = By.xpath("(//button[@class='UserNameDropDown_header__y-U81'])[6]");
	private By merchantDropDown = By.xpath("//span[@class='UserNameDropDown_title__RKKVD']");
	private By btnsharedAccount = By.xpath("//div[contains(@class,'UserNameDropDown_arrowDown__1VWOu')]");
	private By btnMerchnatApplicationTracker = By
			.xpath("(//span[contains(.,'Merchant')][contains(., 'Application')])[1]");
	private By merchnatApplicationTracker = By.xpath("(//div[@class='flex mt-3 h-2.5 justify-around'])[1]");
	private By merchnatApplicationTrackerToolTip = By.xpath("(//div[text()='Merchant Application step 4 of 6'])[2]");
	private By btnContinueApplication = By.xpath("//button[contains(@class,'w-60')]");
	private By qrCode = By
			.xpath("(//button[@class='absolute bg-cwhite UserProfile_QR_main__7Go2P cursor-pointer false'])[1]");
	private By lblColor = By.xpath("//div[contains(@class,'justify-center rounded-l-full')]");
	private By lbllColor = By.xpath("//div[@data-tip='merchant-application']//button");

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("(//span[.='%s'])[1]", eleName));
	}

	public void verifyColor() {
		String str = getElement(lblColor, "Color").getCssValue("background-color");
		ExtentTestManager.setInfoMessageInReport("the Color is " + str);
	}

	public ArrayList<String> verifyColorOfSideMenuBar() {
		List<WebElement> eles = getElementsList(lbllColor, " ");
		ArrayList<String> st = new ArrayList<>();
		for (WebElement ele : eles) {
			String str = ele.getCssValue("background-color");

			ExtentTestManager.setInfoMessageInReport("the Color of rgba value is " + str);
			st.add(str);

		}
		return st;

	}

	public void clickContinueApplication() {
		click(btnContinueApplication, "Continue Application");
	}

	public void clickQRCode() {
		click(qrCode, "QR Code");
	}

	public void clickAddDBA() {
		click(btnAddDBA, "Add DBA");
	}

	public void clickDBAOrMerchant() {
		click(btnAddDBA, "Add DBA");
	}

	public void clickOnPersonalAccount() {
		click(personalAccount, "Personal Account");
	}

	public void clickOnPersonalAccountDropDown() {
		click(btnPersonalDropDown, "Personal Account Drop Down");
	}

	public void clickPersonalAccount() {
		click(btnPersonalAccount, "Personal Account");
	}

	public void clickMerchantAccount() {
		click(btnMerchantAccount, "Merchant Account");
	}

	public void clickSharedAccount() {
		click(btnsharedAccount, "Shared Account");
	}

	private By getMerchantActivityDrpDwn(String Activity) {
		return By.xpath(String.format("(//button[.='%s'])[1]", Activity));
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public void clickUserdrpdwn() {
		click(userNameDrpDwn, "User drop down");
	}

	public void clickMerchantdrpdwn() {
		click(merchantDropDown, "Merchant drop down");
	}
	
	public void clickOnSharedDropDown() {
		click(sharedDropsDown, "Shared Drop Down");
		
	}

	public void clickSharedDropDown() {
		click(sharedDropDown, "Shared Drop Down");
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

	}

	public void verifyMerchnatTracker() {
		new CommonFunctions().elementView(merchnatApplicationTracker, "Merchant Application tracker");
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

	public MyQRCodeComponent myQRCodeComponent() {
		return new MyQRCodeComponent();
	}

	public CompleteVerificationPopup completeVerificationPopup() {
		return new CompleteVerificationPopup();
	}

	public AddDBABusinessPopup addDBABusinessPopup() {
		return new AddDBABusinessPopup();
	}
}
