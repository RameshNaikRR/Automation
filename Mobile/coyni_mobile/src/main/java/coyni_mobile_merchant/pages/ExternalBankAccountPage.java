package coyni_mobile_merchant.pages;

import org.openqa.selenium.By;

import coyni_mobile.components.NavigationComponent;
import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class ExternalBankAccountPage extends MobileFunctions {
	private By btnBank = MobileBy.xpath(" ");
	private By lnkAddaNewPaymentMethod = MobileBy.xpath(" ");
	private By headingExternalBankAccount = MobileBy.xpath("");
	private By linkLearnMore = MobileBy.xpath("");
	private By brnNext = MobileBy.xpath("");
	private By lblBankAccount = MobileBy.xpath("");
	private By lblBankAccountNumber = MobileBy.xpath("");

	public void verifyLabel(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBankAccount, "Verify Label Bank Account", expHeading);
	}

	public void verifyLabelBankAccountNumber(String expHeading) {
		new CommonFunctions().verifyLabelText(lblBankAccountNumber, "Verify Label Bank Account", expHeading);
	}

	public void clickBank() {
		click(btnBank, "Bank");
	}

	public void clickAddaNewPaymentMethod() {
		click(lnkAddaNewPaymentMethod, "AddaNewPaymentMethod");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(headingExternalBankAccount, "Add External Bank", expHeading);
	}

	public void clickLearnMore() {
		click(linkLearnMore, "Learn More");
	}

	public void clickNext() {
		click(brnNext, "Next");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
