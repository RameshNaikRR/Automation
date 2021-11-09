package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class HomePage extends MobileFunctions {

    private By btnSignIn =  MobileBy.xpath("//*[contains(@resource-id, 'tvSignIn')]");
    private By btnGetStarted = MobileBy.xpath("//*[contains(@resource-id, 'cvGetStarted')]");
    private By lnkSignup = MobileBy.xpath("//*[text()='Sign up']");

    public void clickSignIn(){
        click(btnSignIn, "Sign In button");
    }

    public CreateAnAccountPage clickGetStarted(){
        click(btnGetStarted, "Get Started Button");
        return new CreateAnAccountPage();
    }



}
