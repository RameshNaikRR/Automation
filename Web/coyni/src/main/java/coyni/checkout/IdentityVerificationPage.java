package coyni.checkout;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class IdentityVerificationPage extends BrowserFunctions {

	private By heading = By.xpath("//p[contains(text(),'Identity Verification')]");
	private By lblDescription = By.xpath("//p[contains(text(),'Please select a method')]");
	private By radiobtnPhone = By.xpath("(//input[@type='radio'])[1]");
	private By radiobtnEmail = By.xpath("(//input[@type='radio'])[2]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Identity Verification heading", expHeading);
	}

	public String getDescription() {
		return getText(lblDescription, "Description");

	}

	public void clickRadioBtnPhone() {
		click(radiobtnPhone, "Radio Btn Phone");
	}

	public void clickRadioBtnEmail() {
		click(radiobtnEmail, "Radio Btn Email");
	}

}
