package coyni.api.business.popups;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.web.actions.WaitForElement;

public class WithdrawtoSignetAccountPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Withdraw to Signet Account']");

	private By lnkAddNewSignetAccount = By.xpath("//span[text()='Add New Signet Account']");
	private By rdbtnBankAccount = By.xpath("(//input[@name='buy-token-radio'])[1]");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By txtAmount = By.xpath("//input[@name='amount']");
	private By lnkConverter = By.xpath("//button[@id='flip-button']");
	private By txtTransactionDesc = By.xpath("//label[text()='Transaction Description (Optional)']");
	private By lblErrMsg = By.xpath("//p[text()='Amount is required']");
	private By txtDescription = By.xpath("//textarea[@id='message']");
	private By wtdAmount = By.xpath("//span[text()='Withdraw Amount']/parent::div");
	private By lblProcessingFee = By.xpath("//span[text()='Processing Fee']/parent::div");
	private By lblTotal = By.xpath("//span[text()='Total']/parent::div");
	private By btnConfrim = By.xpath("//button[text()='Confirm']");
	private By iconDelete = By.xpath("//img[@data-tip='Delete']");
	private By btnCross = By.xpath("//button[@class='self-end']");

	private By lblNote = By.xpath("//p[@class='mt-4 text-xs text-center text-cgy4'] ");
	private By BankAccounts = By.xpath("//div[@class='flex flex-col items-center justify-center mt-9']//p");

	public void clickDelete() {
		click(iconDelete, "delete");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void verifyOrderPreviewForWithdraw() {
		new CommonFunctions().elementView(wtdAmount, "Withdraw Amount");
		new CommonFunctions().elementView(lblProcessingFee, "ProcessingFee");
		new CommonFunctions().elementView(lblTotal, "Total");
	}

	public void verifyDescription(String description) throws InterruptedException {
		click(txtDescription, "description");
		Thread.sleep(2000);
		new CommonFunctions().verifyLabelText(txtDescription, "Transaction Description", description);
	}

	public void selectBankAccount() {
		BrowserFunctions objBrowserFunctions = new BrowserFunctions();
		objBrowserFunctions.waitForElement(BankAccounts, BrowserFunctions.waittime, WaitForElement.presence);
		List<WebElement> optionsEles = objBrowserFunctions.getElementsList(BankAccounts, "BankAccounts");
		for (WebElement optionEle : optionsEles) {
			if (optionEle.getText().contains("CashEdge Test Bank")) {
				optionEle.click();
				break;
			}
		}
	}

	public void selectSignetAccount() {
		BrowserFunctions objBrowserFunctions = new BrowserFunctions();
		objBrowserFunctions.waitForElement(BankAccounts, BrowserFunctions.waittime, WaitForElement.presence);
		List<WebElement> optionsEles = objBrowserFunctions.getElementsList(BankAccounts, "BankAccounts");
		for (WebElement optionEle : optionsEles) {
			if (!optionEle.getText().contains("CashEdge Test Bank")) {
				optionEle.click();
				break;
			}
		}
	}

	public void clickfirstSignet() {
		click(rdbtnBankAccount, "BankAccount");
	}

	public void clickAddNewSignetAccount() {
		click(lnkAddNewSignetAccount, "AddNewSignetAccoungt");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void fillAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");
	}

	public void clickConverter() {
		click(lnkConverter, "Converter");
	}

	public void fillTransactionDesc(String desc) {
		enterText(txtTransactionDesc, "desc", desc);
	}

	public void verifyNote(String expNote) {
		new CommonFunctions().verifyLabelText(lblNote, "Note", expNote);
	}

	public void verifyProcessingFeeView() {
		new CommonFunctions().elementView(lblProcessingFee, "Processing Fee");
	}

	public void verifyTotalView() {
		new CommonFunctions().elementView(lblTotal, "Total");
	}

	public void clickConfirm() {
		click(btnConfrim, "Confirm");
	}

	public void clickClose() {
		click(btnCross, "Close");
	}

	public void clickOutside() {
		new CommonFunctions().clickOutSideElement();
	}

}
