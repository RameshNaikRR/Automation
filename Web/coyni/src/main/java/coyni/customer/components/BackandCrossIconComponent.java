package coyni.customer.components;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;

public class BackandCrossIconComponent extends BrowserFunctions {
	
	private By btnBack = By.xpath(" //button[@class='self-start']//img");
	private By btnCross = By.xpath("//button[@class='self-end']//img ");
	
	public void clickBack() {
		click(btnBack, "Back");
	}
	public void clickCross() {
		click(btnCross, "Cross");
	}

}
