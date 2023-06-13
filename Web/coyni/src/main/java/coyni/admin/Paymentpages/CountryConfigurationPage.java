package coyni.admin.Paymentpages;

import org.openqa.selenium.By;

import coyni.admin.Paymentcomponents.EntriesAndPaginationsComponent;
import coyni.admin.Paymentcomponents.ExportComponent;
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
