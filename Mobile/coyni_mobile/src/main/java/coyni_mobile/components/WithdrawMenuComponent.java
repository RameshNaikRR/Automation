package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.GiftCardPage;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class WithdrawMenuComponent extends MobileFunctions {

	// withdraw options
	private By btnInstantPay = MobileBy.id("com.coyni.android:id/layoutInstant");
	private By btnGiftCard = MobileBy.id("//*[contains(@resource-id, 'lyGiftCard')]");
	private By btnBankAccountWithDraw = MobileBy.id("com.coyni.android:id/layoutWBank");
	private By btnSignetAccount = MobileBy.id("com.coyni.android:id/layoutWSignet");

	// withdraw options actions
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

	public GiftCardPage giftCardPage() {
		return new GiftCardPage();
	}
}
