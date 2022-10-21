package coyni.admin.components;

import org.openqa.selenium.By;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.web.actions.WaitForElement;

public class ExportFileComponent extends BrowserFunctions {
	private By btnDownload = By.xpath("//button[@data-for='Download']");
	private By txtSuccess = By.xpath("//span[text()='Success']");
	private By chkboxBulkActions = By.xpath("//input[@type='checkbox']");
	private By btnBulkActions = By.xpath("//div[text()='Bulk Actions']");
	private By btnBulkDownload = By.xpath("//data[text()='Download']");
	private By chkboxFirstExport = By.xpath("(//input[@type='checkbox'])[2]");
	private By chkboxTrash = By.xpath("//data[text()='Trash']");
	private By btnApply = By.xpath("//div[text()='Apply']");

	public void clickDownload() {
		click(btnDownload, "DownloadIcon");
	}

	public void verifySuccess() {
		waitForElement(txtSuccess, waittime, WaitForElement.presence);
	}

	public void clickchkboxBulkActions() {
		click(chkboxBulkActions, "chkboxBulkActions");
	}

	public void clickBulkActions() {
		click(btnBulkActions, "BulkActions");
	}

	public void clickBulkDownload() {
		click(btnBulkDownload, "BulkDownload");
	}

	public void clickchkboxFirstExport() {
		click(chkboxFirstExport, "chkboxFirstExport");
	}

	public void clickchkboxTrash() {
		click(chkboxTrash, "chkboxTrash");
	}

	public void clickApply() {
		click(btnApply, "Apply");
	}

	public ToastComponent toastComponent() {
		return new ToastComponent();
	}
}
