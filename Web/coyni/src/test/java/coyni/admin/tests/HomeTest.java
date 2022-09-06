package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.UploadIMGComponent;
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
	UploadIMGComponent imgComponent;

	@BeforeTest
	public void init() {
		adminUserDetailsPage = new AdminUserDetailsPage();
		homePage = new HomePage();
		imgComponent = new UploadIMGComponent();
	}
	
	@Test // added
	@Parameters({ "strParams" })
	
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
	@Test // added
	@Parameters({ "strParams" })
	
	
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
			homePage.adminUserDetailsPage().fillConfirmPassword(data.get("expConfirmPassword"));
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
	
	@Test // added
	@Parameters({ "strParams" })
	public void testverifyYourPhoneNumberWithValid(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(5000);
			homePage.navigationTOSignUp(data.get("expUrl"));
			Thread.sleep(5000);
			homePage.verifyHeading(data.get("expHeading"));
			homePage.fillNumber(data.get("expPhoneNumber"));
			homePage.clickNext();
			Thread.sleep(3000);
			homePage.phoneEmailVerificationComponent().authyComponent().fillInput(data.get("code"));
			homePage.phoneEmailVerificationComponent().createPasswordPage().verifyPageHeading(data.get("heading"));
			homePage.phoneEmailVerificationComponent().createPasswordPage().fillCreatePassword(data.get("expCreatePassword"));
			homePage.phoneEmailVerificationComponent().createPasswordPage().fillConfirmPassword(data.get("expConfirmPassword"));
			homePage.phoneEmailVerificationComponent().createPasswordPage().clickCreate();
			Thread.sleep(2000);
			homePage.verifyTokenAccountHeading(data.get("expTokenAccountHeading"));
			}
        catch(Exception e) {
			ExtentTestManager.setFailMessageInReport("testverifyYourPhoneNumberWithInvalid i sfailed due to"+e);
		}
}

	@Test // added
	@Parameters({ "strParams" })
	public void uploadImg(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			imgComponent.clickUserName();
			imgComponent.clickUserDetails();
			imgComponent.clickEditUserImage();
			imgComponent.verifyHeading(data.get("accountProfileHeading"));
			imgComponent.clickUploadNewImage();
			//imgComponent.verifyHeadingsCrop(data.get("cropYourImageHeading"));
			Thread.sleep(2000);
			imgComponent.uploadSelectImage();//data.get("folderName"), data.get("fileName")
			Thread.sleep(2000);
			imgComponent.clickSave();
			imgComponent.toastComponent().verifyToast(data.get("title"), data.get("message"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testUserDetailsAddImage failed due to exception" + e);
		}
	}
	@Test // added
	@Parameters({ "strParams" })
	public void testRemoveUploadedImg(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			imgComponent.clickUserName();
			imgComponent.clickUserDetails();
			imgComponent.clickEditUserImage();
			imgComponent.verifyHeading(data.get("accountProfileHeading"));
			imgComponent.clickRemoveImg();
			imgComponent.verifyRemoveHeading(data.get("removeHeading"));
			imgComponent.verifyContent(data.get("content"));
			imgComponent.clickRemove();
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testUserDetails Remove failed due to exception" + e);
		}
	}
	
}
