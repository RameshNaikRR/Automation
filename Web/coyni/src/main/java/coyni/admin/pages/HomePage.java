package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.admin.components.SideBarComponent;
import coyni.admin.components.TopBarComponent;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.web.actions.Navigation;

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
		
		public void navigationTOSignUp() {
			navigate(Navigation.valueOf("https://admin-qa.coyni.com/activate-account?code=UnFKclo5dVNTbTAzSG9EMzFjVEZwK3NKL1JwWmFvMk40NlFFcXVxb3JiZ2ZZNzZpYlZPR2RGbzVvM1Z2VXBYa2lyZnMvck0zbnBiaUMyTkJWYVN6NW1NRk5UZS9vVy8wSEgzU2U0R1NLcHBBWFJUUUp2dnZSUVE1VHJOeFYzRjR4UlA2MU5waUYwUi95OEJSTlRxejFKN1pZMjkwV0Y0WFR3PT0="));
		}

}
