package coyni.merchant.popups;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import coyni.uitilities.CommonFunctions;
import ilabs.WebFramework.BrowserFunctions;

public class GeneratePrintableQRCodePopup extends BrowserFunctions {

	private By lblHeading = By.xpath("//h1[text()='Generate A Printable QR Code']");

	private By lblElements = By.xpath("//input[@type='checkbox']");

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

	public void clickGenerate() {
		click(btnGenerate, "Generate");
	}

}
