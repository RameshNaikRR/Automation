package coyni_mobile.components;
import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;



public class ForgotPinComponent extends MobileFunctions{

private By txtEmail = MobileBy.xpath("//*[contains(@resource-id,'etEmail')]");
private By btnNext = MobileBy.xpath("//*[contains(@resource-id,'cvNext')]");
private By lblForgotYourPin = MobileBy.xpath("//*[contains(@resource-id,'tvHead')] ");

public void clickNext() {
click(btnNext, "Next");
}
public void verifyForgotYourPinView() {
new CommonFunctions().elementView(lblForgotYourPin, "ForgotYourPin");
}
public void verifyEmail(String email) {
new CommonFunctions().verifyLabelText(txtEmail, "email is displayed as", email);}
// public VerifyNewEmailPage verifyNewEmailPage() {
// return new VerifyNewEmailPage();
//}
public NavigationComponent navigationComponent() {
return new NavigationComponent();
}
public VerifyEmailComponent verifyEmailComponent() {
return new VerifyEmailComponent();
}



}