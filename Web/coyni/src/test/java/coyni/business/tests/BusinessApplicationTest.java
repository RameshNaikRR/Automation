package coyni.business.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.business.components.SideBarMenuComponent;
import coyni.business.pages.RegistrationStartPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessApplicationTest {
	SideBarMenuComponent sideBarMenuComponent;
	RegistrationStartPage registrationStartPage;

	@BeforeTest
	public void init() {

		sideBarMenuComponent = new SideBarMenuComponent();
		registrationStartPage = new RegistrationStartPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessApplicationSideBarMenu(String strParams) {
		try {
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			sideBarMenuComponent.clickWallets();
			sideBarMenuComponent.clickPayments();
			sideBarMenuComponent.clickExports();
			sideBarMenuComponent.clickBusinessSettings();
			sideBarMenuComponent.clickGetHelp();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Business Application side bar menu failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessInformationView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(7000);
			// Company Information
			registrationStartPage.verifyHeading();
			registrationStartPage.verifyPageDescription(data.get("startPageDescription"));
			registrationStartPage.verifyBusinessApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickStartApplication();
			registrationStartPage.registrationCompanyInfoPage().verifyHeading(data.get("companyInfoHeading"));
			registrationStartPage.registrationCompanyInfoPage()
					.verifyPageDescription(data.get("companyInfoDescription"));
			Thread.sleep(2000);
			registrationStartPage.registrationCompanyInfoPage().fillCompanyName(data.get("companyName"));
			registrationStartPage.registrationCompanyInfoPage().clickBusinessEntityDropdown();
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity(data.get("businessEntity"));
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().fillSSN_EIN_TIN(data.get("ssn_ein_tin"));
			registrationStartPage.registrationCompanyInfoPage().fillBusinessStartDate(data.get("businessStartDate"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.verifyCountry(data.get("country"));

			// Doing as Business

//			registrationStartPage.registrationDBAPage().clickCheckBox();
			registrationStartPage.registrationDBAPage().fillDBAName(data.get("dbaName"));
			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillAddress1(data.get("address1"));
			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillAddress2(data.get("address2"));
			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillZipCode(data.get("zipcode"));
			registrationStartPage.registrationDBAPage().mailingAddressComponent().verifyCountry(data.get("country"));
			registrationStartPage.registrationCompanyInfoPage().clickExit();
			Thread.sleep(10000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBusinessInformation failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessInformationFieldValidations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(10000);
			registrationStartPage.verifyHeading();
			registrationStartPage.verifyBusinessApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickStartApplication();
			registrationStartPage.registrationCompanyInfoPage().verifyHeading(data.get("companyInfoHeading"));
			Thread.sleep(2000);
			registrationStartPage.registrationCompanyInfoPage().validateCompanyName(data.get("companyName"));
			registrationStartPage.registrationCompanyInfoPage().clickBusinessEntityDropdown();
			registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity(data.get("businessEntity"));
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().fillBusinessStartDate(data.get("businessStartPage"));
			registrationStartPage.registrationCompanyInfoPage().fillSSN_EIN_TIN(data.get("ssn_ein_tin"));
			registrationStartPage.registrationCompanyInfoPage().validateCompanyEmail(data.get("companyEmail"));
			// registrationStartPage.registrationCompanyInfoPage().validatePhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.validateAddress1(data.get("addressline1"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.validateAddress2(data.get("addressline2"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.validateCity(data.get("city"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.validateZipCode(data.get("zipCode"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBusinessInformationTextField failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessInformationWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(10000);
			registrationStartPage.verifyHeading();
			registrationStartPage.verifyBusinessApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickStartApplication();
			registrationStartPage.registrationCompanyInfoPage().verifyHeading(data.get("companyInfoHeading"));
			Thread.sleep(2000);
			registrationStartPage.registrationCompanyInfoPage().fillCompanyName(data.get("companyName"));
			registrationStartPage.registrationCompanyInfoPage().clickBusinessEntityDropdown();
			Thread.sleep(500);
			// registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity();
			registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity(data.get("businessEntity"));
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().fillSSN_EIN_TIN(data.get("ssn_ein_tin"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
//Doing as Business
			registrationStartPage.registrationDBAPage().fillDBAName(data.get("dbaName"));
			registrationStartPage.registrationDBAPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationDBAPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillZipCode(data.get("zipCode"));
			new CommonFunctions().clickOutSideElement();
			if (!data.get("errMsg").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("color"),
						data.get("elementName"));
			}
			new CommonFunctions().clickOutSideElement();
		} catch (Exception e) {
			ExtentTestManager
					.setFailMessageInReport("testBusinessInformationWithInvalidData failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBusinessInformation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(7000);
			// Company Information
			registrationStartPage.verifyHeading();
			registrationStartPage.verifyPageDescription(data.get("startPageDescription"));
			registrationStartPage.verifyBusinessApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickStartApplication();
			registrationStartPage.registrationCompanyInfoPage().verifyHeading(data.get("companyInfoHeading"));
			registrationStartPage.registrationCompanyInfoPage()
					.verifyPageDescription(data.get("companyInfoDescription"));
			Thread.sleep(2000);
			registrationStartPage.registrationCompanyInfoPage().fillCompanyName(data.get("companyName"));
			registrationStartPage.registrationCompanyInfoPage().clickBusinessEntityDropdown();
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().selectBusinessEntity(data.get("businessEntity"));
			Thread.sleep(500);
			registrationStartPage.registrationCompanyInfoPage().fillSSN_EIN_TIN(data.get("ssn_ein_tin"));
			registrationStartPage.registrationCompanyInfoPage().fillBusinessStartDate(data.get("businessStartDate"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationCompanyInfoPage().fillCompanyPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			registrationStartPage.registrationCompanyInfoPage().mailingAddressComponent()
					.verifyCountry(data.get("country"));

			// Doing as Business

			registrationStartPage.registrationDBAPage().clickCheckBox();
//			registrationStartPage.registrationDBAPage().fillDBAName(data.get("dbaName"));
//			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillAddress1(data.get("address1"));
//			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillAddress2(data.get("address2"));
//			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillCity(data.get("city"));
//			registrationStartPage.registrationDBAPage().mailingAddressComponent().fillZipCode(data.get("zipcode"));
//			registrationStartPage.registrationDBAPage().mailingAddressComponent().verifyCountry(data.get("country"));
			registrationStartPage.registrationCompanyInfoPage().clickNext();
			Thread.sleep(10000);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testBusinessInformation failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialsOwners(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			registrationStartPage.clickBusinessApplicationArrow();
			registrationStartPage.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(5000);
			registrationStartPage.registrationBeneficialOwnersPage().VerifyHeading(data.get("heading"));
			Thread.sleep(7000);
			String[] id = data.get("id").split(",");
			String[] expOwnerlabel = data.get("expOwnerLabels").split(",");
			String[] ownerName = data.get("ownerName").split(",");
			String[] ownerShipValue = data.get("ownerShip").split(",");
			String[] firstName = data.get("firstName").split(",");
			String[] lastName = data.get("lastName").split(",");
			String[] ownerShip = data.get("ownerShip").split(",");
			int i = 0;
			String num = Integer.toString(i + 1);
			int num1 = i;
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress1(data.get("addressline1"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillFirstName(data.get("firstName"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillLastName(data.get("lastName"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillDateOfBirth(data.get("dateOfBirth"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillSocialSecurityNum(data.get("ssn_ein_tin"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillOwnerShip(data.get("ownerShip"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress2(data.get("addressline2"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillEmail(data.get("email"));
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillPhoneNumber(data.get("phoneNum"));
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.selectState(data.get("state"), 0);
			Thread.sleep(6000);
			registrationStartPage.registrationBeneficialOwnersPage().selectID(id[i], num1);
			registrationStartPage.registrationBeneficialOwnersPage().uploadSelectImage(data.get("folderName"),
					data.get("fileName"));
			Thread.sleep(20000);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillCity(data.get("city"), 0);
			Thread.sleep(5000);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillZipCode(data.get("zipCode"));
			registrationStartPage.registrationBeneficialOwnersPage().clickSave();
			Thread.sleep(2000);
			registrationStartPage.registrationBeneficialOwnersPage().clickNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners  failed due to Exception " + e);
		}

	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialsOwnersWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			registrationStartPage.clickBusinessApplicationArrow();
			registrationStartPage.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(1000);
			registrationStartPage.registrationBeneficialOwnersPage().clickBeneficialOwners();
			Thread.sleep(3000);
//			 sideBarMenuComponent.registrationBeneficialOwnersPage().ClickDrpDwn();
			Thread.sleep(3000);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillFirstName(data.get("firstName"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillLastName(data.get("lastName"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillDateOfBirth(data.get("dateOfBirth"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillSocialSecurityNum(data.get("ssn_ein_tin"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillOwnerShip(data.get("ownerShip"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress1(data.get("addressline1"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress2(data.get("addressline2"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillEmail(data.get("email"));
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillPhoneNumber(data.get("phoneNum"));
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillCity(data.get("city"), 0);
			Thread.sleep(1000);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.selectState(data.get("state"), 0);
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillZipCode(data.get("zipCode"));
			registrationStartPage.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.verifyCountry(data.get("country"));
			new CommonFunctions().clickOutSideElement();
			if (!data.get("errMsg").isEmpty()) {
				Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);

				if (!data.get("elementName").equalsIgnoreCase("ownership")) {
					new CommonFunctions().validateFormErrorMessage(data.get("errMsg"), data.get("color"),
							data.get("elementName"));
				}
				if (data.get("elementName").equalsIgnoreCase("ownership")) {
					registrationStartPage.registrationBeneficialOwnersPage()
							.validateBeneificalOwnersError(data.get("errMsg"), data.get("elementName"));
				}
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners Negative Flow is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testBeneficialsOwnersWithNewContact(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(1000);
			registrationStartPage.registrationBeneficialOwnersPage().verifyPrimaryContact(data.get("primarycontact"));
			registrationStartPage.registrationBeneficialOwnersPage().ClickDrpDown();
			registrationStartPage.registrationBeneficialOwnersPage().fillFirstName(data.get("firstName"));
			registrationStartPage.registrationBeneficialOwnersPage().fillLastName(data.get("lastName"));
			registrationStartPage.registrationBeneficialOwnersPage().fillemail(data.get("emailAddress"));
			registrationStartPage.registrationBeneficialOwnersPage().fillPhone(data.get("phone"));
			registrationStartPage.registrationBeneficialOwnersPage().clickSave();
			registrationStartPage.registrationBeneficialOwnersPage().clickNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Beneficial Owners Contact Flow is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDocumentsUploadView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(1000);
			registrationStartPage.documentsUploadPage().verifyHeading(data.get("heading"));
			registrationStartPage.documentsUploadPage().verifyDescription(data.get("description"));
			registrationStartPage.documentsUploadPage().verifyArticlesOfCorporation(data.get("articlesOfCorporation"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().removeFile();
			registrationStartPage.documentsUploadPage().verifyCompanyW(data.get("company"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().removeFile();
			registrationStartPage.documentsUploadPage().verifyDbaFiling(data.get("dbafiling"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().removeFile();
			registrationStartPage.documentsUploadPage().verifyEINLetter(data.get("einletter"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().removeFile();
			registrationStartPage.documentsUploadPage().verifyAdditionalDocument(data.get("additionalDocument"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().removeFile();
			registrationStartPage.documentsUploadPage().clickExit();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Documents Upload is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testDocumentsUpload(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.clickContinueApplication();
			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			Thread.sleep(1000);
			registrationStartPage.documentsUploadPage().verifyHeading(data.get("heading"));
			registrationStartPage.documentsUploadPage().verifyDescription(data.get("description"));
			registrationStartPage.documentsUploadPage().verifyArticlesOfCorporation(data.get("articlesOfCorporation"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().verifyCompanyW(data.get("company"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().verifyDbaFiling(data.get("dbafiling"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().verifyEINLetter(data.get("einletter"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().verifyAdditionalDocument(data.get("additionalDocument"));
			registrationStartPage.documentsUploadPage().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			registrationStartPage.documentsUploadPage().clickNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Documents Upload is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAccountFeesandLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.accountFeesAndLimitsPage().verifyHeading(data.get("limitsHeading"));
			registrationStartPage.accountFeesAndLimitsPage().verifyDescription(data.get("description"));
			registrationStartPage.accountFeesAndLimitsPage().clickCheckBox();
			registrationStartPage.accountFeesAndLimitsPage().clickNext();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Documents Upload is failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAgreementsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.verifyHeading();
			registrationStartPage.verifyBusinessApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.agreementsPage().verifyHeading(data.get("heading"));
			registrationStartPage.agreementsPage().verifyAgreementsDescription(data.get("description"));
			registrationStartPage.agreementsPage().clickPrivacyPolicy();
			registrationStartPage.agreementsPage().scrollDownPrivacyPolicy();
			registrationStartPage.agreementsPage().clickCheckBox();
			registrationStartPage.agreementsPage().clickAgree();
			registrationStartPage.agreementsPage().clickTermsOfServices();
			registrationStartPage.agreementsPage().scrollDownTermsOfService();
			registrationStartPage.agreementsPage().clickCheckBox();
			registrationStartPage.agreementsPage().clickAgree();
			registrationStartPage.agreementsPage().clickNext();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Agreements failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testApplicationSubmissionView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			sideBarMenuComponent.clickBusinessApplicationArrow();
//			sideBarMenuComponent.clickContinueApplication();
//			sideBarMenuComponent.verifyBusinessApplicationTrackerView();
			registrationStartPage.verifyHeading();
			registrationStartPage.verifyBusinessApplicationView();
			registrationStartPage.getStatus();
			registrationStartPage.clickContinueApplication();
			registrationStartPage.applicationSubmissionPage().verifyHeading(data.get("heading"));
//			registrationStartPage.applicationSubmissionPage().verifyDescription(data.get("description"));
			registrationStartPage.applicationSubmissionPage().verifyAppStepHeading();
			registrationStartPage.applicationSubmissionPage().verifyAppSummary();
			registrationStartPage.applicationSubmissionPage().clickCheckBox();
			registrationStartPage.applicationSubmissionPage().SignOnSubmission(data.get("signature"));
			Thread.sleep(3000);
			registrationStartPage.applicationSubmissionPage().clickSubmit();
			registrationStartPage.applicationSummaryPage().verifyHeading(data.get("sumHeading"));
//			registrationStartPage.applicationSummaryPage().verifyDescription(data.get("sumDescription"));
			registrationStartPage.applicationSummaryPage().clickDone();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Application Submission  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testStatusApproved(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			{

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Application Submission  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testApplicationDeclined(String strParams) {
		try {
			registrationStartPage.applicationDecline().verifyHeading();
			registrationStartPage.applicationDecline().verifyDescription();
			registrationStartPage.applicationDecline().verifyMessageHeading();
			registrationStartPage.applicationDecline().verifyMessage();
			registrationStartPage.applicationDecline().verifyDeclineMessage();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Application Declined failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testApplicationAdditionalInfo(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			registrationStartPage.actionRequired().verifyHeading();
			registrationStartPage.actionRequired().verifyDescription();
			registrationStartPage.actionRequired().verifyMessageHeading();
			registrationStartPage.actionRequired().verifyMessage();
			registrationStartPage.actionRequired().uploadSelectImage(data.get("folderName"), data.get("fileName"));
			ExtentTestManager.setPassMessageInReport("Uploaded File");
			Thread.sleep(4000);
			registrationStartPage.actionRequired().clickSubmit();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Application Additional Information failed due to Exception " + e);
		}
	}
}
