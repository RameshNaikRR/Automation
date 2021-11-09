package coyni.customer.tests;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.customer.pages.HomePage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class HomeTest extends BrowserFunctions {

	HomePage homePage;

	@BeforeMethod
	public void init() {
		homePage = new HomePage();
	}

	@Test
	@Parameters({ "strParams" })

	public void testCreateAccountPage(String strParams) {
		try {
			Thread.sleep(2000);
			Map<String, String> homePageData = Runner.getKeywordParameters(strParams);
			homePage.verifyHomePageTitle(homePageData.get("pageTitle"));
			homePage.verifyHeading(homePageData.get("createAccount"));
			homePage.verifyHeading(homePageData.get("businessAccount"));
			homePage.verifyHeading(homePageData.get("logIn"));
			homePage.verifyCreateAccountText(homePageData.get("createAnAccount"));
			homePage.verifyPersonalAccountText(homePageData.get("personalAccount"));
			homePage.verifyBusinnesAccountText(homePageData.get("businessAccount"));
			homePage.clickPersonalAccount();
			homePage.verifyHeading(homePageData.get("createAPersonalAccount"));
			homePage.verifyHeading(homePageData.get("Please enter your name as it appear on official documents"));
			homePage.verifyFirstNameautoFoucsed();
			homePage.verifyTabNavigation();
			homePage.verifyFirstNameValidations(homePageData.get("singleCharacter"));
			homePage.verifyFirstNameValidations(homePageData.get("upto30Chracaters"));
			homePage.verifyFirstNameValidations(homePageData.get(""));
			homePage.verifyLastNameValidations(homePageData.get("singleCharacter"));
			homePage.verifyLastNameValidations(homePageData.get("upto30Chracaters"));
			homePage.verifyLastNameValidations(homePageData.get(""));
			homePage.phoneNumberValidations(homePageData.get("5346667543"));
			homePage.verifyUSnumberForformat(homePageData.get("USNumber"));
			homePage.verifyEmailAdressFiledwithReqcharc(homePageData.get("sixLetters"));
			homePage.verifyEmailAdressFiledwithReqcharc(homePageData.get("twoFiftyFiveLetters"));
			homePage.verifyEmailAdressFiledWithSpecialCharacters(homePageData.get("specialCharacters"));
			homePage.verifyCreatePasswordTextFiled(homePageData.get("CreatePassword"));
			homePage.verifyConfirmPasswordTextFiled(homePageData.get("ConfirmPassword"));
			homePage.verifyCreatePasswordAndConfirmPasswordShowIcons(homePageData.get("Show"));
			homePage.verifyPasswordFieldsverifyMaskedWithBlackCircles(homePageData.get("password"));
			homePage.clickOnPrivacyPolicy();
			homePage.clickOnTermsOfServices();
			homePage.clickOnNext();
			homePage.verifyHeading(homePageData.get("Phone Verification"));
			homePage.clickLogIn();
			homePage.verifyHeading(homePageData.get("Log In to Coyni"));

			if (!homePageData.get("invalidAttempts").isEmpty()) {
				homePage.validateRemainingAttempts(homePageData.get("invalidAttempts"));
			}
			if (!homePageData.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(homePageData.get("errMessage"));
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("CreatAccount Page is not loaded" + e);

		}

	}

}
