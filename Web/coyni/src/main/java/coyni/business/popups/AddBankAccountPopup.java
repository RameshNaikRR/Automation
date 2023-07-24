package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.business.components.NavigationComponent;
import coyni.business.components.SuccessFailureComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class AddBankAccountPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Add Bank Checking Account']");
	private By btnIamReady = By.cssSelector(".w-60");
	private By headingNewWindow = By.xpath("//h1[text()='Add Accounts']");
	private By txtBankName = By.xpath("//input[@id='searchbar']");
	private By lnkBankName = By.xpath("//span[text()='https://www.mx.com']");
	private By txtUserName = By.xpath("//input[@id='acctForm:j_idt145:0:login_']");
	private By txtPassword = By.xpath("//input[@id='acctForm:j_idt149:0:password_']");
	private By btnBankNext = By.xpath("(//span[text()='Next'])[1]");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By chckBoxBank1 = By.xpath("(//div[@class='custom-control custom-checkbox'])[1]");
	private By chckBoxBank2 = By.xpath("(//div[@class='custom-control custom-checkbox'])[2]");
	private By heading = By.xpath("//h2[contains(text(),'Where to Find My Account Information?')]");
	private By txtnameOnBankAccount = By.name("fullName");
	private By btnFindAccountNumbers = By.xpath("//button[contains(text(),'Find Your Account Numbers')]");
	private By txtRoutingNumber = By.xpath("(//input[contains(@id,'Routing Number')])[1]");
	private By txtConfirmRoutingNumber = By.xpath("//input[contains(@name,'confirmRouting')]");
	private By txtCheckingAccountNumber = By.xpath("//input[contains(@name,'accountNumber')]");
	private By txtConfirmAccountNumber = By.xpath("//input[contains(@name,'confirmAccountNumber')]");
	private By btnMXBank = By.xpath("//span[@class='f1ot2xyt Body bold primary  kyper-text ']");
	private By clickContinue = By.xpath("//button[text()='Continue']");

	private By status = By.xpath("//span[contains(text(),'Status')]/following-sibling::*");

	private By nameOnAccount = By.xpath("//span[contains(text(),'Name on Account')]/following-sibling::*");

	private By institution = By.xpath("//span[contains(text(),'Institution')]/following-sibling::*");

	private By routingNumber = By.xpath("//span[contains(text(),'Routing Number')]/following-sibling::*");

	private By accountNumber = By.xpath("//span[contains(text(),'Account Number')]/following-sibling::*");

	private By btnDone = By.xpath("//span[contains(text(),'Done')]");

	private By btnBuyCoyni = By.xpath("//button[contains(text(),'Buy coyni')]");

	private By btnWithdraw = By.xpath("//button[contains(text(),'Withdraw')]");
	private By clickAdd = By.xpath("//button[text()='Add']");
	private By btnCheckBoxforMXBank = By.xpath("//input[@type='checkbox']");
	private By btnChecking = By.xpath("//span[contains(text(),'Checking')]");
	private By btnStart = By.xpath("//button[contains(text(),'Start')]");
	private By btnSearchInstitutions = By.xpath("//button[contains(text(),'Search more institutions')]");
	private By iframe = By.cssSelector("#iframe");
	private By btnMxBankk = By.xpath("//span[@class='f1ot2xyt Body bold primary  kyper-text ']");
	private By btnBack = By.xpath("//button[contains(text(),'Back')]");

	public void verifyHeading() {
		String text = getText(lblHeading, "Heading");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickSearchInstitutions() {
		click(btnSearchInstitutions, "Search Institutions");
	}

	public void clickOnMxBank() {
		switchToFrame(iframe, "iframe");
		click(btnMxBankk, "Mx Bank");
		switchToParentFrame();
	}

	public void clickMXBank() {
		click(btnMXBank, "Mx Bank");
	}

	public void clickBack() {
		click(btnBack, " Back ");
	}

	public void clickStart() {
		click(btnStart, "start");
	}

	public void clickOnMXBankCheckBox() {
		click(btnCheckBoxforMXBank, "Clicked on Check Box");
	}

	public void clickOnChecking() {
		switchToFrame(iframe, "iframe");
		click(btnChecking, "Checked");
		switchToParentFrame();
	}

	public void verifyStatus() {
		String lstatus = getText(status, "Status");
		ExtentTestManager.setInfoMessageInReport(lstatus + " is displayed");
	}

	public void verifyNameOnAccount() {
		String name = getText(nameOnAccount, "Name");
		ExtentTestManager.setInfoMessageInReport(name + " is displayed");
	}

	public void verifyRoutingNumber() {
		String routingNumberl = getText(routingNumber, "Routing Number");
		ExtentTestManager.setInfoMessageInReport(routingNumberl + " is displayed");
	}

	public void verifyAccount() {
		String account = getText(accountNumber, "Institution");
		ExtentTestManager.setInfoMessageInReport(account + " is displayed");
	}

	public void verifyInstitution() {
		String inst = getText(institution, "Institution");
		ExtentTestManager.setInfoMessageInReport(inst + " is displayed");
	}

	public void clickDone() {
		if (DriverFactory.getDriver().findElements(btnDone).size() > 0) {
			click(btnDone, "Click Done");
		} else if (DriverFactory.getDriver().findElements(btnBuyCoyni).size() > 0) {
			click(btnBuyCoyni, "Buy Coyni");
		} else {
			click(btnWithdraw, "Withdraw");

		}

	}

	public void clickContinue() {
		switchToFrame(iframe, "iframe");
		click(clickContinue, "Continue");
		switchToParentFrame();
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

	public void clickFindYourAccountNumbers() {
		click(btnFindAccountNumbers, "Find Account Numbers");
	}

	public void getFindMyAccountInfo() {
		String text = getText(heading, "Heading");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickIamReady() {
		click(btnIamReady, "I am Ready");
	}

	public void clickAdd() {
		click(clickAdd, "Add");
	}

	public void verifyNewHeading(String expNewWindowHeading) {
		new CommonFunctions().verifyLabelText(headingNewWindow, "New Window Heading", expNewWindowHeading);
	}

	public void enterBankName(String expBankName) {
		enterText(txtBankName, expBankName, "Bank Name");
	}

	public void enterUserName(String expUserName) {
		enterText(txtUserName, expUserName, "User Name");
	}

	public void enterPassword(String expPassword) {
		enterText(txtPassword, expPassword, "password");
	}

	public void clickNext() {
		click(btnNext, "Click Next");
	}

	public void clickBankNext() {
		click(btnBankNext, "Click Next");
	}

	public void unSelectBank() {
		click(chckBoxBank1, "UnSelect Bank");
		click(chckBoxBank2, "UnSelect Bank");

	}

	public void clickOnBankName() {
		moveToElement(btnMxBankk, " Bank Name");
		click(btnMxBankk, " Bank Name");
	}

	public void clickUncheckBank() {
		click(btnBankNext, "Click Next");
	}

	public SuccessFailureComponent successFailureComponent() {
		return new SuccessFailureComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

//	public SessionCancelledPopup sessionCancelledPopup() {
//		return new SessionCancelledPopup();
//	}
}
