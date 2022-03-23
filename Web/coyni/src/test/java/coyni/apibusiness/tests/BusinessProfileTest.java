package coyni.apibusiness.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.apibusiness.components.AuthyComponent;
import coyni.apibusiness.pages.ChangePasswordPage;
import coyni.apibusiness.pages.TokenWalletPage;
import coyni.customer.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessProfileTest {
	TokenWalletPage tokenWalletPage;

	@BeforeTest
	public void init() {
		tokenWalletPage = new TokenWalletPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePassword(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			
			tokenWalletPage.topBarComponent().clickUserName();
			tokenWalletPage.topBarComponent().clickChangePassword();
			tokenWalletPage.topBarComponent().authyComponent().verifyPageHeading(data.get("identityHeading"));
			tokenWalletPage.topBarComponent().authyComponent().verifyPageDescription(data.get("identityDescription"));
			tokenWalletPage.topBarComponent().authyComponent().fillInput(data.get("code"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().verifyPageHeading(data.get("changePasswordHeading"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage()
					.VerifyPageDescription(data.get("changePasswordDescription"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconCurrentPassword();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().verifyNewPassword(data.get("newPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconNewPassowrd();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().fillConfirmPassword(data.get("confirmPassword"));
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickEyeIconConfirmPassword();
			tokenWalletPage.topBarComponent().authyComponent().changePasswordPage().clickSave();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test change password failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			// APIAdminMenuComponent.clickUserName();
//			tokenWalletPage.topBarComponent().clickUserName();
//			tokenWalletPage.topBarComponent().clickChangePassword();
//			tokenWalletPage.topBarComponent().verifyYourIdentityPage().verifyPageHeading(data.get("identityHeading"));
//			tokenWalletPage.topBarComponent().verifyYourIdentityPage()
//					.verifyPageDescription(data.get("identityDescription"));
//			tokenWalletPage.topBarComponent().verifyYourIdentityPage().fillpin(data.get("code"));
//			tokenWalletPage.topBarComponent().changePasswordPage().verifyPageHeading(data.get("changePasswordHeading"));
//			tokenWalletPage.topBarComponent().changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
//			tokenWalletPage.topBarComponent().changePasswordPage().fillNewPassword(data.get("newPassword"));
//			tokenWalletPage.topBarComponent().changePasswordPage().fillConfirmPassword(data.get("confirmPassword"));
//			tokenWalletPage.topBarComponent().changePasswordPage().clickOutSide();

			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordWithInvalidData failed due to exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testChangePasswordView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
//			tokenWalletPage.topBarComponent().clickUserName();
//			tokenWalletPage.topBarComponent().clickChangePassword();
//			tokenWalletPage.topBarComponent().verifyYourIdentityPage().verifyPageHeading(data.get("identityHeading"));
//			tokenWalletPage.topBarComponent().verifyYourIdentityPage()
//					.verifyPageDescription(data.get("identityDescription"));
//			tokenWalletPage.topBarComponent().verifyYourIdentityPage().fillpin(data.get("code"));
//			tokenWalletPage.topBarComponent().changePasswordPage().verifyPageHeading(data.get("changePasswordHeading"));
//			tokenWalletPage.topBarComponent().changePasswordPage().fillCurrentPassword(data.get("currentPassword"));
//			tokenWalletPage.topBarComponent().changePasswordPage().clickEyeIconCurrentPassword();
//			Thread.sleep(1000);
//			tokenWalletPage.topBarComponent().changePasswordPage().verifyCurrentPasswordMaskedView();
//			tokenWalletPage.topBarComponent().changePasswordPage().clickEyeIconCurrentPassword();
//			Thread.sleep(1000);
//			tokenWalletPage.topBarComponent().changePasswordPage().verifyCurrentPasswordMaskedView();
//			tokenWalletPage.topBarComponent().changePasswordPage().fillNewPassword(data.get("newPassword"));
//			tokenWalletPage.topBarComponent().changePasswordPage().clickEyeIconNewPassowrd();
//			Thread.sleep(1000);
//			tokenWalletPage.topBarComponent().changePasswordPage().verifyNewPasswordMaskedView();
//			tokenWalletPage.topBarComponent().changePasswordPage().clickEyeIconNewPassowrd();
//			Thread.sleep(1000);
//			tokenWalletPage.topBarComponent().changePasswordPage().verifyNewPasswordMaskedView();
//			tokenWalletPage.topBarComponent().changePasswordPage().fillConfirmPassword(data.get("confirmPassword"));
//			tokenWalletPage.topBarComponent().changePasswordPage().clickEyeIconConfirmPassword();
//			Thread.sleep(1000);
//			tokenWalletPage.topBarComponent().changePasswordPage().verifyConfirmPasswordMaskedView();
//			tokenWalletPage.topBarComponent().changePasswordPage().clickEyeIconConfirmPassword();
//			Thread.sleep(1000);
//			tokenWalletPage.topBarComponent().changePasswordPage().verifyConfirmPasswordMaskedView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testChangePasswordView failed due to exception " + e);
		}
	}

}
