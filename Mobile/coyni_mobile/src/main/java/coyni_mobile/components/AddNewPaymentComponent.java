package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class AddNewPaymentComponent extends MobileFunctions{
	private By lblHeading =MobileBy.AccessibilityId("Add Payment Method");

    private By lblPageDes =MobileBy.xpath("//*[contains(@name,'no payment')]");

    private By btnExternalBank =MobileBy.xpath("//*[contains(@name,'External Bank')] | //*[contains(@name,'Bank Account')] | (//*[contains(@name,'Bank Account')])[2]");

    private By btnDebitCard = MobileBy.xpath("//*[@name='Debit Card']");

//    private By btnDebitCard = MobileBy.AccessibilityId("Debit Card");

    private By btnCreditCard =MobileBy.xpath("//*[@name='Credit Card']");

//    private By btnCreditCard =MobileBy.AccessibilityId("Credit Card");

    

    private By lblBankCount =MobileBy.xpath("//*[contains(@name,'External Bank')]/following-sibling::*[1]");

    private By lblCreditCardCount =MobileBy.xpath("//*[contains(@name,'Credit Card')]/following-sibling::*[1]");

    private By lblDebitCardCount = MobileBy.xpath("//*[contains(@name,'Debit Card')]/following-sibling::*[1]");

    

    private By lblBankContent = MobileBy.xpath("//*[contains(@name,'withdraw')]");

//    private By lblCreditContent = MobileBy.xpath("//*[contains(@name,'credit cards')]");

    private By lblCreditContent = MobileBy.AccessibilityId("Visa, Mastercard, Discover, and American Express credit cards");

//    private By lblDebitContent =MobileBy.xpath("//*[contains(@name,'debit cards')]");

    private By lblDebitContent =MobileBy.AccessibilityId("Visa or Mastercard debit cards");

    private By lblError = MobileBy.xpath("//*[@name='Error']");

    private By lblErrorMesg = MobileBy.xpath("//*[@name='Error']/following-sibling::XCUIElementTypeStaticText");

    private By btnOK = MobileBy.xpath("(//*[@name='OK'])[1]");

//    private By btnCross = MobileBy.xpath("//XCUIElementTypeButton[@name='close']");

    private By btnCross = MobileBy.AccessibilityId("close");

//    private By lblMaxLimit = MobileBy.xpath("//*[@name='Credit Card']/preceding-sibling::*[1]");

    private By lblMaxLimit = MobileBy.AccessibilityId("This method has reached maximum 4 cards");

    

    

    private By lblCoyni = MobileBy.AccessibilityId("coyni");

    private By lblerrorText = MobileBy.xpath("//*[@name='coyni']/following-sibling::*[1]");

    

    public int verifyCoyniView() {

        //new CommonFunctions().elementView(lblCoyni, "Coyni");

        return getElementList(lblCoyni, "Coyni").size();

    }

    

    

    

    public void verifyErrorTextView() {

        new AndroidCommonFunctions().elementView(lblerrorText, "ErrorText");

        click(btnOK, "Ok");

    }

    

    public void verifyMaxlimit(String expTxt) {

        new AndroidCommonFunctions().verifyLabelText(lblMaxLimit, "Max limit", expTxt);

    }

    

    //2.3//

//    private By lblAddNewPayment = MobileBy.xpath("//XCUIElementTypeStaticText[@name='Add Payment Method']");

    private By lblAddNewPayment = MobileBy.AccessibilityId("Add Payment Method");

    

    public void  verifyAddNewPaymentHeading(String expHeading) {

    new AndroidCommonFunctions().verifyLabelText(lblAddNewPayment, "Heading", expHeading);    

    }

    

    public void clickCross() {

        click(btnCross, "Cross");

    }

    

    public int verifyAddPaymentSize() {

        return getElementList(lblHeading, "Heading").size();

    }

    public void verifyAddPaymentMethodView() {

        new AndroidCommonFunctions().elementView(lblHeading, "Add Payment method");

    }

    

    

    public void verifyErrorView() {

        new AndroidCommonFunctions().elementView(lblError, "Error");

    }

    public void verifyErrorMessage(String expMessage) {

        new AndroidCommonFunctions().verifyLabelText(lblErrorMesg, "Error Message", expMessage);

    }

    public void clickOk() {

        click(btnOK, "Ok");

    }

    public By getNumbersList(String account) {

        return MobileBy.xpath(String.format("//*[@name='%s']/following-sibling::XCUIElementTypeStaticText[1]", account));

    }

    

    public void verifyBankNums() {

        ExtentTestManager.setInfoMessageInReport("Bank Number is " + getText(getNumbersList(("Bank Account"))));

    //    new CommonFunctions().verifyLabelText(getNumbersList("Bank Account"), "bankNumbers", bankNumbers);

    }

    public void verifyCardNums(String cardNums) {

        new AndroidCommonFunctions().verifyLabelText(getNumbersList("Debit Card"), "cardNums", cardNums);

    }

    

    public void verifyCreditCardNums(String cardNums) {

        new AndroidCommonFunctions().verifyLabelText(getNumbersList("Credit Card"), "cardNums", cardNums);

    }

    

    public void verifyAddPaymentPage() {

        new AndroidCommonFunctions().elementView(lblHeading, "Add Payment Method Page");

    }

    public void verifyHeading(String expHeading) {

        new AndroidCommonFunctions().verifyLabelText(lblHeading, "Page Heading", expHeading);

    }

    public void verifyPageText(String expText) {

        new AndroidCommonFunctions().verifyLabelText(lblPageDes, "Page Description ", expText);

    }

    public void clickExternalBankAcount() {

        click(btnExternalBank, "External Bank Account");

    }

    public void verifyDebitContent(String content) {

        new AndroidCommonFunctions().verifyLabelText(lblDebitContent, "Debit card label", content);

    }

    

    public void clickDebitCard() throws InterruptedException {

        Thread.sleep(1000);

        if(getElementList(btnDebitCard, "DebitCard").size()>0) {

        click(btnDebitCard, "Debit Card");

        }

    }

    public void verifyCreditContent(String content) {

        new AndroidCommonFunctions().verifyLabelText(lblCreditContent, "Credit card label", content);

    }

    public void clickCreditCard() {

        click(btnCreditCard, "Credit Card");

    }

//    public AddExternalBankAccountComponent addExternalBankAccountComponent() {
//
//        return new AddExternalBankAccountComponent();
//
//    }

    public void verifyExternalBankView() {

        new AndroidCommonFunctions().elementView(btnExternalBank, "External Bank Account");

    }

    public void verifyExternalBankText(String expBankText) {

        new AndroidCommonFunctions().verifyLabelText(lblBankContent, "Add Bank Description ",expBankText);

    }

    public void verifyCreditCardView() {

        new AndroidCommonFunctions().elementView(btnCreditCard, "Credit card");

    }

    public void verifyCreditCardText(String expCreditText) {

        new AndroidCommonFunctions().verifyLabelText(lblCreditContent, "Credit Card Description ",expCreditText);

    }

    public void verifyDebitCardView() {

        new AndroidCommonFunctions().elementView(btnDebitCard, "Debit Card");

    }

    public void verifyDebitCardText(String expDebitText) {

        new AndroidCommonFunctions().verifyLabelText(lblDebitContent, "Debit Card Description ",expDebitText);

    }

    public NavigationComponent navigationComponent() {

        return new NavigationComponent();

    }

    public void getBankAccountCount() {

        if(getElementList(lblBankCount, "Bank Account Count").size()>0) {

            String count = getAttribute(lblBankCount, "value").replace("(", "").replace(")", "").split("/")[0];

            

        }

    }

    public AddCardComponent addCardComponent() {

        return new AddCardComponent();

    }

//    public AddManualBankComponent addManualBankComponent() {
//
//        return new AddManualBankComponent();
//
//    }
}
