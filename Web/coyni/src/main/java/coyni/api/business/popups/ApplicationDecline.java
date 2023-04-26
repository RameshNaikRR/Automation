package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.NavigationComponent;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class ApplicationDecline extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[contains(@class,' Heading_heading4__7XPCN leading-10 ')]");
	private By description = By.xpath("//p[@class='text-cgy4 text-base BusinessApplicationBanner_bannerDesc__gYMXW']");
	private By message = By.xpath("//p[@class='text-cgy4 mt-5 text-base']");
	private By msgtext = By.xpath("//p[@class='text-cgy4 text-base font-semibold italic']");
	private By decline = By.xpath("//div[@class='Board_board__GpGSr p-6 BusinessApplicationBanner_cancelbox__3ZUZ2']");

	public void verifyHeading() {
		String str = getText(lblHeading, "Heading");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyDescription() {
		String str = getText(description, "Description");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyMessageHeading() {
		String str = getText(message, "Message Heading");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyDeclineMessage() {
		String str = getText(decline, "Decline Message");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public void verifyMessage() {
		String str = getText(msgtext, "Message");
		ExtentTestManager.setPassMessageInReport(str);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
