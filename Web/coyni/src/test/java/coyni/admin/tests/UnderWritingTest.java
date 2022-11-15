package coyni.admin.tests;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.UnderWritingPersonalComponent;
import coyni.admin.pages.HomePage;
import coyni.admin.pages.LoginPage;
import coyni.admin.pages.MerchantRegistrationPage;
import coyni.merchant.components.SideMenuBarComponent;
import coyni.merchant.pages.RegistrationStartPage;
import coyni.merchant.pages.SignupPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.DriverFactory;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class UnderWritingTest {

	HomePage homePage;
	LoginPage loginPage;
	MerchantRegistrationPage merchantregistrationpage;
	UnderWritingPersonalComponent underwritingpersonalcomponent;
	RegistrationStartPage registrationStartPage;
	SideMenuBarComponent sideMenuBarComponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		loginPage =new LoginPage();
		merchantregistrationpage = new MerchantRegistrationPage();	
		underwritingpersonalcomponent = new UnderWritingPersonalComponent();
		registrationStartPage = new RegistrationStartPage();
		sideMenuBarComponent = new SideMenuBarComponent();

	}

	@Test
	@Parameters({ "strParams" })
	public void testUnderWritingTest(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().clickUnderWriting();
			homePage.sideBarComponent().clickPersonal();
			homePage.sideBarComponent().underWritingPersonalComponent().verifyHeading();
			homePage.sideBarComponent().underWritingPersonalComponent().clickNew();
			String caseID=homePage.sideBarComponent().underWritingPersonalComponent().verifyCaseID();
			String date=homePage.sideBarComponent().underWritingPersonalComponent().verifyDate();
			String customerId=homePage.sideBarComponent().underWritingPersonalComponent().verifyCustomerID();
			String caseStatus=homePage.sideBarComponent().underWritingPersonalComponent().verifyCaseStatus();
			String dueDate=homePage.sideBarComponent().underWritingPersonalComponent().verifyDueDate();
			homePage.sideBarComponent().underWritingPersonalComponent().clickCustomer();
			Thread.sleep(2000);
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyHeading();
			String caseDetailsCaseID= homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyCaseId();
			String caseDetailscaseStatus=homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyCaseStatus();
			String caseDetailsCaseDate = homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyDate();
			
			String caseDetailsCustomerID =homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyCustomerID();
			String caseDetailsDueDate =homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyDueDate();
			
			if(caseID.equals(caseDetailsCaseID)) {
				ExtentTestManager.setPassMessageInReport("Case ID is Matched");
			}
			else {
				ExtentTestManager.setInfoMessageInReport("Case Id is not Matched");
			}
			
			if(date.equals(caseDetailsCaseDate)) {
				ExtentTestManager.setPassMessageInReport("Date is Matched");
			}
			else {
				ExtentTestManager.setInfoMessageInReport("Date is not Matched");
			}
			
			if(customerId.equals(caseDetailsCustomerID)) {
				ExtentTestManager.setPassMessageInReport("Customer Id is Matched");
			}
			else {
				ExtentTestManager.setInfoMessageInReport("Customer Id is not Matched");
			}
			
			if(caseStatus.equals(caseDetailscaseStatus)) {
				ExtentTestManager.setPassMessageInReport("Case status is Matched");
			}
			else {
				ExtentTestManager.setInfoMessageInReport("Case status is not Matched");
			}
			
			if(dueDate.equals(caseDetailsDueDate)) {
				ExtentTestManager.setPassMessageInReport("Due Date is Matched");
			}
			else {
				ExtentTestManager.setInfoMessageInReport("Due Date is not Matched");
			}
			
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyDateOfBirth(data.get("dateOfBirth"));
//			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifySSNNumber(data.get("SSNNumber"));
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyPhoneNumber(data.get("phoneNumber"));
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyEmail(data.get("emailCustm"));;
		//	homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyDownloadDriversLicense();
			Thread.sleep(2000);
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().clickAssignee();
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyListofAssignes();
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().selectAssigneName();
			homePage.clickUserName();
			homePage.clickSignOut();
			
			
			
			


		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testUnderWritingTest Failed due to Exception " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testAssigneLogin(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
		//	new CommonFunctions().switchtoUrl(data.get("urlAdmin"));
			loginPage.verifyPageHeading(data.get("loginHeading"));
			//loginPage.verifyPageDescription(data.get("loginDescription"));
			loginPage.fillEmail(data.get("assigneEmail"));
			loginPage.fillPassword(data.get("assingepassword"));
			loginPage.clickNext();
			loginPage.authyComponent().verifyPageHeading(data.get("authyHeading"));
			//loginPage.authyComponent().verifyPageDescription(data.get("authyDescription"));
			// loginPage.authyComponent().fillAuthyInput(data.get("securityKey"));
			loginPage.authyComponent().fillInput(data.get("code"));
			//loginPage.authyComponent().verifyMessage(data.get("message"));
			Thread.sleep(2000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testAddRequiredDocuments(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickUnderWriting();
			homePage.sideBarComponent().clickPersonal();
			homePage.sideBarComponent().underWritingPersonalComponent().verifyHeading();
		    homePage.sideBarComponent().underWritingPersonalComponent().clickInReview();
		    homePage.sideBarComponent().underWritingPersonalComponent().clickCustomer();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyHeading();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().clickHide();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().clickAddNewTask();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().addAdditionalDocumentsPopup().verifyHeading();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().addAdditionalDocumentsPopup().clickCheckBox();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().addAdditionalDocumentsPopup().clickAdd();
		    if (!data.get("toastMessage").isEmpty()) {
				loginPage.toastComponent().verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}
			Thread.sleep(2000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}
	
	
	@Test
	@Parameters({ "strParams" })
	public void testAssigneDirectApprove(String strParams) {
		try {
		//	Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickUnderWriting();
			homePage.sideBarComponent().clickPersonal();
			homePage.sideBarComponent().underWritingPersonalComponent().verifyHeading();
			
		    homePage.sideBarComponent().underWritingPersonalComponent().clickInReview();
		    homePage.sideBarComponent().underWritingPersonalComponent().clickCustomer();
		    String str = homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyCaseIDNumber(); 
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyHeading();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().clickApprove();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().approveCasePopup().verifyHeading();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().approveCasePopup().verifyDescription();
		    String str1 = homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().approveCasePopup().verifyCaseNumber();
		    if(str.equals(str1)) {
		    	ExtentTestManager.setPassMessageInReport("Case ID is matched");
		    }
		    else {
		    	ExtentTestManager.setWarningMessageInReport("Case ID is not matched");
		    }
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().approveCasePopup().clickYes();
		    Thread.sleep(5000);
		    homePage.clickUserName();
		    Thread.sleep(5000);
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().approveCasePopup().toastComponet().navigationComponent().clickClose();
		    homePage.clickSignOut();
		    

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}
	
	
	@Test
	@Parameters({ "strParams" })
	public void testIdentifivericationSuccesfull(String strParams) {
		try {
		//	Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.verifyIdetification();
			ExtentTestManager.setPassMessageInReport("Idetification Sucessfull");
		
		    

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testcreateMerchantAccount(String strParams) {
		try {
			WebDriver driver = DriverFactory.getDriver();
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			underwritingpersonalcomponent.openMerchantPortal();
			underwritingpersonalcomponent.switchToYopmailWindow();
			
			loginPage.clickSignUp();
			merchantregistrationpage.clickMerchantAccount();
			merchantregistrationpage.fillFirstName(data.get("firstName1"));
			merchantregistrationpage.fillLastName(data.get("lastName1"));
			merchantregistrationpage.fillPhoneNumber(data.get("phoneNumber1"));
			merchantregistrationpage.fillEmail(data.get("email1"));
			Thread.sleep(1000);
			merchantregistrationpage.fillCreatePassword(data.get("createPassword1"));
			merchantregistrationpage.fillConfirmPassword(data.get("confirmPassword1"));
			merchantregistrationpage.clickNext();
			merchantregistrationpage.phoneVerificationComponent().verifyHeading(data.get("verificationHeading1"));
			merchantregistrationpage.phoneVerificationComponent().verifyPhoneNumber();
			merchantregistrationpage.phoneVerificationComponent().fillpin(data.get("code1"));
			merchantregistrationpage.phoneVerificationComponent().emailVerificationComponent()
					.verifyEmailHeading(data.get("emailHeading1"));
			merchantregistrationpage.phoneVerificationComponent().emailVerificationComponent().fillpin(data.get("code1"));

//			merchantregistrationpage.scrollDownTermsOfService();
//			merchantregistrationpage.clickOnCheckBox();
//			merchantregistrationpage.clickNext();
//			merchantregistrationpage.scrollDownPrivacyPolicy();
//
//			merchantregistrationpage.PrivacyPolicyUpdate();
//			merchantregistrationpage.TermsOfServiceUpdate();
//
//			merchantregistrationpage.phoneVerificationComponent().emailVerificationComponent()
//					.verifyAccountCreated(data.get("createdAccountHeading1"));

			Thread.sleep(60000);
			
			
//			registrationStartPage.verifyHeading(data.get("startPageHeading"));
//			registrationStartPage.verifyPageDescription(data.get("startPageDescription"));
//			registrationStartPage.verifyMerchantApplicationView();
//			registrationStartPage.getStatus();
			registrationStartPage.clickStartApplication();
			Thread.sleep(4000);

			// sideMenuBarComponent.verifyColor(data.get("expColor"));
			registrationStartPage.registrationCompanyInfoPage().verifyCompanyInformation();
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
			registrationStartPage.registrationCompanyInfoPage().uploadDocument(data.get("folderName"),
					data.get("fileName"), data.get("businessEntity"));

			registrationStartPage.registrationCompanyInfoPage().clickNext();
			Thread.sleep(10000);
			registrationStartPage.registrationCompanyInfoPage().verifyDBAInformation();
			Thread.sleep(3000);
			registrationStartPage.registrationCompanyInfoPage().verifyCompanyInformation();

			Thread.sleep(10000);
			registrationStartPage.registrationDBAInformationPage().verifyHeading(data.get("dbaHeading"));
			registrationStartPage.registrationDBAInformationPage().clickNo();
			Thread.sleep(10000);
			registrationStartPage.registrationDBAInformationPage().fillDBAName(data.get("dbaName"));
			registrationStartPage.registrationDBAInformationPage().selectBusinessType(data.get("businessType"));
			registrationStartPage.registrationDBAInformationPage().clickRetailLocation();
			registrationStartPage.registrationDBAInformationPage().fillCompanyEmail(data.get("companyEmail"));
			registrationStartPage.registrationDBAInformationPage().fillPhoneNumber(data.get("companyPhoneNumber"));
			registrationStartPage.registrationDBAInformationPage().fillWebsite(data.get("website"));
			registrationStartPage.registrationDBAInformationPage()
					.fillMonthlyProcessingVolume(data.get("monthlyProcessingVolume"));
			registrationStartPage.registrationDBAInformationPage().fillHighTicket(data.get("highTicket"));
			registrationStartPage.registrationDBAInformationPage().fillAverageTicket(data.get("averageTicket"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.fillAddress1(data.get("addressline1"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.fillAddress2(data.get("addressline2"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent().fillCity(data.get("city"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.selectState(data.get("state"));
			registrationStartPage.registrationDBAInformationPage().mailingAddressComponent()
					.fillZipCode(data.get("zipCode"));
			registrationStartPage.registrationDBAInformationPage().selectTimeZone(data.get("timezone"));
			registrationStartPage.registrationDBAInformationPage().clickNext();
			Thread.sleep(5000);
			registrationStartPage.registrationCompanyInfoPage().verifyBeneficialOwners();
			registrationStartPage.registrationCompanyInfoPage().verifyDBAInformation();
			Thread.sleep(5000);
			Thread.sleep(7000);
			String[] id = data.get("id").split(",");
			String[] expOwnerlabel = data.get("expOwnerLabels").split(",");
			String[] ownerName = data.get("ownerName").split(",");
			String[] ownerShipValue = data.get("ownerShip").split(",");
			String[] firstName = data.get("firstName").split(",");
			String[] lastName = data.get("lastName").split(",");
			String[] ownerShip = data.get("ownerShip").split(",");

			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillFirstName(data.get("firstName"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillLastName(data.get("lastName"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillDateOfBirth(data.get("dateOfBirth"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillSocialSecurityNum(data.get("ssn_ein_tin"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillOwnerShip(data.get("ownerShip"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress1(data.get("addressline1"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillAddress2(data.get("addressline2"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillCity(data.get("city"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.selectState(data.get("state"));
			sideMenuBarComponent.registrationBeneficialOwnersPage().addBeneficialOwnersComponent()
					.fillZipCode(data.get("zipCode"));
			Thread.sleep(6000);

			sideMenuBarComponent.registrationBeneficialOwnersPage().selectID();
			sideMenuBarComponent.registrationBeneficialOwnersPage().uploadSelectImage(data.get("folderName"),
					data.get("fileName"));
			Thread.sleep(10000);
			sideMenuBarComponent.registrationBeneficialOwnersPage().clickSave();
			Thread.sleep(10000);

			Thread.sleep(10000);
			sideMenuBarComponent.registrationBeneficialOwnersPage().clickNext();

			Thread.sleep(10000);
			sideMenuBarComponent.bankAccountPage().fillRoutingNumber(data.get("routingNumber"));
			sideMenuBarComponent.bankAccountPage().fillConfirmRoutingNumber(data.get("confirmRoutingNumber"));
			sideMenuBarComponent.bankAccountPage().fillAccountNumber(data.get("accountNumber"));
			sideMenuBarComponent.bankAccountPage().fillConfirmAccountNumber(data.get("confirmAccountNumber"));
			sideMenuBarComponent.bankAccountPage().clickEnter();

			registrationStartPage.merchantAgreementsPage().clickView();
			registrationStartPage.merchantAgreementsPage().verifyESignature(data.get("signature"));
			registrationStartPage.merchantAgreementsPage().clickSave();

			registrationStartPage.merchantAgreementsPage().clickNext();

			Thread.sleep(7000);

			registrationStartPage.registrationCompanyInfoPage().verifyMerchantAgreements();

			registrationStartPage.applicationSummaryPage().verifyCompanyInformation();
			registrationStartPage.applicationSummaryPage().getCompanyInformation();
			registrationStartPage.applicationSummaryPage().getCompanyInformationBusinessEntity();
			registrationStartPage.applicationSummaryPage().getCompanyInformationEINNumber();
			registrationStartPage.applicationSummaryPage().getCompanyInformationEmailAddress();
			registrationStartPage.applicationSummaryPage().getCompanyInformationPhoneNumber();
			registrationStartPage.applicationSummaryPage().getCompanyInformationAddress();
			registrationStartPage.applicationSummaryPage().verifyDBAInformation();
			registrationStartPage.applicationSummaryPage().getDBAInfomation();
			registrationStartPage.applicationSummaryPage().getDBAInformationEmail();
			registrationStartPage.applicationSummaryPage().getDBAInformationPhoneNumber();
			registrationStartPage.applicationSummaryPage().getDBAInformationWebsite();
			registrationStartPage.applicationSummaryPage().getDBAInformationMonthlyProcessingVolume();
			registrationStartPage.applicationSummaryPage().getDBAInformationHighTicket();
			registrationStartPage.applicationSummaryPage().getDBAInformationAverageTicket();
			registrationStartPage.applicationSummaryPage().getDBAInformationAddress();
			registrationStartPage.applicationSummaryPage().verifyBeneficialOwners();
			registrationStartPage.applicationSummaryPage().getBeneficialOwnersDropDown();
			registrationStartPage.applicationSummaryPage().getAgreementsDetails();
			registrationStartPage.applicationSummaryPage().getAgreementsSignedDetails();
			registrationStartPage.applicationSummaryPage().clickSubmit();
			ArrayList<String> str = sideMenuBarComponent.verifyColorOfSideMenuBar();
			ArrayList<String> str1 = registrationStartPage.verifyColorOfRegistration();
			ArrayList<String> str2 = registrationStartPage.VerifyChangeColorofRegistration();
			for (int i = 0; i < str.size(); i++) {
				String string1 = str1.get(i);
				String string2 = str.get(i);
				if (string1.equals(string2)) {
					ExtentTestManager.setPassMessageInReport(string1 + " is matched with " + string2);
				} else if (string1.equals(str2.get(0))) {
					ExtentTestManager.setPassMessageInReport(string1 + " is matched with " + str2.get(0));
				} else {
					ExtentTestManager.setInfoMessageInReport(string1 + " is not matched with " + string2);
				}

			}
			registrationStartPage.applicationSummaryPage().clickDone();

//			registrationStartPage.applicationSubmissionPage().verifyHeading(data.get("heading"));
//			registrationStartPage.applicationSubmissionPage().verifyUnderReviewDescription();
//			registrationStartPage.applicationSubmissionPage().verifyStatus();
//			registrationStartPage.applicationSubmissionPage().clickCancelApplication();
//			registrationStartPage.applicationSubmissionPage().cancelMerchantApplicationPopup().clickBack();
//			registrationStartPage.applicationSubmissionPage().clickCancelApplication();
//			registrationStartPage.applicationSubmissionPage().cancelMerchantApplicationPopup().clickCancelApplication();
//
//			registrationStartPage.registrationCompanyInfoPage().verifyApplicationSummary();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testUnderWritingTest Failed due to Exception " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void testMerchantUnderWriting(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			homePage.sideBarComponent().clickUnderWriting();
			homePage.sideBarComponent().clickMerchant();
			homePage.sideBarComponent().underWritingPersonalComponent().verifyUnderwritingMerchantHeading();
			homePage.sideBarComponent().underWritingPersonalComponent().clickNew();
			Thread.sleep(3000);
			String caseID=homePage.sideBarComponent().underWritingPersonalComponent().verifyCaseID();
			String date=homePage.sideBarComponent().underWritingPersonalComponent().verifyMerchantDate();
			String customerId=homePage.sideBarComponent().underWritingPersonalComponent().verifyMerchantID();
			String caseStatus=homePage.sideBarComponent().underWritingPersonalComponent().verifyCaseStatus();
			String dueDate=homePage.sideBarComponent().underWritingPersonalComponent().verifyMerchantDueDate();
			Thread.sleep(5000);
			homePage.sideBarComponent().underWritingPersonalComponent().clickCustomer();
			Thread.sleep(2000);
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyHeading();
			String caseDetailsCaseID= homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyMerchantCaseId();
			String caseDetailscaseStatus=homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().VerifyMerchantCaseStatus();
			String caseDetailsCaseDate = homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyMerchantDate();
			
			String caseDetailsCustomerID =homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyMerchantID();
			//String caseDetailsDueDate =homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyDueDate();
			
			if(caseID.equals(caseDetailsCaseID)) {
				ExtentTestManager.setPassMessageInReport("Case ID is Matched");
			}
			else {
				ExtentTestManager.setInfoMessageInReport("Case Id is not Matched");
			}
			
			if(date.equals(caseDetailsCaseDate)) {
				ExtentTestManager.setPassMessageInReport("Date is Matched");
			}
			else {
				ExtentTestManager.setInfoMessageInReport("Date is not Matched");
			}
			
			if(customerId.equals(caseDetailsCustomerID)) {
				ExtentTestManager.setPassMessageInReport("Merchant Id is Matched");
			}
			else {
				ExtentTestManager.setInfoMessageInReport("Merchant Id is not Matched");
			}
			
			if(caseStatus.equals(caseDetailscaseStatus)) {
				ExtentTestManager.setPassMessageInReport("Case status is Matched");
			}
			else {
				ExtentTestManager.setInfoMessageInReport("Case status is not Matched");
			}
			
//			if(dueDate.equals(caseDetailsDueDate)) {
//				ExtentTestManager.setPassMessageInReport("Due Date is Matched");
//			}
//			else {
//				ExtentTestManager.setInfoMessageInReport("Due Date is not Matched");
//			}
			
			//homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyDateOfBirth(data.get("dateOfBirth"));
//			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifySSNNumber(data.get("SSNNumber"));
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyMerchantPhoneNumber(data.get("phoneNumber"));
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyMerchantEmail(data.get("emailCustm"));;
		//	homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyDownloadDriversLicense();
			Thread.sleep(2000);
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().clickAssignee();
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyListofAssignes();
			homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().selectMerchantAssigneName();
			homePage.clickUserName();
			homePage.clickSignOut();
			
			
			
			


		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testUnderWritingTest Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantAddRequiredDocuments(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickUnderWriting();
			homePage.sideBarComponent().clickMerchant();
			homePage.sideBarComponent().underWritingPersonalComponent().verifyUnderwritingMerchantHeading();
		    homePage.sideBarComponent().underWritingPersonalComponent().clickInReview();
		    homePage.sideBarComponent().underWritingPersonalComponent().clickCustomer();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().verifyHeading();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().clickHide();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().clickAddNewTask();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().addAdditionalDocumentsPopup().verifyHeading();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().addAdditionalDocumentsPopup().clickCheckBox();
		    homePage.sideBarComponent().underWritingPersonalComponent().underWritingCaseDetailsComponent().addAdditionalDocumentsPopup().clickAdd();
		    if (!data.get("toastMessage").isEmpty()) {
				loginPage.toastComponent().verifyToast(data.get("toastTitle"), data.get("toastMessage"));
			}
			Thread.sleep(2000);

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Exception happend due to this " + e);
		}
	}

}
