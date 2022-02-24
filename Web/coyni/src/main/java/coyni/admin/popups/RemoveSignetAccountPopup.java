package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RemoveSignetAccountPopup extends BrowserFunctions {
	public By lblHeading = By.xpath("//h1[text()='Remove Signet Account']");
	public By lblDescription = By.xpath("//p[@class='mt-12 text-sm leading-5 text-center text-cgy4']");
	public By btnRemove = By.xpath("//button[text()='Remove']");
	public By lblWalletID = By.xpath("//p[contains(text(), 'Signet Wallet ID')]/following-sibling::p");
	public By lblName = By.xpath("");
	public By lblAddSignet = By.xpath("//button[text()='Add Signet']");

	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Remove signet Account Heading", expHeading);
	}

	public void verifyPageDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "Add New signet Account Heading", expDescription);
	}

	public void verifyWalletIDView() {
		ExtentTestManager.setInfoMessageInReport("Wallet ID is " + getElement(lblWalletID, "Wallet ID"));
	}

	public void verifyName(String name) {
		new CommonFunctions().verifyLabelText(lblName, name, "Name");
	}

	public void clickRemove() {
		click(btnRemove, "Click on Remove");
	}

	public void clickAddSignet() {
		click(lblAddSignet, "Add Signet");
	}

}
