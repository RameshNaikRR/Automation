package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.GiftCardPage;
import coyni_mobile_merchant.pages.WithdrawTokenTransactionPage;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import coyni_mobile_merchant.popups.WithdrawToUSDBankAccountPopup;
import coyni_mobile_merchant.popups.WithdrawTokenTransactionPopup;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WithdrawMenuComponent extends MobileFunctions {

	// withdraw options
	private By btnInstantPay = MobileBy.xpath("(//*[contains(@text,'Instant Pay')])[1]");
	private By btnGiftCard = MobileBy.xpath("//*[contains(@resource-id,'GiftCard')]");
	private By btnChooseWithdrawBank = MobileBy.xpath("//*[contains(@text,'External Bank Account')]");
	private By btnSignetAccount = MobileBy.xpath("//*[contains(@text,'Signet Account')]");
	private By lblWithdrawHeading = MobileBy.xpath("//*[contains(@text,'Withdraw')]");
	private By btnChooseInstantPay = MobileBy.xpath("//*[contains(@resource-id,'CardName')]");
	private By btnWithdrawBankMethod = MobileBy.xpath("//*[contains(@resource-id,'Account')]");
	private By btnChooseSignetAccount = MobileBy.xpath("//*[contains(@resource-id,'Account')]");
	private By lblWithdrawMethod = MobileBy.xpath("//*[contains(@resource-id,'Head')]");
	private By lblAddPaymentHeading = MobileBy.xpath("//*[contains(@resource-id,'PayHead')]");
	private By lblAddPaymentDesc = MobileBy.xpath("//*[contains(@resource-id,'PayMessage')]");
	private By btnAddPaymentMethod = MobileBy.xpath("//*[contains(@resource-id,'PayClick')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'lySelBack')]");

//	private By btnAddDebitCard = MobileBy.xpath("//*[contains(@resource-id,'PayClick')]");
//	private By btnAddSignetAcc = MobileBy.xpath("//*[contains(@resource-id,'Head')]");
//	private By lblWithdrawMethod = MobileBy.xpath("//*[contains(@text,'Add Bank Account')]");

	public void verifyWithdrawHeading(String expheading) {
		new CommonFunctions().verifyLabelText(lblWithdrawHeading, "Select Withdraw Method Heading", expheading);
	}

	public void verifyAddPaymentHeading(String expheading) {
		new CommonFunctions().verifyLabelText(lblAddPaymentHeading, "Add Payment Method Heading", expheading);
	}

	public void verifyAddPaymentDesc(String expheading) {
		new CommonFunctions().verifyLabelText(lblAddPaymentDesc, "Add Payment Method Description", expheading);
	}

	public void clickAddPaymentMethod() {
		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnAddPaymentMethod));
		click(btnAddPaymentMethod, getText(btnAddPaymentMethod));
	}

	public void clickInstantPay() {
		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnInstantPay));
		click(btnInstantPay, getText(btnInstantPay));
	}

	public void clickGiftCard() {
		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnGiftCard));
		click(btnGiftCard, getText(btnGiftCard));
	}

	public void clickBank() {
		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnChooseWithdrawBank));
		click(btnChooseWithdrawBank, getText(btnChooseWithdrawBank));
	}

	public void clickSignetAccount() {
		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnSignetAccount));
		click(btnSignetAccount, getText(btnSignetAccount));
	}

	public void clickClose() {
		click(btnClose, "close");
	}

	public void verifyWithdraMethodHeading(String expheading) {
		new CommonFunctions().verifyLabelText(lblWithdrawMethod, "Withdraw Method Heading", expheading);
	}

	public void clickChooseInstantPay() {
		ExtentTestManager.setInfoMessageInReport(getText(btnChooseInstantPay));
		click(btnChooseInstantPay, "Choosen Instant Pay");
	}

	public void clickChooseWithdrawBankAccount() {
		ExtentTestManager.setInfoMessageInReport("Withdraw Payment Method is : " + getText(btnWithdrawBankMethod));
		click(btnWithdrawBankMethod, getText(btnWithdrawBankMethod));
	}

	public void clickChooseSignetAccount() {
		ExtentTestManager.setInfoMessageInReport(getText(btnChooseSignetAccount));
		click(btnChooseSignetAccount, "Choosen Signet Account");
	}

	public WithdrawToUSDBankAccountPopup withdrawToUSDBankAccountPopup() {
		return new WithdrawToUSDBankAccountPopup();
	}

	public WithdrawTokenTransactionPopup withdrawToUSDInstantPayPopup() {
		return new WithdrawTokenTransactionPopup();
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public GiftCardPage giftCardPage() {
		return new GiftCardPage();
	}

	public WithdrawTokenTransactionPage withdrawTokenTransactionPage() {
		return new WithdrawTokenTransactionPage();
	}
}
