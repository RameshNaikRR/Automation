package coyni.admin.tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Uninterruptibles;

import coyni.admin.pages.HomePage;
import coyni.admin.pages.LoginPage;
import coyni.customer.tests.TokenAccountTest;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.Runner;
import ilabs.api.reporting.ExtentTestManager;

public class ProfilesTest {

	HomePage homePage;
	LoginPage loginPage;

	@BeforeTest
	public void init() {
		homePage = new HomePage();
		loginPage = new LoginPage();
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileLinks(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonal();
			homePage.sideBarComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().exportComponent().clickExport();
			homePage.sideBarComponent().exportComponent().clickClose();
			homePage.sideBarComponent().clickMerchant();
			homePage.sideBarComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().exportComponent().clickExport();
			homePage.sideBarComponent().exportComponent().clickClose();
			homePage.sideBarComponent().clickCoyniEmployees();
			homePage.sideBarComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().clickAPIBusinessess();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNewApiBusiness();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyApiInvitation(data.get("headingInvitation"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("test verify Api Business details Failed due to Exception" + e);
		}
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
					.verifyTokenWalletHeading(data.get("tokenWalletHeading"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalAmountforBusinessFees(data.get("doller"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalBanckAccountPercentageforBusinessFees(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillInstantPayAmountforBusinessFees(data.get("doller"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillInstantPayPercentageforBusinessFees(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillCogentAccountAmountforBusinessFees(data.get("amount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillCogentAccountPercentageforBusinessFees(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillGiftCardforBusinessFees(data.get("doller"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillFailedBankWithdrawAmountforBusinessFees(data.get("doller"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillFailedBankWithdrawPercentageforBusinessFees(data.get("percentage"));
			// homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().verifyBuyTokenHeading(data.get("buyTokenHeading"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalAmountBuyTokenforBusinessFees(data.get("doller"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalPercentageBuyTokenforBusinessFees(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillMonthlyFeeforBusinessFees(data.get("amount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNext();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyEcoSystemHeading(data.get("ecoSystem"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyTokenWalletHeading(data.get("tokenWalletHeading"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalAmountforEcoSystemFees(data.get("amount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalBanckAccountPercentageforEcoSystemFees(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillInstantPayAmountforEcoSystemFees(data.get("amount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillInstantPayPercentageforEcoSystemFees(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillGiftCardAmountforEcoSystemFees(data.get("amount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillGiftCardPercentageforEcoSystemFees(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillFailedBankWithdrawAmountforBusinessFees(data.get("amount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillFailedBankWithdrawPercentageforBusinessFees(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.verifyBuyTokenHeading(data.get("buyTokenHeading"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalAmountBuyTokenforEcoSystemFees(data.get("amount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalPercentageBuyTokenforEcoSystemFees(data.get("percentage"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNext();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalBankLimitforBusinessFees(data.get("limitAmount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillInstantPayLimitforBusinessFees(data.get("limitAmount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillgiftCardLimitforBusinessFees(data.get("limitAmount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillCogentLimitforBusinessFees(data.get("limitAmount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalBankLimitBuyTokensforBusinessFees(data.get("limitAmount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNext();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalBankLimitBuyTokensforEcoSystemFees(data.get("limitAmount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillInstantPayLimitforEcoSystemFees(data.get("limitAmount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillgiftCardLimitforEcoSystemFees("limitAmount");
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillExternalBankLimitBuyTokensforEcoSystemFees(data.get("limitAmount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser()
					.fillDebitAndCreditCardLimitBuyTokensforEcoSystemFees(data.get("limitAmount"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().clickNext();
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().invitationPopup()
					.verifyHeading(data.get("invitationHeading"));
			homePage.sideBarComponent().profileComponent().createNewApiBusinessUser().invitationPopup().clickDone();

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
			// Demo
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().clickAddWallet();
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().tokenAmount();
			// homePage.sideBarComponent().profileComponent().sideBarApiBusinessComponent().viewWalletIdAndBalance();
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

//this is the used for Profile personal->Merchant
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
			if (Size == 0) {
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
			} else {
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

	// 2.3 Merchant

	static String mail;
	static String url;

	@Test
	@Parameters({ "strParams" })
	public void testAddMerchantUser(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
			homePage.sideBarComponent().addMerchantComponent().clickAddMerchant();
			homePage.sideBarComponent().addMerchantComponent().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().addMerchantComponent().verifyContent(data.get("headingContact"));
			homePage.sideBarComponent().addMerchantComponent().fillFirstName(data.get("firstName"));
			homePage.sideBarComponent().addMerchantComponent().fillLastName(data.get("lastName"));
			mail = homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.getEmail();
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.fillEmail(mail);// this line used for static email (Next time we can change the class name)
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
			url = homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.getUrl();
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
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
			homePage.sideBarComponent().clickMerchant();
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
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
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
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
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
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
			homePage.sideBarComponent().addMerchantComponent().clickAddMerchant();
			homePage.sideBarComponent().addMerchantComponent().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().addMerchantComponent().verifyContent(data.get("headingContact"));
			homePage.sideBarComponent().addMerchantComponent().fillFirstName(data.get("firstName"));
			homePage.sideBarComponent().addMerchantComponent().fillLastName(data.get("lastName"));
			homePage.sideBarComponent().addMerchantComponent().fillEmail();
			homePage.sideBarComponent().addMerchantComponent().fillPartnerName(data.get("partnerName"));
			homePage.sideBarComponent().addMerchantComponent().fillCompanyName(data.get("companyName"));
			homePage.sideBarComponent().addMerchantComponent().clickOutside();
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
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
			homePage.sideBarComponent().addMerchantComponent().clickAddMerchant();
			homePage.sideBarComponent().addMerchantComponent().verifyHeading(data.get("heading"));
			homePage.sideBarComponent().addMerchantComponent().verifyContent(data.get("headingContact"));
			homePage.sideBarComponent().addMerchantComponent().validateFirstNameField(data.get("firstName"));
			homePage.sideBarComponent().addMerchantComponent().validateLastNameField(data.get("lastName"));
			homePage.sideBarComponent().addMerchantComponent().fillEmail();
			homePage.sideBarComponent().addMerchantComponent().validatePartnerNameField(data.get("partnerName"));
			homePage.sideBarComponent().addMerchantComponent().validateCompantNameField(data.get("companyName"));
			homePage.sideBarComponent().addMerchantComponent().clickOutside();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileMerchantFilterandExports(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
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
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
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

	@Test
	@Parameters({ "strParams" })
	public void testProfileMerchantDetailsWithTokenAccount(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
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
					testFilters(strParams);
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
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickFilters();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().tokenAccountPage().filterComponent().clickApplyFilters();
			homePage.sideBarComponent().profileComponent().fillSearchForMerchantDetails(data.get("searchText"));
			Uninterruptibles.sleepUninterruptibly(100, TimeUnit.MILLISECONDS);
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

//Coyni Employee
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
	public void testProfileMerchantPreferencesControlsDisable(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
			homePage.sideBarComponent().fillSearch(data.get("search"));
			homePage.sideBarComponent().clickRecord();
			homePage.sideBarComponent().merchantDetailsComponent().clickPreferencesControl();
			homePage.sideBarComponent().preferencesandControlsComponent().clickDisable();
			homePage.sideBarComponent().preferencesandControlsComponent().clickSave();
			homePage.sideBarComponent().preferencesandControlsComponent().saveChangePopUp().clickYes();
			new CommonFunctions().switchtoUrl(data.get("url"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileMerchantPreferencesControlsEnable(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchant();
			homePage.sideBarComponent().fillSearch(data.get("search"));
			homePage.sideBarComponent().clickRecord();
			homePage.sideBarComponent().merchantDetailsComponent().clickPreferencesControl();
			homePage.sideBarComponent().preferencesandControlsComponent().clickEnable();
			homePage.sideBarComponent().preferencesandControlsComponent().clickSave();
			homePage.sideBarComponent().preferencesandControlsComponent().saveChangePopUp().clickYes();
			new CommonFunctions().switchtoUrl(data.get("url"));

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testAddMerchantUser Failed due to Exception " + e);
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

//	@Test
//	@Parameters({ "strParams" })
//	public void testCreateCoyniEmployee(String strParams) {
//		try {
//			Map<String, String> data = Runner.getKeywordParameters(strParams);
//			homePage.sideBarComponent().clickProfiles();
//			homePage.sideBarComponent().clickCoyniEmployees();
//			homePage.sideBarComponent().profileComponent().verifyPersonalHeading(data.get("profileHeading"));
//
//		} catch (Exception e) {
//			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
//		}
//	}
//	

	@Test
	@Parameters({ "strParams" })
	public void testCreateCoyniEmployee(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickCoyniEmployees();
			homePage.sideBarComponent().profileComponent().verifyCoyniEmployeesHeading(data.get("profileHeading"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().clickNewEmployeeBtn();
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.verifyAddNewEmployeeHeading();
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.verifyHeading(data.get("heading"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.fillFirstName(data.get("firstname"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.fillLastName(data.get("lastname"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.fillEmail(mail);
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.fillPhonenNumber(data.get("phoneNumber"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.selectDepartment(data.get("Department"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.clickOnPermissionRole(data.get("permissionRole"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.clickSendInvitaion();
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.clickActivateAccountInYOPMail(data.get("firstname"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.activateAccountComponent().fillPhoneNumber(data.get("phoneNumber"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.activateAccountComponent().clickNext();
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.activateAccountComponent().fillVerificationCode(data.get("verificationCode"));// 123456
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.activateAccountComponent().fillCreatePassword(data.get("createPassword"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.activateAccountComponent().fillConfirmPassword(data.get("confirmPassword"));
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.activateAccountComponent().clickCreate();
			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.activateAccountComponent().authyComponent().clickActivateTwoStepAuthyLink();

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.activateAccountComponent().authyComponent().enterVerficationCode(data.get("verificationCode"));

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().addNewEmployeeComponent()
					.activateAccountComponent().authyComponent().clickDoneBtn();

			homePage.sideBarComponent().doLogin(data.get("createPassword"), data.get("verificationCode"));

			homePage.sideBarComponent().clickProfiles();

			homePage.sideBarComponent().clickCoyniEmployees();

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().clickOnFiltersBtn();

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().selectFilter(data.get("filter1"));

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().selectFilter(data.get("filter2"));

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().fillSearch();

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().clickEmployeeDetails();

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent()
					.verifyPhoneNumber(data.get("phoneNumber"));

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().verifyEmail();

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().verifyAccStatus();

			homePage.sideBarComponent().profileComponent().coyniEmployeeComponent().clickCancelOrRemoveUser();

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testIndividualsActivityLogView Failed due to Exception " + e);
		}
	}
	
	/*
	 * New code for profile filters
	 */

	@Test
	@Parameters({ "strParams" })
	public void testProfilePersonalWithFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			Thread.sleep(2000);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxUnderReview();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData1 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData1 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query1"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxUnderReview();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxDeclined();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData2 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData2 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query2"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxDeclined();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxDeactivated();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData3 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData3 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query3"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxDeactivated();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxTerminated();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData4 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData4 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query4"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test filters with personal Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileMerchantWithFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchants();
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query5"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxTerminated();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData1 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData1 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query6"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxTerminated();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxDeclined();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData2 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData2 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query7"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxDeclined();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxApplication();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData3 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData3 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query8"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxApplication();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxUnderReview();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData4 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData4 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query9"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxUnderReview();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxCancelled();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData5 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData5 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query10"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}

		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Test filters with merchants Failed due to Exception " + e);
		}
	}

	@Test
	@Parameters({ "strParams" })
	public void testProfileCoyniEmployeesWithFilters(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickCoyniEmployees();
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query11"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData1 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData1 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query12"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData2 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData2 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query13"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			int noFilterData3 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData3 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query14"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			Thread.sleep(2000);
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData4 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData4 == 0) {

				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query15"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData5 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData5 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query16"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData6 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData6 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query17"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkRiskManagement();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData7 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData7 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query18"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxActive();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkRiskManagement();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxDeactivated();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData8 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData8 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query19"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData9 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData9 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query20"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData10 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData10 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query21"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData11 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData11 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query22"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData12 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData12 == 0) {
//				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query23"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData13 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData13 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query24"));
			} else {
//				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData14 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData14 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query25"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkRiskManagement();

			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData15 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData15 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query26"));
			} else {
				// Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkRiskManagement();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbxDeactivated();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkPending();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData16 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData16 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query27"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData17 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData17 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query28"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData18 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData18 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query29"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData19 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData19 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query30"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData20 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData20 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query31"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData21 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData21 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query32"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData22 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData22 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query33"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkRiskManagement();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData23 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData23 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query34"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkRiskManagement();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkPending();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkExpired();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData24 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData24 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query35"));
			} else {
				// Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData25 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData25 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query36"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData26 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData26 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query37"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData27 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData27 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query38"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData28 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData28 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query39"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData29 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData29 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query40"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData30 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData30 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query41"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkRiskManagement();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData31 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData31 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query42"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			/*
			 * New Code for Cancelled
			 */
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkRiskManagement();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkExpired();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCancelled();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData32 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData32 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query43"));
			} else {
				// Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAdministrator();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData33 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData33 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query44"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkUnderwriting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData34 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData34 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query45"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkDevelopment();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData35 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData35 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query46"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkCLevel();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData36 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData36 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query47"));
			} else {
				Thread.sleep(2000);
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkAccounting();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData37 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData37 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query48"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkSupport();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData38 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData38 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query49"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}
			homePage.sideBarComponent().profileComponent().filterComponent().clickFilters();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkLegal();
			homePage.sideBarComponent().profileComponent().filterComponent().clickchkbkRiskManagement();
			homePage.sideBarComponent().profileComponent().filterComponent().clickApplyFilters();
			Thread.sleep(2000);
			int noFilterData39 = homePage.sideBarComponent().tokenAccountPage().filterComponent().noFilterData();
			if (noFilterData39 == 0) {
				Thread.sleep(2000);
				homePage.sideBarComponent().tokenAccountPage().filterComponent()
						.getTotalCustomerCount(data.get("query50"));
			} else {
				ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
			}

		} catch (Exception e) {
			ExtentTestManager.setInfoMessageInReport("No Filter Data found in the system");
		}
	}

	@Test
	public void testProfilePersonalWithPaginations() {
		try {
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonal();
			homePage.sideBarComponent().accountTableComponent().verifyPaginations();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Paginations Failed due to this Exception " + e);
		}

	}

	@Test
	public void testProfileMerchantsWithPaginations() {
		try {
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickMerchants();
			homePage.sideBarComponent().accountTableComponent().verifyPaginations();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Paginations Failed due to this Exception " + e);
		}

	}

	@Test
	public void testProfileCoyniEmployeesWithPaginations() {
		try {
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickCoyniEmployees();
			homePage.sideBarComponent().accountTableComponent().verifyPaginations();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Paginations Failed due to this Exception " + e);
		}

	}

	@Test
	public void testProfileApiBusinessWithPaginations() {
		try {
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickApiBusiness();
			homePage.sideBarComponent().accountTableComponent().verifyPaginations();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Paginations Failed due to this Exception " + e);
		}

	}
	@Test
	@Parameters({ "strParams" })
	public void testProfilePersonalTransactionWithSentAndReceive(String strParams) {
		try {
			Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonal();
			homePage.sideBarComponent().accountTableComponent().fillSearchData(data.get("emailData"));;
			homePage.sideBarComponent().accountTableComponent().clickUser();
			homePage.sideBarComponent().accountTableComponent().profileSideBarComponent().clickTokenAccount();
			homePage.sideBarComponent().accountTableComponent().profileSideBarComponent().filterComponent().clickFilters();
		//	homePage.sideBarComponent().accountTableComponent().profileSideBarComponent().filterComponent().clickchkbxPersonal();
			homePage.sideBarComponent().accountTableComponent().profileSideBarComponent().filterComponent().clickchkbxSent();
			homePage.sideBarComponent().accountTableComponent().profileSideBarComponent().filterComponent().clickchkbkReceived();
			homePage.sideBarComponent().accountTableComponent().profileSideBarComponent().filterComponent().clickApplyFilters();
			//homePage.sideBarComponent().accountTableComponent().profileSideBarComponent().filterComponent().getTotalCustomerCount(data.get("query"));
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("Paginations Failed due to this Exception " + e);
		}

	}
	@Test
	@Parameters({ "strParams" })
	public void testProfilePersonalPhoneNumbers(String strParams) {
		try {
			//Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonal();
			homePage.sideBarComponent().filterComponent().verifyPhoneNumber();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfilePersonalPhoneNumbers Failed due to this Exception " + e);
		}

	}
	@Test
	@Parameters({ "strParams" })
	public void testVerifyPersonalID(String strParams) {
		try {
			//Map<String, String> data = Runner.getKeywordParameters(strParams);
			homePage.sideBarComponent().clickProfiles();
			homePage.sideBarComponent().clickPersonal();
			homePage.sideBarComponent().accountTableComponent().clickUser();
			Thread.sleep(2000);
			homePage.sideBarComponent().accountTableComponent().profileSideBarComponent().clickUserDetails();
			homePage.sideBarComponent().accountTableComponent().profileSideBarComponent().getCustomerAccountID();
		} catch (Exception e) {
			ExtentTestManager.setFailMessageInReport("testProfilePersonalPhoneNumbers Failed due to this Exception " + e);
		}

	}
}
