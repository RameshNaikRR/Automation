package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class CreateAnAccountPage extends MobileFunctions {

    private By txtFirstName = MobileBy.xpath("//*[contains(@resource-id, 'etFirstName')]");


    public void verifyCreateAnAccountPage(){
        if(isElementPresent(txtFirstName)){
            ExtentTestManager.setPassMessageInReport("User is in Create an account Page");
        } else {
            ExtentTestManager.setFailMessageInReport("User is not in Create an account Page");
        }
    }

}
