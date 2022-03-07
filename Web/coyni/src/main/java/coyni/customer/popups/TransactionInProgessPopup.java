package coyni.customer.popups;

import org.openqa.selenium.By;

import coyni.customer.components.NavigationComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class TransactionInProgessPopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Transaction In Progress']");
	private By lnkCopy = By.xpath("//span[@class='copy-image icon-copy']");
	private By btnDone = By.xpath("//button[text()='Done']");
	private By lnkLearnmore = By.xpath("//span[text()='Learn More']");
	private By referenceID = By.xpath("//span[text()='Reference ID']");

	public void clickCopyLink() {
		click(lnkCopy, "Click Copy");
	}

	public void clickDone() {
		click(btnDone, "Click Done");
	}

	public void lnkLearnmore() {
		click(lnkLearnmore, "Click LearnMore");
	}

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Transaction InProgress", expHeading);
	}

	public void verifyReferenceID() {
		new CommonFunctions().elementView(referenceID, "Reference ID");

	}
	
	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}
}
