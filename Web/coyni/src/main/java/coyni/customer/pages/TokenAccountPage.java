package coyni.customer.pages;

import org.openqa.selenium.By;

import coyni.customer.components.TokenAccountActivityComponent;
import coyni.customer.components.TokenPaidOrdersDetailsComponent;
import coyni.customer.components.TokensPurchasedDetailsComponent;
import coyni.customer.components.TokensReceivedDetailsComponent;
import coyni.customer.components.TokensSentDetailsComponent;
import coyni.customer.components.TokensWithdrawnDetailsComponent;
import coyni.customer.components.TransactionsListComponent;
import coyni.customer.popups.BuyCoyniTokensPaymentMethodPopup;
import coyni.customer.popups.PayAndRequestTokensPopup;
import coyni.customer.popups.WithdrawCoyniToUSDPopup;
import ilabs.WebFramework.BrowserFunctions;

public class TokenAccountPage extends BrowserFunctions {

	private By lblAvailableBalance = By.name(" ");
	private By btnPayRequestToken = By.name(" ");
	private By btnBuyTokens = By.name(" ");
	private By btnWithdrawToUSD = By.name(" ");

	public String getAvailableBalance() {
		return getText(lblAvailableBalance, "Available Balance");

	}

	public void clickPayRequestToken() {
		click(btnPayRequestToken, "PayRequestToken");
	}

	public void clickBuyTokens() {
		click(btnBuyTokens, "BuyTokens");
	}

	public void clickWithdrawToUSD() {
		click(btnWithdrawToUSD, "WithdrawToUSD");

	}
// public  TokenAccountActivityComponent tokenAccountActivityComponent() {
// 	return new TokenAccountActivityComponent(); }
// public TransactionsListComponent transactionsListComponent() {
//  return new TransactionsListComponent(); }
//  public  TokensSentDetailsComponent tokensSentDetailsComponent() {
//  return new TokensSentDetailsComponent(); }
//  public TokensReceivedDetailsComponent tokensReceivedDetailsComponent() {
//  return new TokensReceivedDetailsComponent(); }
//  public  TokensPurchasedDetailsComponent tokensPurchasedDetailsComponent() {
//  return new TokensPurchasedDetailsComponent() ;}
// 	public  TokensWithdrawnDetailsComponent okensWithdrawnDetailsComponent() {
//  return new TokensWithdrawnDetailsComponent();}
//  public  TokenPaidOrdersDetailsComponent tokenPaidOrdersDetailsComponent() {
//  return new TokenPaidOrdersDetailsComponent(); }

	public TokenAccountActivityComponent tokenAccountActivityComponent() {
		return new TokenAccountActivityComponent();
	}

	public TransactionsListComponent transactionsListComponent() {
		return new TransactionsListComponent();
	}

	public TokensSentDetailsComponent tokensSentDetailsComponent() {
		return new TokensSentDetailsComponent();
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
