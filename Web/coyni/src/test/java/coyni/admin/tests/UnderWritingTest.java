package coyni.admin.tests;

import java.util.Map;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.pages.HomePage;
import coyni.admin.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class UnderWritingTest {

	HomePage homePage;
	LoginPage loginPage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		loginPage =new LoginPage();

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


	
	

	
	

}
