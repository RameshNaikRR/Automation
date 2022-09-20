package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.admin.components.ToastComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class ApproveCasePopup extends BrowserFunctions {
 
	private By heading = By.xpath("//h1[text()='Approve Case']");
	private By lblDescription = By.xpath("//p[contains(@class,'description-title')]");
	private By btnYes = By.xpath("//button[text()='Yes']");
	private By btnNoGoBack = By.xpath("//div[text()='No, go back']");
	
	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Heading");
	}
	
	public void verifyDescription() {
		new CommonFunctions().elementView(lblDescription, "Description");
	}
	
	public String verifyCaseNumber() {
		String str = getText(lblDescription, "Description");
		String str1 = str.replaceAll("[^0-9]", "");
		ExtentTestManager.setInfoMessageInReport("the case number is " + str1);
		return str1;
	}
	
	public void clickYes() {
		click(btnYes, "Yes");
	}
	
	public void clickNoGoBack() {
		click(btnNoGoBack, "No Go back");
	}
	
	public ToastComponent toastComponet() {
		return new ToastComponent();
	}
}
