package coyni.customer.pages;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TokenAccountPage extends BrowserFunctions{
	
	private By lblAvailableBalance = By.name(" ");
	private By btnPayRequestToken = By.name(" ");
	private By btnBuyTokens  = By.name(" ");
	private By btnWithdrawToUSD = By.name(" ");
	
	
	public String getAvailableBalance() {
		return getText(lblAvailableBalance,"Available Balance");
		
	}
	public void clickPayRequestToken() {
		click(btnPayRequestToken, "PayRequestToken");
	}
	public void clickBuyTokens() {
		click(btnBuyTokens, "BuyTokens");
	}
	public void btnWithdrawToUSD() {
		click(btnWithdrawToUSD, "WithdrawToUSD");
		
	}
 //public void TokenAccountActivityComponent tokenAccountActivityComponent() {
 //	return new TokenAccountActivityComponent() }
 //public void TransactionsListComponent transactionsListComponent() {
 // return new TransactionsListComponent() }
 // public void TokensSentDetailsComponent tokensSentDetailsComponent() {
 // return new TokensSentDetailsComponent() }
 // public void TokensReceivedDetailsComponent tokensReceivedDetailsComponent() {
 // return new TokensReceivedDetailsComponent() }
 // public void TokensPurchasedDetails tokensPurchasedDetails() {
 // return new TokensPurchasedDetails() }
 //	public void TokensWithdrawnDetails okensWithdrawnDetails() {
 // return new TokensWithdrawnDetails();}
 // public void TokenPaidOrdersDetails tokenPaidOrdersDetails() {
 // return new TokenPaidOrdersDetails(); }
	
 }
