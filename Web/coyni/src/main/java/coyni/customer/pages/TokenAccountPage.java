package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.TokenAccountActivityComponent;
import coyni.customer.components.TokenPaidOrdersDetailsComponent;
import coyni.customer.components.TokensPurchasedDetailsComponent;
import coyni.customer.components.TokensReceivedDetailsComponent;
import coyni.customer.components.TokensSentDetailsComponent;
import coyni.customer.components.TokensWithdrawnDetailsComponent;
import coyni.customer.components.TransactionsListComponent;
import coyni.customer.components.UserDetailsComponent;
import coyni.customer.components.UserNameDropDownComponent;
import coyni.customer.popups.BuyCoyniTokensPaymentMethodPopup;
import coyni.customer.popups.PayAndRequestTokensPopup;
import coyni.customer.popups.WithdrawCoyniToUSDPopup;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TokenAccountPage extends BrowserFunctions {

	// added
	private By btnTokenAccount = By.id("token-dashboard");
	private By lblTotalFunds = By.cssSelector(".text-6xl");
	private By btnPayRequestToken = By.xpath("//span[text()='Pay / Request Tokens']");
	private By btnBuyTokens = By.xpath("//span[text()='Buy Tokens']");
	private By btnWithdrawToUSD = By.xpath("//span[text()='Withdraw to USD']");
	private By btnPay = By.xpath("//button[text()='Pay']");
	private By lblYourTransactions = By.xpath("//h2[contains(text(),'Your Transactions')]");
	// private By dropDownUserName = By.cssSelector(".down-arrow");

	public void clickTokenAccount() {
		click(btnTokenAccount, "Token Account");
	}

	public String getAvailableBalance() {
		return getText(lblTotalFunds, "Available Balance");

	}

//	public void clickUserName() {
//		click(dropDownUserName, "UserName");
//	}

	public void clickPayRequestToken() {
		click(btnPayRequestToken, "PayRequestToken");
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "BuyTokens");
	}

	public void clickWithdrawToUSD() {
		click(btnWithdrawToUSD, "WithdrawToUSD");

	}

	// added
	public void verifyPay() {
		new CommonFunctions().elementView(btnPay, "Pay is verified");
	}

	// added
	public void verifyLabelYourTransactions() {

		new CommonFunctions().elementView(lblYourTransactions, "Your Transactions");
	}
	// public TokenAccountActivityComponent tokenAccountActivityComponent() {
//	 	return new TokenAccountActivityComponent(); }
	// public TransactionsListComponent transactionsListComponent() {
	// return new TransactionsListComponent(); }
	// public TokensSentDetailsComponent tokensSentDetailsComponent() {
	// return new TokensSentDetailsComponent(); }
	// public TokensReceivedDetailsComponent tokensReceivedDetailsComponent() {
	// return new TokensReceivedDetailsComponent(); }
	// public TokensPurchasedDetailsComponent tokensPurchasedDetailsComponent() {
	// return new TokensPurchasedDetailsComponent() ;}
//	 	public  TokensWithdrawnDetailsComponent okensWithdrawnDetailsComponent() {
	// return new TokensWithdrawnDetailsComponent();}
	// public TokenPaidOrdersDetailsComponent tokenPaidOrdersDetailsComponent() {
	// return new TokenPaidOrdersDetailsComponent(); }

	public TokenAccountActivityComponent tokenAccountActivityComponent() {
		return new TokenAccountActivityComponent();
	}

	public TransactionsListComponent transactionsListComponent() {
		return new TransactionsListComponent();
	}

	public TokensSentDetailsComponent tokensSentDetailsComponent() {
		return new TokensSentDetailsComponent();
	}

	public UserNameDropDownComponent userNameDropDownComponent() {
		return new UserNameDropDownComponent();
	}

	public TokensReceivedDetailsComponent tokensReceivedDetailsComponent() {
		return new TokensReceivedDetailsComponent();
	}

	public TokensPurchasedDetailsComponent tokensPurchasedDetailsComponent() {
		return new TokensPurchasedDetailsComponent();
	}

	public TokensWithdrawnDetailsComponent tokensWithdrawnDetailsComponent() {
		return new TokensWithdrawnDetailsComponent();
	}

	public TokenPaidOrdersDetailsComponent tokenPaidOrdersDetailsComponent() {
		return new TokenPaidOrdersDetailsComponent();
	}

	public NavigationMenuPage navigationMenuPage() {
		return new NavigationMenuPage();
	}

	public PayAndRequestTokensPopup payAndRequestTokensPopup() {
		return new PayAndRequestTokensPopup();
	}

	public BuyCoyniTokensPaymentMethodPopup buyCoyniTokensPaymentMethodPopup() {
		return new BuyCoyniTokensPaymentMethodPopup();
	}

	public WithdrawCoyniToUSDPopup withdrawCoyniToUSDPopup() {
		return new WithdrawCoyniToUSDPopup();
	}
}
