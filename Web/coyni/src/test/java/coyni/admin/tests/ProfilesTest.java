package coyni.admin.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.admin.pages.HomePage;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ProfilesTest {

	HomePage homePage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();

	}

	@Test
	@Parameters({ "strParams" })
	public void testAddApiBusiness(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().profileComponent().clickApiBusiness();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNewApiBusiness();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyApiInvitation(data.get("headingInvitation"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyHeading(data.get("headingContact"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillFirstName(data.get("firstName"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().fillLastName("lastName");
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().fillEmail(data.get("email1"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillPhoneNumber(data.get("phoneNumber"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNext();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyBusinessHeading(data.get("business"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalDoller(data.get("doller"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillBuySignetPercentage(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNext();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyEcoSystem(data.get("ecoSystem"));
//			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().fillExternalDoller(data.get("doller"));
//			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().fillBuySignetPercentage(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNext();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyBusinessAccount(data.get("businessLimit"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNext();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyEcosystemLimit(data.get("ecoSystemLimit"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickSend();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test verify Api Business details Failed due to Exception" + e);
		}
	}

	public void testFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			HomePage homePage = new HomePage();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
//			homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyMouseHoverChangedColor("cssProp",
//					"expValue", "expColor");
			homePage.sideBarComponent().tokenAccountPage().filterComponent().viewFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().selectFilter(data.get("filterType"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("toAmount"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("amount"));
			// homePage.sideBarComponent().tokenAccountPage().filterComponent().fillReferenceID(data.get("referenceID"));
			// homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyEmployeeName(data.get("empName"));
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testTokenAccountFilters Failed due to Exception " + e);
		}
	}

	public void testExportSelectedTransactions(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			HomePage homePage = new HomePage();
			homePage.sideBarComponent().exportComponent().clickExport();
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
					.verifyHeading(data.get("heading"));
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnToday();

			Thread.sleep(2000);
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnExport();
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
					.verifyTitle(data.get("exportHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickExportPage();
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test Export files failed due to exception " + e);

		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testveifyGrid(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().profileComponent().clickApiBusiness();
			homePage.sideBarComponent().profileComponent().clickUser();
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickTokenWallet();
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().tokenAmount();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().viewWalletIdAndBalance();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickViewMore();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getAvaliableBalance();
			testFilters(strParams);
			testExportSelectedTransactions(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test verify Api Business details Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testveifyApiBusinessDetails(String strParams) {
		try {
		//	Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().profileComponent().clickApiBusiness();
			homePage.sideBarComponent().profileComponent().clickUser();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickCompanyInformation();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getCompany();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getContact();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getAddress();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickDBA();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getBusiness();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getCustomerService();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getAddressDBA();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickOwners();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickBenefical();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getBenefiName();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getBenefiDOB();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getSSN();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getOwnerShip();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getBenefiAddress();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickAPIKeys();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getPublicKey();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickRevealKey();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getSecretKey();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickAgreements();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickTermOfService();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickDownloadAgreement();
			
			
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualSideBarView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualSideBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickIndividuals();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyID(data.get("expID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyUserName(data.get("expUserName"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyAccountID(data.get("expAccountID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickWebIcon();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.getWebLastSeen();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickMobileIcon();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.getMobileLastSeen();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyUserDetailsView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyPaymentMethodsView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyTokenAccountView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyPreferencesControlView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyAgreementsView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyAccountLimitsView();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyActivityLogView();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualSideBarView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualUserDetailsView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickIndividuals();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyID(data.get("expID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickUserDetails();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.UserDetailsComponent().verifyHeading(data.get("expHeading"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.UserDetailsComponent().verifyUserName(data.get("userName"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.UserDetailsComponent().verifyAccountID(data.get("expAccountID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.UserDetailsComponent().verifyAccountStatus(data.get("expAccountStatus"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.UserDetailsComponent().getPhoneNumber();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.UserDetailsComponent().getEmail();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.UserDetailsComponent().getAddress();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualUserDetailsView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualPaymentMethodView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickIndividuals();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyID(data.get("expID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickPaymentMethods();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.PaymentMethodsComponent().verifyHeading(data.get("expHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualUserDetailsView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsActivityLogView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickIndividuals();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyID(data.get("expID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickActivityLog();
			// homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent().A

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testActionsOnCoyniEmployee(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniEmployees();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickAction();
			homePage.sideBarComponent().profileComponent().accountTableComponent().actionsPopup()
					.verifyHeading(data.get("popupHeading"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().actionsPopup().verifyPopDes();
			homePage.sideBarComponent().profileComponent().accountTableComponent().actionsPopup().clickYes();
			if (!data.get("toastMessage").isEmpty()) {
				homePage.sideBarComponent().profileComponent().toastComponent().verifyToast(data.get("toastTitle"),
						data.get("toastMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testCoyniEmployeeSearch(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickCoyniEmployees();
			homePage.sideBarComponent().profileComponent().verifyHeading(data.get("profileHeading"));

			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			Uninterruptibles.sleepUninterruptibly(3000, TimeUnit.MILLISECONDS);
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickAction();
			homePage.sideBarComponent().profileComponent().accountTableComponent().actionsPopup()
					.verifyHeading(data.get("popupHeading"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().actionsPopup().verifyPopDes();
			homePage.sideBarComponent().profileComponent().accountTableComponent().actionsPopup().clickYes();
			if (!data.get("toastMessage").isEmpty()) {
				homePage.sideBarComponent().profileComponent().toastComponent().verifyToast(data.get("toastTitle"),
						data.get("toastMessage"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

}
