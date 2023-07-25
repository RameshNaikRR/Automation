package coyni.business.components;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class SideMenuBarComponent extends BrowserFunctions {

	private By userNameDrpDwn = By.xpath("//div[contains(@class,'DashboardMenu_username')]");
	private By btnContinueApplication = By.xpath("//button[contains(@class,'w-60')]");
	private By qrCode = By
			.xpath("(//button[@class='absolute bg-cwhite UserProfile_QR_main__7Go2P cursor-pointer false'])[1]");
	private By lblColor = By.xpath("//div[contains(@class,'justify-center rounded-l-full')]");
	private By lbllColor = By.xpath("//div[@data-tip='merchant-application']//button");
	private By paymentsDrpDown = By
			.xpath("//div[@class='icon-small-arrow text-xs mr-3 font-semibold text-cm3 arrowUp ']");
	private By ACH = By.xpath("//button[text()='ACH Payments']");
	private By wire = By.xpath("//button[text()='Wire Payments']");
	private By approvals = By.xpath("//button[text()='Approvals']");
	private By payees = By.xpath("//button[text()='Payees']");
//	private By btnMerchantActivityDropDown = By
//			.xpath("(//div[contains(@class,'icon-small-arrow text-xs mr-3 font-semibold text-cm3 arrowUp ')])[1]");

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

//	public void clickOnMerchantActivitydrpdwn() {
//		click(btnMerchantActivityDropDown, "Merchant drop down");
//	}

	public void clickContinueApplication() {
		click(btnContinueApplication, "Continue Application");
	}

	public void clickQRCode() {
		click(qrCode, "QR Code");
	}

	private By getMerchantActivityDrpDwn(String Activity) {
		return By.xpath(String.format("(//button[.='%s'])[1]", Activity));
	}

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public void handSymbolHighlightedPayments(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Payments"), "Payments");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", cssProp, expValue,
				expColor);
	}

	public void handSymbolHighlightedWallets(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Wallets"), "Wallets");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", cssProp, expValue,
				expColor);
	}

	public void handSymbolHighlightedExportFiles(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Export Files"), "Export Files");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", cssProp, expValue,
				expColor);
	}

	public void handSymbolHighlightedBusinessSettings(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Business Settings"), "Business Settings");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", cssProp, expValue,
				expColor);
	}

	public void handSymbolHighlightedGetHelp(String cssProp, String expValue, String expColor) {
		click(getDashBoardItems("Get Help"), "Get Help");
		new CommonFunctions().verifyChangedColor(getDashBoardItems("Type"), "SideBarItems", cssProp, expValue,
				expColor);
	}

	public void clickUserdrpdwn() {
		click(userNameDrpDwn, "User drop down");
	}

	public void verifyUserName() {
		new CommonFunctions().elementView(userNameDrpDwn, "User Name ");
	}

	public void verifyWallets() {
		new CommonFunctions().elementView(getDashBoardItems("Wallets"), "Wallets");
//		new CommonFunctions().verifyMouseHoverAction(getDashBoardItems("Wallets"), "Wallets", "", "");
	}

	public void paymentsDropDown() {
		click(paymentsDrpDown, "Drop Down");
	}

	public void clickWallets() {
		click(getDashBoardItems("Wallets"), "Wallets");
	}

	public void clickACH() {
		click(ACH, "ACH Payments");
	}

	public void verifyPayments() {
		new CommonFunctions().elementView(getDashBoardItems("Payments"), "Payments");
//		new CommonFunctions().verifyMouseHoverAction(getDashBoardItems("Payments"), "Payments", "", "");
	}

	public void clickWire() {
		click(wire, "Wire Payments");
	}

	public void approvals() {
		click(approvals, "Approvals");
	}

	public void payees() {
		click(payees, "Payees");
	}

	public void clickPayments() {
		click(getDashBoardItems("Payments"), "Payments");
	}

	public void verifyExports() {
		new CommonFunctions().elementView(getDashBoardItems("Exports"), "Exports");
//		new CommonFunctions().verifyMouseHoverAction(getDashBoardItems("Exports"), "Exports","","");
	}

	public void clickExports() {
		click(getDashBoardItems("Exports"), "Exports");
	}

	public void verifyBusinessSettings() {
		new CommonFunctions().elementView(getDashBoardItems("Business Settings"), "Business Settings");
//		new CommonFunctions().verifyMouseHoverAction(getDashBoardItems("Business Settings"), "Business Settings","","");
	}

	public void clickBusinessSettings() {
		click(getDashBoardItems("Business Settings"), "Business Settings");
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

}
