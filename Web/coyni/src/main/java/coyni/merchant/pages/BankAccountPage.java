package coyni.merchant.pages;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class BankAccountPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h4[text()='Add Bank Account']");
	private By lnkLearnMore = By.xpath("//strong[text()='Learn More']");
	private By lblAddBankAccountDesc = By.xpath("//p[@class='text-sm text-cgy13 leading-5']");
	private By btnImReady = By.xpath("//button[text()='I’m Ready']");
	private By btnNext = By.xpath("//a[@id='acctForm:addFiNext']");
	private By btnBank = By.xpath("//button[text()='Next']");
	private By lnkExit = By.xpath("//Strong[text()='Exit']");
	private By btnBack = By.xpath("//button[text()='Back']");
	private By lblFiserv = By.xpath(" ");
	private By txtBankName = By.xpath("//input[@id='searchbar']");
	private By txtUserName = By.xpath("//input[@name='acctForm:j_idt145:0:login_']");
	private By txtPassword = By.xpath("//input[@name='acctForm:j_idt149:0:password_']");
	private By btnSelectAnotherInst = By.xpath("//a[@id='acctForm:selectFI']");
	private By btnBankNext = By.xpath("//a[@id='acctForm:addFiNext']");
	private By chkbxBank = By.xpath("(//div[@class='custom-control custom-checkbox'])");
	private By next = By.xpath("//span[.='Next']");
	private By informationAboutFiesrvHdg = By.xpath("//h1[text()='Information About Fiserv']");
	private By lblAddBankAccount = By.xpath("//h1[text()='Add Bank Account']");
	private By lblDoNotNavigate = By.xpath("//h2[text()='Do Not Navigate Away From This Page']");
	private By lnkBank = By.cssSelector("#filist>li:nth-of-type(1)");

	public void verifyDoNotNavigateView() {
		new CommonFunctions().elementView(lblDoNotNavigate, "Do Not Navigate AwayFrom This Page");
	}

	public void clickBank() {
		click(btnBank, "Bank Next");

	}

	public void clickEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void verifyLabelHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, heading, "Heading");
	}

	public void clickNextButtonBank() {
		click(next, "Next");

	}

	public void clickLearnMore() {
		click(lnkLearnMore, "Learn More");
	}

	public void VerifyAddBankAccountDesc(String AddBankAccountDesc) {
		new CommonFunctions().verifyLabelText(lblAddBankAccountDesc, AddBankAccountDesc, "Add Bank Account Desc");
	}

	public void clickImReady() {
		click(btnImReady, "IM Ready");
	}

	public void clickNext() {
		click(btnNext, "Next");
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
}
