package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.admin.components.PhoneEmailVerificationComponent;
import coyni.admin.components.SideBarComponent;
import coyni.admin.components.TopBarComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;

public class HomePage extends BrowserFunctions {
	
	private By lbluserName = By.xpath("//div[@class='header__circle-initials hover:underline hover:text-cgy4']");
	private By lnkUserDetails = By.xpath("//span[contains(text(),'User Details')]");
	private By lnkChangePassword = By.xpath("//span[contains(text(),'Change Password')]");
	private By heading = By.xpath("//span[text()='Verify Your Phone Number']");
	private By txtPhoneNumber= By.xpath("//input[@id='Phone_Number']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By headingTokenAccount = By.xpath("//span[text()='Token Account']");
			
	
	
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
		
		public void verifyHeading(String expHeading) {
			new CommonFunctions().verifyLabelText(heading, "Heading", expHeading);
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
		
		public PhoneEmailVerificationComponent phoneEmailVerificationComponent() {
			return new PhoneEmailVerificationComponent();
		}
		
		public void navigationTOSignUp(String expUrl) {
		DriverFactory.getDriver().navigate().to(expUrl);
		}
		
		public void fillNumber(String expPhoneNumber) {
			enterText(txtPhoneNumber, expPhoneNumber, "Phone Number");
		}
		
		public void clickNext() {
			click(btnNext, "Click Next");
		}
		
		public void verifyTokenAccountHeading(String expTokenAccountHeading) {
			new CommonFunctions().verifyLabelText(headingTokenAccount, "Heading is", expTokenAccountHeading);
		}

}
