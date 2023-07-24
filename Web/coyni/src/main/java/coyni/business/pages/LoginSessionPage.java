package coyni.business.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class LoginSessionPage extends BrowserFunctions {

	private By lblLoginSessions = By.xpath("");
	private By lblDescription = By.xpath("");
	private By lnkChangeYourPassword = By.xpath("");
	private By iconEndSession = By.xpath("");
	private By lnkEndAllSessions = By.xpath("");


	public void verifyLoginSessions(String expHeading) {
		new CommonFunctions().verifyLabelText(lblLoginSessions, "Heading is: ", expHeading);
	}

	public void verifyLoginSessionsDescription(String expHeading) {
		new CommonFunctions().verifyLabelText(lblDescription, "Description is: ", expHeading);
	}

	public void clickChangeYourPassword() {
		new CommonFunctions().verifyCursorAction(lnkChangeYourPassword, "Change Your Password");
		click(lnkChangeYourPassword, "Change Your Password");
	}

	public void clickEndSession(String backGround, String border) {
		new CommonFunctions().verifyMouseHoverAction(iconEndSession, "End Session", backGround, border);
		new CommonFunctions().verifyCursorAction(iconEndSession, "End Session");
		click(iconEndSession, "End Session");
	}

	public void clickEndAllSessions() {
		new CommonFunctions().verifyCursorAction(lnkEndAllSessions, "End All Sessions");
	}

}