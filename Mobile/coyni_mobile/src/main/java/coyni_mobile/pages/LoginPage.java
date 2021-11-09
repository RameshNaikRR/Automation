package coyni_mobile.pages;

import org.openqa.selenium.By;

import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class LoginPage extends MobileFunctions {
    private By txtUserName = MobileBy.id("com.coyni.android:id/etEmail");
    private By txtPassword = MobileBy.id("com.coyni.android:id/etPassword");
    private By btnLogin = MobileBy.id("com.coyni.android:id/cvLogin");
    private By lnkSignUp = MobileBy.linkText("Sign up");
    private By lnkForgotPassword = MobileBy.linkText("com.coyni.android:id/tvForgot");

    public void fillUserName(String userName){
        enterText(txtUserName, userName, "username");
    }

    public void fillPassword(String password){
        enterText(txtPassword, password, "password");
    }

    public void clickLogin(){
        click(btnLogin, "login button");
    }

    public CreateAnAccountPage clickSingupLink(){
        click(lnkSignUp, "sign up link");
        return new CreateAnAccountPage();
    }

    public void clickForgotPasswordLink(){
        click(lnkForgotPassword, "forgot password link");
    }


}
