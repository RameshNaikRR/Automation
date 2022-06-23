package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.customer.components.AppliedFiltersComponent;
import coyni.customer.components.DatePickerComponent;
import coyni.customer.components.EntriesComponent;
import coyni.customer.components.FilterComponent;
import coyni.customer.components.PaginatorComponent;
import ilabs.WebFramework.BrowserFunctions;

public class TransactionListComponent extends BrowserFunctions {
	private By btnFilter = By.xpath("//span[starts-with(@class,'icon-filter')]/parent::button");
	private By btnExport = By.xpath("//span[starts-with(@class,'icon-export')]/parent::button");

	public void clickFilterButton() {
		click(btnFilter, "Filter button");
	}

	public void clickExportButton() {
		click(btnExport, "Export button");
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