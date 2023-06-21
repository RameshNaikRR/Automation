package coyni_mobile.pages;

import org.openqa.selenium.By;

import coyni_mobile.utilities.CommonFunctions;
import ilabs.MobileFramework.MobileFunctions;
import ilabs.mobile.reporting.ExtentTestManager;
import io.appium.java_client.MobileBy;

public class WalletsFeesPage extends MobileFunctions {
		private By lblWalletFees = MobileBy.AccessibilityId("");
		private By lblBuyToken = MobileBy.AccessibilityId("");
		private By lblWithdraw = MobileBy.AccessibilityId("");
		private By lblBankAccount = MobileBy.AccessibilityId("");
		private By lblBankAccountFee = MobileBy.AccessibilityId("");
		private By lblCreditCard = MobileBy.AccessibilityId("");
		private By lblCreditCardFee = MobileBy.AccessibilityId("");
		private By lblDebitCard = MobileBy.AccessibilityId("");
		private By lblDebitCardFee = MobileBy.AccessibilityId("");
		private By lblWithdrawBankAccount = MobileBy.AccessibilityId("");
		private By lblWithdrawBankAccountFee = MobileBy.AccessibilityId("");
		private By lblWithdrawInstantPay = MobileBy.AccessibilityId("");
		private By lblWithdrawInstantPayFee = MobileBy.AccessibilityId("");
		private By lblGiftCard = MobileBy.AccessibilityId("");
		private By lblGiftCardFee = MobileBy.AccessibilityId("");
		private By lblFailedBankWithdraw = MobileBy.AccessibilityId("");
		private By lblFailedBankWithdrawFee = MobileBy.AccessibilityId("");
		
		
		public String verifyBuyTokenBankAccountFee() {
			String str = getText(lblBankAccountFee).trim().replace(" ", "");
			return str;
		}
		public String verifyBuyTokenDebitCardFee() {
			String str = getText(lblDebitCardFee).trim().replace(" ", "");
			return str;
		}
		public String verifyBuyTokenCreditCardFee() {
			String str = getText(lblCreditCardFee).trim().replace(" ", "");
			return str;
		}
		
		public String verifyWithdrawTokenBankAccountFee() {
			String str = getText(lblWithdrawBankAccountFee).trim().replace(" ", "");
			return str;
		}
		public String verifyWithdrawTokenInstantFee() {
			String str = getText(lblWithdrawInstantPayFee).trim().replace(" ", "");
			return str;
		}
//		public String verifyBuyTokenCreditCardFee() {
//			String str = getText(lblCreditCardFee).trim().replace(" ", "");
//			return str;
//		}
		
		
		
		
		
		
		
		
		

		public void verifyWalletFees(String hdg) {
			new CommonFunctions().verifyLabelText(lblWalletFees, "WalletFees", hdg);
		}

		public void verifyBuyToken(String hdg) {
			new CommonFunctions().verifyLabelText(lblBuyToken, "Buy Token", hdg);
		}

		public void verifyWithdraw(String hdg) {
			new CommonFunctions().verifyLabelText(lblWithdraw, "Withdraw", hdg);
		}

		public void verifyBankAccount() {
			new CommonFunctions().elementView(lblBankAccount, "BankAccount");
			ExtentTestManager.setInfoMessageInReport("The Fee is: " + getText(lblBankAccountFee));
		}

		public void verifyCreditCard() {
			new CommonFunctions().elementView(lblCreditCard, "Credit Card");
			ExtentTestManager.setInfoMessageInReport("The Fee is: " + getText(lblCreditCardFee));
		}
		public void verifyDebitCard() {
			new CommonFunctions().elementView(lblDebitCard, "Debit Card");
			ExtentTestManager.setInfoMessageInReport("The Fee is: " + getText(lblDebitCardFee));
		}
		
		public void verifyWithdrawBankAccount() {
			new CommonFunctions().elementView(lblWithdrawBankAccount, "Bank Account");
			ExtentTestManager.setInfoMessageInReport("The Fee is: " + getText(lblWithdrawBankAccountFee));
		}
		public void verifyWithdrawInstantPay() {
			new CommonFunctions().elementView(lblWithdrawInstantPay, "InstantPay");
			ExtentTestManager.setInfoMessageInReport("The Fee is: " + getText(lblWithdrawInstantPayFee));
		}
		public void verifyWithdrawGiftCard() {
			new CommonFunctions().elementView(lblGiftCard, "Gift Card");
			ExtentTestManager.setInfoMessageInReport("The Fee is: " + getText(lblGiftCardFee));
		}
		public void verifyFailedBankWithdraw() {
			new CommonFunctions().elementView(lblFailedBankWithdraw, "Failed Banl Withdraw");
			ExtentTestManager.setInfoMessageInReport("The Fee is: " + getText(lblFailedBankWithdrawFee));
		}

}