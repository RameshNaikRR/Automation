package coyni.apibusiness.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ApplicationSubmissionPage extends BrowserFunctions {
	private By lblHeading = By.xpath("");
	private By lblDesc = By.xpath("");
	private By btnDone = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, "Application Submitted Successfully");
	}

	public void verifyDescription() {
		new CommonFunctions().elementView(lblDesc, "Description");
	}

	public void clickDone() {
		click(btnDone, "Done");
	}

}
