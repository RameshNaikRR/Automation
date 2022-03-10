package coyni.admin.components;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class SuccessFailureComponent extends BrowserFunctions {
	private By lblTransactionFailed = By
			.xpath("//h1[@class='text-cm3 tracking-normal Heading_heading4__2QNbr leading-10 text-center']");
	private By tryAgain = By.cssSelector(".w-60");
	private By imgSuccessFailure = By.cssSelector(".mt-12");
	private By lblFailureDescription = By.cssSelector(".mt-10");

	public void verifyTransactionFailedHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblTransactionFailed, expHeading, "Transaction Failed");
	}

	public void verifyTransactionFailedDesHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblFailureDescription, expHeading, "Transaction description");
	}

	public void verifyImage() {
		new CommonFunctions().elementView(imgSuccessFailure, "Tick Mark");

	}

	public void clickTryAgain() {
		click(tryAgain, "Try Again");
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

}
