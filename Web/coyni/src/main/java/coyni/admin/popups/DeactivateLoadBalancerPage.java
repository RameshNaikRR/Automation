package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class DeactivateLoadBalancerPage extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Deactivate Load Balancer?']");
	private By lblSubHeading = By.xpath("//p[contains(@class,'load-balancer-alert-message')]");
	private By btnDeactivate = By.xpath("//button[text()='Deactivate']");

	public void clickDeactivate() {
		click(btnDeactivate, "Deactivate");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, expHeading);
	}

	public void verifySubHeading(String expSubHeading) {
		new CommonFunctions().verifyLabelText(lblSubHeading, expSubHeading, expSubHeading);

	}

}
