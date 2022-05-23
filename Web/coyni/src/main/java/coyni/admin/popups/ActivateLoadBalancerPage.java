package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class ActivateLoadBalancerPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Activate Load Balancer?']");
	private By lblDescription = By.xpath(" //p[contains(@class,'load-balancer')]");
	private By btnActivate = By.xpath("//button[text()='Activate']");
	private By lnkBack = By.xpath("//span[text()='No, go back']");
	private By btnCross = By.cssSelector(".self-end");

	public void clickActivate() {
		click(btnActivate, "Activate");
	}

	public void clickBack() {
		click(lnkBack, "Back");
	}

	public void clickCross() {
		click(btnCross, "Cross");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, expHeading);
	}

	public void verifyeDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, expDescription, expDescription);

	}
}
