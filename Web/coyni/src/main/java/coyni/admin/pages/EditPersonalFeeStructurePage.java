package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.DatePickerAndNextDayComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;

public class EditPersonalFeeStructurePage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[text()='Edit Personal Fee Structure']");
	private By lblMerchantHeading = By.xpath("//span[text()='Edit Merchant Fee Structure']");

	private By lblFirstRowHeading = By
			.xpath("//div[contains(@class,'grid w-full h-10 grid-cols-4 bg-cm1 rounded-xl')]");
	private By lnkEdit = By.xpath("//a[text()='Edit All']");
	private By lnkEditAccontLimit = By.xpath("//button[text()='Edit All']");

	private By getSideHeading(String HeadingNum) {
		return By.xpath(String.format("(//span[contains(@class,'font-bold text-cgy8')])[%s]", HeadingNum));
	}

	private By editExternalBanAmount = By.xpath("//input[@name='WEBAAmount']");

	private By editInstantPayPercentage = By.xpath("//input[@name='InstantPercent']");

	private By editCreditAmount = By.xpath("//input[@name='CreditCardAmount']");
	private By editDebitCardPercentage = By.xpath("//input[@name='DebitCardPercent']");

	public void clickEditAccountLimit() {
		new CommonFunctions().elementView(lnkEditAccontLimit, "edit");
		click(lnkEditAccontLimit, "edit");
	}

	public void verifyWithdrawals() {
		new CommonFunctions().elementView(getSideHeading("1"), "Withdrawals");
	}

	public void verifyBuyToken() {
		new CommonFunctions().elementView(getSideHeading("2"), "BuyToken");
	}

	public void verifyDispute() {
		new CommonFunctions().elementView(getSideHeading("3"), "Dispute");
	}

	public void clickEdit() {
		new CommonFunctions().elementView(lnkEdit, "Edit All");
		click(lnkEdit, "edit");
	}

	public void verifyHeading(String expEditHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expEditHeading", expEditHeading);
	}

	public void verifyMerchantHeading(String expEditHeading) {
		new CommonFunctions().verifyLabelText(lblMerchantHeading, "Edit Merchant Fee Structure", expEditHeading);
	}

	public void getFirstRowHeading() {
		String str = getText(lblFirstRowHeading, "FirstRowHeading");
		ExtentTestManager.setInfoMessageInReport(str);

	}

	public void editExternalBankAmount(String data) throws InterruptedException {
		clearText(editExternalBanAmount, "ExternalBanAmount");
		enterText(editExternalBanAmount, data, "ExternalBanAmount");
	}

	public void editInstantPayPercentage(String data) throws InterruptedException {
		clearText(editInstantPayPercentage, "InstantPayPercentage");
		enterText(editInstantPayPercentage, data, "InstantPayPercentage");
	}

	public void editCreditCardAmount(String data) throws InterruptedException {
		clearText(editCreditAmount, "CreditAmount");
		enterText(editCreditAmount, data, "CreditAmount");
	}

	public void editDebitCardPercentage(String data) throws InterruptedException {
		click(editDebitCardPercentage, "DebitCardPercentage");
		// Thread.sleep(2000);
		// clearText(editDebitCardPercentage, "DebitCard Percentage");
		DriverFactory.getDriver().findElement(editDebitCardPercentage).clear();
		Thread.sleep(1000);
		enterText(editDebitCardPercentage, data, "DebitCard Percentage");

	}

	private By btnschedule = By.xpath("//button[text()='Schedule']");

	public void clickSchedule() {
		if (getElement(btnschedule, "Schedule").isDisplayed()) {
			click(btnschedule, "Schedule");
		} else {
			ExtentTestManager.setFailMessageInReport("Schedule Button is Disable");
		}
	}

	private By btnAccountLimitschedule = By.xpath("(//button[text()='Schedule'])[2]");

	public void clickScheduleButton() {
		if (getElement(btnAccountLimitschedule, "Schedule").isDisplayed()) {
			click(btnAccountLimitschedule, "Schedule");
		} else {
			ExtentTestManager.setFailMessageInReport("Schedule Button is Disable");
		}
	}

	private By btnApplicationEffectiveDate = By.xpath("//input[@placeholder='Select A Date']");

	public void clickEfftiveDate() throws InterruptedException {
		click(btnApplicationEffectiveDate, "Effitive Date");
		Thread.sleep(2000);
		new DatePickerAndNextDayComponent().generateDate();
	}

	private By btnAccountLimitEffectiveDate = By.xpath("//input[@placeholder='Select A Date']");

	public void clickAccountLimit() throws InterruptedException {
		click(btnAccountLimitEffectiveDate, "Effitive Date");
		Thread.sleep(2000);
		new DatePickerAndNextDayComponent().generateDate();
	}

	private By lblApplicationAcknowledgementAgreement = By.xpath("//h1[text()='Schedule Your Fee Structure']");

	public void verifyScheduleFeeStructure(String heading) {
		new CommonFunctions().verifyLabelText(lblApplicationAcknowledgementAgreement, "Schedule Your Fee Structure",
				heading);
	}

//edit meerchant

	private By lnkTransactionEdit = By.xpath("(//a[text()='Edit All'])[1]");
	private By lnkTokenEdit = By.xpath("(//a[text()='Edit All'])[2]");
	private By lnkOtherFeeEdit = By.xpath("(//a[text()='Edit All'])[2]");

	public void clickTransactionEdit() {
		new CommonFunctions().elementView(lnkTransactionEdit, "edit");
		click(lnkTransactionEdit, "TransactionEdit");
	}

	public void clickTokenAccountEdit() {
		new CommonFunctions().elementView(lnkTokenEdit, "lnkTokenEdit");
		click(lnkTokenEdit, "TokenEdit");
	}

	public void editSaleOrderEcommereAmount(String data) throws InterruptedException {
		// click(editSaleOrderEcommereAmount, "SaleOrderEcommereAmount");
		new CommonFunctions().doubleClick(editSaleOrderEcommereAmount, "SaleOrderEcommereAmount");
		clearText(editSaleOrderEcommereAmount, "SaleOrderEcommereAmount");
		enterText(editSaleOrderEcommereAmount, data, "SaleOrderEcommereAmount");
	}

	public void clickOtherFeeEdit() {
		new CommonFunctions().elementView(lnkOtherFeeEdit, "OtherFeeEdit");
		click(lnkOtherFeeEdit, "OtherFeeEdit");
	}

	private By editSaleOrderEcommereAmount = By.xpath("//input[@name='SaleOrderECommerceDollar']");

	private By editSaleOrderPercent = By.xpath("//input[@name='SaleOrderPercent']");

	private By editEBAAmount = By.xpath("//input[@name='EBAAmount']");

	public void editSaleOrderPercent(String data) throws InterruptedException {
		clearText(editSaleOrderPercent, "SaleOrderPercent");
		enterText(editSaleOrderPercent, data, "SaleOrderPercent");
	}

	public void editEBAAmount(String data) throws InterruptedException {
		clearText(editEBAAmount, "EBAAmount");
		enterText(editEBAAmount, data, "EBAAmount");
	}

	private By editWSAmount = By.xpath("//input[@name='WSAmount']");

	public void editWSAmount(String data) throws InterruptedException {
		new CommonFunctions().doubleClick(editWSAmount, "WSAmount");
		clearText(editWSAmount, "WSAmount");
		enterText(editWSAmount, data, "WSAmount");
	}

	private By editAccountLimitExternalBanAmount = By.xpath("//input[@name='WEBAmount']");

	public void editAccountLimitExternalBanAmount(String data) throws InterruptedException {
		new CommonFunctions().doubleClick(editAccountLimitExternalBanAmount, "ExternalBanAmount");
		clearText(editAccountLimitExternalBanAmount, "ExternalBanAmount");
		enterText(editAccountLimitExternalBanAmount, data, "ExternalBanAmount");
	}

	private By btnLabelDaily = By.xpath(
			"(//div[contains(@class,'false font-semibold  text-base sm:text-xs lg:text-sm false  undefined text-cgy3 group-hover:text-cgy4  text-cgy3 hover:text-cgy4 ')])[5]");
	private By btnLabelWeekly = By.xpath("//data[text()='Weekly']");
	private By btnLabellDaily = By.xpath(
			"(//div[contains(@class,'false font-semibold  text-base sm:text-xs lg:text-sm false  undefined text-cgy3 group-hover:text-cgy4  text-cgy3 hover:text-cgy4 ')])[3]");

	public void clickWeeklyLimit() {
		click(btnLabelDaily, "Daily Limit");
		click(btnLabelWeekly, "Weekly Limit");
	}

	public void clickWeeklyLimits() {
		click(btnLabellDaily, "Daily Limit");
		click(btnLabelWeekly, "Weekly Limit");
		new CommonFunctions().switchToAdmin();
	}

	private By ScheduleError = By.xpath("//p[contains(text(),'Please select another date')]");

	public void VerifyScheduleError() {
		boolean String;
		if (String = getText(ScheduleError, "ScheduleError") != null) {
			ExtentTestManager.setInfoMessageInReport(String + "Error is displayed ");
		}
		;
	}

	private By lblAccountLimit = By.xpath("//h1[text()='Schedule Your Account Limits']");

	public void verifyScheduleAccountLimits(String heading) {
		new CommonFunctions().verifyLabelText(lblAccountLimit, "Schedule Your Account Limits", heading);
	}
}
