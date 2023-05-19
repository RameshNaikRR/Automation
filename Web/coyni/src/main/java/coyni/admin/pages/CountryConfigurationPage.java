package coyni.admin.pages;

import org.openqa.selenium.By;

import coyni.admin.components.EntriesAndPaginationsComponent;
import coyni.admin.components.ExportComponent;
import ilabs.WebFramework.BrowserFunctions;

public class CountryConfigurationPage extends BrowserFunctions{
	
	private By lblCountryConfigurationPage = By.xpath("");
	private By txtSearch = By.xpath("");
	
	public ExportComponent exportComponent() {
		return new ExportComponent();
	}
	
	public EntriesAndPaginationsComponent entriesAndPaginationsComponent() {
		return new EntriesAndPaginationsComponent();
	}
	
	
	
			

}
