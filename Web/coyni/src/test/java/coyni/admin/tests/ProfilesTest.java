package coyni.admin.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.admin.pages.HomePage;
import coyni.customer.tests.TokenAccountTest;
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
			boolean filterEna = homePage.sideBarComponent().tokenAccountPage().filterComponent().filterEna();

			if (filterEna == true) {

				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
//                homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyMouseHoverChangedColor("cssProp",
//                        "expValue", "expColor");
				homePage.sideBarComponent().tokenAccountPage().filterComponent().viewFilters();
				homePage.sideBarComponent().tokenAccountPage().filterComponent().selectFilter(data.get("filterType"));
				homePage.sideBarComponent().tokenAccountPage().filterComponent().fillToAmount(data.get("toAmount"));
				homePage.sideBarComponent().tokenAccountPage().filterComponent().fillFromAmount(data.get("amount"));
				// homePage.sideBarComponent().tokenAccountPage().filterComponent().fillReferenceID(data.get("referenceID"));
				// homePage.sideBarComponent().tokenAccountPage().filterComponent().verifyEmployeeName(data.get("empName"));
				homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();

			} else {
				System.out.println("---------------------------");
			}

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

			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickAddNewWallet();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent()
					.verifyTokenHeading(data.get("heading1"));
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent()
					.enterTokenWallet(data.get("walletID"));
			//Demo
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickAddWallet();
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().tokenAmount();
	//		homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().viewWalletIdAndBalance();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickViewMore();
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().getAvaliableBalance();
			if (homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent()
					.getNoTransactionSize() > 0) {
				ExtentTestManager.setInfoMessageInReport("Export button is disable because no transactions");
			} else {
				testFilters(strParams);
				testExportSelectedTransactions(strParams);

			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test verify Api Business details Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testveifyApiBusinessDetails(String strParams) {
		try {
			// Map<String, String> data = Runner.getKeywordParameters(strParams);
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
            homePage.sideBarComponent().clickPersonals();
            homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
            Thread.sleep(2000);
            homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
            Thread.sleep(4000);
            int Size = homePage.sideBarComponent().profileComponent().accountTableComponent().getNoRecSize();
            if(Size==0) {
            homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
            homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
                    .verifyID(data.get("expID"));
            // homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
            // .clickUserDetails();
            Thread.sleep(2000);
            homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
                    .userDetailsComponent().verifyHeading(data.get("expUserHeading"));
            homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
                    .userDetailsComponent().verifyUserName(data.get("userName"));
            homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
                    .userDetailsComponent().verifyAccountID(data.get("expAccountID"));
            homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
                    .userDetailsComponent().verifyAccountStatus(data.get("expAccountStatus"));
            homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
                    .userDetailsComponent().getPhoneNumber();
            homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
                    .userDetailsComponent().getEmail();
            homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
                    .userDetailsComponent().getAddress();
            }
            else {
                ExtentTestManager.setPassMessageInReport("No data found ");
            }



       } catch (Exception e) {
            ExtentTestManager.setFailMessageInReport("testIndividualUserDetailsView Failed due to Exception " + e);
        }
    }

	@Test
	@Parameters({ "strParams" })
	public void testIndividualSideBarView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();

			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyID(data.get("expID"));
			Thread.sleep(1000);
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyUserName(data.get("expUserName"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyAccountID(data.get("expAccountID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickWebIcon();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.getWebLastSeen();
//			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
//					.clickMobileIcon();
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
	public void testIndividualUserDetailsViewWithInvalidData(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));
			homePage.sideBarComponent().profileComponent().verifyNoRecords();

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
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();

			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.verifyID(data.get("expID"));
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickPaymentMethods();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.paymentMethodsComponent().verifyHeading(data.get("expPaymentMethodHeading"));
			Thread.sleep(2000);
			if (homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.paymentMethodsComponent().verifyNoPaymentMethods() == 1) {
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.paymentMethodsComponent().viewNoPaymentMethods();
			}
			if (homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.paymentMethodsComponent().verifyCardslist() == 1) {
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.paymentMethodsComponent().cardDetails();
			}
			if (homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.paymentMethodsComponent().verifyBankList() == 1) {
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.paymentMethodsComponent().bankDetails();
			}

			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.paymentMethodsComponent().verifyHeading(data.get("expPaymentMethodHeading"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualUserDetailsView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsTokenAccountTrasactionList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			TokenAccountTest tokenAccountTest = new TokenAccountTest();
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			tokenAccountTest.testTransactionList(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsTokenAccountTrasactionPurchasedDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			TokenAccountTest tokenAccountTest = new TokenAccountTest();
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			tokenAccountTest.testTransactionPurchasedDetailsList(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsTokenAccountTrasactionSentDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			TokenAccountTest tokenAccountTest = new TokenAccountTest();
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			tokenAccountTest.testTransactionSentDetailsList(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsTokenAccountTrasactionWithdarwDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			TokenAccountTest tokenAccountTest = new TokenAccountTest();
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			tokenAccountTest.testTransactionWithdrawDetailsList(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsTokenAccountTrasactionRecieveDetailsList(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			TokenAccountTest tokenAccountTest = new TokenAccountTest();
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			tokenAccountTest.testTransactionReceiveDetailsList(strParams);
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsTokenAccountActivityDetalis(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			TokenAccountTest tokenAccountTest = new TokenAccountTest();
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			tokenAccountTest.testTokenAccountActivityDetails();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsPreferencesView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickPreferencesControl();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().viewHeading();
			Thread.sleep(1000);
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().verifyTimeZone();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().verifyLocalCurrency();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsPreferencesDisableAllControls(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickPreferencesControl();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().viewHeading();
			Thread.sleep(1000);
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().clickDisable();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().clickSave();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().saveChangePopUp().clickYes();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsPreferencesEnableAllControls(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickPreferencesControl();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().viewHeading();
			Thread.sleep(5000);
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().clickEnable();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().clickSave();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().saveChangePopUp().clickYes();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsPreferencesandControlsnavigations(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickPreferencesControl();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().viewHeading();
			Thread.sleep(5000);
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().verifyAllControls();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().clickSave();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().saveChangePopUp().clickCross();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.preferencesandControlsComponent().clickCancel();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsPrivacyPolicyAgreement(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickAgreements();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.agreementsComponent().verifyHeading();

			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.agreementsComponent().clickPrivacyPolicy();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.agreementsComponent().verifyPrivacyPolicyHeading();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.agreementsComponent().viewAgreement();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsTermsofServiceAgreement(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickAgreements();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.agreementsComponent().verifyHeading();

			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.agreementsComponent().clickTermsofService();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.agreementsComponent().verifyTermsofServiceHeading();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.agreementsComponent().viewAgreement();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsAccountLimits(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickAccountLimits();
			Thread.sleep(4000);
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.accountLimitsComponent().verifyHeading();

			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.accountLimitsComponent().verifyDailyLimitBuyTokenBankAccount();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.accountLimitsComponent().verifyDailyLimitBuyTokenCreditCard();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.accountLimitsComponent().verifyDailyLimitBuyTokenDebitCard();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.accountLimitsComponent().verifyDailyLimitWithdrawToUSDBankAccount();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.accountLimitsComponent().verifyDailyLimitWithdrawToUSDGiftCard();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.accountLimitsComponent().verifyDailyLimitWithdrawToUSDInstantPay();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testIndividualsActivityLogView(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonals();
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().fillSearch(data.get("searchText"));

			homePage.sideBarComponent().profileComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.clickActivityLog();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.activityLogComponent().verifyHeading();
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.activityLogComponent().clickSatuses();
			if (homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.activityLogComponent().verifyNoActivityLog() == 1) {
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.activityLogComponent().verifyNoActivityLog();
			} else {
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.activityLogComponent().verifyActivityLogStatuses();
			}
			homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.activityLogComponent().clickControls();
			if (homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
					.activityLogComponent().verifyNoActivityLog() == 1) {
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.activityLogComponent().verifyNoActivityLog();
			} else {
				homePage.sideBarComponent().profileComponent().accountTableComponent().profileSideBarComponent()
						.activityLogComponent().verifyActivityLogControls();
			}

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
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
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
			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));

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
