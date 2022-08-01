package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.admin.pages.TokenAccountPage;
import coyni.admin.pages.TransactionPage;
import coyni.merchant.pages.DashBoardPage;
import coyni.merchant.pages.ExportfilesPage;
import coyni.merchant.pages.MerchantTransactionsPage;
import coyni.merchant.pages.PayOutHistoryPage;
import coyni.merchant.pages.ReserveHistoryPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantActivityComponent extends BrowserFunctions {

	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getSideBarItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}

	public By getSideBarItems(String elementName) {
		return By.xpath(String.format("//span[(contains(@class,'menu' ) or contains(@class,'label'))and text()='%s']",
				elementName));
	}

	public By getSubMenuItems(String num) {
		return By.xpath(String.format("(//div[@class='subitems-container'])[1]/a[%s]", num));

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

	public DashBoardPage dashBoardPage() {
		return new DashBoardPage();
	}

	public ReserveHistoryPage reserveHistoryPage() {
		return new ReserveHistoryPage();
	}

	public PayOutHistoryPage payOutHistoryPage() {
		return new PayOutHistoryPage();
	}

	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public TransactionPage transactionPage() {
		return new TransactionPage();
	}

	public TransactionDetailsComponent transactionDetailsComponent() {
		return new TransactionDetailsComponent();
	}

	public MerchantTransactionsPage merchantTransactionsPage() {
		return new MerchantTransactionsPage();
	}

	public ExportfilesPage exportfilesPage() {
		return new ExportfilesPage();
	}

}
