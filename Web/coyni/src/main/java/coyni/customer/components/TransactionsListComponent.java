package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class TransactionsListComponent extends BrowserFunctions {
	private By btnFilter =By.cssSelector("");

	private By btnExport = By.cssSelector("");

	private By tblTransactions = By.cssSelector("");

	public void clickFilter() {
		click(btnFilter, "click filter");
	}

	public void clickExport() {
		click(btnExport, "click export");
	}

	public EntriesComponent entriesComponent() {
	return new EntriesComponent();
	}
	
	public Paginator paginator() {
	return new Paginator();
	}




}
