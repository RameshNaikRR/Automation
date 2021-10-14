package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SuccessFailurePopupCardComponent  extends BrowserFunctions{

	
	private By imgSuccessFailure = By.cssSelector("");
	
	private By lblMessage = By.cssSelector("");
	
	private By btnDone =By.cssSelector("");
	
	private By heading = By.cssSelector("");
	
	
	//DOUBT
	public void verifyImage(String expImage) {
		new CommonFunctions().verifyLabelText(imgSuccessFailure, "expImage", expImage);
	}

	public void verifyMessge(String expMessage) {
		new CommonFunctions().verifyLabelText(lblMessage, "Message", expMessage);
	}
	
	public void clickDone() {
		   click(btnDone, "Click Done");
	   }
	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(heading, "Autentication Heading", expHeading);
	}




}
