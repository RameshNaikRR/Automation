package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.AndroidCommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class PreAuthorizationComponent extends MobileFunctions{
	// private By lblHeading =MobileBy.xpath("//*[@name='Pre-Authorization']");

    private By lblHeading = MobileBy.AccessibilityId("Pre-Authorization");

//    private By lblPageDes = MobileBy.xpath("//*[contains(@name,'For security reasons, we have charged ')]");

    private By lblPageDes = MobileBy.AccessibilityId(

            "For security reasons, we have charged your card a small amount which will be removed after the verification process is complete. Please check your recent card transactions and enter the amount of this charge below.");

    private By txtAmount = MobileBy.xpath("//*[@name='$']/..");

    private By btnVerify = MobileBy.xpath("(//*[@name='Verify'])[1]");

    private By lblIncorrectAmount = MobileBy.xpath("//XCUIElementTypeStaticText[contains(@name,'Incorrect amount.)]");

//    private  By imgPreAuth = MobileBy.xpath("//*[contains(@name,'preAuthImg')]");

    private By imgPreAuth = MobileBy.AccessibilityId("preAuthImg");

//    private By lblDollar = MobileBy.xpath("//*[contains(@name,'$')]");

    private By lblDollar = MobileBy.AccessibilityId("$");

    private By lblError2Tries = MobileBy.xpath("//*[contains(@name,'Incorrect amount. 2 tries left.')]");

    private By lblError1try = MobileBy.xpath("//*[contains(@name,'Incorrect amount. 1 try left.')]");

 

    public void verifytwotriesLeftMsgView() {

        new AndroidCommonFunctions().elementView(lblError2Tries, "2 trie left");

        ExtentTestManager.setInfoMessageInReport("error msg is :" + getText(lblError2Tries));

    }

 

    public void verifyOneTryLeftView() {

        new AndroidCommonFunctions().elementView(lblError1try, "1 try left");

        ExtentTestManager.setInfoMessageInReport("error msg is :" + getText(lblError1try));

    }

 

    // Incorrect amount. 2 tries left.

 

    public void verifyHeading(String expHeading) {

        new AndroidCommonFunctions().verifyLabelText(lblHeading, "heading", expHeading);

    }

 

    public void verifyPageDes(String expPageDes) {

        new AndroidCommonFunctions().elementView(imgPreAuth, "Pre Authy image");

        new AndroidCommonFunctions().verifyLabelText(lblPageDes, "Page Description", expPageDes);

    }

 
    public void fillAmount(String amount) {

        new AndroidCommonFunctions().elementView(lblDollar, "Dollar");

    //    enterText(txtAmount, amount, "amount");

        new ChoosePinComponent().fillPin(amount);

    }

 

    public void clickVerify() {

        click(btnVerify, "Verify");

    }

 

    public SuccessFailureComponent successFailureComponent() {

        return new SuccessFailureComponent();

    }

 

    private By lblStatusHeading = MobileBy.xpath("//*[@name='Pre-Authorization Failed']");

    private By lblMessage = MobileBy.xpath("//*[contains(@name,'amount')] ");

    private By btnAddBank = MobileBy.xpath("(//*[contains(@name,'Add Bank')])[1]");

 

    public void verifyErrHeading(String statusHeading) {

        new AndroidCommonFunctions().verifyLabelText(lblStatusHeading, "Status ", statusHeading);

    }

 

    public void verifyErrText(String statusText) {

        new AndroidCommonFunctions().verifyLabelText(lblMessage, "Message", statusText);

    }

 

    public void clickAddBankAccount() {

        click(btnAddBank, "Add Bank Account");

    }

 

    public NavigationComponent navigationComponent() {

        return new NavigationComponent();

    }

}
