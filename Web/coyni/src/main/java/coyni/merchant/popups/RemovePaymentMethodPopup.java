package coyni.merchant.popups;

import org.openqa.selenium.By;

import coyni.merchant.components.NavigationComponent;
import coyni.merchant.components.SuccessFailurePopupCardComponent;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class RemovePaymentMethodPopup extends BrowserFunctions {
	private By lblheading = By.xpath("//h1[contains(text(),'Remove Payment Method')]");
	private By lblDescription = By.xpath("//p[starts-with(.,'If you')]");
	private By lblBank = By.xpath("//p[contains(.,'CashEdge')]");
	private By btnRemove = By.xpath("//button[text()='Remove']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblheading, "Heading", Heading);
	}

	public void verifyDescription() {
		String desc = getText(lblDescription, "");
		ExtentTestManager.setInfoMessageInReport(desc + " is displayed");
	}

	public void verifyBank() {
		new CommonFunctions().elementView(lblBank, "Existing bank");
	}

	public void clickOnRemove() {
		click(btnRemove, "Remove");
	}

	public SuccessFailurePopupCardComponent successFailurePopupCardComponent() {
		return new SuccessFailurePopupCardComponent();
	}

	public NavigationComponent navigationComponent() {
		return new NavigationComponent();
	}

	public PaymentMethodRemovesdSuccessfullyPopup paymentMethodRemovesdSuccessfullyPopup() {
		return new PaymentMethodRemovesdSuccessfullyPopup();
	}
}
