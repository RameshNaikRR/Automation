package coyni.business.popups;

import org.openqa.selenium.By;

import ilabs.WebFramework.BrowserFunctions;
import coyni.uitilities.CommonFunctions;

public class NewSingleACH extends BrowserFunctions {
	private By lblheading = By.xpath("");
	private By lbldescription = By.xpath("");
	private By searchicon = By.xpath("");
	private By searchInput = By.xpath("");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblheading, "Heading is :", Heading);
	}

	public void verifyDescription(String Desription) {
		new CommonFunctions().verifyLabelText(lbldescription, "Description is:", Desription);
	}

	public void clickSearchIcon() {
		click(searchicon, "Search");
	}

	public void enterSearch() {
		click(searchInput, "Input");
	}
}
