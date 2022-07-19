package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.merchant.popups.DeclineReserveRulePopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApplicationApprovedPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading4__7XPCN leading-10']");

	private By lblStatus = By.xpath("//span[contains(text(),'Requires Your ')]");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public void verifyStatus() {
		String text = getText(lblStatus, "Status");
		ExtentTestManager.setInfoMessageInReport("Status " + text);

	}

}
