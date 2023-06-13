package coyni.admin.Paymentcomponents;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class DisputesWonAndLostComponent extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Mark As Won']");
	private By lblContent = By.xpath("//span[contains(@class,'text-sm text-center mt-9 text-cgy4')]");
	private By btnYes = By.xpath("//button[text()='Yes']");
	private By btnGoBack = By.xpath("//button[text()='No, go back']");

	public void verifyHeading(String heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Mark As Won", heading);
	}

	public void verifyContent(String heading) {
		new CommonFunctions().verifyLabelText(lblContent, "", heading);
	}
	
	public void clickYes() {
		click(btnYes, "Yes");
	}
	public void clickGoBack() {
		click(btnGoBack, "Go Back");
	}

}
