package coyni_mobile_merchant.components;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.GiftCardPage;
import coyni_mobile_merchant.pages.WithdrawTokenTransactionPage;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import coyni_mobile_merchant.popups.WithdrawToUSDBankAccountPopup;
import coyni_mobile_merchant.popups.WithdrawTokenTransactionPopup;
import ilabs.MobileFramework.DriverFactory;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WithdrawMenuComponent extends MobileFunctions {

	// withdraw options
	private By btnInstantPay = MobileBy.xpath("(//*[contains(@text,'Instant Pay')])[1]");
	private By btnGiftCard = MobileBy.xpath("//*[contains(@resource-id,'GiftCard')]");
	private By btnChooseWithdrawBank = MobileBy.xpath("//*[contains(@text,'External Bank Account')]");
	private By btnCogentAccount = MobileBy.xpath("//*[contains(@text,'Cogent Account')]");
	private By lblWithdrawHeading = MobileBy.xpath("//*[contains(@text,'Withdraw')]");
	private By btnChooseInstantPay = MobileBy.xpath("(//*[contains(@resource-id,'CardName')])[1]");
	private By btnWithdrawBankMethod = MobileBy.xpath("(//*[contains(@resource-id,'Account')])[1]");
	private By btnChooseSignetAccount = MobileBy.xpath("//*[contains(@resource-id,'Account')]");
	private By lblWithdrawMethod = MobileBy.xpath("//*[contains(@resource-id,'Head')]");
	private By lblAddPaymentHeading = MobileBy.xpath("//*[contains(@resource-id,'PayHead')]");
	private By lblAddPaymentDesc = MobileBy.xpath("//*[contains(@resource-id,'PayMessage')]");
	private By btnAddPaymentMethod = MobileBy
			.xpath("//*[contains(@resource-id,'PayClick')]|//*[contains(@text,'New Payment ')]");
	private By btnClose = MobileBy.xpath("//*[contains(@resource-id,'lySelBack')]");

//	Expired card scenario
	private By lblExpired = MobileBy
			.xpath("(//*[contains(@resource-id,'tvError')])[1]|(//*[contains(@resource-id,'tvBankExpire')])[1]");
	private By btnRemove = MobileBy.id("com.coyni.mapp:id/tvRemove");
	private By btnEdit = MobileBy.id("com.coyni.mapp:id/tvEdit");
	private By lblOopsDes = MobileBy.id("com.coyni.mapp:id/tvMessage");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

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
//		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnAddPaymentMethod));
		click(btnAddPaymentMethod, getText(btnAddPaymentMethod));
	}

	public int verifyAddNewPaymentMethod() {
		return DriverFactory.getDriver().findElements(btnAddPaymentMethod).size();
	}

	public void clickInstantPay() {
//		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnInstantPay));
		click(btnInstantPay, getText(btnInstantPay));
	}

	public void clickGiftCard() {
//		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnGiftCard));
		click(btnGiftCard, getText(btnGiftCard));
	}

	public void clickBank() {
//		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnChooseWithdrawBank));
		click(btnChooseWithdrawBank, getText(btnChooseWithdrawBank));
	}

	public void clickCogentAccount() {
//		ExtentTestManager.setInfoMessageInReport("Payment Method Name is : " + getText(btnSignetAccount));
		click(btnCogentAccount, getText(btnCogentAccount));
	}

	public void clickClose() {
		click(btnClose, "close");
	}

	public void verifyWithdraMethodHeading(String expheading) {
		new CommonFunctions().verifyLabelText(lblWithdrawMethod, "Withdraw Method Heading", expheading);
	}

	public void clickChooseInstantPay() {
//		ExtentTestManager.setInfoMessageInReport(getText(btnChooseInstantPay));
		click(btnChooseInstantPay, "Choosen Instant Pay");
	}

	public void clickChooseWithdrawBankAccount() {
		ExtentTestManager.setInfoMessageInReport("Withdraw Payment Method is : " + getText(btnWithdrawBankMethod));
		click(btnWithdrawBankMethod, getText(btnWithdrawBankMethod));
	}

	public void clickChooseCogentAccount() {
		ExtentTestManager.setInfoMessageInReport(getText(btnChooseSignetAccount));
		click(btnChooseSignetAccount, "Choosen Signet Account");
	}

	public void clickExpiredCard() {
		new CommonFunctions().elementView(lblExpired, "Expired");
		click(lblExpired, "Expired Card");
	}

	public void clickRemove() {
		click(btnRemove, "Remove");
	}

	public void verifyErrorDescription() {
		new CommonFunctions().elementView(lblOopsDes, "Oops Description");
	}

	public void clickEdit() throws InterruptedException {
//		wait.until(ExpectedConditions.presenceOfElementLocated(btnEdit));
//		Explicitly waiting techniques are not working, so we are using static wait
		Thread.sleep(1000);
		click(btnEdit, "Edit");
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
