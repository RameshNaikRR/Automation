package coyni.admin.Paymentcomponents;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class MerchantEditInviteComponent extends BrowserFunctions {

	private By lnkEditInvite = By.xpath("//div[text()='Edit Invite']");
	private By lblEditHeading = By.xpath("//h1[text()='Edit Merchant Invite']");
	private By lblContent = By.xpath("//p[contains(@class,'mx-4 mt-6 text-sm text-center text-cgy4')]");

	public void clickEditInvite() {
		click(lnkEditInvite, "Edit Invite");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEditHeading, "Edit Merchant Invite", expHeading);
	}

	public void verifyContent(String expHeading) {
		new CommonFunctions().verifyLabelText(lblContent, "Content", expHeading);
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public AddMerchantComponent addMerchantComponent() {
		return new AddMerchantComponent();
	}

}
