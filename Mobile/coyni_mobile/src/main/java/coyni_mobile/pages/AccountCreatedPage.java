package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AccountCreatedPage extends MobileFunctions {
	private By heading = MobileBy.xpath("//*[@text='Account Created!']"); /// 2.3 ///
	private By btnGetStarted = MobileBy.xpath("//*[contains(@text,'Get Started')]");
	// 2.3//
	private By btnAddCreditOrDebit = MobileBy.xpath("//*[contains(@resource-id,'tvAddCard')]");
	private By btnSkip = MobileBy.xpath("//*[contains(@resource-id,'tvSkip')]|(//*[@text='Skip'])[1]");
	private By lblDescription = MobileBy.xpath("//*[contains(@text,'Your coyni account')]");

	public void verifyHeading(String expHeading, String accountDescription) {
		new CommonFunctions().verifyLabelText(heading, "heading", expHeading);
		new CommonFunctions().verifyLabelText(lblDescription, "Description", accountDescription);
	}

	public void clickSkip() {
		click(btnSkip, "Skip");
	}

	public void clickAddCreditOrDebit() {
		click(btnAddCreditOrDebit, "Credit or Debit");
	}

	public void clickGetStarted() {
		new CommonFunctions().elementView(btnGetStarted, "Get started ");
		click(btnGetStarted, "Get Started");
	}

	public TokenAccountPage tokenAccountPage() {
		return new TokenAccountPage();
	}

	public IdentityVerificationPage identityVerificationPage() {
		return new IdentityVerificationPage();
	}

}
