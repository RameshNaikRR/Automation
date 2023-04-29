package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AddBankAccountPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[.='Add Bank Checking Account']");
	private By btnIamReady = By.xpath("//button[contains(text(),'Ready')]");
	private By lblDoNotNavigate = By.xpath("//h2[contains(.,'Do Not')]");
	private By lblDescription = By.xpath("//p[contains(.,'coyni uses')]");
	private By lblDescription1 = By.xpath("//p[contains(.,'Please complete')]");
	private By lnkLearnMore = By.xpath("//strong[.='Learn More']");
	private By heading = By.xpath("//h2[contains(text(),'Where to Find My Account Information?')]");
	private By txtnameOnBankAccount = By.name("fullName");
	private By btnFindAccountNumbers = By.xpath("//button[contains(text(),'Find Your Account Numbers')]");
	private By txtRoutingNumber = By.xpath("(//input[contains(@id,'Routing Number')])[1]");
	private By txtConfirmRoutingNumber = By.xpath("//input[contains(@name,'confirmRouting')]");
	private By txtCheckingAccountNumber = By.xpath("//input[contains(@name,'accountNumber')]");
	private By txtConfirmAccountNumber = By.xpath("//input[contains(@name,'confirmAccountNumber')]");
	private By txtBankName = By.xpath("//input[@id='mx-connect-search']");
	private By headingNewPage = By.xpath("//h1[contains(text(),'Add Accounts')]");
	private By lnkBankName = By.xpath("(//div[@class='autoResultBankName'])[1]");
	private By txtUserName = By.xpath("//input[@id='LOGIN']");
	private By txtPassword = By.xpath("//input[@id='PASSWORD']");
	private By btnContinue = By.xpath("//button[text()='Continue']");
	private By btnBack = By.xpath("//button[contains(text(),'Back')]");
	private By chckbox = By.xpath("//div[contains(@class,'custom-checkbox')]");
	private By btnAdd = By.xpath("//button[contains(text(),'Add')]");
	private By btnCheckBoxforMXBank = By.xpath("//input[@type='checkbox']");
	private By btnStart = By.xpath("//button[contains(text(),'Start')]");
	private By btnSearchInstitutions = By.xpath("//button[contains(text(),'Search more institutions')]");
	private By btnMXBank = By.xpath("//div[contains(@class,'kyper-utilityrow-base-left')]");
	private By btnChecking = By.xpath("(//label[contains(@class,'kyper-selectionbox')])[1]");
	private By btnSaving = By.xpath("(//label[contains(@class,'kyper-selectionbox')])[2]");
	private By btnClose = By.xpath("//button[@class='self-end']");
	private By iframe = By.cssSelector("#iframe");
	private By btnMxBankk = By.xpath("(//span[contains(text(),'MX Bank')])[1]");
	private By btnMXBankOATH = By.xpath("//span[contains(text(),'MX Bank (Oauth)')]");

	public void clickMXBank() {
		click(btnMXBank, "Mx Bank");
	}

	public void clickOnMxBankOATH() {
		switchToFrame(iframe, "iframe");
		click(btnMXBankOATH, "Mx Bank OATH");
		switchToParentFrame();
	}

	public void clickSearchInstitutions() {
		click(btnSearchInstitutions, "Search Institutions");
	}

	public void clickOnChecking() {
		click(btnChecking, "Checked");

	}

	public void clickOnMxBank() {
		switchToFrame(iframe, "iframe");
		click(btnMxBankk, "Mx Bank");
		switchToParentFrame();
	}

	public void clickOnBankAccountName(String AccountType) {
		switchToFrame(iframe, "frame");
		if (AccountType.equalsIgnoreCase("Checking")) {
			click(btnChecking, "Checking");
		}

		else if (AccountType.equalsIgnoreCase("Savings")) {
			click(btnSaving, "Savings");
		}
	}

	public void verifyHeading() {
		String text = getText(lblHeading, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickOnMXBankCheckBox() {
		click(btnCheckBoxforMXBank, "Clicked on Check Box");
	}

	public void clickStart() {
		click(btnStart, "start");
	}

	public void clickAdd() {
		click(btnAdd, "Add");
	}

	public void verifyFiservBankDescription() {
		String text = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickBack() {
		click(btnBack, " Back ");
	}

	public void getFindMyAccountInfo() {
		String text = getText(heading, "Heading");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyLnkLearnMore() {
		new CommonFunctions().elementView(lnkLearnMore, "Learn more link ");
	}

	public void clickFindYourAccountNumbers() {
		click(btnFindAccountNumbers, "Find Account Numbers");
	}

	public void fillNameOnBankAccount(String bankName) {
		enterText(txtnameOnBankAccount, bankName, "bankName");
	}

	public void fillRoutingNumber(String routingNumber) {
		enterText(txtRoutingNumber, routingNumber, "Routing Number");
	}

	public void fillConfirmRoutingNumber(String confirmRoutingNumber) {
		enterText(txtConfirmRoutingNumber, confirmRoutingNumber, "Confirm Routing Number");
	}

	public void fillAccountNumber(String accountNumber) {
		enterText(txtCheckingAccountNumber, accountNumber, "Account Number");
	}

	public void fillConfirmAccountNumber(String confirmAccountNumber) {
		enterText(txtConfirmAccountNumber, confirmAccountNumber, "Confirm Account Number");
	}

	public void clickLearnMore() {
		click(lnkLearnMore, "Learm More");
	}

	public void clickIamReady() {
		click(btnIamReady, "click IamReady");
	}

	public void verifyDoNotNavigateLbl() {
		String text = getText(lblDoNotNavigate, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void verifyDescription() {
		String text = getText(lblDescription1, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void switchToWindow() {
		new CommonFunctions().switchTodWindow();
	}

	public void verifyNewWindowHeading() {
		new CommonFunctions().elementView(headingNewPage, "Heading New Page");
	}

	public void enterBankName(String expBanName) {
		click(txtBankName, "");
		enterText(txtBankName, expBanName, "Bank Name");
	}

	public void clickOnBankName() {
		switchToFrame(iframe, "frame");
		click(lnkBankName, "Bank Name");
	}

	public void enterUserName(String expUserName) {
		enterText(txtUserName, expUserName, "User Name");
//		click(txtPassword, "Password");
	}

	public void enterPassword(String expPassword) {
		enterText(txtPassword, expPassword, " Password");
	}

	public void clickNext() {
		click(btnContinue, "Click On Continue");
	}

//	public void unSelectBank() {
//		WebDriver driver = DriverFactory.getDriver();
//		WebDriverWait wait = new WebDriverWait(driver, 120);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.loader")));
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loader")));
//		List<WebElement> List = getElementsList(chckbox, "");
//		int size = List.size();
//		if (size == 1) {
//			ExtentTestManager.setInfoMessageInReport("We have only one bank");
//			Object[] windowHandles = driver.getWindowHandles().toArray();
//			driver.close();
//			driver.switchTo().window(windowHandles[0].toString());
//		} else {
//			List.get(0).click();
//			ExtentTestManager.setInfoMessageInReport("Unselected the extra bank");
//			click(btnNext, "Click Next");
//			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
//			Object[] windowHandles = driver.getWindowHandles().toArray();
//			driver.switchTo().window(windowHandles[0].toString());
//		}
//	}
//
//	public void clickUncheckBank() {
//		click(btnNext, "Click Next");
//	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public BankAccountAddedPopup bankAccountAddedPopup() {
		return new BankAccountAddedPopup();
	}

	public SessionCancelledPopup sessionCancelledPopup() {
		return new SessionCancelledPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
