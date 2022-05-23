package coyni.admin.pages;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class FeeStructureMerchant extends BrowserFunctions {
	private By btnView = By.xpath(
			"//button[contains(@class,'icon-button  icon-icon-View-Icon-and-Tooltip icon-View-Icon-and-Tooltip')]");
	private By btnEdit = By.xpath("//div[contains(@class,'button-row-row show')]");
	
	public void clickView() {
		click(btnView, "view");
	}

	public void clickEdit() {
		click(btnEdit, "edit");
	}
}
