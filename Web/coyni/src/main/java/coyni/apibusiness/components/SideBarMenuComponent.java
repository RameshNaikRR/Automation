package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.api.business.popups.AddNewPaymentMethodPopup;
import coyni.apibusiness.pages.BankAccountPage;
import coyni.apibusiness.pages.BusinessSettingsPage;
import coyni.apibusiness.pages.ExportFilesPage;
import coyni.apibusiness.pages.GetHelpPage;
import coyni.apibusiness.pages.RegistrationBeneficialOwnersPage;
import coyni.apibusiness.pages.TokenWalletPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class SideBarMenuComponent extends BrowserFunctions {

	private By getDashBoardItems(String eleName) {
		return By.xpath(
				String.format("(//div[@class='DashboardMenu_menu_items__WTmN5']//span[text()='%s'])[1]", eleName));
	}

	// business setting
	private By lblBusinessSetting = By.xpath("//span[text()='Business Settings']");

	public void clickBusinessSettings() throws InterruptedException {
		new CommonFunctions().verifyCursorAction(getDashBoardItems("Business Settings"), "Business Settings");
		String str = getElement(getDashBoardItems("Business Settings"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(lblBusinessSetting, "Business Settings");
		Thread.sleep(3000);
		// click(getDashBoardItems("Business Settings"), "Business Settings");
	}

	private By BusinessApplicationArrow = By.xpath("//div[@class='items-center text-xs -ml-2 4xl:mr-2']");
	private By BusinessApplicationTracker = By.xpath("//div[@class='flex mt-3 h-2.5 justify-around']");
	private By btnContinueApplication = By.xpath("//button[contains(@class,'w-60')]");
	private By dbaName = By.xpath("");

	public void clickTokenwallet() {
		new CommonFunctions().verifyCursorAction(getDashBoardItems("Token Wallets"), "Token Wallet");
		String str = getElement(getDashBoardItems("Token Wallets"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
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

	public void clickEcosystemActivity() throws InterruptedException {
		new CommonFunctions().verifyCursorAction(getDashBoardItems("Ecosystem Activity"), "Ecosystem Activity");
		String str = getElement(getDashBoardItems("Ecosystem Activity"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(getDashBoardItems("Ecosystem Activity"), "Ecosystem Activity");
		Thread.sleep(3000);
	}

	public void clickExportFiles() throws InterruptedException {
		new CommonFunctions().verifyCursorAction(getDashBoardItems("Export Files"), "Export Files");
		String str = getElement(getDashBoardItems("Export Files"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(getDashBoardItems("Export Files"), "Export Files");
		Thread.sleep(3000);
	}

	public void clickBusinessApplicationArrow() {
		click(BusinessApplicationArrow, "Business Application Arrow");
	}

	public void clickContinueApplication() {
		click(btnContinueApplication, "Continue Application");
	}

	public void clickGetHelp() throws InterruptedException {
		new CommonFunctions().verifyCursorAction(getDashBoardItems("Get Help"), "Get Help");
		String str = getElement(getDashBoardItems("Get Help"), "").getCssValue("color");
		ExtentTestManager.setInfoMessageInReport(str);
		click(getDashBoardItems("Get Help"), "Get Help");
		Thread.sleep(3000);
	}

	public RegistrationBeneficialOwnersPage registrationBeneficialOwnersPage() {
		return new RegistrationBeneficialOwnersPage();
	}

	public BusinessSettingsSideBarMenuComponent businessSettingsSideBarMenuComponent() {
		return new BusinessSettingsSideBarMenuComponent();
	}

	public void verifyBusinessApplicationTrackerView() {
		new CommonFunctions().verifyCursorAction(BusinessApplicationTracker, "Business Application Tracker");
		String str = getElement(BusinessApplicationTracker, "").getCssValue("color");
		ExtentTestManager.setPassMessageInReport(str);
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

	public AddNewPaymentMethodPopup addNewPaymentMethodPopup() {
		return new AddNewPaymentMethodPopup();
	}

	public ExportFilesPage exportFilesPage() {
		return new ExportFilesPage();
	}

	public PaymentMethodComponent paymentMethodComponent() {
		return new PaymentMethodComponent();
	}

	public TransactionDetailsComponent transactionDetailsComponent() {
		return new TransactionDetailsComponent();
	}
}
