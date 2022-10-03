package coyni.apibusiness.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.api.business.popups.AddBankAccountPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BankAccountPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//div[text()='Add Bank Account']");
	private By lnkLearnMore = By.xpath("//strong[text()='Learn More']");
	private By lblAddBankAccountDesc = By.xpath("//span[contains(text(),'Please add your')]");
	private By lblFindAccount = By.xpath("//h2[contains(text(),'Where to Find')]");
	private By findAccDesc = By.xpath("//p[contains(text(),'You can find your')]");
	private By btnAccountBack = By.xpath("(//button[text()='Back'])[1]");
	private By selfEnd = By.cssSelector(".self-end");
	private By lblAccountName = By.xpath("//input[@id='accountName']");
	private By routingNum = By.xpath("//input[@id='routingNumber']");
	private By confirmRoutNum = By.xpath("//input[@id='confirmRoutingNumber']");
	private By AccountNumber = By.xpath("//input[@id='accountNumber']");
	private By cnfrmAccNum = By.xpath("//input[@id='confirmAccountNumber']");
	private By btnImReady = By.xpath("//button[text()='I’m Ready']");
	private By btnNext = By.xpath("//a[@id='acctForm:addFiNext']");
	private By lnkExit = By.xpath("//Strong[text()='Exit']");
	private By btnBack = By.xpath("//button[text()='Back']");
	private By lblFiserv = By.xpath(" ");
	private By txtBankName = By.xpath("//input[@id='searchbar']");
	private By txtUserName = By.xpath("//input[@name='acctForm:j_idt143:0:login_']");
	private By txtPassword = By.xpath("//input[@name='acctForm:j_idt147:0:password_']");
	private By btnSelectAnotherInst = By.xpath("//a[@id='acctForm:selectFI']");
	private By btnBankNext = By.xpath("//a[@id='acctForm:addFiNext']");
	private By chkbxBank = By.xpath("(//div[@class='custom-control custom-checkbox'])[1]");
	private By NextButton = By.xpath("//button[text()='Next']");
	private By informationAboutFiesrvHdg = By.xpath("//h1[text()='Information About Fiserv']");
	private By lblAddBankAccount = By.xpath("//h1[text()='Add Bank Account']");
	private By lblDoNotNavigate = By.xpath("//h2[text()='Do Not Navigate Away From This Page']");
	private By lnkBank = By.cssSelector("#filist>li:nth-of-type(1)");

	public void verifyDoNotNavigateView() {
		new CommonFunctions().elementView(lblDoNotNavigate, "Do Not Navigate AwayFrom This Page");
	}

	public void clickEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getAccountName() {
		String accName = getText(lblAccountName, "");
		ExtentTestManager.setInfoMessageInReport(accName + "is displayed");
	}

	public void enterAccName(String accName) {
		enterText(lblAccountName, accName,"Account Name");
	}

	public void enterRoutingNum(String routingNumber) {
		enterText(routingNum,routingNumber, "Routing Number");
	}

	public void enterConfrmRouteNum(String cnfrmRoutingNum) {
		enterText(confirmRoutNum,cnfrmRoutingNum, "Confirm Routing Number");
	}

	public void enterAccountNum(String AccNum) {
		enterText(AccountNumber,AccNum, "Account Number");
	}

	public void enterConfrmAccNum(String cnfrmAccNumber) {
		enterText(cnfrmAccNum, cnfrmAccNumber,"Confirm Account Number");
	}

	public void clickNext() {
		click(NextButton, "Next");
	}

	public void selfEnd() {
		click(selfEnd, "Self-End");
	}

	public void verifyLabelHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", heading);
	}

	public void verifyFindAccHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblFindAccount, "Heading", heading);
	}

	public void clickLearnMore() {
		click(lnkLearnMore, "Learn More");
	}

	public void VerifyAddBankAccountDesc(String AddBankAccountDesc) {
		new CommonFunctions().verifyLabelText(lblAddBankAccountDesc, AddBankAccountDesc, "Add Bank Account Desc");
	}

	public void VerifyFindAccountDesc(String findAccountDesc) {
		new CommonFunctions().verifyLabelText(findAccDesc, findAccountDesc, "Add Bank Account Desc");
	}

	public void clickImReady() {
		click(btnImReady, "IM Ready");
	}

	public void clickExit() {
		click(lnkExit, "Exit");
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void selectBank() {
		click(lnkBank, "Bank");
	}

	public void fillBankName(String bankName) throws AWTException {
		enterText(txtBankName, bankName, "bankName");
		selectBank();
	}

	public void fillUserName(String userName) {
		enterText(txtUserName, userName, "userName");
	}

	public void fillPassword(String password) {
		enterText(txtPassword, "cashedge1", "password");
	}

	public void clickSelectAnotherInstitute() {
		click(btnSelectAnotherInst, "Select Another Institute");
	}

	public void clickBankNext() {
		click(btnBankNext, "Next");
	}

	public void clickChkbxBank() {
		click(chkbxBank, "Bank");
	}

	public void verifyHeadingView() {
		new CommonFunctions().elementView(lblHeading, "Add Bank Account");
	}

	public void verifyFiesrvHeading(String fiesrvHdg) {
		new CommonFunctions().verifyLabelText(informationAboutFiesrvHdg, "fiesrv heading", fiesrvHdg);
	}

	public void verifyAddBankAccountView() {
		new CommonFunctions().elementView(lblAddBankAccount, "Add Bank Account");
	}

	public void switchTab() {
		new CommonFunctions().switchTodWindow();
	}

	public AddBankAccountPopup addBankAccountPopup() {
		return new AddBankAccountPopup();
	}

}
