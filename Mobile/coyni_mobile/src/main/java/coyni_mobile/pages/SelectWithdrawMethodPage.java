package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.popups.WithdrawMethodPopup;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class SelectWithdrawMethodPage extends MobileFunctions{
	
//	private By lblHeading =MobileBy.xpath("//*[contains(@name,'Select Withdraw')]");
	private By lblWithdraw =MobileBy.AccessibilityId("Select Withdraw Method");
	private By lblWIthdrawDesc = MobileBy.AccessibilityId("");
	private By lblBankDescription =MobileBy.xpath("//*[contains(@name,'External Bank')]/following-sibling::*[1]");
	private By lblInstantDescription = MobileBy.xpath("//*[@name='Instant Pay']/following-sibling::*[1]");
	private By lblGiftCardDescription = MobileBy.xpath("//*[contains(@name,'Gift')]/following-sibling::*[1]");
//	private By btnExternalBankAccount = MobileBy.xpath("//*[contains(@name,'External Bank')]");
	private By btnExternalBankAccount = MobileBy.AccessibilityId("External Bank Account");
//	private By btnInstantPay = MobileBy.xpath("//*[@name='Instant Pay']	");
	private By btnInstantPay = MobileBy.AccessibilityId("Instant Pay");
//	private By btnGiftCard = MobileBy.xpath("//*[@name='Gift Card']");
	private By btnGiftCard = MobileBy.AccessibilityId("Gift Card");
	private By btnCogentWallet = MobileBy.xpath("//*[@name='Cogent Account']");
	private By imgGiftCard = MobileBy.xpath("//XCUIElementTypeButton[@name='Gift card']");
	private By lblBankFee = MobileBy.AccessibilityId("");
	private By lblInstantFee = MobileBy.AccessibilityId("");
	private By lblGiftFee = MobileBy.AccessibilityId("");
	
	
	
	//when no card and accounts
	
	private By imgAddBank = MobileBy.AccessibilityId("");
	private By lblAddBankAccountHdg = MobileBy.AccessibilityId("");
	private By lblBankAccountdesc = MobileBy.AccessibilityId("");
	private By lnkBankAccount = MobileBy.AccessibilityId("");
	private By lblBankdesc = MobileBy.AccessibilityId("");
	
	private By imgAddDebit= MobileBy.AccessibilityId("");
	private By lblAddInstantPayHdg = MobileBy.AccessibilityId("");
	private By lblInstantPaydesc = MobileBy.AccessibilityId("");
	private By lnkDebitCard = MobileBy.AccessibilityId("");
	private By lblDebitdesc = MobileBy.AccessibilityId("");
	
	
	
	public void verifyBankAccountHeading(String hdg) {
		new CommonFunctions().elementView(imgAddBank, "Add Bank image");
		new CommonFunctions().verifyLabelText(lblAddBankAccountHdg, "Add Bank Account heading", hdg);
	}
	public void verifyBankAccountDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblBankAccountdesc, "Add Bank Account heading", desc);
	}
	
	public void clickBankAccount(String desc) {
		new CommonFunctions().verifyLabelText(lblBankdesc, "description", desc);
		click(lnkBankAccount, "Banl Account");
	}
	
	public void verifyDebitCardHeading(String hdg) {
		new CommonFunctions().elementView(imgAddDebit, "Add Debit image");
		new CommonFunctions().verifyLabelText(lblAddInstantPayHdg, "Add Instant Pay heading", hdg);
	}
	public void verifyDebitCardDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblInstantPaydesc, "Instant Pay description", desc);
	}
	
	public void clickDebitCard(String desc) {
		new CommonFunctions().verifyLabelText(lblDebitdesc, "description", desc);
		click(lnkDebitCard, "Debit Cardt");
	}
	
	
	public void clickCogentWallet() {
		click(btnCogentWallet, "Signet Wallet");
	}
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblWithdraw, "Page Heading ", expHeading);
	}
	public void verifyWithdrawDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblWIthdrawDesc, "Page Heading ", desc);
	}
	
	
	public void clickExternalBankAccount() {
		click(btnExternalBankAccount ,"ExternalBankAccount");
	}
	public void clickInstantPay() {
		click(btnInstantPay, "Instant Pay");
		}
	public void clickGiftCard() {
		click(btnGiftCard, "GiftCard");
	}
	public void verifyExternalBankView() {
		
		new CommonFunctions().elementView(btnExternalBankAccount, "External Bank Account");
	}
	public void verifyBankDes(String expBankDes) {
		new CommonFunctions().elementView(lblBankFee, "Fee");
		new CommonFunctions().verifyLabelText(lblBankDescription, "External Bank Account Description", expBankDes);
	}
	public void verifyInstantPayView() {
		new CommonFunctions().elementView(btnInstantPay, "Instant Pay");
	}
	public void verifyInstantDes(String expInstantDes) {
		new CommonFunctions().elementView(lblInstantFee, "Fee");
		new CommonFunctions().elementView(lblInstantDescription, "Instant Pay Description");
	}
	public void verifyGiftCardView() {
		new CommonFunctions().elementView(btnGiftCard, "Gift Card");
	}
	public void verifyGiftCardDes(String expGiftDes) {
		new CommonFunctions().elementView(lblGiftFee, "Fee");
		new CommonFunctions().elementView(imgGiftCard, "Gift Card Image");
		new CommonFunctions().verifyLabelText(lblGiftCardDescription, "Gift Card Description", expGiftDes);
	}
//	public ExternalBankAccountPage externalBankAccountPage() {
//		return new ExternalBankAccountPage();
//	}
//	public InstantPayPage instantPayPage() {
//		return new InstantPayPage();
//	}
//	public SelectYourGiftCardPage selectYourGiftCardPage() {
//		return new SelectYourGiftCardPage();
//	}
//    public NavigationComponent navigationComponent() {
//    	return new NavigationComponent();
//    }
	public WithdrawMethodPopup withdrawMethodPopup() {
		return new WithdrawMethodPopup();
	}
//	public AddBankPage addBankPage() {
//		return new AddBankPage();
//	}
//	public AddInstantPayPage addInstantPayPage() {
//		return new AddInstantPayPage();
//	}
	public GiftCardPage giftCardPage() {
		return new GiftCardPage();
	}
	
}
