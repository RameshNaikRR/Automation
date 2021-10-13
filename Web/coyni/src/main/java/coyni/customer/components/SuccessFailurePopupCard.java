package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SuccessFailurePopupCard  extends BrowserFunctions{

	
	private By imgSuccessFailure = By.cssSelector("");
	
	private By lblMessage = By.cssSelector("");
	
	private By btnDone =By.cssSelector("");
	
	private By heading = By.cssSelector("");
	
	public void verifyImage(String expImage) {
		//
	}

	public void verifyMessge(String expMessage) {
		new CommonFunctions().verifyLabelText(lblMessage, "message", expMessage);
	}
	
	public void clickDone() {
		   click(btnDone, "click done");
	   }
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "autentication heading", expHeading);
	}




}
