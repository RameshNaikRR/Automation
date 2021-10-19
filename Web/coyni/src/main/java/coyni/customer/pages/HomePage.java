package coyni.customer.pages;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class HomePage extends BrowserFunctions {
	 private By lnkPersonalAccount = By.name("");
	 private By lnkBusinessAccount = By.name("");
	 private By lnkSignIn = By.name(" ");
	 private By heading = By.name("");
	 
	  public void clickPersonalAccount() {
		  click(lnkPersonalAccount, "PersonalAccount");
		  }
	  public void clickBusinessAccount() {
		  click(lnkBusinessAccount, "BusinessAccount");
		  }
	  public void clickSignIn() {
		  click(lnkSignIn, "SignIn");
		    }
	 
	  public void verifyHeading(String expHeading) {
	//  new CommonFunctions().verifyLabelText(heading, "autentication heading", expHeading);
	  }


	  
	

}
