package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class NoSignetAccountsExistPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='No Signet Accounts Exist']");
	private By lblDescription = By.xpath("//p[@class='mt-12 leading-6 text-center ']");
	private By btnAddSignet = By.xpath("//span[@class='label text-cgy3']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "No signet Accounts Exist Heading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Add New signet Account Heading", expDescription);
	}

	public void clickAddSignet() {
		click(btnAddSignet, "Click on Add Signet Account");
	}

	public AddNewSignetAccountPopup addNewSignetAccountPopup() {
		return new AddNewSignetAccountPopup();
	}

}
