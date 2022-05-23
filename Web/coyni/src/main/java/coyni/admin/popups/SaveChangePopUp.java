package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SaveChangePopUp extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Save Changes']");
	private By lblDescription = By.xpath("//span[text()='Are you sure you want to Save changes?']");
	private By lnkBack = By.xpath("//span[text()='No, go back']");
	private By btnYes = By.xpath("//button[text()='Yes']");
	private By btnCross = By.cssSelector(".self-end");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, expHeading);
	}

	public void verifyDescription(String expDescription) {
		new CommonFunctions().verifyLabelText(lblDescription, "expDescription", expDescription);
	}

	public void clickBack() {
		click(lnkBack, "Back");
	}

	public void clickYes() {
		click(btnYes, "Yes");
	}

	public void clickCross() {
		click(btnCross, "Cross");
	}

}
