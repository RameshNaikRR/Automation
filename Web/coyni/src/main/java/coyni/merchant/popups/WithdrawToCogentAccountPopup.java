package coyni.merchant.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawToCogentAccountPopup extends BrowserFunctions {

	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//h1[.='Withdraw to Signet Account']");
	private By txtmsg = By.xpath("//textarea[@name='message']");
	private By txtAmount = By.cssSelector("#amount");
	private By IconCoyni = By.xpath("//input[@id='amount']/following-sibling::span");
	private By IconDollar = By.xpath("//input[@id='amount']/preceding-sibling::span");
	private By btnCoyniConvert = By.cssSelector("#flip-button");
	private By lblErrorMsg = By.xpath("//p[.='Amount is required']");
	private By lblAvailableBlnc = By.xpath("//span[.='Available Balance:']/..");
	private By lblConvertion = By.xpath("//span[.='Available Balance:']/../following-sibling::div");
	private By lblBank = By.xpath("//span[contains(.,'Signet')]/../..");
	private By txtMsg = By.xpath("#message");
	private By txtPlaceHolder = By.xpath("//label[.='Transaction Description (Optional)']");
	private By lblMsgTransaction = By.xpath("//p[contains(.,'Your tr')]");
	private By btnNext = By.xpath("//button[.='Next']");
	private By btnAddNewCogentAccount = By.xpath("//span[contains(text(),'Add New Cogent Account')]");
	private By lblTransactions = By.xpath("//span[@class='text-cgy4 text-sm']");
	private By btnConfirm = By.xpath("//button[.='Confirm']");

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);

	}

	public void enterMessage(String Message) {
		enterText(txtmsg, Message, "Message");

	}

	public void enterAmount(String Amount) {
		enterText(txtAmount, Amount, "Amount");

	}

	public void clickOutside() {
		new CommonFunctions().clickOutSideElement();

	}

	public void clickAddNewCogentAccount() {
		click(btnAddNewCogentAccount, "Add New Cogent Account");
	}

	public void clickCogent(String number) {
		click(By.xpath(String.format("//p[contains(text(),'%s')]", number)), number);
		ExtentTestManager.setInfoMessageInReport("button clicked for Signet " + (number));
	}

	public void getAvailableBalance() {
		String txt = getText(lblAvailableBlnc, "Available Balance");
		ExtentTestManager.setInfoMessageInReport("Available Balance " + txt);
	}

	public void clickAmount() {
		click(txtAmount, "Amount text field");
	}

	public void verifyCoyniIcon() {
		cf.elementView(IconCoyni, "CYN Icon");
	}

	public void verifyDollarIcon() {
		cf.elementView(IconDollar, "$ Icon");
	}

	public void verifyCoyniConvertion() {
		cf.elementView(btnCoyniConvert, "Coyni Convertion");
	}

	public void clickCoyniConvertion() {
		click(btnCoyniConvert, "Coyni Convertion");
	}

	public void verifyErrorMsg() {
		getText(lblErrorMsg, "Error Message");
	}

	public void verifyAvailableBalncLabel() {
		cf.elementView(lblAvailableBlnc, "Available balance");
	}

	public void verifyCoyniToDollar() {
		cf.elementView(lblConvertion, "Coyni to Dollar");
	}

	public void verifyLblBank() {
		cf.elementView(lblBank, "Bank");
	}

	public void clickTxtMsg() {
		click(txtMsg, "Message text field");
	}

	public void verifyTxtFieldPlaceHolder() {
		String text = getText(txtPlaceHolder, "");
		ExtentTestManager.setInfoMessageInReport(text + "Place Holder is displayed");
	}

	public void verifylblMsgTransaction() {
		String text = getText(lblMsgTransaction, "");
		ExtentTestManager.setInfoMessageInReport(text + "Message is displayed");
	}

	public void verifyNextBtn() {
		cf.elementView(btnNext, "Next");
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void verifyTransactions() {
		List<WebElement> list = getElementsList(lblTransactions, "");
		for (WebElement one : list) {
			String text = one.getText();
			String Value = getText(By.xpath(String.format("//span[.='%s']/following-sibling::span", text)), "");
			ExtentTestManager.setInfoMessageInReport(text + " Amount is " + Value);
		}
	}

	public void verifyConfirm() {
		cf.elementView(btnConfirm, "Confirm");
	}

	public void clickConfirm() {
		click(btnConfirm, "Confirm");
	}

	public WithdrawConfirmPopup withdrawConfirmPopup() {
		return new WithdrawConfirmPopup();
	}

	public AddNewCognetAccountPopup addNewCogentAccountPopup() {
		return new AddNewCognetAccountPopup();
	}

	public WithdrawToCogentPreviewPopup withdrawToCogentPreviewPopup() {
		return new WithdrawToCogentPreviewPopup();
	}

	public WithdrawToSignetPreviewPopup withdrawToSignetPreviewPopup() {
		return new WithdrawToSignetPreviewPopup();
	}
}
