package coyni.business.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class EndAllSessionsPopup extends BrowserFunctions {

	private By lblEndAllSessions = By.xpath("");
	private By lblDes = By.xpath("");
	private By btnEndAllSessions = By.xpath("");
	private By crossClose = By.xpath("");

	public void verifyEndAllSessions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEndAllSessions, "Heading is: ", expHeading);
	}

	public void verifyEndAllSessionsDescription(String expDes) {
		new CommonFunctions().verifyLabelText(lblDes, "Description is: ", expDes);
	}

	public void clickEndAllSessions() {
		if (getElement(btnEndAllSessions, "End All Sessions").isEnabled()) {
			click(btnEndAllSessions, "End All Sessions");
			ExtentTestManager.setPassMessageInReport("End All Sessions Button is Enabled");
		} else {
			ExtentTestManager.setFailMessageInReport("End All Sessions Button is Disabled");
		}
	}

	public void clickClose() {
		click(crossClose, "Close");
	}

}
