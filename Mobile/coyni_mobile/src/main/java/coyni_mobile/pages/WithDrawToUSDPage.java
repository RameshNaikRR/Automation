package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class WithDrawToUSDPage extends MobileFunctions{
	private By lnkExternalBankAccount = MobileBy.xpath(" ");
	private By lnkInstantPay = MobileBy.xpath(" ");
	private By lnkGiftCard = MobileBy.xpath(" ");
	
	public void clickExternalBankAccount() {
		click(lnkExternalBankAccount ,"ExternalBankAccount");
	}
	public void clickInstantPay() {
		click(lnkInstantPay, "Instant Pay");
		}
	public void clickGiftCard() {
		click(lnkGiftCard, "GiftCard");
	}
	public ExternalBankAccountPage externalBankAccountPage() {
		return new ExternalBankAccountPage();
	}
	public InstantPayPage instantPayPage() {
		return new InstantPayPage();
	}
	public GiftCardPage giftCardPage() {
		return new GiftCardPage();
	}

}
