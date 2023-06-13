package coyni.admin.Paymentcomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.web.actions.WaitForElement;

public class AccountLimitsComponent extends BrowserFunctions {

	private By heading = By.xpath("(//p[text()='Account Limits'])[2]");
	
	private By lblBuyTokenBankAccountDailyLimit = By.xpath("(//div[text()='Bank Account']/..//span)[1]");
	private By lblBuyTokenDebitCardDailyLimit = By.xpath("//div[text()='Debit Card']/..//span");
	private By lblBuyTokenCreditCardDailyLimit = By.xpath("//div[text()='Credit Card']/..//span");
	private By lbWithdrawToUSDBankAccountDailyLimit = By.xpath("(//div[text()='Bank Account']/..//span)[2]");
	private By lbWithdrawToUSDInstantPayDailyLimit = By.xpath("(//div[text()='Instant Pay']/..//span)");
	private By lbWithdrawToUSDGidtCardDailyLimit = By.xpath("(//div[text()='Gift Card']/..//span)");
	private By btnView = By.xpath("//button[contains(@data-tip,'View')]");

	public void clickView() {
		click(btnView, "view");

	}
	
	//add method for 2.3
//m
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "expHeading", expHeading);

	}
	public AccountTableComponent accountTableComponent() {
		return new AccountTableComponent();
	}

	public String verifyHeading() {
		String str = getText(heading, "Heading");
		ExtentTestManager.setInfoMessageInReport("Heading is " + str);
		return str;
	}

	public String verifyDailyLimitBuyTokenBankAccount() {
		String str = getText(lblBuyTokenBankAccountDailyLimit, "Bak Account");
		ExtentTestManager.setInfoMessageInReport("Daily limit of Buy token Bank Account is " + str);
		return str;
	}

	public String verifyDailyLimitBuyTokenDebitCard() {
		String str = getText(lblBuyTokenDebitCardDailyLimit, "Debit Card");
		ExtentTestManager.setInfoMessageInReport("Daily limit of Buy token Debit Card is " + str);
		return str;
	}

	public String verifyDailyLimitBuyTokenCreditCard() {
		String str = getText(lblBuyTokenCreditCardDailyLimit, "Credit Card");
		ExtentTestManager.setInfoMessageInReport("Daily limit of Buy token Credit Card is " + str);
		return str;
	}

	public String verifyDailyLimitWithdrawToUSDBankAccount() {
		String str = getText(lbWithdrawToUSDBankAccountDailyLimit, "Bank Account");
		ExtentTestManager.setInfoMessageInReport("Daily Limit Withdraw To USD Bank Account is " + str);
		return str;
	}

	public String verifyDailyLimitWithdrawToUSDInstantPay() {
		String str = getText(lbWithdrawToUSDInstantPayDailyLimit, "Instant Pay");
		ExtentTestManager.setInfoMessageInReport("Daily Limit Withdraw To USD Instant Pay is " + str);
		return str;
	}

	public String verifyDailyLimitWithdrawToUSDGiftCard() {
		String str = getText(lbWithdrawToUSDGidtCardDailyLimit, "Gift Card");
		ExtentTestManager.setInfoMessageInReport("Daily Limit Withdraw To USD Gift Card is " + str);
		return str;
	}

	private By btnActive = By.xpath("//div[text()='Active']/ancestor::tr[@class=' ']/descendant::button");

	public void clickActiveEdit() throws InterruptedException {
		moveToElement(btnActive, "btnActive");
		Thread.sleep(2000);
		click(btnActive, "btnActive");
	}

	private By btnEditDebit = By.xpath(
			"//button[text()='Edit All']");
	
	public void enterTextDebit(String debitAmnt) throws InterruptedException {
		Thread.sleep(2000);
		click(btnEditDebit, "btnEditDebit");
		WebElement ele = getElement(btnEditDebit, "btnEditDebit");
		Actions a = new Actions(DriverFactory.getDriver());
		WebElement ele1 = (WebElement) a.click(ele);
		Thread.sleep(2000);
		ele1.sendKeys(debitAmnt);
		ExtentTestManager.setInfoMessageInReport("Clicked on element debit");
		ExtentTestManager.setInfoMessageInReport("Entered text in element Debit");
	
	}

	private By btnShedule = By.xpath("//button[text()='Schedule']");

	public void clickSheduled() {
		click(btnShedule, "btnShedule");
	}

	private By btnSelectDate = By.xpath("//input[@placeholder='Select A Date']");

	public void clickSelectDate(String selectDate) {
		click(btnSelectDate, "btnSelectDate");
		new DatePickerComponent().setDate(selectDate);
		ExtentTestManager.setInfoMessageInReport("Entered date in element btnSelectDate");
	}

	private By btnShedule2 = By.xpath("(//button[text()='Schedule'])[2]");

	public void clickSheduled2() {
		click(btnShedule2, "btnShedule2");
	}

	private By txtCreditedBy = By.xpath("(//h1[@class='text-sm font-semibold text-cgy4'])[3]");

	public String getCreditedByname() {
		waitForElement(txtCreditedBy, waittime, WaitForElement.presence);
		return getText(txtCreditedBy, "CreditedByName");
	}

	public String getStartDate(String selectDate) throws InterruptedException {
		By txtActStartDate = By.xpath(String.format("//td[text()='%s']", selectDate));
		return getText(txtActStartDate, "txtActStartDate");
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}

}
