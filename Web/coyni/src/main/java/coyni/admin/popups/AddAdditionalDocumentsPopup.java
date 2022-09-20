package coyni.admin.popups;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class AddAdditionalDocumentsPopup extends BrowserFunctions {

	private By heading = By.xpath("//h3[contains(text(),'Add Additional Documents')]");
	private By chkbx   = By.xpath("(//input[@type='checkbox'])[1]");
	private By btnAdd = By.xpath("//button[text()='Add']");
	
	
	public void verifyHeading() {
		new CommonFunctions().elementView(heading, "Heading is");
	}
	
	public void clickCheckBox() {
		click(chkbx,"CheckBox");
	}
	
	public void clickAdd() {
		click(btnAdd, "Add");
	}
	
	
	
}
