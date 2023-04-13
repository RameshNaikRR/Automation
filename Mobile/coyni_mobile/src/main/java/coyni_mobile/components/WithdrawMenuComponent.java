package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.GiftCardPage;
import coyni_mobile.popups.OrderPreviewPopup;
import coyni_mobile.popups.WithdrawToUSDBankAccountPopup;
import coyni_mobile.popups.WithdrawToUSDInstantPayPopup;
import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.DashBoardPage;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class WithdrawMenuComponent extends MobileFunctions {

	// withdraw options
	private By btnInstantPay = MobileBy.xpath("//*[@text='Instant Pay']|//*[contains(@resource-id,'layoutDDetails')]");
	private By btnGiftCard = MobileBy.xpath("//*[@text='Gift Card']");
	private By btnBankAccountWithDraw = MobileBy.xpath("//*[@text='External Bank Account']");
	private By withdrawHeading = MobileBy.xpath("//*[@text='Select Withdraw Method']");
	private By btnExistingCard = MobileBy.xpath("//*[contains(@resource-id,'mainRL')]|//*[contains(@text,'8780')]");

	public void clickInstantPay() {
		click(btnInstantPay, "Instant Pay");
	}
	public void clickExistingCard() {
		click(btnExistingCard, "Card");
	}

	public void clickGiftCard() {
		click(btnGiftCard, "Gift Card");
	}

	public void clickWithdrawBankAccount() {
		click(btnBankAccountWithDraw, "Bank Account");
	}

	public void verifyWithdrawHeading(String expheading) {
		new CommonFunctions().verifyLabelText(withdrawHeading, "Withdraw Heading", expheading);
	}

	public WithdrawToUSDInstantPayPopup withdrawToUSDInstantPayPopup() {
		return new WithdrawToUSDInstantPayPopup();
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
	public WithdrawToUSDBankAccountPopup withdrawToUSDBankAccountPopup() {
		return new WithdrawToUSDBankAccountPopup();
	}
	public TransactionDetailsComponent2 transactionDetailsComponent2() {
		return new TransactionDetailsComponent2();
	}
	
}
