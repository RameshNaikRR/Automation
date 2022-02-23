package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.AuthyComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class AdminUserDetailsPage extends BrowserFunctions {
	
	private By lblHeading = By.xpath("");
	private By lblName = By.xpath("");
	private By lblAcountID = By.xpath("");
	private By lnkChangePassword = By.xpath("");
	private By lblChangePasswordHeading = By.xpath("");
	private By lblChangePasswordDesc = By.xpath("");
	private By txtCurrentPassword = By.xpath("");
	private By txtNewPassword = By.xpath("");
	private By txtConfirmPassword = By.xpath("");
	private By iconEyeCurrentPassword = By.xpath("");
	private By iconEyeConfirmPassword = By.xpath("");
	private By iconEyeNewPassword = By.xpath("");
	private By lblGreenDot = By.xpath("");
	private By lblGreenDot1 = By.xpath(""); 
	private By lblRedDot = By.xpath("");
	private By btnSave = By.xpath("");
	private By lblPasswordSuccessMsgHeading = By.xpath("");
	private By lblPasswordSuccessMsgDesc = By.xpath("");
	private By btneditImage = By.xpath("");
	
	public By getUserDetails(String Type) {
		return By.xpath(String.format("//span[(contains(@class,'Admin') or contains(@class,'text')) and text()='%s']", Type)) ;
	}
	
	public void verifyPageHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", expHeading);
		}
	public void verifyName(String expName) {
		new CommonFunctions().verifyLabelText(lblName, "Name", expName);
	}
	public void verifyAccountId(String expId) {
		String actId = getAttributeValue(lblAcountID, "value", "Account Id");
		if(actId.equals(expId)) {
		 ExtentTestManager.setPassMessageInReport("Account Id is Matched");
		}
		else {
			ExtentTestManager.setFailMessageInReport("Account Id is not Matched");
		}
	}
	public void getPhoneNumer(String expPhoneNumber) {
		
		String str = getText(getUserDetails("Phone Number"),"Phone Number");
		//new CommonFunctions().verifyLabelTextContains(getUserDetails(Type), expPhoneNumber, "Phone Number");
		ExtentTestManager.setPassMessageInReport("Phone Number"+str);
	}
    public void getEmailAddress(String expexpEmailAddress) {
    	String str = getText(getUserDetails("Email Address"),"Email Address");
		//new CommonFunctions().verifyLabelTextContains(getUserDetails("Email Address"), expexpEmailAddress, "Email Adress");
		ExtentTestManager.setPassMessageInReport("Email Address"+str);
    }
    
    public void getEmployeeDept(String expEmployeeDept) {
    	String str = getText(getUserDetails("Employee Department"),"Employee Department");
		//new CommonFunctions().verifyLabelTextContains(getUserDetails("Employee Department"), expEmployeeDept, "Employee Department");
		ExtentTestManager.setPassMessageInReport("Employee Department"+str);
    }
    
    public void getPermission(String PermissionRole) {
    	String str = getText(getUserDetails("Permission Role"),"Permission Role");
		//new CommonFunctions().verifyLabelTextContains(getUserDetails("Permission Role"), expPermissionRole, "Employee Department");
		ExtentTestManager.setPassMessageInReport("Permission Role"+str);
    }	
    
    public void clickChangePassword() {
    	click(lnkChangePassword,"Change Password");
    }
    
    public AuthyComponent authyComponent() {
    	return new AuthyComponent();
    }
    
    public void verifyChangePasswordHeading() {
    	new CommonFunctions().elementView(lblChangePasswordHeading, "Change PAssword Heading");
    }
    
    public void verifyChangePasswordDescp() {
    	new CommonFunctions().elementView(lblChangePasswordDesc, "ChangePassword");
    }
    public void fillCurrentPassword(String expCurrentPassword) {
    	enterText(txtCurrentPassword, expCurrentPassword, "Current password");
    }
    public void fillNewPassword(String newPassword) throws InterruptedException {
		String[] inputs = { "H", "h", "qazwsxeh", "qazwsxedcrfv", "@", "1" };
		String[] messages = { "uppercase", "lowercase", "total characters", "total characters", "special character", "number" };
		for (int i = 0; i < inputs.length; i++) {
			enterText(txtNewPassword, inputs[i], "New Password");
			String text = "";
			if (inputs[i].length() >= 8) {
				 text = getText(lblGreenDot1, "Validation Dot");
			}else {
				text = getText(lblGreenDot, "Validation Dot");
			}
			if (text.toLowerCase().contains(messages[i])) {
				ExtentTestManager.setPassMessageInReport("Password field satisifies strength condition : " + text);
			} else {
				ExtentTestManager
						.setFailMessageInReport("Password field does not satisifies strength condition : " + text);
			}
//			new CommonFunctions().clearText(txtCreatePassword, "Create Password");
			
			clearText(txtNewPassword, "Create Password");
		}
		int initialRedDot = getElementsList(lblRedDot, "red dot").size();
		Thread.sleep(100);
		int initialGreenDot = getElementsList(lblGreenDot, "green dot").size();
		Thread.sleep(100);
		enterText(txtNewPassword, newPassword	, "Create Password");
		int finalRedDot = getElementsList(lblRedDot, "red dot").size();
		int finalGreenDot = getElementsList(lblGreenDot, "green dot").size();
		System.out.println("value: "+initialRedDot+" "+initialGreenDot+" "+finalRedDot+" "+finalGreenDot);
		if (initialGreenDot == finalRedDot && initialRedDot == finalGreenDot && finalRedDot == initialGreenDot
				&& finalGreenDot == initialRedDot) {
		String	NewPassword = getText(txtNewPassword, "CreatePassword");
			ExtentTestManager.setPassMessageInReport("password is valid");
		} else {
			ExtentTestManager.setFailMessageInReport("password is invalid");
		}
	}

    public void fillConfirmPassword(String expConfirmPassword) {
    	enterText(txtConfirmPassword, expConfirmPassword, "Current Phone Number");
    }
    public void clickEyeIconCurrentPassword() {
    	click(iconEyeCurrentPassword,"Icon Eye Current Password ");
    }
    public void clickEyeIconNewPassword() {
    	click(iconEyeNewPassword,"Icon Eye New Password");
    }
    public void clickEyeIconConfirmPassword() {
    	click(iconEyeConfirmPassword,"Icon Eye Confirm Password");
    }
    public void clickSave() {
        click(btnSave,"Save");
    }
    
    public void verifyPasswordUpadteSuccesMsg(String expPasswordMsgHeading) {
    	new CommonFunctions().verifyLabelText(lblPasswordSuccessMsgHeading, "Password upadte Message Heading", expPasswordMsgHeading);
    }
    
    public void verifyPasswordUpdateSucessDescp(String expPasswordUpdatDescp) {
    	new CommonFunctions().verifyLabelText(lblPasswordSuccessMsgDesc, "Password Update Description", expPasswordUpdatDescp);
    	
    }
    
    public void clickEditImage() {
    	click(btneditImage,"Edit Image");
    }
}
