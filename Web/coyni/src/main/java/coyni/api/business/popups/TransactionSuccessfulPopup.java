package coyni.api.business.popups;

import java.sql.SQLException;

import org.openqa.selenium.By;

import coyni.admin.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.DBConnection;

public class TransactionSuccessfulPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[.='Transaction Successful']");
	private By lblBorder = By.xpath("//hr[contains(@class,'border-1 border-cm2')]");
	private By btnDone = By.xpath("//button[.='Done']");
	private By copyreference = By.xpath("//span[contains(text(),'WTA')]//button");
	private By transactionMsg = By.xpath("//h2[@class='TransferTokenModal_Pay_text__+IoGJ']");

	private By getAccountDetails(String Number) {
		return By.xpath(String.format("(//div[contains(@class,'flex items-center justify-between')])[%s]", Number));
	}

//	private By lblReferenceID = By.xpath("(//div[contains(@class,'flex items-center justify-between')])[1]");
//	private By lblFromBalanceName = By.xpath("(//div[contains(@class,'flex items-center justify-between')])[2]");
//	private By lblToBalanceName = By.xpath("(//div[contains(@class,'flex items-center justify-between')])[3]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyTransactionMessage() {
		String str = getText(transactionMsg, "Transaction Successful Message");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void VerifyReferenceIdView() {
		String str = getText(getAccountDetails("1"), "ReferenceID");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(getAccountDetails("1"), "ReferenceID");
	}

	public String VerifyTransferReferenceId() {
		String str = getText(getAccountDetails("1"), "ReferenceID");
		return str;
	}

	public void getTransferReferenceId(String query) throws SQLException {

		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(VerifyTransferReferenceId());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("Total Balance is matched ");
		} else {
			ExtentTestManager.setFailMessageInReport("Total Balance is not matched");
		}
	}

	public void getLoginDetails() {
		LoginPage loginPage = new LoginPage();
		loginPage.fillEmail("santoshp@ideyalabs.com");
		loginPage.fillPassword("Admin@123");
		loginPage.clickNext();
		loginPage.authyComponent().fillAuthyInput("123456");
	}

	public void switchTab() {
		new CommonFunctions().switchTodWindow();
	}

	public void openAdminPortal() {
		try {
			new CommonFunctions().switchtoUrl("https://admin-qa.coyni.com/login");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void copyreferenceID() {
		click(copyreference, "Reference ID");
	}

	public void verifyFromBalanceNameView() {
		String str = getText(getAccountDetails("2"), "FromBalanceName");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(getAccountDetails("2"), "FromBalanceName");
	}

	public String verifyTransferFromBalanceName() {
		String str = getText(getAccountDetails("2"), "FromBalanceName");
		return str;
	}

	public void getTransferFromBalanceName(String query) throws SQLException {

		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(verifyTransferFromBalanceName());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("FromBalance is matched ");
		} else {
			ExtentTestManager.setFailMessageInReport("FromBalance is not matched");
		}
	}

	public void verifyToBalanceNameView() {
		String str = getText(getAccountDetails("3"), "ToBalanceName");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(getAccountDetails("3"), "ToBalanceName");
	}

	public String verifyTransferToBalanceName() {
		String str = getText(getAccountDetails("3"), "ToBalance");
		return str;
	}

	public void getTransferToBalanceName(String query) throws SQLException {

		int count = DBConnection.getDbCon().getCount(query);
		int expCount = Integer.parseInt(verifyTransferToBalanceName());
		if (count == expCount) {
			ExtentTestManager.setPassMessageInReport("ToBalance is matched ");
		} else {
			ExtentTestManager.setFailMessageInReport("ToBalance is not matched");
		}
	}

	public void verifyBorder() {
		new CommonFunctions().elementView(lblBorder, "Border");
	}

	public void VerifyReferenceId() {
		new CommonFunctions().elementView(getAccountDetails("1"), "ReferenceID");
	}

	public void verifyFromBalanceName() {
		new CommonFunctions().elementView(getAccountDetails("2"), "FromBalanceName");
	}

	public void verifyToBalanceName() {
		new CommonFunctions().elementView(getAccountDetails("3"), "ToBalanceName");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

}