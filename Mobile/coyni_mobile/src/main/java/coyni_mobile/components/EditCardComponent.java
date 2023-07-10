package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditCardComponent extends MobileFunctions {
	private By lblCardNumHeading = MobileBy.id("com.coyni.mapp:id/tvHeading");
	private By lblEditCardHeading = MobileBy.id("com.coyni.mapp:id/tvCard");
	private By imgCard = MobileBy.id("com.coyni.mapp:id/cardView");
	private By lblCardType = MobileBy.xpath("//*[contains(@resource-id,'tvBankName')]|//*[contains(@resource-id,'tvCardName')]");
	private By lblNameonCard = MobileBy.id("com.coyni.mapp:id/tvNameOnCard");
	private By lblCardNumOnImg = MobileBy.xpath("//*[contains(@resource-id,'tvAccount')]|//*[contains(@resource-id,'tvCardNumber')]");
	private By lblCardNum = MobileBy.id("com.coyni.mapp:id/tvCardNoInstitution");
	private By lblExpDate = MobileBy.id("com.coyni.mapp:id/tvDateORouting");
	private By txtExpDate = MobileBy.id("");
	private By lblBillingAddress = MobileBy.id("com.coyni.mapp:id/tvAddressOrACNo");
	private By txtBillingAddress = MobileBy.id("");
	private By btnEditPaymentMethod = MobileBy.id("com.coyni.mapp:id/button");
	private By btnSave = MobileBy.id("com.coyni.mapp:id/cvSave");
/////Remove Card popup
	private By btnRemoveCard = MobileBy.id("com.coyni.mapp:id/cvRemove");
	private By btnRemoveAccount = MobileBy.xpath("//*[@text='Remove Account']");
	private By lblRemovingCard = MobileBy.id("com.coyni.mapp:id/tvHeading");
	private By lblRemovingBankAccount = MobileBy.id("");
	private By lblCardimageNum = MobileBy.id("com.coyni.mapp:id/imgBankIcon");
	private By btnNo = MobileBy.id("com.coyni.mapp:id/tvNo");
	private By btnYes = MobileBy.id("com.coyni.mapp:id/tvYes");

	public String verifyCardNumHeading() {
		new CommonFunctions().elementView(lblCardNumHeading, "Card");
		new CommonFunctions().elementView(imgCard, "Card");
		return getText(lblCardNumHeading);
	}

	public String verifyEditCardHeading() {
		new CommonFunctions().elementView(lblEditCardHeading, "Edit Card");
		return getText(lblEditCardHeading);
	}

	public void verifyNameonCard(String name) {
		new CommonFunctions().elementView(lblNameonCard, "Name on Card");
		new CommonFunctions().verifyLabelText(lblNameonCard, "Name on Card", name);
	}

	public void verifyCardNum(String cardNum) {
		new CommonFunctions().elementView(lblCardNum, "Card Number");
		new CommonFunctions().verifyLabelText(lblCardNum, "Card Number", cardNum);
	}

	public void verifyCardExp(String cardNum) {
		new CommonFunctions().elementView(lblCardNum, "Card Number");
		new CommonFunctions().verifyLabelText(lblCardNum, "Card Number", cardNum);
	}

	public void verifyBillingAddress(String address) {
		new CommonFunctions().elementView(lblBillingAddress, "Billing Address");
		new CommonFunctions().verifyLabelText(txtBillingAddress, "Billing Address", address);
	}

	public void clickEditPaymentMethod() {
		if (getElement(btnEditPaymentMethod, "Edit Payment Method").isEnabled()) {
			click(btnEditPaymentMethod, "Edit Payment Method");
		} else {
			ExtentTestManager.setInfoMessageInReport("Edit Payment Button is disabled");
		}
	}

	public void clickSave() {
		if (getElementList(btnSave, "Save").size() > 0) {
			if (getElement(btnSave, "Save").isEnabled()) {
				click(btnSave, "Save");
			} else {
				ExtentTestManager.setInfoMessageInReport("Save button is disabled");
			}
		}
	}

	public void verifyRemovingBankAccount(String hdg) {
		new CommonFunctions().verifyLabelText(lblRemovingBankAccount, "Removing Bank Account", hdg);
		new CommonFunctions().elementView(lblCardimageNum, "Card Image Number");
	}

	public void verifyRemovingHdg(String hdg) {
		new CommonFunctions().verifyLabelText(lblRemovingCard, "Removing Card", hdg);
		new CommonFunctions().elementView(lblCardimageNum, "Card Image Number");
		new CommonFunctions().elementView(lblCardType, "Card Type");
		new CommonFunctions().elementView(lblCardNumOnImg, "Card Number");
	}

	public void verifyBankRemovingHdg(String hdg) {
		new CommonFunctions().verifyLabelText(lblRemovingCard, "Removing Bank Heading", hdg);
		new CommonFunctions().elementView(lblCardimageNum, "Bank Logo");
		new CommonFunctions().elementView(lblCardType, "Bank Name");
		new CommonFunctions().elementView(lblCardNumOnImg, "Card Number");
	}
	
	public void clickNo() {
		click(btnNo, "No");
	}

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void clickRemove() {
		scrollDownToElement(btnRemoveCard, "Remove");
		click(btnRemoveCard, "Remove");
	}

	public void clickRemoveAccount() {
		scrollDownToElement(btnRemoveAccount, "Remove");
		click(btnRemoveAccount, "Remove");
	}

	public void verifyRemoveBankAccount() {
		new CommonFunctions().elementView(lblCardNumHeading, "Remove Bank Heading");
		ExtentTestManager.setPassMessageInReport(getText(lblCardNumHeading));
		new CommonFunctions().elementView(lblNameonCard, "Bank Type");
		ExtentTestManager.setPassMessageInReport(getText(lblNameonCard));
		new CommonFunctions().elementView(lblCardNum, "Bank Name");
		ExtentTestManager.setPassMessageInReport(getText(lblCardNum));
		new CommonFunctions().elementView(lblExpDate, "Routong Number");
		ExtentTestManager.setPassMessageInReport(getText(lblExpDate));
		new CommonFunctions().elementView(lblBillingAddress, "Account Number");
		ExtentTestManager.setPassMessageInReport(getText(lblBillingAddress));
	}
	
}
