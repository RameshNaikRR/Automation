package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.api.business.popups.SaveChangePopUp;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WebhookComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("");
	private By endPointURL = By.xpath("");
	private By editEndPointURL = By.xpath("");
	private By endpointStatus = By.xpath("");
	private By endpointDescription = By.xpath("");
	private By lastupdated = By.xpath("");
	private By editEndPoint = By.xpath("");
	private By editIcon = By.xpath("");
	private By btnSave = By.xpath("");
	private By btnCreate = By.xpath("");
	private By createheading = By.xpath("");
	private By txtEndPointURL = By.xpath("");
	private By endPointDesc = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, "Webhooks");
	}

	public void verifyCreateHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(createheading, expHeading, "Webhooks");
	}

	public void verifyEndPointURL() {
		new CommonFunctions().elementView(endPointURL, "EndPointURL");

	}

	public void verifyEndPointURL(String txtURL) {
		enterText(txtEndPointURL, txtURL, "EndPoint URL");
		;

	}

	public void verifyEndPointStatus() {
		new CommonFunctions().elementView(endpointStatus, "End Point Status");
	}

	public void verifyEndPointDescription() {
		new CommonFunctions().elementView(endpointDescription, "End Point Description");
	}

	public void endPointDescription(String endPointDescription) {
		enterText(endPointDesc, endPointDescription, "Description");
	}

	public void verifyLastUpdated() {
		new CommonFunctions().elementView(lastupdated, "Last Updated");
	}

	public void verifyEditEndPointURL(String editEndPointWebhookURL) {
		new CommonFunctions().verifyLabelText(editEndPointURL, editEndPointWebhookURL, "Edit End Point Webhook");
	}

	public void verifyEditEndPoint(String editEndPointWebhook) {
		new CommonFunctions().verifyLabelText(editEndPoint, editEndPointWebhook, "Edit Webhook");
	}

	public void clickIcon() {
		click(editIcon, "EditIcon");
	}

	public void clickSave() {
		click(btnSave, "Save");
	}

	public void clickCreate() {
		click(btnCreate, "Create");
	}

	public SaveChangePopUp saveChangePopUp() {
		return new SaveChangePopUp();
	}
}
