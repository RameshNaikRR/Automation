package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class CreatePersonalAccountPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//div[contains(@class,'CreateAccount_heading__mj12S')]");

	private By btnCreatePersonalAccount = By.xpath("(//button[text()='Create Personal Account'])[1]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void clickCreatePersonalAccount() {
		click(btnCreatePersonalAccount, "Personal Account");
	}

}
