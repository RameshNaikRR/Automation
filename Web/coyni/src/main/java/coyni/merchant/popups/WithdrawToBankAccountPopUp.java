package coyni.merchant.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WithdrawToBankAccountPopUp extends BrowserFunctions {
	CommonFunctions cf = new CommonFunctions();
	private By lblHeading = By.xpath("//h1[.='Withdraw to Bank Account']");
	private By lblDailyLimitMsg = By.xpath("//h2[contains(@class,'font-sans ')]");
	private By txtAmount = By.cssSelector("#amount");
	private By amount = By.cssSelector("p[class*='BankInstantPayWithdrawModal']");
	private By IconCoyni = By.xpath("//input[@id='amount']/following-sibling::span");
	private By IconDollar = By.xpath("//input[@id='amount']/preceding-sibling::span");
	private By btnCoyniConvert = By.cssSelector("#flip-button");
	private By lblErrorMsg = By.xpath("//p[.='Amount is required']");
	private By lblAvailableBlnc = By.xpath("//span[.='Available Balance:']/..");
	private By lblConvertion = By.xpath("//span[.='Available Balance:']/../following-sibling::div");
	private By lblBank = By.xpath("//span[contains(.,'CashEdge Test')]/../..");
	private By txtMsg = By.cssSelector("#message");
	private By txtPlaceHolder = By.xpath("//label[.='Transaction Description (Optional)']");
	private By lblMsgTransaction = By.xpath("//p[contains(.,'Please allow')]");
	private By btnNext = By.xpath("//button[.='Next']");
	private By lblTransactions = By.xpath("//span[@class='text-cgy4 text-sm']");
	private By btnConfirm = By.xpath("//button[.='Confirm']");

	public void verifyHeading(String Heading) {
		cf.verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDailyLimitMsg() {
		cf.elementView(lblDailyLimitMsg, "Daily Limit Message ");
	}

	public void verifyAmountTxtField() {
		cf.elementView(txtAmount, "Amount text field");
	}

	public void clickAmount(String amount) {
		click(txtAmount, "Amount text field");
		enterText(txtAmount, amount, "Amount");
		cf.clickOutSideElement();
	}
	

	public void getAmount() {
		String amoun = getText(amount, "");
		ExtentTestManager.setInfoMessageInReport("Amount is: "+ amoun);
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

	public void verifyErrorMsg(String erroMsg) {
		cf.validateFormErrorMessage(erroMsg);
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

	public void clickTxtMsgField(String msg) {
		click(txtMsg, "Message text field");
		enterText(txtMsg, "Message", msg);
	}

	public void verifyTxtMsgField() {
		cf.elementView(txtMsg, "Message text field ");
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
		WebElement element = getElement(btnNext, "");
		if (element.isEnabled()) {
			ExtentTestManager.setInfoMessageInReport("Next button is in enable mode");
		} else {
			ExtentTestManager.setInfoMessageInReport("Next button is in disable mode");
		}
	}

	public void clickNext() {
		click(btnNext, "Next");
	}

	public void verifyTransactions() {
		List<WebElement> list = getElementsList(lblTransactions, "");
		for (WebElement one : list) {
			String text = one.getText();
			String Value = getText(By.xpath(String.format("//span[.='%s']/following-sibling::span", text)), "");
			ExtentTestManager.setInfoMessageInReport(text + " Coyni is " + Value);
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

	public VerifyYourIdentityPopup verifyYourIdentityPopup() {
		return new VerifyYourIdentityPopup();
	}
	
	public PaymentMethodRemovesdSuccessfullyPopup paymentMethodRemovesdSuccessfullyPopup() {
		return paymentMethodRemovesdSuccessfullyPopup();
	}

}
