package coyni.merchant.popups;

import org.openqa.selenium.By;


import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SaveChangePopUp extends BrowserFunctions {
	private By lblHeading = By.xpath("//h1[text()='Save Permission Role']");
	private By lblEndPointHeading=By.xpath("");
	private By lnkBack = By.xpath("//span[text()='No, go back']");
	private By btnYes = By.xpath("//button[text()='Yes']");
	private By btnCross = By.cssSelector(".self-end");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, expHeading);
	}
	public void verifyEndPointHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblEndPointHeading, expHeading, expHeading);
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
