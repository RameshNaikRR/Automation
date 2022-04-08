     	package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SuccessFailureComponent extends BrowserFunctions {

	private By lblBankAddedSuccesful = By.xpath("//h1[contains(text(),'Bank Account Added')]");
	private By lblRemovedSuccesful = By.xpath("");
	
	public void verifyBankAddSuccesfulHeaading() {
		new CommonFunctions().elementView(lblBankAddedSuccesful, "Bank Added Succesful");
	}
	
	public void verifyPaymnetRemovedSuccessfulHeading(String expRemovedheading) {
		new CommonFunctions().verifyLabelText(lblRemovedSuccesful, " Remove sucessful", expRemovedheading);
	}
	
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
		
	
}