package coyni_mobile.components;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;

import coyni_mobile.components.MailingAddressComponent;
import coyni_mobile.pages.SignUpPage;
import coyni_mobile.utilities.AndroidCommonFunctions;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AddCardComponent extends MobileFunctions {
	
	
	private By lblHeading =MobileBy.xpath("//*[contains(@name,'Add New')]");
//	private By lblHeading =MobileBy.AccessibilityId("Add New Debit Card");
//	private By lblPageHeading = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Add Debit or Credit Card'] | //XCUIElementTypeStaticText[@name='Add Address']");
	private By lblPageHeading = MobileBy.AccessibilityId("Add Debit or Credit Card");
	private By lblAddAddressHeading = MobileBy.AccessibilityId("Add Address");
	//private By txtNameOnCard = MobileBy.xpath("(//*[@name='Name on card'])[1]");
	
//	private By txtCardNumber = MobileBy.xpath("(//*[@name='Card Number'])[1]");
	
//	private By txtCardExp = MobileBy.xpath("(//*[@name='Card Exp'])[1]");
//	private By txtCVVorCVC = MobileBy.xpath("(//*[@name='CVV/CVC'])[1]");

//	private By lblPleaseEnter = MobileBy.xpath("//*[contains(@name,'Please enter')]");
	private By slideBar = MobileBy.xpath("(//XCUIElementTypeButton[contains(@name,'back')])[1]/following-sibling::*[1]/XCUIElementTypeButton[1] |(//XCUIElementTypeButton[contains(@name,'back')])[2]/following-sibling::*[1]/XCUIElementTypeButton[1]");
	private By slidebar2 = MobileBy.xpath("//*[contains(@name,'close')]/following-sibling::*[1]/XCUIElementTypeButton[2]");
//	private By lblConfirmAddress = MobileBy.xpath("//*[contains(@name,'Please confirm')]");
	
	

	private By lblPleaseEnter = MobileBy.xpath("//*[contains(@name,'Please enter')]");
//	private By lblConfirmAddress = MobileBy.xpath("//*[contains(@name,'Please confirm')]");
	private By lblConfirmAddress = MobileBy.AccessibilityId("Please confirm your billing address");
	private By btnDone = MobileBy.AccessibilityId("Done");
	
	private By lblError = MobileBy.xpath("//*[@name='Error']");
	private By descError = MobileBy.xpath("//*[contains(@name,'Please ensure that,')]");
	private By btnOk = MobileBy.xpath("//XCUIElementTypeButton[contains(@name,'OK')]");
	
	
	public void verifyError(String error) {
		new AndroidCommonFunctions().elementView(lblError, "error");
		new AndroidCommonFunctions().verifyLabelText(descError, "error", error);
	    click(btnOk, "Ok");
	}
	
    public void VerifyPleaseConfirm() {
		new AndroidCommonFunctions().elementView(lblConfirmAddress,"Please confirm your billing address");
	}
	public void verifypleaseEnterView() {
		new AndroidCommonFunctions().elementView(lblPleaseEnter, "Please Enter card details");
	}
	
	public void verifySideBarView2() {
		new AndroidCommonFunctions().elementView(slidebar2, "second slide bar");
	}
	public void verifySideBarView() {
		new AndroidCommonFunctions().elementView(slideBar, "Slide Bar");
	}
	
	public void verifyHeading(String expHeading) {
		if(getElementList(lblHeading, "Heading").size()>0) {
		new AndroidCommonFunctions().verifyLabelText(lblHeading, "heading", expHeading);
		}
	}
	
	public void verifyHeadingView() {
		if(getElementList(lblHeading, "Heading").size()>0) {
		new AndroidCommonFunctions().elementView(lblHeading, "Heading");
		}
	}
	public void verifyPageHeading(String expHeading) {
		if(getElementList(lblPageHeading, "Page Heading").size()>0) {
		new AndroidCommonFunctions().verifyLabelText(lblPageHeading, "Heading", expHeading);
		}
	}
	public void verifyAddresHeading(String expHeading) {
		new AndroidCommonFunctions().verifyLabelText(lblAddAddressHeading, "pageHeading", expHeading);
	}
	
	
	public void clickCamera() {
		click(iconCamera, "Camera");
	}
	public void validateNameOnCard(String nameOnCard) {
		new SignUpPage().validateNameField(txtNameOnCard, "Name on card", nameOnCard);
	}
	/**
	 *Order -minChar, maxChar,maxiPlus
	 * 
	 */
	public void validateCardNumber(String textField) {
		String[] field = textField.split(",");
			new AndroidCommonFunctions().validateField(txtCardNumber, "Card Number", field[0]);
		  new AndroidCommonFunctions().validateFieldMaxichar(txtCardNumber, "Card Number", field[1]);
	}
	/**
	 *Order -minChar, maxChar,maxiPlus
	 * 
	 */
	public void validateCredCardNumber(String textField) {
		String[] field = textField.split(",");
			new AndroidCommonFunctions().validateField(txtCardNumber, "Card Number", field[0]);
			new AndroidCommonFunctions().validateField(txtCardNumber, "Card Number", field[1]);
		  new AndroidCommonFunctions().validateFieldMaxichar(txtCardNumber, "Card Number", field[2]);
	}
	/**
	 *Order - minChar, maxiPlus
	 * 
	 */
	public void validateCardExp(String textField) {
		String[] field = textField.split(",");
		new AndroidCommonFunctions().validateField(txtCardExp, "Card Exp", field[0]);
		new AndroidCommonFunctions().validateFieldMaxichar(txtCardExp, "Card Exp", field[1]);
	}
	
	public void validateCVVorCVC(String textField) {
		String[] field = textField.split(",");
		for (int i = 0; i < 2; i++) {
			validateCvvField(txtCVVorCVC, "CVV/CVC", field[i]);
		}
		new AndroidCommonFunctions().validateFieldMaxichar(txtCVVorCVC, "CVV/CVC", field[2]);
	}

	public void validateCvvField(By ele, String eleName, String enterText) {
		ExtentTestManager.setInfoMessageInReport("trying to enter " + enterText.length() + " characters in " + eleName);
		enterText(ele, enterText, eleName);
		String actualtext = new AndroidCommonFunctions().getTextBoxValue(ele).trim();
		System.out.println(actualtext);
		By errorMsgs = MobileBy.xpath(String.format("//*[contains(@label,'%s,')]", eleName));
	//	new SignUpPage().clickDone();
		if (getElementList(errorMsgs, "errorMsg").size() == 0 && actualtext.length() == enterText.length()) {

			ExtentTestManager.setPassMessageInReport(eleName + " is accepting " + enterText.length() + " characters");
		} else {

			ExtentTestManager
					.setFailMessageInReport(eleName + " is not accepting " + enterText.length() + " characters");
		}
	}
	
	
	
	/******
	 * 
	 */
	private By lblAddCredorDebit = MobileBy.AccessibilityId("");
	private By txtNameOnCard = MobileBy.AccessibilityId("Name on card");
	private By txtCardNumber = MobileBy.AccessibilityId("Card Number");
	private By txtCardExp = MobileBy.AccessibilityId("Card Exp");
	private By txtCVVorCVC = MobileBy.AccessibilityId("CVV/CVC");
	private By btnContinue = MobileBy.AccessibilityId("");
	private By iconCamera = MobileBy.AccessibilityId("");
	private By imgCard = MobileBy.AccessibilityId("");
	private By lblAddDebitCard = MobileBy.AccessibilityId("");
	private By lblAddCardDesc = MobileBy.AccessibilityId("");
	private By btnNext = MobileBy.AccessibilityId("");
	private By lblPlsConfirmBillingAdd = MobileBy.AccessibilityId("");
	
	
	public void verifyAddcardDesc(String desc) {
		new CommonFunctions().verifyLabelText(lblAddCardDesc, "Add Debit Card Desc", desc);
	}
	public void verifyPlsConfirmBillingAdd(String desc) {
		new CommonFunctions().verifyLabelText(lblPlsConfirmBillingAdd, "Please Confirm Billing", desc);
	}
	
	public void verifyAddDebitorCredHeadingView(String hdg) {
		new CommonFunctions().verifyLabelText(lblAddDebitCard, "Add Debit Card", hdg);
	}
	public void fillNameOnCard(String nameOnCard) {
		enterText(txtNameOnCard, nameOnCard, "NameOnCard");
	}
	public void fillCardNumber(String cardNumber) {
		new CommonFunctions().elementView(imgCard, "Card Image");
		new CommonFunctions().elementView(iconCamera, "Camere");
		click(txtCardNumber, "CardNum");
		enterText(txtCardNumber, cardNumber, "Card Number");
	}
	
	
	public void fillCardExp(String cardExp) {
		enterText(txtCardExp, cardExp, "CardExp");
       click(btnDone, "Done");
	}
	public void fillCVVorCVC(String cVVorCVC) {
		enterText(txtCVVorCVC, cVVorCVC, "CVVorCVC");
		click(btnDone, "Done");
	}
	
	public void clickContinue() {
		if(getElement(btnContinue, "Continue").isEnabled()) {
		click(btnContinue, "Continue");
		}
	}
	
	public void clickNext() {
		if(getElement(btnNext, "Next").isEnabled()) {
		click(btnNext, "Next");
		}else {
			ExtentTestManager.setInfoMessageInReport("Next button is disabled");
		}
	}
	public MailingAddressComponent mailingAddressComponent() {
		return new MailingAddressComponent();
	}
	public NavigationComponent navigationComponent() {
		 return new NavigationComponent();
	 }
	public PreAuthorizationComponent preAuthorizationComponent() {
		 return new PreAuthorizationComponent();
	 }
	
	
	
	
}
