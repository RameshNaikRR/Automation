package coyni.admin.merchanttests;

import java.util.Map;

import org.junit.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import coyni.admin.Paymentpages.CommissionAccountPage;
import coyni.admin.Paymentpages.HomePage;
import coyni.business.pages.LoginPage;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class BusinessProfileTest {

	HomePage homePage;
	CommissionAccountPage commissionAccountPage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void init() {
		homePage = new HomePage();
		loginPage = new LoginPage();
	}
	
	static String mail;
	static String url;

	@Test
	@Parameters({ "strParams" })
	public void testAddMerchantUser(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessProfile();
			homePage.sideBarComponent().addMerchantComponent().clickAddMerchant();
			homePage.sideBarComponent().addMerchantComponent().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().addMerchantComponent().verifyContent(data.get("headingContact"));
			homePage.sideBarComponent().addMerchantComponent().fillFirstName(data.get("firstName"));
			homePage.sideBarComponent().addMerchantComponent().fillLastName(data.get("lastName"));
			mail = homePage.sideBarComponent().addMerchantComponent().getEmail();
			homePage.sideBarComponent().addMerchantComponent().fillEmail(mail);// this line used for static email (Next time we can change the class name)
			homePage.sideBarComponent().addMerchantComponent().fillPartnerName(data.get("partnerName"));
			homePage.sideBarComponent().addMerchantComponent().fillCompanyName(data.get("companyName"));
			homePage.sideBarComponent().addMerchantComponent().clickSendInvitation();
			if (!data.get("toastMerchantInvitation").isEmpty()) {
				loginPage.toastComponent().verifyToast(data.get("toastTitle1"), data.get("toastMerchantInvitation"));
			}
			Thread.sleep(3000);
//			homePage.sideBarComponent().addMerchantComponent().toastComponent().verifyToast(data.get("title"),
//					data.get("message"));
//			homePage.sideBarComponent().addMerchantComponent().verifyMerchantHeading();
			url = homePage.sideBarComponent().addMerchantComponent()
					.getUrl();
			homePage.sideBarComponent().addMerchantComponent()
					.navigateUrl(url);
			// new CommonFunctions().swtichToNewtabUrl(data.get("merchUrl"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testEditMerchantInvitation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.ClickMerchantUserBasedOnMerchantName();
			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.merchantEditInviteComponent().clickEditInvite();
			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.merchantEditInviteComponent().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.merchantEditInviteComponent().verifyContent(data.get("headingContact"));

			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.merchantEditInviteComponent().addMerchantComponent().fillEditEmail();

			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.merchantEditInviteComponent().navigationComponent().clickBack();
			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.merchantEditInviteComponent().clickEditInvite();
			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.merchantEditInviteComponent().navigationComponent().clickClose();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Resend invitation  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantResendInvitation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessProfile();
			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.ClickMerchantUserBasedOnMerchantName();

			String verifyName = homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.getName();

			if ((data.get("firstName") + " " + data.get("lastName")).contains(verifyName)) {
				ExtentTestManager.setInfoMessageInReport(verifyName + "Name Is Same");
				homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
						.clickResendInvite();
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Resend invitation  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testMerchantCancelInvitation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessProfile();
			homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.ClickMerchantUserBasedOnMerchantName();
			String verifyName = homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
					.getName();
			if ((data.get("firstName") + " " + data.get("lastName")).contains(verifyName)) {
				ExtentTestManager.setInfoMessageInReport(verifyName + "Name Is Same");
				homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
						.clickCancelInvite();
				homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
						.VerifyCancelHeading(data.get("heading"));
				homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent()
						.clickCancelInvite();
				Thread.sleep(3000);
				homePage.sideBarComponent().addMerchantComponent().merchantResendAndCancelComponent().toastComponent()
						.verifyToast(data.get("title"), data.get("message"));
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Resend invitation  Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddMerchantWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessProfile();
			homePage.sideBarComponent().addMerchantComponent().clickAddMerchant();
			homePage.sideBarComponent().addMerchantComponent().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().addMerchantComponent().verifyContent(data.get("headingContact"));
			homePage.sideBarComponent().addMerchantComponent().fillFirstName(data.get("firstName"));
			homePage.sideBarComponent().addMerchantComponent().fillLastName(data.get("lastName"));
			homePage.sideBarComponent().addMerchantComponent().fillEmail();
			homePage.sideBarComponent().addMerchantComponent().fillPartnerName(data.get("partnerName"));
			homePage.sideBarComponent().addMerchantComponent().fillCompanyName(data.get("companyName"));
	//		homePage.sideBarComponent().addMerchantComponent().clickOutside();
			if (!data.get("errMessage").isEmpty()) {
				new CommonFunctions().validateFormErrorMessage(data.get("errMessage"), data.get("colour"),
						data.get("elementName"));
			}
			// homePage.sideBarComponent().addMerchantComponent().clickSendInvitation();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testAddMerchantWithFieldValidation(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessProfile();
			homePage.sideBarComponent().addMerchantComponent().clickAddMerchant();
			homePage.sideBarComponent().addMerchantComponent().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().addMerchantComponent().verifyContent(data.get("headingContact"));
			homePage.sideBarComponent().addMerchantComponent().validateFirstNameField(data.get("firstName"));
			homePage.sideBarComponent().addMerchantComponent().validateLastNameField(data.get("lastName"));
			homePage.sideBarComponent().addMerchantComponent().fillEmail();
			homePage.sideBarComponent().addMerchantComponent().validatePartnerNameField(data.get("partnerName"));
			homePage.sideBarComponent().addMerchantComponent().validateCompantNameField(data.get("companyName"));
		//	homePage.sideBarComponent().addMerchantComponent().clickOutside();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileMerchantFilterandExports(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessProfile();
			ProfileMerchantFilters(strParams);
			testProfilrMerchantExportTransactions(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}

	public void ProfileMerchantFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			boolean filterEna = homePage.sideBarComponent().tokenAccountPage().filterComponent().filterEna();

			if (filterEna == true) {
				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxActive();
				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxApplication();
				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxCancelled();
				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxDeclined();
				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickResetAllFilters();
				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxActive();
				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("ProfileMerchantFiltersAndExports Failed due to Exception " + e);
		}
	}

	public void testProfilrMerchantExportTransactions(String strParams) {
		Map<String, String> data = Runner.getKeywordParameters(strParams);
		try {
			homePage.sideBarComponent().exportComponent().clickExport();
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
					.verifyProfileMerchantExportHeading(data.get("heading"));
			Thread.sleep(200);
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickOnExport();
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup()
					.verifyTitle(data.get("exportHeading"));
			homePage.sideBarComponent().exportComponent().exportSelectedTransactionsPopup().clickClose();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("ProfileMerchantFiltersAndExports Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileMerchantDetails(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessProfile();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			homePage.sideBarComponent().profileComponent().fillSearchForMerchantDetails(data.get("searchText"));
			int Size = homePage.sideBarComponent().profileComponent().accountTableComponent().getNoFilterRecSize();
			if (Size == 0) {
				homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.clickAccountLimits();
				Thread.sleep(4000);
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.accountLimitsComponent().verifyHeading();

				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.accountLimitsComponent().verifyDailyLimitBuyTokenBankAccount();
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.accountLimitsComponent().verifyDailyLimitWithdrawToUSDBankAccount();
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.accountLimitsComponent().verifyDailyLimitWithdrawToUSDGiftCard();
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.accountLimitsComponent().verifyDailyLimitWithdrawToUSDInstantPay();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickCompanyInformation();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getCompany();
				// homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getContact();
				// homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getAddress();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickDBA();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getBusiness();
				// homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getCustomerService();
				// homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getAddressDBA();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickOwners();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickBenefical();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getBenefiName();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getBenefiDOB();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getSSN();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getOwnerShip();
				// homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getBenefiAddress();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickAPIKeys();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getPublicKey();
				int reSize = homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().reSize();
				if (reSize > 0) {
					homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickRevealKey();
					homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getSecretKey();
				} else {
					ExtentTestManager.setInfoMessageInReport("Reveal ");
				}
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickAgreements();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickTermOfService();
				homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickDownloadAgreement();

			} else {
				ExtentTestManager.setPassMessageInReport("No data found ");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
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
	public void testProfileMerchantDetailsWithTokenAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessProfile();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			homePage.sideBarComponent().profileComponent().fillSearchForMerchantDetails(data.get("searchText"));
			int Size = homePage.sideBarComponent().profileComponent().accountTableComponent().getNoFilterRecSize();
			if (Size == 0) {
				homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
				Thread.sleep(2000);
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.clickTokenAccount();
				int size = homePage.sideBarComponent().profileComponent().accountTableComponent()
						.profileSideBarComponent().getNoFilterRecSize();
				if (size == 0) {
					//testFilters(strParams);
					testExportSelectedTransactions(strParams);

				} else {
					ExtentTestManager
							.setInfoMessageInReport("Their is no transaction & Filters and Export are Disabled");
				}
			} else {
				ExtentTestManager.setInfoMessageInReport("Their is No Active Records");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileMerchantPayoutHistory(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickBusinessProfile();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			homePage.sideBarComponent().profileComponent().fillSearchForMerchantDetails(data.get("searchText"));
		//	Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
			int Size = homePage.sideBarComponent().profileComponent().accountTableComponent().getNoFilterRecSize();
			if (Size == 0) {
				homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileComponent()
						.clickViewPayoutHistory();
				int size = homePage.sideBarComponent().profileComponent().accountTableComponent().profileComponent()
						.getNoRecSize();
				if (size == 0) {
					ExtentTestManager.setInfoMessageInReport("PayOut Transactions History is displayed");

				} else {
					System.out.println("No Record found in the system");
				}
			} else {

			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfileMerchantPayoutHistory Failed due to Exception " + e);
		}
	}

	
}
