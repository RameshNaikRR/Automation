package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.admin.components.SideBarComponent;
import coyni.admin.components.TopBarComponent;
import ilabs.WebFramework.BrowserFunctions;

public class HomePage extends BrowserFunctions {
	
	private By lbluserName = By.xpath("//div[@class='header__circle-initials hover:underline hover:text-cgy4']");
	private By lnkUserDetails = By.xpath("//span[contains(text(),'User Details')]");
	private By lnkChangePassword = By.xpath("//span[contains(text(),'Change Password')]");
	
	
	public SideBarComponent sideBarComponent() {
		return new SideBarComponent();
	}
	public TopBarComponent topBarComponent() {
		return new TopBarComponent();
	}
	
	public void clickUserName() {
		   click(lbluserName,"User Name");	
		}
		
		public void clickUserDetails() {
			click(lnkUserDetails,"User Details");
		}
		
		public AdminUserDetailsPage adminUserDetailsPage() {
			return new AdminUserDetailsPage();
		}
		
		public void clickChangePassword() {
			click(lnkChangePassword, "Change Password");
		}
		
		public AuthyComponent authyComponent() {
			return new AuthyComponent();
		}

}
