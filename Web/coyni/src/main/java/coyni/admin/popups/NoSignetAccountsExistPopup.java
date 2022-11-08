package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class NoSignetAccountsExistPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='No Cogent Accounts Exist']");
	private By lblDescription = By.xpath("//p[@class='mt-12 leading-6 text-center ']");
	private By btnAddCogent = By.xpath("//p[contains(@class,'label text-cgy3')]");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "No Cogent Accounts Exist", expHeading);
	}
	
	public int getLabelsize() {
		return getElementsList(lblHeading, "").size();
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Add New signet Account Heading", expDescription);
	}

	public void clickAddSignet() {
		click(btnAddCogent, "Click on Add Cogent Account");
	}

	public AddNewSignetAccountPopup addNewSignetAccountPopup() {
		return new AddNewSignetAccountPopup();
	}

}
