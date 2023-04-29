package coyni.merchant.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.api.business.popups.SaveChangePopUp;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class WebhookComponent extends BrowserFunctions {
	private By lblHeading = By.xpath("//p[contains(text(),'Webhooks')]");
	private By btnCreateEndPoint = By.xpath("//button[contains(text(),'Create Endpoint')]");
	private By endPointURL = By.xpath("//input[@name='url']");
	private By editEndPointURL = By.xpath("");
	private By endpointStatus = By.xpath("//div[@class='chip__text--green  ']");
	private By endpointDescription = By.xpath("//textarea[@name='description']");
	private By lastupdated = By.xpath("//p[@class='Webhooks_time__8zGbT']");
	private By editEndPoint = By.xpath("");
	private By editIcon = By.xpath("");
	private By btnSave = By.xpath("//button[text()='Save']");
	private By btnCreate = By.xpath("//button[contains(text(),'Create Endpoint')]");
	private By createheading = By.xpath("");
	private By txtEndPointURL = By.xpath("");
	private By endPointDesc = By.xpath("");
	private By lblWebhookKeyLogs = By.xpath(
			"(//div[contains(@class,'ActivityLog_logs_container')]/parent::div//div[contains(@class,'flex flex-col mb-6')])");

//	private By apikeyname = By.xpath("(//p[contains(@class,'font-bold capitalize break-all')])[1]//span");

	private By webhookkeyname = By.xpath("(//span)[1]");

//	private By apikeyDate = By.xpath("((//p[contains(@class,'font-bold capitalize break-all')])[1]//span)[2]");

	private By webhookkeyDate = By.xpath("(//span)[2]");

	public void verifyHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(lblHeading, expHeading, "Webhooks");
	}

	public void clickOnEndPointURL() {
		click(btnCreateEndPoint, "End Point URL");
	}

	public void getListOfWebHookLogs() throws InterruptedException {
		Thread.sleep(5000);
		List<WebElement> list = getElementsList(lblWebhookKeyLogs, "Webhook Key Logs");
		int size = list.size();
		System.out.println("size is " + size);
		ExtentTestManager.setInfoMessageInReport("List size is " + size);
		for (WebElement eles : list) {
			try {
				WebElement ele = eles.findElement(webhookkeyname);
				String text = ele.getText();
				WebElement ele2 = eles.findElement(webhookkeyDate);
				String text2 = ele.getText();
				String text1 = text + text2;
				// System.out.println("Element is " + text);
				ExtentTestManager.setInfoMessageInReport("API Keys " + text1);

			} catch (Exception e) {
				ExtentTestManager.setInfoMessageInReport("Information is " + e);
			}

		}

	}

	public void verifyCreateHeading(String expHeading) {
		new CommonFunctions().verifyLabelText(createheading, expHeading, "Webhooks");
	}

	public String verifyEndPointURL() {
		String text = getText(endPointURL, "EndPointURL");
		return text;
	}

	public void clickEndPointURL() {
		click(endPointURL, "EndPointURL");
	}

	public void enterEndPointURL(String endpointUrl) {
		enterText(endPointURL, endpointUrl, "EndPoint URL");
	}

	public String verifyEndPointStatus() {
		String text = getText(endpointStatus, "End Point Status");
		return text;
	}

	public String verifyEndPointDescription() {
		String text = getText(endpointDescription, "End Point Description");
//		new CommonFunctions().elementView(endpointDescription, "End Point Description");
		return text;
	}

	public void clickEndPointDescription() {
		click(endpointDescription, "EndPointURL");
	}

	public void enterEndpointDesc(String endPointDescription) {
		enterText(endpointDescription, endPointDescription, "Description");
	}

	public String verifyLastUpdated() {
		String text = getText(lastupdated, "Last Updated");
		return text;
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
