package coyni.customer.components;

import java.util.List;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class EntriesComponent extends BrowserFunctions {
	
	private By lblEntries = By.cssSelector("");
	
	private By drpdwnEntries =By.cssSelector("");
	
	private By optionsEntries =By.cssSelector("");
	
	public String getEntriesMessage() {
		return getText(lblEntries, "label Entries");
	}
	
	public void selectEntriesOption(String entries) {
		click(drpdwnEntries, "click Entries dropdown");
		new CommonFunctions().selectCustomDropDown(entries, "entries");
	}
	
	public List<String> getEntriesText() {
	return getDropDownOptions(optionsEntries, "Entries options");
	}





}
