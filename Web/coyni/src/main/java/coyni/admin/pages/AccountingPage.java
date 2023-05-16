package coyni.admin.pages;

import org.openqa.selenium.By;
import coyni.admin.components.EntriesAndPaginationsComponent;
import ilabs.WebFramework.BrowserFunctions;

public class AccountingPage extends BrowserFunctions {

	private By tabACHs = By.xpath("");
	private By tabWires = By.xpath("");
	private By tabMT = By.xpath("");
	private By btnACHCutoffTimes = By.xpath("");
	private By btnStatusKey = By.xpath("");
	private By txtSearch = By.xpath("");

	public void clickACHsTab() {
		click(tabACHs, "ACHs");
	}

	public void clickWiresTab() {
		click(tabWires, "Wires");
	}

	public void clickMT() {
		click(tabMT, "MT");
	}

	public void clickAutooffTimes() {
		click(btnACHCutoffTimes, "Auto Cutoff Times");
	}

	public void clickStatusKey() {
		click(btnStatusKey, "Status Key");
	}
//	public void fillSearch(){
//		enterText(txtSearch, , getCopiedData());
//		
//	}
}
