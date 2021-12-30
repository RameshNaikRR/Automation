package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class GetStartedPage extends BrowserFunctions {
	private By btnAuthy = By.xpath("//button[contains(text(),'Authentication')]");
	private By lblHeading = By.xpath("//h1[text()='Two-Step Authentication']");
	private By lnkManualEntry = By.xpath("//p[contains(text(),'Manual')]");
	private By btnCopy = By.cssSelector(".icon-copy");
	private By lblSucessHeading = By.xpath("//h1[contains(text(),'Success')]");
	private By btnVerifyIdentity = By.xpath("//button[text()='Verify Identity']");

	public void clickTwoStepAuthentication() {
		click(btnAuthy, "Two Step Authentication");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}

	public void clickManualEntry() {
		click(lnkManualEntry, "Use Manual Entry");
	}

	public void clickCopy() {
		click(btnCopy, "Copy");
	}

	public void fillAuthyInput() {
		new AuthyComponent().fillAuthyInput(getCopiedData());
	}

	public void verifySucessHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblSucessHeading, "Heading", expHeading);
	}

	public void clickVerifyIdentity() {
		click(btnVerifyIdentity, "Verify Identity");
	}
    public VerifyYourIdentityPage verifyYourIdentityPage() {
    	return new VerifyYourIdentityPage();
    }
}
