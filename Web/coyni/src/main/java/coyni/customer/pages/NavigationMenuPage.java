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
	private By drpDwnAccount =By.cssSelector("");
	private By lnkPersonalAccount =By.cssSelector("");
	private By lnkBusinessAccount = By.cssSelector("");
	private By lblBusinessAccount = By.cssSelector("");
	private By lnkAddNewBusiness = By.cssSelector("");
	private By lblTokenAccount = By.cssSelector("");
	private By lblExportFiles = By.cssSelector("");
	private By lblGetHelp = By.cssSelector("");
    
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
  
public void verifyAccountHolderNameView() {
	new CommonFunctions().elementView(lblUserNameHead, "Account Holder Name");
}
public void verifyAccountIDView() {
	new CommonFunctions().elementView(lblAccountId, "Account ID");
} 
public void verifyAccountID(String expAccountID) {
	new CommonFunctions().verifyLabelText(lblAccountId, "Account ID",expAccountID);
}

public void verifyUserImageView() {
	new CommonFunctions().elementView(imgUser, "User Image");
}
public void verifyQRCodeView() {
	new CommonFunctions().elementView(ImgQRcode, "QR code");
}
public void clickAccountDropdwn() {
	click(drpDwnAccount, "Account Dropdown");
	
}
public void verifyPersonalAccountView() {
	new CommonFunctions().elementView(lnkPersonalAccount, "Personal Account ");
}

public void verifyBusinessAccountView() {
	new CommonFunctions().elementView(lnkBusinessAccount, "Business Account ");
}
public void verifyAddNewBusinessAccountView() {
	new CommonFunctions().elementView(lnkAddNewBusiness, "Add New Business");
}
public void verifyAddNewBusinessAccountLabel(String expMessage) {
	new CommonFunctions().verifyLabelText(lblBusinessAccount, "Message", expMessage);
}

public void verifyTokenAccountView() {
	new CommonFunctions().elementView(lnkTokenAccount, "Token Account");
}
public void verifyExportFilesView() {
	new CommonFunctions().elementView(lnkExportFiles, "Export Files");
}
public void verifyGetHelpView() {
	new CommonFunctions().elementView(lnkGetHelp, "Get Help");
}
public void verifyTokenAccountHeadingView() {
	new CommonFunctions().elementView(lblTokenAccount, "Token Account ");
}
public void verifyExportFilesHeadingView() {
	new CommonFunctions().elementView(lblExportFiles, "Export Files ");
}
public void verifyGetHelpHeadingView() {
	new CommonFunctions().elementView(lblGetHelp, "Get Help ");
}
}
	   
   
	   
   
