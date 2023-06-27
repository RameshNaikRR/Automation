package coyni.merchant.pages;

import org.openqa.selenium.By;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class PointOfSalesMPOSPage extends BrowserFunctions {

	private By lblHeading = By.xpath("//span[contains(text(),'Terminal Locations')]");

	private By lblHeadingNoTerminalExists = By.xpath("//div[contains(text(),'No Terminals Exist')]");

	private By searchOption = By.xpath("//input[contains(@class,'NewEditSearchInput_form_input__0QkV6')]");

	private By search = By.xpath("//button[contains(@class,'icon-search')]");

	private By btnTerminal = By.xpath("//div[contains(text(),'Add Terminal')]");

	private By dropDownIcon = By.xpath("//button[contains(@class,'icon-arrow-down')]");

	private By btnAddTermianlToLocation = By.xpath("//button[contains(text(),'Add Terminal to Location')]");

	public void clickTerinal() {
		click(btnTerminal, "Terminal");
	}

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Heading", Heading);
	}

	public void clickTerminalSearch() {
		click(searchOption, "Terminal Search");
	}

	public void clickSearch() {
		click(search, "Search");
	}

	public void clickOnDropDown() {
		click(dropDownIcon, "Drop Down");
	}

	public void clickAddTerminalToLocation() {
		click(btnAddTermianlToLocation, "Add Terminal Location");
	}

	public void verifyHeadingForNoTerminalExists(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeadingNoTerminalExists, "Heading", Heading);
	}

}