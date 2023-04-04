package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.admin.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class TransactionSuccessfulPopup extends BrowserFunctions {
	private By lblHeading = By.xpath("//div[.='Transaction Successful']");
	private By lblDescription = By.xpath("//h2[contains(@class,'TransferTokenModal_Pay')]");
	private By lblBorder = By.xpath("//hr[contains(@class,'border-1 border-cm2')]");
	private By btnDone = By.xpath("//button[.='Done']");
	private By copyreference = By.xpath("//span[contains(text(),'WTA')]//button");

	private By getAccountDetails(String Number) {
		return By.xpath(String.format("(//div[contains(@class,'flex items-center justify-between')])[%s]", Number));
	}

//	private By lblReferenceID = By.xpath("(//div[contains(@class,'flex items-center justify-between')])[1]");
//	private By lblFromBalanceName = By.xpath("(//div[contains(@class,'flex items-center justify-between')])[2]");
//	private By lblToBalanceName = By.xpath("(//div[contains(@class,'flex items-center justify-between')])[3]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescriptionView() {
		new CommonFunctions().elementView(lblDescription, "Description");
	}

	public void VerifyReferenceIdView() {
		String str = getText(getAccountDetails("1"), "ReferenceID");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(getAccountDetails("1"), "ReferenceID");
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

	public void verifyToBalanceNameView() {
		String str = getText(getAccountDetails("3"), "ToBalanceName");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(getAccountDetails("3"), "ToBalanceName");
	}

	public void verifyDescription(String Description) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description", Description);
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