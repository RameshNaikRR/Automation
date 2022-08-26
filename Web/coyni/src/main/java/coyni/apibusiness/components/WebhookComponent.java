package coyni.apibusiness.components;

import org.openqa.selenium.By;

import coyni.api.business.popups.SaveChangePopUp;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class WebhookComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("(//span[text()='Webhooks'])[2]");
	private By endPointURL = By.xpath("//input[@name='url']");
	private By editEndPointURL = By.xpath("");
	private By endpointStatus = By.xpath("//div[@class='chip__text--green  ']");
	private By endpointDescription = By.xpath("//textarea[@name='description']");
	private By lastupdated = By.xpath("//p[@class='Webhooks_time__8zGbT']");
	private By editEndPoint = By.xpath("");
	private By editIcon = By.xpath("");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By btnCreate = By.xpath("");
	private By createheading = By.xpath("");
	private By txtEndPointURL = By.xpath("");
	private By endPointDesc = By.xpath("");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, "Webhooks", expHeading);
	}

	public void verifyCreateHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(createheading, expHeading, "Webhooks");
	}

	public void verifyEndPointURL() {
		new CommonFunctions().elementView(endPointURL, "EndPointURL");
	}

	public void clickEndPointURL() {

		click(endPointURL, "EndPointURL");
	}

	public void enterEndPointURL(String endpointUrl) {
		enterText(endPointURL, endpointUrl, "EndPoint URL");
	}

	public void verifyEndPointStatus() {
		new CommonFunctions().elementView(endpointStatus, "End Point Status");
	}

	public void verifyEndPointDescription() {
		new CommonFunctions().elementView(endpointDescription, "End Point Description");
	}

	public void clickEndPointDescription() {
//		new CommonFunctions().verifyMouseHoverAction(endpointDescription, "EndPoint Description", "", "");
		click(endpointDescription, "EndPointURL");
	}

	public void enterEndpointDesc(String endPointDescription) {
		enterText(endpointDescription, endPointDescription, "Description");
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

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
