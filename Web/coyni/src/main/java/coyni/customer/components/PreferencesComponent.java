package coyni.customer.components;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PreferencesComponent extends BrowserFunctions {
	
	private By drpDwnTimeZone = By.cssSelector("");
	
	private By drpDwnDefaultAccount =By.cssSelector("");
	
	private By txtLocalCurrency = By.cssSelector("");
	
	private By btnSave =By.cssSelector("");
	
	public void selectTimeZone(String timeZone) {
		click(drpDwnTimeZone, "time zone dropDown");
		new CommonFunctions().selectCustomDropDown(timeZone, "time Zone");
	}
	
	public void selectDefaultAccount(String defaultAccount) {
		click(drpDwnDefaultAccount, "default account dropDown");
		new CommonFunctions().selectCustomDropDown(defaultAccount, "default account");
	}
	
	public void verifyLocalCurrency(String expCurrency) {
		new CommonFunctions().verifyLabelText(txtLocalCurrency, "local currency", expCurrency);
	}

   public void clickSave() {
	   click(btnSave, "click save");
   }


}
