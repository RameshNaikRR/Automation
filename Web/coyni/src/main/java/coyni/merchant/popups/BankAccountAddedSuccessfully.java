package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class BankAccountAddedSuccessfully extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[.='Bank Account Added' or .='Successfully']");
	private By lblDescription = By.xpath("//p[starts-with(.,'Your')]");
	private By btnDone = By.xpath("//button[.='Done']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void verifyDescription(String Description) {
		String text = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(text + " is displayed");
	}

	public void clickDone() {
		click(btnDone, "Done button");
	}
}
