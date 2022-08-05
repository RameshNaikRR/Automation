package coyni.merchant.popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddBankAccountPopup extends BrowserFunctions {

	private By btnIamReady = By.xpath("//button[contains(text(),'Ready')]");
	private By txtBankName = By.xpath("//input[@id='searchbar']");
	private By lnkLearnMore = By.cssSelector(" ");
	private By btnBack = By.cssSelector(" ");
	private By headingNewPage = By.xpath("//h1[contains(text(),'Add Accounts')]");
	private By headingAddBankAccount = By.xpath("//h1[contains(text(),'Add Bank Account')]");
	private By lnkBankName = By.xpath("(//div[@class='autoResultBankName'])[1]");
	private By txtUserName = By.xpath("//input[@name='acctForm:j_idt145:0:login_']");
	private By txtPassword = By.xpath("//input[@name='acctForm:j_idt149:0:password_']");
	private By btnNext = By.xpath("//a[@id='acctForm:addFiNext']");
	private By btnNextBank = By.xpath("//a[@id='acctForm:classNext']");
	private By chckBoxBank1 = By.xpath("(//div[@class='custom-control custom-checkbox'])[1]");
	private By chckBoxBank2 = By.xpath("(//div[@class='custom-control custom-checkbox'])[2]");
	private By chckBoxBank3 = By.xpath("(//div[@class='custom-control custom-checkbox'])[3]");
	private By lnkBank = By.cssSelector("#filist>li:nth-of-type(1)");

	public void clickIamReady() {
		click(btnIamReady, "click IamReady");
	}

	public void clickLearnMore() {
		click(lnkLearnMore, "Learm More");
	}

	public void clickEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void clickBack() {
		click(btnBack, "Back");
	}

	public void switchToWindow() {
		new CommonFunctions().switchTodWindow();
	}

	public void verifyHeading() {
		new CommonFunctions().elementView(headingAddBankAccount, "Heading Add Account Bank");
	}

	public void verifyNewWindowHeading() {
		new CommonFunctions().elementView(headingNewPage, "Heading New Page");
	}

	public void fillBankName(String bankName) throws AWTException {
		enterText(txtBankName, bankName, "bankName");
	}

	public void selectBank() {
		click(lnkBank, "Bank");
	}

	public void clickOnBankName() {
		click(lnkBankName, "Bank Name");
	}

	public void fillUserName(String userName) {
		enterText(txtUserName, userName, "userName");
	}

	public void fillPassword(String password1) {
		enterText(txtPassword, "cashedge1", "Password");
	}

	public void clickNext() {
		click(btnNext, "Click Next");
	}

	public void unSelectBank() {
//		if (verifyElementDisplayed(chckBoxBank3, "Bank")) {
//			click(chckBoxBank3, "Bank");
//
//		} else if (verifyElementDisplayed(chckBoxBank2, "Bank")) {
//			click(chckBoxBank2, "UnSelect Bank");
//		} else {
//			//click(chckBoxBank1, "UnSelect Bank");
		click(chckBoxBank2, "UnSelect Bank");

	}

	public void clickBankNext() {
		click(btnNextBank, "Click Next");
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
