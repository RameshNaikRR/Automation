package coyni.api.business.popups;

import org.openqa.selenium.By;

import coyni.apibusiness.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class GenerateNewSecretKeyPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Are You Sure You Want To Generate A New Secret Key?']");

	private By lblGenetareDesc = By
			.xpath("//p[contains(text(),'The current secret key will')]");

	private By btnGenerate = By.xpath("//button[text()='Generate']");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Generate Secrey Key", expHeading);
	}

	public String getGenerateKeyDescription() {
		new CommonFunctions().elementView(lblGenetareDesc, "Generate Key Description");
		return getText(lblGenetareDesc, "Generate Key Description");

	}

	public void clickGenerate() {
		click(btnGenerate, "Clicked on Generate");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
