package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class AppliedFiltersComponent extends BrowserFunctions {
	
	private By appliedFilters =By.cssSelector("");
	
	public String getAppliedFilters() {
		return getText(appliedFilters, "Applied Filters");
	}

	public void closeAppliedFilter() {
		click(appliedFilters, "Close Applied filters");
	}



}
