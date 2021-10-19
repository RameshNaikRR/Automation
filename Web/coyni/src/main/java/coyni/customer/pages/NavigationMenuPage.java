package coyni.customer.pages;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class NavigationMenuPage extends BrowserFunctions {
	
	private By lnkExportFiles = By.cssSelector(".dashboard-menu-items>.icon-external");
	private By lnkGetHelp = By.cssSelector(".dashboard-menu-items>.icon-help");
	private By lblUserNameMenu = By.cssSelector(".internal-header__bolder>span");
	private By lblAccountId = By.cssSelector("span>small[class *= 'account-number']");
	private By lnkTokenAccount = By.cssSelector(" ");
	private By ImgQRcode = By.cssSelector(" ");
	private By lblUserNameHead = By.cssSelector(" ");
	private By ImgNotifications = By.cssSelector(" ");

    
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
   
//   public void CustomerMenuComponent customerMenuComponent() {
//	   return new CustomerMenuComponent();}
   //  public void MyQRCodeComponent myQRCodeComponent() {
    //	return new MyQRCodeComponent();}
    }
	   
   
	   
   
