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
	
	public PaginatorComponent paginatorComponent() {
	return new PaginatorComponent();
	}
    
	public FilterComponent filterComponent() {
		return new FilterComponent();
	}

	public DatePickerComponent datePickerComponent() {
		   return new DatePickerComponent();
	   }
	public AppliedFiltersComponent appliedFiltersComponent() {
		return new AppliedFiltersComponent();
	}




}
