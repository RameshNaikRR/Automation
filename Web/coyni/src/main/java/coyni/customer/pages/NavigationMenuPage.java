package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.CustomerMenuComponent;
import coyni.customer.components.MyQRCodeComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class NavigationMenuPage extends BrowserFunctions {
	
	private By lnkExportFiles = By.cssSelector("");
	private By lnkGetHelp = By.cssSelector("");
	private By lblUserNameMenu = By.cssSelector("");
	private By lblAccountId = By.cssSelector("");
	private By lnkTokenAccount = By.cssSelector(" ");
	private By ImgQRcode = By.cssSelector(" ");
	private By lblUserNameHead = By.cssSelector(" ");
	private By ImgNotifications = By.cssSelector(" ");
	private By imgUser = By.cssSelector("");

    
	public void clickExportFilesMenu() {
		click(lnkExportFiles, "exports button");
		}

	 public void clickGetHelpMenu() {
		 click(lnkGetHelp, "help button");
	 }
   public String getUserName() {
	   return getText(lblUserNameMenu, "username");
   }
   public String  getAccountId() {
	   return getText(lblAccountId, "account Id").split("-")[1];
   }
   
   public void clickTokenAccountMenu() {
	   click(lnkTokenAccount, "TokenAccount");
   }
   public void clickQRcode() {
	   click(ImgQRcode, "QR code");
   }
   public void clickUserNameHead() {
	   click(lblUserNameHead, "UserNameHeading");
	   }
   public void clickNotifications() {
	   click(ImgNotifications, "ImageNotifications");
   }
   
     public  CustomerMenuComponent customerMenuComponent() {
      return new CustomerMenuComponent();}
      public  MyQRCodeComponent myQRCodeComponent() {
   	return new MyQRCodeComponent();}
  

public void verifyAccountIDView() {
	new CommonFunctions().elementView(lblAccountId, "Account ID");
} 

public void verifyUserImageView() {
	new CommonFunctions().elementView(imgUser, "User Image");
}
public void verifyQRCodeView() {
	new CommonFunctions().elementView(ImgQRcode, "QR code");
}
}
	   
   
	   
   
