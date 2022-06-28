package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.admin.pages.BalanceReportsPage;
import coyni.admin.pages.CommissionAccountPage;
import coyni.admin.pages.FeatureControlPage;
import coyni.admin.pages.FeeStructurePage;
import coyni.admin.pages.TokenAccountPage;
import coyni.admin.pages.TransactionPage;
import coyni.admin.pages.ViewMerchantfeeStructurePage;
import coyni.admin.pages.ViewPersonalFeeStructurePage;
import coyni.admin.popups.ExportSelectedTransactions;
import coyni.merchant.pages.ExportfilesPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SideBarComponent extends BrowserFunctions {

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getSideBarItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public By getSideBarItems(String elementName) {
		return By.xpath(String.format("//span[(contains(@class,'menu' ) or contains(@class,'label'))and text()='%s']",
				elementName));
	}

	public By getSubMenuItems(String num) {
		return By.xpath(String.format("(//div[@class='subitems-container'])[2]/a[%s]", num));

	}

	public void clickDashBoard() {
		click(getSubMenuItems("1"), "DashBoard");
	}

	public void clickTransactions() {
		click(getSubMenuItems("2"), "Transactions");
	}

	public void clickPayOutHistory() {
		click(getSubMenuItems("3"), "PayOut History");
	}

	public void clickReserveHistory() {
		click(getSubMenuItems("4"), "Reserve History");
	}

	public TokenAccountPage tokenAccountPage() {
		return new TokenAccountPage();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public TransactionPage transactionPage() {
		return new TransactionPage();
	}

	public ExportfilesPage exportfilesPage() {
		return new ExportfilesPage();
	}

}
