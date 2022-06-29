package coyni_mobile_merchant.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import coyni_mobile_merchant.pages.GiftCardPage;
import coyni_mobile_merchant.popups.OrderPreviewPopup;
import coyni_mobile_merchant.popups.WithdrawToUSDBankAccountPopup;
import coyni_mobile_merchant.popups.WithdrawToUSDInstantPayPopup;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class WithdrawMenuComponent extends MobileFunctions {

	// withdraw options
	private By btnInstantPay = MobileBy.xpath("//*[contains(@resource-id,'InstantPay')]");
	private By btnGiftCard = MobileBy.xpath("//*[contains(@resource-id,'GiftCard')]");
	private By btnBankAccountWithDraw = MobileBy.xpath("//*[contains(@resource-id,'External')]");
	private By btnSignetAccount = MobileBy.xpath("//*[contains(@resource-id,'Signet')]");
	private By lblWithdrawHeading = MobileBy.xpath("//*[contains(@text,'Withdraw')]");

	public void clickInstantPay() {
		click(btnInstantPay, "Instant Pay");
	}

	public void clickGiftCard() {
		click(btnGiftCard, "Gift Card");
	}

	public void clickWithdrawBankAccount() {
		click(btnBankAccountWithDraw, "Bank Account");
	}
	public void clickSignetAccount() {
		click(btnSignetAccount, "Signet Account");
	}

	public void verifyWithdrawHeading(String expheading) {
		new CommonFunctions().verifyLabelText(lblWithdrawHeading, "Select Withdraw Method Heading", expheading);
	}
	public WithdrawToUSDBankAccountPopup withdrawToUSDBankAccountPopup() {
		return new WithdrawToUSDBankAccountPopup();
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
//	public WithdrawToUSDBankAccountPopup withdrawToUSDBankAccountPopup() {
//		return new WithdrawToUSDBankAccountPopup();
//	}
}
