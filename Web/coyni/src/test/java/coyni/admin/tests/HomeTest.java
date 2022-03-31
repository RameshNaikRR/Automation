package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.AdminUserDetailsPage;
import coyni.admin.pages.HomePage;
import coyni.admin.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;


public class HomeTest {
	
    HomePage homePage;
	AdminUserDetailsPage adminUserDetailsPage;
	LoginPage loginPage;
	

	@BeforeTest
	public void init() {
		adminUserDetailsPage = new AdminUserDetailsPage();
		homePage = new HomePage();

	}
	
	public void testUserDetailsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			
		homePage.clickUserName();
		homePage.clickUserDetails();
		homePage.adminUserDetailsPage().verifyPageHeading(data.get("heading"));
		homePage.adminUserDetailsPage().verifyName();
		homePage.adminUserDetailsPage().verifyAccountId(data.get("expId"));
		homePage.adminUserDetailsPage().getPhoneNumer(data.get("expPhoneNumber"));
		homePage.adminUserDetailsPage().getEmailAddress(data.get("expEmailAddress"));
		homePage.adminUserDetailsPage().getEmployeeDept(data.get("expEmployeeDept"));
		homePage.adminUserDetailsPage().getPermission(data.get("permissionRole"));
		homePage.adminUserDetailsPage().clickChangePassword();
		homePage.adminUserDetailsPage().authyComponent().fillInput(data.get("code"));
		homePage.adminUserDetailsPage().verifyChangePasswordHeading();
		homePage.adminUserDetailsPage().verifyChangePasswordHeading();
		homePage.adminUserDetailsPage().clickEditImage();
		homePage.adminUserDetailsPage().accountProfileImagePopup().verifyAccountProfileImageHeading();
		homePage.adminUserDetailsPage().accountProfileImagePopup().uploadNewImage();
		homePage.adminUserDetailsPage().accountProfileImagePopup().cropYourImagePopup().verifyCropYourImageHeading();
		homePage.adminUserDetailsPage().accountProfileImagePopup().cropYourImagePopup().navigationComponent().clickBack();
		homePage.adminUserDetailsPage().accountProfileImagePopup().verifyAccountProfileImageHeading();
		homePage.adminUserDetailsPage().accountProfileImagePopup().navigationComponent().clickClose();
		homePage.adminUserDetailsPage().verifyPageHeading(data.get("heading"));
		
	}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("testUserDetailsView is failed due to "+ e);
		}
	}
	
	public void testUserDetailsChangePasswordWithValid(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickUserName();
			homePage.clickChangePassword();
			homePage.authyComponent().fillInput(data.get("code"));
			homePage.adminUserDetailsPage().verifyChangePasswordHeading();
			homePage.adminUserDetailsPage().verifyChangePasswordDescp();
			homePage.adminUserDetailsPage().fillCurrentPassword(data.get("expCurrentPassword"));
			homePage.adminUserDetailsPage().clickEyeIconCurrentPassword();
			homePage.adminUserDetailsPage().fillNewPassword(data.get("newPassword"));
			homePage.adminUserDetailsPage().clickEyeIconNewPassword();
			homePage.adminUserDetailsPage().fillConfirmPassword("expConfirmPassword");
			homePage.adminUserDetailsPage().clickEyeIconConfirmPassword();
			homePage.adminUserDetailsPage().clickSave();
			
	}
		catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("testUserDetailsChangePassword is failed due to "+ e);
		}
	
	}
	
	@Test // added
	@Parameters({ "strParams" })
	public void testUserDetailsChangePasswordInvalidCredentials(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickUserName();
			homePage.clickChangePassword();
			homePage.authyComponent().fillInput(data.get("code"));
			homePage.adminUserDetailsPage().verifyChangePasswordHeading();
			homePage.adminUserDetailsPage().verifyChangePasswordDescp();
			homePage.adminUserDetailsPage().fillCurrentPassword(data.get("expCurrentPassword"));
			homePage.adminUserDetailsPage().fillNewPassword(data.get("newPassword"));
			homePage.adminUserDetailsPage().fillConfirmPassword("expConfirmPassword");
			homePage.adminUserDetailsPage().clickTab();
            
			// customerProfilePage.changePasswordComponent().clickSave();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"));
//				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
//						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport(
					"test change password with invalis  credentials failed due to exception " + e);
		}
	}
	
	@Test // added
	@Parameters({ "strParams" })
	public void testUserDetailsEditProfileImage(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.clickUserName();
			homePage.clickUserDetails();
			homePage.adminUserDetailsPage().verifyPageHeading(data.get("heading"));
			homePage.adminUserDetailsPage().clickEditImage();
			homePage.adminUserDetailsPage().accountProfileImagePopup().verifyAccountProfileImageHeading();
			homePage.adminUserDetailsPage().accountProfileImagePopup().uploadNewImage();
			homePage.adminUserDetailsPage().accountProfileImagePopup().cropYourImagePopup().clickSelectYourImage();
			homePage.adminUserDetailsPage().accountProfileImagePopup().cropYourImagePopup().uploadSelectImage(strParams, strParams);
			homePage.adminUserDetailsPage().accountProfileImagePopup().cropYourImagePopup().clickSave();
		}
		
		catch(Exception e) {
			
		}
}
}
