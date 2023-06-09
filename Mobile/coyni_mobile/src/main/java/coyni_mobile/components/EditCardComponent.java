package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class EditCardComponent extends MobileFunctions{
	private By lblCardNumHeading = MobileBy.AccessibilityId("");
	private By imgCard = MobileBy.AccessibilityId("");
	private By lblNameonCard = MobileBy.AccessibilityId("");
	private By txtNameonCard = MobileBy.AccessibilityId("");
	private By lblCardNum = MobileBy.AccessibilityId("");
	private By txtCardNum = MobileBy.AccessibilityId("");
	private By lblExpDate = MobileBy.AccessibilityId("");
	private By txtExpDate = MobileBy.AccessibilityId("");
	private By lblBillingAddress = MobileBy.AccessibilityId("");
	private By txtBillingAddress = MobileBy.AccessibilityId("");
	private By btnEditPaymentMethod = MobileBy.AccessibilityId("");
	private By btnSave = MobileBy.AccessibilityId("");
	
	public void verifyCardNumHeading() {
		new CommonFunctions().elementView(lblCardNumHeading, "Card");
		new CommonFunctions().elementView(imgCard, "Card");
	}
	
	public void verifyNameonCard(String name) {
		new CommonFunctions().elementView(lblNameonCard, "Name on Card");
		new CommonFunctions().verifyLabelText(txtNameonCard, "Name on Card", name);
	}
	public void verifyCardNum(String cardNum) {
		new CommonFunctions().elementView(lblCardNum, "Card Number");
		new CommonFunctions().verifyLabelText(txtCardNum, "Card Number", cardNum);
	}
	public void verifyCardExp(String cardNum) {
		new CommonFunctions().elementView(lblCardNum, "Card Number");
		new CommonFunctions().verifyLabelText(txtCardNum, "Card Number", cardNum);
	}
	public void verifyBillingAddress(String address) {
		new CommonFunctions().elementView(lblBillingAddress, "Billing Address");
		new CommonFunctions().verifyLabelText(txtBillingAddress, "Billing Address", address);
	}
    public void clickEditPaymentMethod() {
    	if(getElement(btnEditPaymentMethod, "Edit Payment Method").isEnabled()) {
    		click(btnEditPaymentMethod, "Edit Payment Method");
    	}else {
    		ExtentTestManager.setInfoMessageInReport("Edit Payment Button is disabled");
    	}
    }
    public void clickSave() {
    	if(getElement(btnSave, "Save").isEnabled()) {
    		click(btnSave, "Save");
    	}else {
    		ExtentTestManager.setInfoMessageInReport("Save button is disabled");
    	}
    }
    
    /////Remove Card popup////
    private By btnRemoveCard = MobileBy.AccessibilityId("");
    private By btnRemoveAccount = MobileBy.AccessibilityId("");
    private By lblRemovingCard = MobileBy.AccessibilityId("");
    private By lblRemovingBankAccount = MobileBy.AccessibilityId("");
    private By lblCardimageNum = MobileBy.AccessibilityId("");
    private By btnNo = MobileBy.AccessibilityId("");
    private By btnYes = MobileBy.AccessibilityId("");
    
    public void verifyRemovingBankAccount(String hdg) {
    	new CommonFunctions().verifyLabelText(lblRemovingBankAccount, "Removing Bank Account", hdg);
    	new CommonFunctions().elementView(lblCardimageNum, "Card Image Number");
    }
    public void verifyRemovingHdg(String hdg) {
    	new CommonFunctions().verifyLabelText(lblRemovingCard, "Removing Card", hdg);
    	new CommonFunctions().elementView(lblCardimageNum, "Card Image Number");
    }
    public void clickNo() {
    	if(getElement(btnNo, "No").isEnabled()) {
    		click(btnNo, "No");
    	}else {
    		ExtentTestManager.setInfoMessageInReport("No button is disabled");
    	}
    }
    public void clickYes() {
    	if(getElement(btnYes, "Yes").isEnabled()) {
    		click(btnYes, "Yes");
    	}else {
    		ExtentTestManager.setInfoMessageInReport("Yes button is disabled");
    	}
    }
    public void clickRemove() {
    	if(getElement(btnRemoveCard, "Remove").isEnabled()) {
    		click(btnRemoveCard, "Remove");
    	}else {
    		ExtentTestManager.setInfoMessageInReport("Remove button is disabled");
    	}
    }
    public void clickRemoveAccount() {
    	if(getElement(btnRemoveAccount, "Remove").isEnabled()) {
    		click(btnRemoveAccount, "Remove");
    	}else {
    		ExtentTestManager.setInfoMessageInReport("Remove button is disabled");
    	}
    }
    

}
