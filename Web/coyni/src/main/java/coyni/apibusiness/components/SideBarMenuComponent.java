package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.apibusiness.pages.BankAccountPage;
import coyni.apibusiness.pages.BusinessSettingsPage;
import coyni.apibusiness.pages.ExportFilesPage;
import coyni.apibusiness.pages.GetHelpPage;
import coyni.apibusiness.pages.RegistrationBeneficialOwnersPage;
import coyni.apibusiness.pages.TokenWalletPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SideBarMenuComponent extends BrowserFunctions {

	private By getDashBoardItems(String eleName) {
		return By.xpath(String.format("//div[@class='DashboardMenu_menu__3PSTN']//span[text()='%s']", eleName));
	}

	// business setting
	private By lblBusinessSetting = By.xpath("//span[text()='Business Settings']");

	public void clickBusinessSettings() {
		click(lblBusinessSetting, "Business Settings");
		// click(getDashBoardItems("Business Settings"), "Business Settings");
	}

	private By BusinessApplicationArrow = By.xpath("//div[@class='items-center text-xs -ml-2 4xl:mr-2']");
	private By BusinessApplicationTracker = By.xpath("//div[@class='flex mt-3 h-2.5 justify-around']");
	private By btnContinueApplication = By.xpath("//button[contains(@class,'w-60')]");

	public void clickTokenwallet() {
		click(getDashBoardItems("Token Wallets"), "Token Wallet");
	}

	public void verifyTokenWalletView() {
		new CommonFunctions().elementView(getDashBoardItems("Token Wallets"), "Token Wallets");
	}

	public void verifyHandCursorAction() {
		new CommonFunctions().verifyCursorAction(getDashBoardItems("Token Wallets"), "Token Wallets");
	}

	public void verifyTokenWalletBackGroundColor(String backGround, String border) {
		new CommonFunctions().verifyMouseHoverAction(getDashBoardItems("Token Wallets"), "token Wallets", backGround,
				border);
	}

	public void clickEcosystemActivity() {
		click(getDashBoardItems("Ecosystem Activity"), "Ecosystem Activity");
	}

	public void clickExportFiles() {
		click(getDashBoardItems("Export Files"), "Export Files");
	}

	public void clickBusinessApplicationArrow() {
		click(BusinessApplicationArrow, "Business Application Arrow");
	}

	public void clickContinueApplication() {
		click(btnContinueApplication, "Continue Application");
	}

	public void clickGetHelp() {
		click(getDashBoardItems("Get Help"), "Get Help");
	}

	public RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage() {
		return new RegistrationBeneficialOwnersPage();
	}

	public BusinessSettingsSideBarMenuComponent businessSettingsSideBarMenuComponent() {
		return new BusinessSettingsSideBarMenuComponent();
	}

	public void verifyBusinessApplicationTrackerView() {
		new CommonFunctions().elementView(BusinessApplicationTracker, "Business Application Tracker");
	}

	public BankAccountPage bankAccountPage() {
		return new BankAccountPage();
	}

	public RegistrationSideBarMenuComponent registrationSideBarMenuComponent() {
		return new RegistrationSideBarMenuComponent();

	}

	public TransactionListComponent transactionListComponent() {
		return new TransactionListComponent();
	}

	public TokenWalletPage tokenWalletPage() {
		return new TokenWalletPage();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public ExportComponent exportComponent() {
		return new ExportComponent();
	}

	public TokenWalletActivityComponent tokenWalletActivityComponent() {
		return new TokenWalletActivityComponent();
	}

	public GetHelpPage getHelpPage() {
		return new GetHelpPage();
	}

	public EcoSystemActivityComponent ecoSystemActivityComponent() {
		return new EcoSystemActivityComponent();
	}

	public ExportFilesPage exportfilesPage() {
		return new ExportFilesPage();
	}

	public BusinessSettingsPage businessSettingsPage() {
		return new BusinessSettingsPage();
	}

}
