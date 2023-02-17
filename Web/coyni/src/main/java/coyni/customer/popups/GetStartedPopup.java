package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class GetStartedPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[contains(text(),'Get Started')]");
	private By txtGetStarted = By.xpath("//p[contains(text(),'Your coyni account is now ready.')]");
	private By btnCard = By.xpath("//button[contains(text(),'Add Debit or Credit Card')]");
	private By btnSkip = By.xpath("//button[contains(text(),'Skip')]");

	public void verifyHeading() {
		String text = getText(lblHeading, "Get Started Heading");
		System.out.println("Verified Heading is " + text);
	}

	public void verifyTextHeading() {
		String text = getText(txtGetStarted, "Get Started");
		System.out.println("Get Started Text" + text);
	}

	public void clickCard() {
		click(btnCard, "Card");

	}

	public void clickSkip() {
		click(btnSkip, "Skip");
	}
}
