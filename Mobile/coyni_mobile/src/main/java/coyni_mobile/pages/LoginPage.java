package coyni_mobile.pages;



import org.openqa.selenium.By;



import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;



public class LoginPage extends MobileFunctions {
private By txtemail = MobileBy.xpath("");
private By txtPassword = MobileBy.xpath("");
private By btnRemenberMe = MobileBy.xpath("");
private By btnLogin = MobileBy.xpath("");



public void fillUserName(String email) {
enterText(txtemail, email, "Email");
}



public void fillPassword(String password) {
enterText(txtPassword, password, "password");
}



public void clickRemenberMe() {
click(btnRemenberMe, "RemenberMe");
}



public void clickLogin() {
click(btnLogin, "login button");
}



public ForgotPasswordPage forgotPasswordPage() {
return new ForgotPasswordPage();
}





}