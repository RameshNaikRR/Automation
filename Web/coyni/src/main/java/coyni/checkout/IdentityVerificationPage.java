package coyni.checkout;

import org.openqa.selenium.By;

import coyni.merchant.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;

public class IdentityVerificationPage extends AuthyComponent {

	private By heading = By.xpath("//p[contains(text(),'Identity Verification')]");
	private By lblDescription = By.xpath("//p[contains(text(),'Please select a method')]");
	private By radiobtnPhone = By.xpath("(//input[@type='radio'])[1]");
	private By radiobtnEmail = By.xpath("(//input[@type='radio'])[2]");
	private By btnNext = By.xpath("//button[text()='Next']");
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Identity Verification heading", expHeading);
	}

	public String getDescription() {
		return getText(lblDescription, "Description");

	}
	public void clickNext() {
		click(btnNext, "Next");
	}

	public void clickRadioBtnPhone() {
		click(radiobtnPhone, "Radio Btn Phone");
	}

	public void clickRadioBtnEmail() {
		click(radiobtnEmail, "Radio Btn Email");
	}
	
	public PhoneVerificationPage phoneVerificationPage() {
		return new PhoneVerificationPage();
	}

}
