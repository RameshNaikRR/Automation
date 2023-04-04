package coyni.apibusiness.components;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.admin.pages.HomePage;
import coyni.admin.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class SuccessFailureComponent extends BrowserFunctions {

	private By lblBankAddedSuccesful = By.xpath("//h1[contains(text(),'Bank Account Added')]");
	private By lblRemovedSuccesful = By.xpath("//h1[text()='Payment Method Removed Successfully']");
	private By btnClose = By.xpath("//button[text()='Close']");
	private By editHeading = By.xpath("//h1[text()='Payment Method Edited Successfully']");
	private By lblSignetAddedSuccessful1 = By.xpath("//h1[text()='Cogent Account Added']");
	private By lblSignetAddedSuccessful2 = By.xpath("//h1[text()='Successfully']");
	private By lblSignetDeleted = By.xpath("//h1[text()='Payment Method Removed Successfully']");
	private By lblSignetDeleted1 = By.xpath("//h1[text()='Removed Successfully']");
	private By failedHeading = By.xpath("");
	private By btnDone = By.xpath("//button[text()='Done']");
	private By lblReferenceID = By.xpath("//span[text()='Reference ID']");
	private By referenceIdCopied = By.xpath("(//button[@class='copy-image icon-copy fontColor'])[2]");

	public void clickReferenceID() {
		click(referenceIdCopied, "Copied to ClipBoard");
	}

	public void verifyBankAddSuccesfulHeading() {
		new CommonFunctions().elementView(lblBankAddedSuccesful, "Bank Added Succesful");
	}

	public void verifyPaymnetRemovedSuccessfulHeading(String expRemovedHeading) {
		new CommonFunctions().verifyLabelText(lblRemovedSuccesful, " Remove sucessful", expRemovedHeading);
	}

	public void verifyPaymentEditSuccess(String expEditHeading) {
		new CommonFunctions().verifyLabelText(editHeading, "Payment Method Edited Successfully", expEditHeading);
	}

	public void verifySignetSucessfulHeading(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetAddedSuccessful1, "Signet Account Added Successfully",
				expSignetHeading);
	}

	public void verifySignetSucessfulHeading2(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetAddedSuccessful2, "Signet Account Added Successfully",
				expSignetHeading);
	}

	public void verifySignetDeleteHeading(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetDeleted, "Payment method removed Successfully",
				expSignetHeading);
	}

	public void verifySignetDeleteHeading2(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(lblSignetDeleted1, "Payment method removed Successfully",
				expSignetHeading);
	}

	public void verifyFailedHeadingView(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(failedHeading, "Failed", expSignetHeading);
	}

	public void verifyDone(String expSignetHeading) {
		new CommonFunctions().verifyLabelText(btnDone, "Done", expSignetHeading);
	}

	public void clickClose() {
		click(btnClose, "Close");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

	public void getLoginDetails() throws InterruptedException {
		String str = "123456";
		LoginPage loginPage = new LoginPage();
		loginPage.fillEmail("santoshp@ideyalabs.com");
		loginPage.fillPassword("Admin@123");
		loginPage.clickNext();

		loginPage.authyComponent().fillInput(str);

		Uninterruptibles.sleepUninterruptibly(300, TimeUnit.MILLISECONDS);
	}

	public void switchTab() throws InterruptedException {
		new CommonFunctions().switchtoUrl("https://admin-qa.coyni.com/");
	}

	public void fillSearch() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.sideBarComponent().clickTransactions();
		homePage.sideBarComponent().transactionPage().fillTransactionSearch();
	}

	public void verifyReferenceID() {
		String str = getText(lblReferenceID, "Reference ID");
		ExtentTestManager.setInfoMessageInReport(str);
		new CommonFunctions().elementView(lblReferenceID, "Reference ID");
	}

	public void openAdmin() {
		WebDriver driver = DriverFactory.getDriver();
		((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
		try {
			((JavascriptExecutor) driver).executeScript("window.open('https://admin-qa.coyni.com/login');");
			ExtentTestManager.setPassMessageInReport("Admin portal launched successfully");
		}

		catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(e + "launching Admin portal is failed");
		}
	}

	public void switchToAdminWindow() {
		String Window = DriverFactory.getDriver().getWindowHandle();
		Set<String> windowHandles = DriverFactory.getDriver().getWindowHandles();
		for (String string : windowHandles) {
			if (!string.equals(Window)) {
				DriverFactory.getDriver().switchTo().window(string);
				ExtentTestManager.setPassMessageInReport("Switched to New Window");
				break;
			}
		}
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}