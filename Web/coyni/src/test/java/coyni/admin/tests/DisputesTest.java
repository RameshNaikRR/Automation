package coyni.admin.tests;

import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import coyni.admin.components.ExportComponent;
import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class DisputesTest {

	HomePage homePage;
	ExportComponent exportcomponent;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		exportcomponent = new ExportComponent();
	}

	@Test
	@Parameters({ "strParams" })
	public void testDisputesTest(String strParams){
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().verifyCursorAction();
			
			homePage.sideBarComponent().clickDisputes();
			homePage.sideBarComponent().verifyDisputes(data.get("disputesHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testDisputesTest Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void VerifyFilter(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickDisputes();
			homePage.sideBarComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().filterComponent().verifyFiltersHeadings(data.get("filterHeadings"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("VerifyFilter Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void VerifyCaseNumFilterWonDispaly(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickDisputes();
			homePage.sideBarComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().filterComponent().enterCaseNum(data.get("caseNum"));
			homePage.sideBarComponent().filterComponent().clickWon();
			homePage.sideBarComponent().filterComponent().clickApplyFilters();
			String caseNum = homePage.sideBarComponent().filterComponent().getCaseNum();
			if (caseNum.contains(data.get("caseNum"))) {
				ExtentTestManager
						.setInfoMessageInReport("Given " + caseNum + " is present in apply filter search results");
			} else {
				ExtentTestManager
						.setInfoMessageInReport("Given " + caseNum + " is not present in apply filter search results");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("VerifyCaseNumFilterWonDispaly Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void verifyDisputesExportsStatusCaseID(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(4000);
			if(exportcomponent.noData()==0) {
			exportcomponent.clickExport();
			homePage.sideBarComponent().filterComponent()
					.verifyDisputesExportStatusCaseID(data.get("disputesExportsStatusCaseID"));
			exportcomponent.clickExportButton();
			exportcomponent.clickClose();
			}
			else {
				ExtentTestManager.setPassMessageInReport("No Data Found");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("verifyDisputesExportsStatusCaseID Failed due to Exception " + e);
		}
	}
	@Test
	@Parameters({ "strParams" })
	public void verifyDisputesTransactionsCountWithDB(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickDisputes();
			homePage.sideBarComponent().disputesDetailsComponent().clickPendingStatus();
			homePage.sideBarComponent().disputesDetailsComponent().getTotalPendingTransaction();
			homePage.sideBarComponent().disputesDetailsComponent().getTotalItemsCount(data.get("query"));
			homePage.sideBarComponent().disputesDetailsComponent().clickWons();
			homePage.sideBarComponent().disputesDetailsComponent().getTotalWonItemsCount(data.get("query2"));
			homePage.sideBarComponent().disputesDetailsComponent().clickLosts();
			homePage.sideBarComponent().disputesDetailsComponent().getTotalLostItemsCount(data.get("query3"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("verifyDisputesPendingTransactionsCount Failed due to Exception " + e);
		}
	}
	
	@Test
	@Parameters({ "strParams" })
	public void testDisputesWithFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickDisputes();
			homePage.sideBarComponent().disputesDetailsComponent().clickAllDisputes(data.get("expColor"),
					data.get("elementName"));
			int noDisputesData = homePage.sideBarComponent().disputesDetailsComponent().noDisputesData();
			if (noDisputesData == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().disputesDetailsComponent().getTotalDisputesCount(data.get("query"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Disputes Data Found in the System");
			}
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
					.fillCaseNumber(data.get("caseNumber"));
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().fillAccountId(data.get("accountID"));
		    homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
			.clickWon();
//			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().fillCustomerName(data.get("customerName"));
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData1 = homePage.sideBarComponent().underWritingPersonalComponent()
					.underWritingCaseDetailsComponent().filterComponent().noFilterData();
			if (noFilterData1 == 0) {
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query1"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			Thread.sleep(2000);
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();		
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickWon();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
			.clickchkbkPending();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData5 = homePage.sideBarComponent().underWritingPersonalComponent()
					.underWritingCaseDetailsComponent().filterComponent().noFilterData();
			if (noFilterData5 == 0) {
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query7"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
			.clickchkbkPending();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
			.clickLost();		
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData6 = homePage.sideBarComponent().underWritingPersonalComponent()
					.underWritingCaseDetailsComponent().filterComponent().noFilterData();
			if (noFilterData6 == 0) {
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query8"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			
			/*
			 * New Code for Pending
			 */
			Thread.sleep(2000);
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickResetAllFilters();
			Thread.sleep(2000);
			homePage.sideBarComponent().disputesDetailsComponent().clickPendingTab(data.get("expColor1"),
					data.get("elementName1"));
			int noDisputesData1 = homePage.sideBarComponent().disputesDetailsComponent().noDisputesData();
			if (noDisputesData1 == 0) {
				homePage.sideBarComponent().disputesDetailsComponent().getTotalDisputesCount(data.get("query2"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Disputes Data Found in the System");
			}
			Thread.sleep(2000);
            /*
            * New Code for Won		
            */
			homePage.sideBarComponent().disputesDetailsComponent().clickWonTab(data.get("expColor2"),
					data.get("elementName2"));
			int noDisputesData2 = homePage.sideBarComponent().disputesDetailsComponent().noDisputesData();
			if (noDisputesData2 == 0) {
				homePage.sideBarComponent().disputesDetailsComponent().getTotalDisputesCount(data.get("query3"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Disputes Data Found in the System");
			}
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
					.fillCaseNumber(data.get("caseNumber3"));
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().fillAccountId(data.get("accountID"));
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickchkbkPending();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData3 = homePage.sideBarComponent().underWritingPersonalComponent()
					.underWritingCaseDetailsComponent().filterComponent().noFilterData();
			if (noFilterData3 == 0) {
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query9")); //query4
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
			.clickchkbkPending();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
			.clickLost();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData7 = homePage.sideBarComponent().underWritingPersonalComponent()
					.underWritingCaseDetailsComponent().filterComponent().noFilterData();
			if (noFilterData7 == 0) {
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query10"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
			.clickLost();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
			.clickWon();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData8 = homePage.sideBarComponent().underWritingPersonalComponent()
					.underWritingCaseDetailsComponent().filterComponent().noFilterData();
			if (noFilterData8 == 0) {
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query11"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickResetAllFilters();
			Thread.sleep(2000);
			homePage.sideBarComponent().disputesDetailsComponent().clickLostTab(data.get("expColor3"),
					data.get("elementName3"));
			int noDisputesData3 = homePage.sideBarComponent().disputesDetailsComponent().noDisputesData();
			if (noDisputesData3 == 0) {
				homePage.sideBarComponent().disputesDetailsComponent().getTotalDisputesCount(data.get("query5"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Disputes Data Found in the System");
			}
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent()
					.fillCaseNumber(data.get("caseNumber4"));
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().fillAccountId(data.get("accountID4"));
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickchkbkPending();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData4 = homePage.sideBarComponent().underWritingPersonalComponent()
					.underWritingCaseDetailsComponent().filterComponent().noFilterData();
			if (noFilterData4 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query6"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickchkbkPending();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickLost();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData9 = homePage.sideBarComponent().underWritingPersonalComponent()
					.underWritingCaseDetailsComponent().filterComponent().noFilterData();
			if (noFilterData9 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query12"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickLost();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickWon();
			homePage.sideBarComponent().disputesDetailsComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData10 = homePage.sideBarComponent().underWritingPersonalComponent()
					.underWritingCaseDetailsComponent().filterComponent().noFilterData();
			if (noFilterData10 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query13"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Failed due to this exception" + e);
		}
	}
	
	@Test
	public void testDisputesWithPaginations() {
		try {
			homePage.sideBarComponent().clickDisputes();
			homePage.sideBarComponent().accountTableComponent().verifyPaginations();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Paginations Failed due to this Exception " + e);
		}

	}


}
