package coyni.merchant.components;

import org.openqa.selenium.By;

import coyni.admin.pages.HomePage;
import coyni.admin.pages.LoginPage;
import coyni.admin.pages.TokenAccountPage;
import coyni.admin.pages.TransactionPage;
import coyni.checkout.CheckOutPage;
import coyni.merchant.pages.DashBoardPage;
import coyni.merchant.pages.ExportfilesPage;
import coyni.merchant.pages.MerchantTransactionsPage;
import coyni.merchant.pages.PayOutHistoryPage;
import coyni.merchant.pages.ReserveHistoryPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class MerchantActivityComponent extends BrowserFunctions {

	private By lblMerchantApproved = By.xpath("//h1[contains(text(),'Officially Approved!')]");
	private By btnMerchantDashboard = By.xpath("//button[contains(text(),'Merchant Dashboard')]");
	private By lblAprrovedReserveHeading = By.xpath("//h1[contains(text(),'Conditional Reserve Rule')]"); 
	private By lblMonthlyProcessingVolume = By.xpath("//p[text()='Monthly Volume:']/following-sibling::p");
	private By lblHighTicket = By.xpath("//p[text()='High Ticket:']/following-sibling::p");
	private By lblReserveAmount = By.xpath("(//p[text()='Reserve Rule:']/following-sibling::div//p)[1]");
	private By lblReservePeriod = By.xpath("(//p[text()='Reserve Rule:']/following-sibling::div//p)[2]");
	private By btnAcceptReserve = By.xpath("//button[text()='Accept Reserve']");
	private By btnUserName = By.xpath("//img[contains(@class,'down-arrow')]/..");
	private By lblUserDetails = By.xpath("//span[text()='User Details']");
	private By txtMerchantAccountID = By.xpath("//div[contains(text(),'Account ID: ')]");
	private By lblStatus = By.xpath("//div[contains(text(),'Account Status:')]//div");
	private By btnFilter = By.xpath("//button[text()='Filter']");
	private By chckBoxeCommerece = By.xpath("//span[text()='Sale Order: eCommerce']/preceding-sibling::input");
	private By btnApplyFilters = By.xpath("//button[text()='Apply Filters']");
			
	
	public void verifyMouseHoverChangedColor(String expCssProp, String expValue, String expColor) {
		new CommonFunctions().verifyChangedColor(getSideBarItems("Type"), "SideBarItems", expCssProp, expValue,
				expColor);
	}
	
	public void clickAcceptReserve() {
		click(btnAcceptReserve, "Accept Reserve");
	}
	
	public void clickFilter() {
		click(btnFilter, "Filter");
	}
	
	public void clickApplyFliters() {
		click(btnApplyFilters, "Apply Filters");
	}
	
	public void clickeCommerceChcekBox() {
		click(chckBoxeCommerece, "Check Box Sale Order: eCommerce");
	}
	
	public void verifyStatus() {
		String str = getText(lblStatus, "Status");
	ExtentTestManager.setInfoMessageInReport("The status is " + str);;
	}
	
	public void verifyApprovedHeading() {
		String str = getText(lblMerchantApproved, "The Heading");
		ExtentTestManager.setInfoMessageInReport("The heading is " + str);
	}

	public void verifyApprovedReserveHeading() {
		String str = getText(lblAprrovedReserveHeading, "Approve Reserve");
		ExtentTestManager.setInfoMessageInReport("The Approved Resrve Heading is " + str);
	}
	
	public void verifyMonthlyProcessingVolume(String monthlyProcessingVolume) {
		String str = getText(lblMonthlyProcessingVolume, "Monthly Processing Volume");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		if(str1.equals(monthlyProcessingVolume)) {
			ExtentTestManager.setInfoMessageInReport(str1 + "is matched with " + monthlyProcessingVolume);
		}
		else {
			ExtentTestManager.setInfoMessageInReport(str1 + "is not matched with " + monthlyProcessingVolume);
		}
	}
	
	public void verifyHighTicket(String highTicket) {
		String str = getText(lblHighTicket, "High Ticket");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		if(str1.contains(highTicket)) {
			ExtentTestManager.setInfoMessageInReport(str1 + "is matched with " + highTicket);
		}
		
		else {
			ExtentTestManager.setInfoMessageInReport(str1 + "is not matched with " + highTicket);
		}
	}

	public void verifyResrverAmount(String reserveAmount) {
		String str = getText(lblReserveAmount, "Reserve Amount");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		String str2 = str1.replaceAll("%", "");
		if(str2.contains(reserveAmount)) {
			ExtentTestManager.setInfoMessageInReport(str2 + "is matched with " + reserveAmount);
		}
		
		else {
			ExtentTestManager.setInfoMessageInReport(str2 + "is not matched with " + reserveAmount);
		}
		
	}
	
	public void verifyResrverPeriod(String reservePeriod) {
		String str = getText(lblReservePeriod, "Reserve Period");
		String str1 = str.replaceAll("[a-zA-Z]", "");
		if(str1.contains(reservePeriod)) {
			ExtentTestManager.setInfoMessageInReport(str1 + "is matched with" + reservePeriod);
		}
		
		else {
			ExtentTestManager.setInfoMessageInReport(str1 + "is not matched with" + reservePeriod);
		}
	}
	
	public void clickUserName() {
		click(btnUserName, "User Name");
	}
	
	public void clickUserDetails() {
		click(lblUserDetails, "User Details");
	}
	

	public String verifyMerchantID() {
		String str = getText(txtMerchantAccountID, "CaseIDNumber");
		String str1 = str.replaceAll("[a-zA-Z]", "");
        String str2 = str1.replaceAll(":", "");
        String str3 = str2.replaceAll(" ", "");
        String str4 = "M"+str3;
		ExtentTestManager.setInfoMessageInReport("Case ID Number is "+ str4);
        return str4;  	
	}
	
	public String verifyMerchantIDForReserver() {
		String str = getText(txtMerchantAccountID, "CaseIDNumber");
		String str1 = str.replaceAll("[a-zA-Z]", "");
        String str2 = str1.replaceAll(":", "");
        String str3 = str2.replaceAll(" ", "");
        String str4 =str3.replaceAll("-", "");
		ExtentTestManager.setInfoMessageInReport("Case ID Number is "+ str4);
        return str4;  	
	}
	
	
	public By getSideBarItems(String elementName) {
		return By.xpath(String.format("//span[(contains(@class,'menu' ) or contains(@class,'label'))and text()='%s']",
				elementName));
	}

	public By getSubMenuItems(String num) {
		return By.xpath(String.format("(//div[@class='subitems-container'])[1]/a[%s]", num));

	}
	
	public void clickMerchantDashBoad() {
		click(btnMerchantDashboard, "Merchant Dashboard");
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
	
	public HomePage homePage() {
		return new HomePage();
	}
	
	public CheckOutPage checkOutPage() {
		return new CheckOutPage();
	}
}
