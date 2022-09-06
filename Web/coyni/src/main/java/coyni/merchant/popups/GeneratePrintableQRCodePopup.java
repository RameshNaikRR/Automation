package coyni.merchant.popups;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;
import ilabs.api.reporting.ExtentTestManager;

public class GeneratePrintableQRCodePopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Generate A Printable QR Code']");

	private By lblElements = By.xpath("//input[@type='checkbox']");

	private By btnDownloadPDF = By.xpath("//div[contains(text(),'Download PDF')]");

	private By lblNameCode = By.xpath("//span[contains(@class,'capitalize h-7')]");

	private By lblScanQRCode = By.xpath("//div[contains(text(),'Scan QR Code')]/following-sibling::*");

	private By lblPayInstantly = By.xpath("//div[contains(text(),'Pay Instantly')]/following-sibling::*");

	private By btnGenerate = By.xpath("//button[text()='Generate']");

	public void verifyHeading(String Heading) {
		new CommonFunctions().verifyLabelText(lblHeading, Heading, "Heading");
	}

	public void clickCheckBoxes() {
		List<WebElement> lists = getElementsList(lblElements, "CheckBoxes");
		for (WebElement list : lists) {
			list.click();
		}
	}

	public void clickBoxes() {
		List<WebElement> list = getElementsList(lblElements, "CheckBoxes");
		list.get(0).click();
		for (int i = 0; i <= 5; i++) {
			list.get(1).click();
			list.get(2).click();
			list.get(3).click();
			list.get(4).click();
			list.get(5).click();

		}
	}

	public void clickGenerate() {
		click(btnGenerate, "Generate");
	}

	public void viewGeneratePDF() {
		new CommonFunctions().elementView(btnDownloadPDF, "Download PDF");
	}

	public void getName() {
		String name = getText(lblNameCode, "Name for Generate QR Code");
		ExtentTestManager.setInfoMessageInReport("Name : " + name);
	}

	public void getScanQRCode() {
		String qrCode = getText(lblScanQRCode, "Scan QR Code");
		ExtentTestManager.setInfoMessageInReport("QR Code : " + qrCode);
	}

	public void getPayInstantly() {
		String payInstantly = getText(lblPayInstantly, "Pay Instantly");
		ExtentTestManager.setInfoMessageInReport("Pay Instantly : " + payInstantly);
	}

}
