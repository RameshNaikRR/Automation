package coyni.admin.pages;

import org.openqa.selenium.By;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ChooseAccountPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//span[text()='Choose Account']");
	private By btnUser = By.xpath("//span[text()='QA test']");
	private By lnkReturnToLogin = By.xpath("//div[text()='Return to Login']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "expHeading", expHeading);
	}

	public void clickUser() {
		click(btnUser, "User");
	}

	public void clickReturnToLogin() {
		click(lnkReturnToLogin, "ReturnToLogin");
	}
}