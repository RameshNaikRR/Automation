package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ApplicationSummaryPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1");
	private By lblDesc = By.xpath("//p[contains(text(),'Application has been submitted su')]");
	private By btnDone = By.xpath("//button[text()='Done']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Business Application Summary", expHeading);
	}

	public void verifyDescription(String description) {
		new CommonFunctions().verifyLabelText(lblDesc, "Description", description);
	}

	public void clickDone() {
		click(btnDone, "Submit");
	}
}
