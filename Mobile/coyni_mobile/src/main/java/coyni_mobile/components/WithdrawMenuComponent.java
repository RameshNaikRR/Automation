package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.pages.GiftCardPage;
import coyni_mobile.popups.OrderPreviewPopup;
import coyni_mobile.popups.WithdrawToUSDInstantPayPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class WithdrawMenuComponent extends MobileFunctions {

	// withdraw options
	private By btnInstantPay = MobileBy.xpath("//*[@text='Instant Pay']");
	private By btnGiftCard = MobileBy.xpath("//*[@text='Gift Card']");
	private By btnBankAccountWithDraw = MobileBy.xpath("//*[@text='External Bank Account']");
	private By withdrawHeading = MobileBy.xpath("//*[@text='Select Withdraw Method']");
	private By instantPayHeading = MobileBy.xpath("");
	// private By btnSignetAccount =
	// MobileBy.id("com.coyni.android:id/layoutWSignet");

	public void clickInstantPay() {
		click(btnInstantPay, "Instant Pay");
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

	public void verifyAddInstantPayHeading(String expheading) {
		new CommonFunctions().verifyLabelText(instantPayHeading, "Instant Pay Heading", expheading);
	}

//    public void clickSignetAccount(){
//        click(btnSignetAccount, "Signet Account");
//    }

	public WithdrawToUSDInstantPayPopup withdrawToUSDInstantPayPopup() {
		return new WithdrawToUSDInstantPayPopup();
	}

	public OrderPreviewPopup orderPreviewPopup() {
		return new OrderPreviewPopup();
	}

	public EnterYourPINComponent enterYourPINComponent() {
		return new EnterYourPINComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public GiftCardPage giftCardPage() {
		return new GiftCardPage();
	}
}
