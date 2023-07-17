package coyni.admin.Paymentpages;

import org.openqa.selenium.By;

import coyni.admin.MerchantServicescomponents.SideBarComponent;
import coyni.admin.Paymentcomponents.TopBarComponent;
import coyni.admin.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.api.reporting.ExtentTestManager;
import ilabs.api.utilities.FileHelper;

public class HomePage extends BrowserFunctions {

	private By lbluserName = By.xpath("//div[@class='header__circle-initials hover:underline hover:text-cgy4']");
	private By lblCustUserName = By.xpath("//span[contains(@class,'hover:underline')]");
	private By btnCustSignOut = By.xpath("//span[text()='Sign Out']/..");
	private By lnkUserDetails = By.xpath("//button[contains(text(),'User Details')]");
	private By lnkChangePassword = By.xpath("//button[contains(text(),'Change Password')]");
	private By heading = By.xpath("//span[text()='Verify Your Phone Number']");
	private By txtPhoneNumber = By.xpath("//input[@id='Phone_Number']");
	private By btnNext = By.xpath("//button[text()='Next']");
	private By headingTokenAccount = By.xpath("//span[text()='Token Account']");
	private By txtFirstName = By.id("first-name");
	private By txtLastName = By.id("last-name");
	private By lnkpersonalAccount = By.xpath("//div[contains(text(),'Personal Account')]");
	private By createHeading = By.xpath("//span[contains(text(),'Create a Personal Account')]");
	private By txtEmail = By.id("email-address");
	private By txtPhoneNumberCust = By.id("Phone_Number");
	private By txtCreatePassword = By.id("create-password");
	private By txtConfirmPassword = By.id("confirm-password");
	private By greendot = By.xpath("//span[@class='green-dot']/parent::span");
	private By greendot1 = By.xpath("(//span[@class='green-dot']/parent::span)[2]");
	private By chkBox = By.cssSelector(".custom-checkbox ");
	private By reddot = By.cssSelector(".red-dot");
	private By btnTwoStep = By.xpath("//button[text()='Two-Step Authentication']");//Verify Identity
	private By btnVerifyIdentity = By.xpath("//button[text()='Verify Identity']");
	private By lblTwoStep = By.xpath("//h1[text()='Two-Step Authentication']");
	private By lblTwoStepSucess = By.xpath("//h1[text()='Two-Step Authentication Success']");
	private By radioIdentification = By.xpath("(//input[@type='radio'])[1]");
	private By btnUpload = By.xpath("//input[@id='file']");
	private By btnSignOut = By.xpath("//button[text()='Sign Out']");
	private By btnSubmit = By.xpath("//button[text()='Submit']");
	private By btnLogin = By.xpath("//button[text()='Log In']");
	private By lblIdentificationSuccessful= By.xpath("//p[contains(text(),'Identity verification was successfully')]");
	private String CreatePassword;
	private String ConfirmPassword;
	private String FirstName;
	private String LastName;
	private String PhoneNumber;
	private String Email;
	
	
	public SideBarComponent sideBarComponent() {
		return new SideBarComponent();
	}

	public TopBarComponent topBarComponent() {
		return new TopBarComponent();
	}



	public void clickUserDetails() {
		click(lnkUserDetails, "User Details");
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
	
	public void clickCustUserName() {
		click(lblCustUserName, "Customer USer Name");
	}

	public void clickCustSignOut() {
		click(btnCustSignOut, "Customer Sign Out");
	}
	
	public AuthyComponent authyComponent() {
		return new AuthyComponent();
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


	
	//Customer sign up flow for Under writings
	
	public void fillFirstName(String firstName) {
		enterText(txtFirstName, firstName, "firstName");
		FirstName = getText(txtFirstName, "First Name");
	}

	public void fillLastName(String lastName) {
		enterText(txtLastName, lastName, "lastName");
		LastName = getText(txtLastName,"Last Name");
	}

	public void fillEmail(String userName) {
		enterText(txtEmail, userName, "Email");
		Email = getText(txtEmail, "Email");
	}

	public void fillPhoneNumber(String PhoneNumber) {
		enterText(txtPhoneNumber, PhoneNumber, "PhoneNumber");
		PhoneNumber = getText(txtPhoneNumber,  "Phone Number");
	}

	public void fillCreatePassword(String createPassword) throws InterruptedException {
		String[] inputs = { "H", "h", "qazwsxeh", "qazwsxedcrfv", "@", "1" };
		String[] messages = { "uppercase", "lowercase", "total characters", "total characters", "special character", "number" };
		for (int i = 0; i < inputs.length; i++) {
			enterText(txtCreatePassword, inputs[i], "Create Password");
			String text = "";
			if (inputs[i].length() >= 8) {
				 text = getText(greendot1, "Validation Dot");
			}else {
				text = getText(greendot, "Validation Dot");
			}
			if (text.toLowerCase().contains(messages[i])) {
				ExtentTestManager.setPassMessageInReport("Password field satisifies strength condition : " + text);
			} else {
				ExtentTestManager
						.setFailMessageInReport("Password field does not satisifies strength condition : " + text);
			}
//			new CommonFunctions().clearText(txtCreatePassword, "Create Password");
			
			clearText(txtCreatePassword, "Create Password");
		}
		int initialRedDot = getElementsList(reddot, "red dot").size();
		Thread.sleep(100);
		int initialGreenDot = getElementsList(greendot, "green dot").size();
		Thread.sleep(100);
		enterText(txtCreatePassword, createPassword, "Create Password");
		int finalRedDot = getElementsList(reddot, "red dot").size();
		int finalGreenDot = getElementsList(greendot, "green dot").size();
		System.out.println("value: "+initialRedDot+" "+initialGreenDot+" "+finalRedDot+" "+finalGreenDot);
		if (initialGreenDot == finalRedDot && initialRedDot == finalGreenDot && finalRedDot == initialGreenDot
				&& finalGreenDot == initialRedDot) {
			CreatePassword = getText(txtCreatePassword, "CreatePassword");
			ExtentTestManager.setPassMessageInReport("password is valid");
		} else {
			ExtentTestManager.setFailMessageInReport("password is invalid");
		}
	}

	public void fillConfirmPassword(String confirmPassword) {
		enterText(txtConfirmPassword, confirmPassword, "Confirm Password");
		ConfirmPassword = getText(txtConfirmPassword, "Confirm Password");
	}
	
	public void clickCheckBox() {
	    click(chkBox, "CheckBox");
	  }
    public void clickPersonalAccount() {
	    click(lnkpersonalAccount, "Link Personal ");
	}
    
    public void verifyCreateAccountPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(createHeading, "Create Personal account Heading", expHeading);
	}
    
    public void clickNextCust() {
		if (getElement(btnNext, "Enabled").isEnabled()) {
			click(btnNext, "Next");
		} else {
			ExtentTestManager.setPassMessageInReport("Next button is Disabled");
		}
	}
    
    public void clickTwoStepAuthentication() {
    	click(btnTwoStep,"TwoStep Authentication");
    }
    
    public void verifyTwoStepHeading () {
    	new CommonFunctions().elementView(lblTwoStep, "Two Step");
    }
    
    public void verifyTwoStepSucessHeading() {
    	new CommonFunctions().elementView(lblTwoStepSucess, "Two step Authentication Sucess");
    }
    
    public void clickVerifyIdentity() {
    	click(btnVerifyIdentity, "Verify Identity");
    }
    
    public void selectidentifcation() {
    	click(radioIdentification, "Identification");
    }
    
        
    public void uploadDocument(String folderName,String fileName) {
		getElement(btnUpload, "select Image").sendKeys(FileHelper.getFilePath(folderName,fileName));
	}
    
    
    public void clickSubmit() {
    	
    	click(btnSubmit, "Submit");
    }
    
    public void clickSignOut() {
    	click(btnSignOut, "Sign Out");
    }
    
    public void clickLogin() {
    	click(btnLogin, "Log In");
    }
     
    public void verifyIdetification() {
    	new CommonFunctions().elementView(lblIdentificationSuccessful, "Identification Successfull");
    }
    
    public LoginPage loginPage() {
    	return new LoginPage();
    }
    
    public CommissionAccountPage commissionAccountPage() {
    	return new CommissionAccountPage();
    }
		
}