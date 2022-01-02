package coyni_mobile.components;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import io.appium.java_client.MobileBy;

public class AddExternalBankAccountComponent extends MobileFunctions{
	
	private By lblHeading = MobileBy.xpath("//*[@name='Add External Bank Account']");
	private By lnkLearnMore = MobileBy.xpath("//*[@name='Learn more']");
	private By btnNext = MobileBy.xpath("(//*[@name='Next'])[1]");
	
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
	}
	public void clickLearnMore() {
		click(lnkLearnMore, "Learn More");
	}
	public void clickNext() {
		click(btnNext, "Next");
	}
   public AddAccountsComponent addAccountsComponent() {
	   return new AddAccountsComponent();
   }
	
}
